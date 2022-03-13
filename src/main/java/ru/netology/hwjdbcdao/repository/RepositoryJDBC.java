package ru.netology.hwjdbcdao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositoryJDBC {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SCRIPTH_PATH = "getProductName.sql";
    private static String script = read(SCRIPTH_PATH);


    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        List<String> result = jdbcTemplate.queryForList(script, new Object[]{name}, String.class);
        return result;
    }

}
