package com.baizhi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.entity.GirlFriend;
import com.baizhi.entity.Img;
import com.baizhi.entity.Student;
import com.baizhi.entity.Teacher;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasypoiApplicationTests {

    @Test
    public void daoRu() {

        Student student1 = new Student("1", "小黑", new Date(), 20, "1");
        Student student2 = new Student("2", "小花", new Date(), 18, "2");
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("160班学生", "学生"),
                Student.class, students);

        try {
            workbook.write(new FileOutputStream(new File("D:/easy.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void oneToDuo() {

        Student student1 = new Student("1", "小黑", new Date(), 20, "1");
        Student student2 = new Student("2", "小花", new Date(), 18, "2");
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        Teacher teacher1 = new Teacher("1", "老师一号", students, new GirlFriend("么么1"));
        Teacher teacher2 = new Teacher("2", "老师二号", students, new GirlFriend("么么2"));
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("160班学生", "学生"),
                Teacher.class, teachers);

        try {
            workbook.write(new FileOutputStream(new File("D:/easy.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Img() {
        Img img = new Img("1", "D:\\idea\\easypoi\\src\\main\\webapp\\img\\log.png");
        List<Img> imgs = new ArrayList<>();
        imgs.add(img);

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("图片", "图片"),
                Img.class, imgs);

        try {
            workbook.write(new FileOutputStream(new File("D:/Img.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void daoChu() {

        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(2);

        try {
            List<Teacher> list = ExcelImportUtil.importExcel(new FileInputStream(new File("D:/easy.xls")), Teacher.class, params);
            for (Teacher teacher : list) {
                System.out.println(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
