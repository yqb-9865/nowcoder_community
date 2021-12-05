package com.nowcoder.community.dao;

import com.nowcoder.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

import java.util.Date;

@Mapper
public interface LoginTicketMappper {

    @Insert({
            "insert into login_ticket(user_id, ticket, status, expired) ",
            "values(#{user_id}, #{ticket}, #{status}, #{expired})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    @Select({
            "select id, user_id, ticket, status, expired from login_ticket where ticket = #{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    //可以不用if，这里只是演示一下if如何使用，要加<script>
    @Update({
            "<script> ",
            "update login_ticket set status = #{status} where ticket = #{ticket} ",
            "<if test=\"ticket!=null\"> ",
            "and 1=1 ",
            "</if>",
            "</script>"
    })
    int updateStatus(String ticket, int status);
}
