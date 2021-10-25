package com.shipment.automation.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class SpecialMethods {

    public static JavascriptExecutor executor;
    public static Properties properties;
    public static String defaultContent;
    public static int rowCount;

    public static void configProperties (){
        waitFor(1000);
        properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/conf.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void waitFor(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickJS(WebDriver driver, By by) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(by));
    }


    public static void scroll(WebDriver driver, By by) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", new Object[]{driver.findElement(by)});
    }

    public static void write(WebDriver driver, By by, String string){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(by).sendKeys(string);
    }

    public static WebElement selectRandomOptionFromList(WebDriver driver, By by){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> listElements = driver.findElements(by);
        int elementPosition = (int) (Math.random()*listElements.size());
        return listElements.get(elementPosition);
    }

    public static void validations(WebDriver driver, By by, String expectedString){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        assertEquals(driver.findElement(by).getText(),expectedString);
    }

    public static void visibleComponentValidation(WebDriver driver, By by){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        assertTrue(driver.findElement(by).isEnabled());
    }

    public static void sendEmail() {
        configProperties();
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(properties.getProperty("userForEmail"), properties.getProperty("passwordForEmail")));
        email.setSSLOnConnect(true);
        try {
            email.setFrom(properties.getProperty("destinationMail"));
            email.setSubject(properties.getProperty("subject"));
            email.setMsg(properties.getProperty("message"));
            email.addTo(properties.getProperty("destinationMail"));
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
    public static void screenshot(WebDriver driver, int rowNumber) {
        configProperties();
        Date date = new Date();
        String datos = "hh mm ss a dd-MMM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datos);

        java.io.File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(new File("C:\\RPASQA\\Evidences\\") + ".png"));
        }
        catch (IOException e)

        {
            System.out.println(e.getMessage());
        }
    }

    public static void switchWindow(WebDriver driver){
        defaultContent = driver.getWindowHandle();
        java.util.Set<String> lista = driver.getWindowHandles();
        Iterator<String> Il = lista.iterator();
        while(Il.hasNext()) {
            String child_windows = Il.next();
            if (!defaultContent.equals(child_windows)) {
                driver.switchTo().window(child_windows);
            }
        }
    }


    public static void excelLength(String filepath, String sheetName) throws IOException {
        File excelFile = new File(filepath);
        FileInputStream inputStream = new FileInputStream(excelFile);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
    }

    public static void writeExcel(Row currentRow, String value) {
        Cell cell = currentRow.createCell(currentRow.getLastCellNum());
        cell.setCellValue(value);
    }

    public static String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {
        excelLength(filepath,sheetName);
        File excelFile = new File(filepath);
        FileInputStream inputStream = new FileInputStream(excelFile);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(cellNumber);
        return cell.getStringCellValue();
    }
}
