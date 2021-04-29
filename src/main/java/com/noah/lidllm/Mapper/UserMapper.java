package com.noah.lidllm.Mapper;

import com.noah.lidllm.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author noah
 * @Date 4/29/21 3:52 PM
 * @Version 1.0
 **/
@Mapper
public interface UserMapper {

    public User getById(Integer id);

}
