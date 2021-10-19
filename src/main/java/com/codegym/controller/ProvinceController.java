package com.codegym.controller;

import com.codegym.service.Province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Province")
public class ProvinceController {
    @Autowired
   private IProvinceService provinceService;
    @GetMapping("")
    public ModelAndView showAll(){

    }
}
