package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Img {
    @Excel(name = "编号")
    private String id;
    @Excel(name = "图片", type = 2, width = 20, height = 10)
    private String url;
}
