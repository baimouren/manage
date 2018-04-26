package com.mg.controller.basicinfo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mg.controller.sys.BaseController;
import com.mg.model.basicinfo.MenueModel;
import com.mg.service.basicinfo.IMenueService;

@Controller
@RequestMapping("menue")
public class MenueController  extends BaseController {

    @Autowired
    private IMenueService menueService;

    @ResponseBody
    @RequestMapping("searchMenue")
    public Map<String, Object> searchMenue(HttpServletRequest request) {
        List<MenueModel> searchMenue = menueService.searchMenue(request.getParameterMap());
        return getReturnMap(searchMenue);
    }
}
