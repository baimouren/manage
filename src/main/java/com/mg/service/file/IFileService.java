package com.mg.service.file;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.mg.model.file.FileModle;

public interface IFileService {

    public List<FileModle> searchFilePackage(Map<String, String[]> map) throws IOException;

    public Map<String, Object> searchFileName(Map<String, String[]> parameterMap);

    public void inserts(List<FileModle> searchFilePackageName);
}
