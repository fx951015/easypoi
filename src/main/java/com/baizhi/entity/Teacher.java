package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelTarget(value = "教师")
public class Teacher {
    @Excel(name = "id", needMerge = true)
    private String id;
    @Excel(name = "教师姓名", needMerge = true)
    private String name;
    @ExcelCollection(name = "学生们", orderNum = "7")
    private List<Student> students;
    @ExcelEntity(name = "女朋友")
    private GirlFriend girlFriend;
}
