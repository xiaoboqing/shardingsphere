package com.wang.sharding.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("course_0")
@Data
public class CourseReader {
    private Long courseId;
    private String courseName;
    private Long userId;
    private String courseStatus;

}


