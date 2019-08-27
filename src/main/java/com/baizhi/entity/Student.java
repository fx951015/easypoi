package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @ExcelIgnore
    private String id;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "生日", format = "yyyy-MM-dd", orderNum = "3", width = 30)
    private Date bir;
    @Excel(name = "年龄")
    private Integer age;
    @Excel(name = "性别", replace = {"男_1", "女_2"}, suffix = "生")
    private String sex;
}
