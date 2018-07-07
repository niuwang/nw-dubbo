package io.ymq.dubbo.test;

import cn.newbanker.ConsumerApplication;
import cn.newbanker.service.impl.ConsumerServiceImpl;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *单元测试方法
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerApplication.class)
public class ConsumerTest {

    @Autowired
    private ConsumerServiceImpl consumerDemoService;

    @Test
    public void sayHello(){
        consumerDemoService.sayHello("Peng Lei");
    }
    public void readAndWriteExcel() throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("d:\\poi\\测试.xlsx"));
        //读取工作簿
        XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
        //读取工作表
        XSSFSheet sheet = workBook.getSheetAt(0);
        //读取行
        XSSFRow row = sheet.getRow(2);
        //读取单元格
        XSSFCell cell = row.getCell(2);
        String value = cell.getStringCellValue();

        System.out.println(value);

        inputStream.close();//关闭工作簿
        workBook.close();


        //创建工作簿
        XSSFWorkbook workBook1 = new XSSFWorkbook();
        //创建工作表
        XSSFSheet sheet1 = workBook.createSheet("helloWorld");
        //创建行
        XSSFRow row1 = sheet.createRow(2);
        //创建单元格，操作第三行第三列
        XSSFCell cell1 = row.createCell(2, CellType.STRING);
        cell.setCellValue("helloWorld");

        FileOutputStream outputStream = new FileOutputStream(new File("d:\\poi\\测试.xlsx"));
        workBook.write(outputStream);

        workBook.close();//记得关闭工作簿

    }
}
