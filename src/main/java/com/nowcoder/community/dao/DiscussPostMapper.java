package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //@param用于给参数起别名
    //如果方法只有一个参数，并且在<if>中使用，则必须起别名
    int selectDiscussPostRows(@Param("userId") int userId);
}
