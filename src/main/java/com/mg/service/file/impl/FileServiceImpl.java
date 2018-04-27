package com.mg.service.file.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public Map<String, Object> searchFileName(Map<String, String[]> parameterMap) {
        Map<String, Object> reMap = new HashMap<>();
        Set<String> keySet = parameterMap.keySet();

        Integer page = null, pageSize = null;
        if (parameterMap.isEmpty() || parameterMap.get("url")[0] == null) {
            throw new RuntimeException("参数不能为空");
        }
        if (keySet.contains("page")) {
            page = Integer.valueOf(parameterMap.get("page")[0]);
        }
        if (keySet.contains("pageSize")) {
            pageSize = Integer.valueOf(parameterMap.get("pageSize")[0]);
        }

        // 按名称模糊查询
        Map<String, String> map = new HashMap<String, String>();
        StringBuffer strb = new StringBuffer();
        String wstr = " NAME LIKE '%" + parameterMap.get("url")[0] + "%' ";
        strb.append(" AND " + wstr);
        map.put("sql", strb.toString());
        List<FileModle> selectTotalBySql = fileMapper.selectBySql(map);

        // 查询+1
        Map<String, String> upMap = new HashMap<String, String>();
        StringBuffer str = new StringBuffer();
        str.append(" UPDATE M_TB_FILE SET CLICKS = CLICKS + 1 WHERE " + wstr);
        upMap.put("sql", str.toString());
        fileMapper.excuteBySql(upMap);

        // 分页
        strb.append(" LIMIT " + (page - 1) * pageSize + "," + page * pageSize);
        map.put("sql", strb.toString());
        List<FileModle> selectBySql = fileMapper.selectBySql(map);

        reMap.put("list", selectBySql);
        reMap.put("total", selectTotalBySql.size());

        return reMap;
    }

}
