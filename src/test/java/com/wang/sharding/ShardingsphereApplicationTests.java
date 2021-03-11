package com.wang.sharding;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wang.sharding.entity.Course;
import com.wang.sharding.entity.CourseReader;
import com.wang.sharding.mapper.CourseReaderMapper;
import com.wang.sharding.mapper.CourseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ShardingsphereApplicationTests {

    @Resource
    private CourseMapper courseMapper;
    @Resource
    private CourseReaderMapper course1Mapper;

    /**
     * 分库、分表添加数据测试
     */
    @Test
    void addCourse() {
        for (int i=525; i< 725; i++) {
            Course course = new Course();
            course.setCourseName("java" + i);
            course.setUserId(System.currentTimeMillis());
            course.setCourseStatus("免费");
            courseMapper.insert(course);
        }
    }

    /**
     * 分库分表单个查询
     */
    @Test
    void findCourse() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",1615441489071L);
        wrapper.eq("course_id",576766666382245888L);

        Course course = courseMapper.selectOne(wrapper);
        System.out.println(course);
    }

    /**
     * 分库分表多个数据查询
     */
    @Test
    void findCourses() {
        List<Course> course = courseMapper.selectList(null);
        course.forEach(s->System.out.println(s));

    }

    /**
     * 分库分表更新操作
     */
    @Test
    void updateCourse() {
        QueryWrapper wrapper = new QueryWrapper();

        wrapper.eq("course_id",576766666382245888L);
        Course course = new Course();
        course.setCourseStatus("收费");
        courseMapper.update(course,wrapper);
    }

    //#####################################读写分离#########################################

    /**
     * 读写分离添加数据测试
     */
    @Test
    void readerWriterAddCourse() {
        CourseReader course1 = new CourseReader();
        course1.setCourseName("测试");
        course1.setUserId(12344L);
        course1.setCourseStatus("免费");
        course1Mapper.insert(course1);
    }

    /**
     * 查询
     */
    @Test
    void findReaderWriterCourse() {

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("course_id", 123L);
        course1Mapper.selectOne(wrapper);
    }

    /**
     * 读写分离更新
     */
    @Test
    void updateReaderWriterCourse() {

        CourseReader course1 = new CourseReader();
        course1.setCourseStatus("收费");

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("course_id", 123L);

        course1Mapper.update(course1, wrapper);
    }


}
