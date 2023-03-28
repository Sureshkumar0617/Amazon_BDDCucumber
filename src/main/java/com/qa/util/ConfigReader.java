package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigReader {

	public static String URL;
	public static Properties prop;
	private Logger logg;


	public ConfigReader(Logger logg) {
		this.logg=logg;
	}  

	public static Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

	public static  String readBrowser() throws IOException {
		prop = init_prop();
		String browservalue=prop.getProperty("browser");
		return browservalue;
	}
	public static  String readLoginURL() {
		prop = init_prop();
		String LoginURL=prop.getProperty("loginURL");
		return LoginURL;
	}
	public static  String readLoginURLIndia() {
		prop = init_prop();
		String LoginURL=prop.getProperty("loginURLIndia");
		return LoginURL;
	}
	
	public static  String readsearchHotelURL() {
		prop = init_prop();
		String searchHotelURL=prop.getProperty("searchHotelURL");
		return searchHotelURL;
	}
	public static  String readexcel_SearchHotel() {
		prop = init_prop();
		String excel_SearchHotel=prop.getProperty("excel_SearchHotel");
		return excel_SearchHotel;
	}
	public static  String readBookHotelURL() {
		prop = init_prop();
		String BookHotelURL=prop.getProperty("BookHotelURL");
		return BookHotelURL;
	}
	public static  String readjson_Payment() {
		prop = init_prop();
		String json_Payment=prop.getProperty("json_Payment");
		return json_Payment;
	}
	public static  String readuserid() {
		prop = init_prop();
		String login_userid=prop.getProperty("userid");
		return login_userid;
	}
	public static  String readuserid1() {
		prop = init_prop();
		String login_userid1=prop.getProperty("userid1");
		return login_userid1;
	}
	public static  String readuserid2() {
		prop = init_prop();
		String login_userid2=prop.getProperty("userid2");
		return login_userid2;
	}

	public static  String readpincode() {
		prop = init_prop();
		String pincode=prop.getProperty("Pincode");
		return pincode;
	}

	public static  String readpswrd() {
		prop = init_prop();
		String login_pswrd=prop.getProperty("pswrd");
		return login_pswrd;
	}
	public static  String readpswrd1() {
		prop = init_prop();
		String login_pswrd1=prop.getProperty("pswrd1");
		return login_pswrd1;
	}
	public static  String readpswrd2() {
		prop = init_prop();
		String login_pswrd2=prop.getProperty("pswd2");
		return login_pswrd2;
	}

	public static String readTestSuiteDirectory() throws Exception {
	try
	{
		prop = init_prop();
	return prop.getProperty("testSuiteDirectory");
	}
	catch (Exception e){
	e.printStackTrace();
	throw e;
	}
	}
	public static String readLoginEmpId() throws Exception {
		try
		{
			prop = init_prop();
		return prop.getProperty("LoginEmpId");
		}
		catch (Exception e){
		e.printStackTrace();
		throw e;
		}
		}
	public static String getApplicationName() throws Exception {
		try
		{
			prop = init_prop();
		return prop.getProperty("ApplicationName");
		}
		catch (Exception e){
		e.printStackTrace();
		throw e;
		}
		}
	public static String readJdbcDriver() throws Exception {
		try
		{
			prop = init_prop();
		return prop.getProperty("ApplicationName");
		}
		catch (Exception e){
		e.printStackTrace();
		throw e;
		}
		}
	public static String getOS() throws Exception {
		try
		{
			prop = init_prop();
		return prop.getProperty("OS");
		}
		catch (Exception e){
		e.printStackTrace();
		throw e;
		}
		}

	public static String getEnvironment() throws Exception {
		try
		{
			prop = init_prop();
		return prop.getProperty("Environment");
		}
		catch (Exception e){
		e.printStackTrace();
		throw e;
		}
		}

	public static String readexcel() throws Exception {
		try
		{
			prop = init_prop();
		return prop.getProperty("excel");
		}
		catch (Exception e){
		e.printStackTrace();
		throw e;
		}
		}

}
