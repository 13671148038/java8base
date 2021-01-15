package com.balimiao;

import com.balimiao.annotation.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class PoiTest {
    @Test
    public void aaa() throws Exception {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\54507\\Desktop\\学校模板.xlsx");
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        System.out.println(lastRowNum);
        for (int i = 0; i < lastRowNum; i++) {
            Row row = sheet.getRow(i);
            String provinceName = row.getCell(0).getStringCellValue();//省
            String cityName = row.getCell(1).getStringCellValue();//市
            String districtName = row.getCell(2).getStringCellValue();//区
            String schoolName = row.getCell(3).getStringCellValue();//学校名字
            if (StringUtils.trimToEmpty(provinceName).equals("") || StringUtils.trimToEmpty(cityName).equals("") || StringUtils.trimToEmpty(districtName).equals("") || StringUtils.trimToEmpty(schoolName).equals("")) {
                break;
            }
            System.out.println("provinceName:" + provinceName + "cityName:" + cityName + "districtName:" + districtName + "schoolName:" + schoolName);
        }
    }

    @Test
    public void aaaa() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setName("sdcsdc");
        userList.add(user);

        User user1 = userList.stream().filter(c -> c.getName().equals("sdcsdc")).findFirst().orElse(null);
        user1.setName("为单位多翁多");
        User user2 = userList.get(0);
        System.out.println(user2 == user1);
        System.out.println(user2);

    }

}
