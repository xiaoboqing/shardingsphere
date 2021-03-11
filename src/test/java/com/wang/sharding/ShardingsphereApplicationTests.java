package com.wang.sharding;

import com.wang.sharding.entity.Course;
import com.wang.sharding.mapper.CourseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ShardingsphereApplicationTests {

    @Resource
    private CourseMapper courseMapper;

    /**
     * 分表添加数据测试
     */
    @Test
    void addCourse() {
        System.out.println("......");

        for (int i=100; i< 105; i++) {
            Course course = new Course();
            course.setCourseName("java" + i);
            course.setUserId(00001L);
            course.setCourseStatus("免费");

            courseMapper.insert(course);

        }


    }

}
