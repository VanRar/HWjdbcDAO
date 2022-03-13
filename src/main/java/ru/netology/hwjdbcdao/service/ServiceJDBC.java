package ru.netology.hwjdbcdao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.hwjdbcdao.repository.RepositoryJDBC;

import java.util.List;

@Service
public class ServiceJDBC {
    @Autowired
    private RepositoryJDBC repositoryJDBC;

    public String getProductName(String name){

        List<String> list = repositoryJDBC.getProductName(name);
        StringBuilder stringBuilder = new StringBuilder("Product list ")
                .append(name)
                .append(": ");
        for(String map: list){
            stringBuilder.append(map).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}