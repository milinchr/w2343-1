package org.example.testng.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pom.DemoqaForm;
import org.example.utils.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormTest {
    private static final Logger logger = LogManager.getLogger(FormTest.class);
    static public WebDriver driver;
    public static String URI="https://demoqa.com/automation-practice-form";
    public static String FIRST_NAME ="Liudmila";
    public static String LAST_NAME ="Zugravu";
    public static String USER_EMAIL ="li.mila170@gmail.com";
    public static String USER_GENDER ="Female";
    public static String USER_NUMBER ="0069614900";
    public static String DATE ="24 Jan 2008";
    public static String SUBJECT ="Maths";
    public static String HOBBY ="Music";
    public static String STATE ="NCR";
    public static String CITY ="Delhi";
    public static String SUBMIT;


    @BeforeTest
    public void beforeTest(){
        driver = SeleniumDriver.getAutoLocalDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void formTest() throws InterruptedException{
        logger.info("Start test");
        driver.get(URI);
        DemoqaForm form = new DemoqaForm(driver);
        form.setFirstName(FIRST_NAME);
        form.setLastName(LAST_NAME);
        form.setUserEmail(USER_EMAIL);
        form.setGender(USER_GENDER);
        form.setUserNumber(USER_NUMBER);
        form.setDate(DATE);
        form.setSubject(SUBJECT);
        form.setHobby(HOBBY);
        form.setState(STATE);
        form.setCity(CITY);
        form.setSubmit(SUBMIT);
        String actualName = form.getValue("Student Name");
        Assert.assertEquals(actualName, FIRST_NAME + " " + LAST_NAME);
        Thread.sleep(10000);
        logger.info("Finish test");
    }
@AfterTest
 public void afterTest(){
     driver.quit();
   }
}
