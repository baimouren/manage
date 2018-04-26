package com.mg.service.file.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.mapper.file.FileMapper;
import com.mg.model.file.FileModle;
import com.mg.service.file.IFileService;

@Service("fileService")
public class FileServiceImpl implements IFileService {
    
    private static final Logger log = Logger.getLogger(FileServiceImpl.class);

    @Autowired
    private FileMapper fileMapper;

    @Override
    public List<FileModle> searchFilePackage(Map<String, String[]> map) throws IOException {
        List<FileModle> arrayFiles = new ArrayList<>();

        String url = map.get("url")[0];
        cyclicTraversal(url, arrayFiles);

        // cyclicTraversal(url, arrayFiles, true);
        // inserts(arrayFiles);
        return arrayFiles;
    }

    private static void cyclicTraversal(String path, List<FileModle> arrayFiles) {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                log.info(path + "文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        cyclicTraversal(file2.getAbsolutePath(), arrayFiles);
                    } else if (file2.isFile()) {
                        FileModle fileModle = new FileModle();
                        fileModle.setClicks(0);
                        fileModle.seturl(file2.getPath());
                        fileModle.setName(file2.getName().substring(0, file2.getName().lastIndexOf(".")));
                        fileModle.setFileType(file2.getName().substring(file2.getName().lastIndexOf(".") + 1, file2.getName().length()));
                        fileModle.setCreateTime(new Date());

                        log.info(file2.getPath());
                        arrayFiles.add(fileModle);
                    }
                }
            }
        } else {
            log.info("文件不存在!");
        }

    }

    @Override
    public void insert(FileModle file) {
        fileMapper.insert(file);

    }

    @Override
    public void inserts(List<FileModle> arrayFiles) {

        fileMapper.inserts(arrayFiles);

    }

    @Override
    public void deletedById(int id) {
        fileMapper.deletedById(id);

    }

    @Override
    public List<FileModle> selectById(Integer id) {
        List<FileModle> selectFile = fileMapper.selectById(id);
        return selectFile;
    }

    @Override
    public List<FileModle> selectAll() {
        List<FileModle> fileList = fileMapper.selectAll();
        return fileList;
    }

    @Override
    public List<FileModle> selectByParam(FileModle file) {
        List<FileModle> fileList = fileMapper.selectByParam(file);
        return fileList;
    }

    @Override
    public List<FileModle> selectBySql(Map<String, String> map) {
        List<FileModle> fileList = fileMapper.selectBySql(map);
        return fileList;
    }

    @Override
    public List<FileModle> searchFileName(Map<String, String[]> parameterMap) {
        if (parameterMap.isEmpty() || parameterMap.get("url")[0] == null) {
            throw new RuntimeException("参数不能为空");
        }

        Map<String, String> map = new HashMap<String, String>();
        StringBuffer strb = new StringBuffer();
        strb.append(" AND NAME LIKE '%" + parameterMap.get("url")[0] + "%'");
        map.put("sql", strb.toString());
        List<FileModle> selectBySql = selectBySql(map);
        return selectBySql;
    }

}
