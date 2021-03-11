package com.wang.sharding.entity;

import lombok.Data;

@Data
public class Course {

    private Long courseId;
    private String courseName;
    private Long userId;
    private String courseStatus;
}
