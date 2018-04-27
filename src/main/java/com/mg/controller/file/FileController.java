package com.mg.controller.file;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mg.controller.sys.BaseController;
import com.mg.model.file.FileModle;
import com.mg.service.file.IFileService;

@Controller
@RequestMapping("file")
public class FileController extends BaseController {

    @Autowired
    IFileService fileService;
    
    @ResponseBody
    @RequestMapping("searchFilePackage")
    public Map<String, Object> searchFilePackageName(HttpServletRequest request) throws IOException {
        List<FileModle> searchFilePackageName = fileService.searchFilePackage(request.getParameterMap());
        return getReturnMap(searchFilePackageName);
    }

    @RequestMapping("editInsertsFilePackageName")
    public Map<String, Object> editInsertsFilePackageName(HttpServletRequest request) throws IOException {
        List<FileModle> searchFilePackageName = fileService.searchFilePackage(request.getParameterMap());
        fileService.inserts(searchFilePackageName);
        return getReturnMap();
    }

    @ResponseBody
    @RequestMapping("searchFileName")
    public Map<String, Object> searchFileName(HttpServletRequest request) throws IOException {
        Map<String, Object> searchFileName = fileService.searchFileName(request.getParameterMap());

        return getReturnPageMap(searchFileName);
    }
}
