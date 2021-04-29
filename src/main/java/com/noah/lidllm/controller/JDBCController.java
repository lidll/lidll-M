package com.noah.lidllm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName JDBCController
 * @Description TODO
 * @Author noah
 * @Date 4/27/21 5:54 PM
 * @Version 1.0
 **/
@RestController
public class JDBCController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/test")
    public List<Map<String,Object>> test(){
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
}
