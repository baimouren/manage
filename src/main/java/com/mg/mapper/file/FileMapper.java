package com.mg.mapper.file;

import java.util.List;
import java.util.Map;

import com.mg.model.file.FileModle;

public interface FileMapper {

    public void insert(FileModle file);

    public void inserts(List<FileModle> arrayFiles);

    public void deletedById(int id);

    public List<FileModle> selectById(Integer param);

    public List<FileModle> selectAll();

    public List<FileModle> selectByParam(FileModle file);

    public List<FileModle> selectBySql(Map<String, String> map);

}
