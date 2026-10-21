package org.example.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaForm {
    public static WebDriver driver;
    @FindBy(xpath = "//*[@id='firstName']")
    WebElement firstName;
    @FindBy(css = "#lastName")
    WebElement lastName;
    @FindBy(id="userEmail")
    WebElement userEmail;
    public DemoqaForm(WebDriver driverParam){
        driver =driverParam;
        PageFactory.initElements(driverParam, this);
    }
    public void setLastName(String lastNameParam){
        lastName.clear();
        lastName.sendKeys(lastNameParam);
    }
    public void setFirstName(String firstNameParam){
        firstName.clear();
        firstName.sendKeys(firstNameParam);
    }
    public void setUserEmail(String userEmailParam){
        userEmail.clear();
        userEmail.sendKeys(userEmailParam);
    }
}
