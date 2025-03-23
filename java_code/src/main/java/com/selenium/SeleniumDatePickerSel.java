package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;

public class SeleniumDatePickerSel {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");         // Set the path to the ChromeDriver executable
        WebDriverManager.chromedriver().setup(); //updates and sets up chromedriver
        driver = new ChromeDriver();// Create a new instance of the Chrome driver
        driver.get("http://example.com");

        selectDate("2","May","2020");
    }

    public static void selectDate(String targetDay,String targetMonth,String targetYear){
        driver.findElement(By.id("datepicker")).click();
        while(true){
            String dispMonth = driver.findElement((By.cssSelector(".ui-datepicker-monthoption"))).getText();
            String dispYear = driver.findElement((By.cssSelector(".ui-datepicker-monthoption"))).getText();

            if(targetMonth.equals(dispMonth)&&targetYear.equals(dispYear)){
                break;
            }
            if(isMontYearLater(targetMonth,targetYear,dispMonth,dispYear)){
                WebElement next = driver.findElement(By.xpath("//span[text()='Next']"));
                next.click();
            }else{
                WebElement prev = driver.findElement(By.xpath("//span[text()='Prev']"));
                prev.click();
            }
        }
        WebElement dayPicker = driver.findElement(By.xpath("//table//tbody//tr//td//a[text()="+targetDay+"]"));
        dayPicker.click();

    }

    public static boolean isMontYearLater(String targetMonth,String targetYear,String dispMonth,String dispYear){
        int targetYearInt = Integer.parseInt(targetYear);
        int dispYearInt = Integer.parseInt(dispYear);

        if(targetYearInt>dispYearInt){
            return true;
        }else if(targetYearInt<dispYearInt){
            return false;
        }
        HashMap<String, Integer> monthMap = new HashMap<>();
        monthMap.put("February", 2);
        monthMap.put("January", 1);
        monthMap.put("March", 3);
        monthMap.put("April", 4);
        monthMap.put("May", 5);
        monthMap.put("June", 6);
        monthMap.put("July", 7);
        monthMap.put("August", 8);
        monthMap.put("September", 9);
        monthMap.put("October", 10);
        monthMap.put("November", 11);
        monthMap.put("December", 12);
        
        int targetMonthIndex = monthMap.get(targetMonth);
        int dispMonthIndex = monthMap.get(dispMonth);
        return targetMonthIndex > dispMonthIndex;


    }

}
