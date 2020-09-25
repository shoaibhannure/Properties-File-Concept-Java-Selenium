package com.shoaib.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadPropFile {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream("D:\\javabykiran\\ReadPropFile\\Config.properties");
		prop.load(fis);

		String name = prop.getProperty("name");
		System.out.println(name);

		// System.out.println(prop.getProperty("name"));

		System.out.println(prop.getProperty("age"));

		String url = prop.getProperty("URL");

		System.out.println(url);

		String browserName = prop.getProperty("browser");

		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); // launch chrome
		} else if (browserName.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();  //launch firefox
		} else if (browserName.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver(); //launch IE
		}

		driver.get(url);

		driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).sendKeys(prop.getProperty("firstName"));

		driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).sendKeys(prop.getProperty("lastName"));

		driver.findElement(By.xpath(prop.getProperty("city_xpath"))).sendKeys(prop.getProperty("city"));

	}

}
