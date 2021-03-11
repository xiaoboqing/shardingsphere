package com.wang.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.sharding.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
}
