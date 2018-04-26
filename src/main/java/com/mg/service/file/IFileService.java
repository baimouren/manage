package com.mg.service.file;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.mg.model.file.FileModle;

public interface IFileService {

    public List<FileModle> searchFilePackage(Map<String, String[]> map) throws IOException;

    public void insert(FileModle file);

    public void inserts(List<FileModle> arrayFiles);

    public void deletedById(int id);

    public List<FileModle> selectById(Integer id);

    public List<FileModle> selectAll();

    public List<FileModle> selectByParam(FileModle file);

    public List<FileModle> selectBySql(Map<String, String> map);

    public List<FileModle> searchFileName(Map<String, String[]> parameterMap);

}
