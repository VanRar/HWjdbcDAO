package ru.netology.hwjdbcdao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hwjdbcdao.service.ServiceJDBC;

@RestController
@RequestMapping("/")
public class ControllerJDBC {
    @Autowired
    private ServiceJDBC serviceJDBC;

    @GetMapping("/products/fetch-product")
    public String getProductByName(String name){
        return serviceJDBC.getProductName(name);
    }
}
