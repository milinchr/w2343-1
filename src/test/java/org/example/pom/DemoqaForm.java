package org.example.pom;

import org.example.utils.WaitSel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DemoqaForm {
    public static WebDriver driver;
    @FindBy(xpath = "//*[@id='firstName']")
    WebElement firstName;
    @FindBy(css = "#lastName")
    WebElement lastName;
    @FindBy(id="userEmail")
    WebElement userEmail;
    @FindBy(id="userNumber")
    WebElement userNumber;
    @FindBy(id="dateOfBirthInput")
    WebElement date;
    @FindBy(id="subjectsInput")
    WebElement subjectsInput;
    @FindBy(id="state")
    WebElement state;
    @FindBy(id="city")
    WebElement city;
    @FindBy(id="submit")
    WebElement submit;
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
    public void setGender(String userGenderParam) {
        WebElement gender = driver.findElement(By.xpath("//*[@id='genterWrapper']//label[text()='" + userGenderParam + "']"));
        gender.click();
    }
    public void setUserNumber(String userNumberParam){
        userNumber.clear();
        userNumber.sendKeys(userNumberParam);
    }

    public void setDate(String dateParam) {
       date.sendKeys(Keys.COMMAND, "a");
       date.sendKeys(dateParam);
       date.sendKeys(Keys.ENTER);
    }
    public void setSubject(String subjectParam){
        subjectsInput.clear();
        subjectsInput.sendKeys(subjectParam);
        subjectsInput.sendKeys(Keys.ENTER);
    }
    public void setHobby(String hobbyParam){
        scrollToAmount(200);
        driver.findElement(By.xpath("//*[@id='hobbiesWrapper']//label[text()='"+hobbyParam + "']/../input")).click();

    }
    public void setState(String stateParam){
        state.click();
        driver.findElement(By.xpath("//*[text()='"+ stateParam +"']")).click();

    }
    public void setCity(String cityParam){
        city.click();
        driver.findElement(By.xpath("//*[text()='"+ cityParam +"']")).click();

    }
    public void scrollToAmount(int amountParam){
        new Actions(driver)
                .scrollByAmount(0, amountParam)
                .perform();
    }
    public void setSubmit(String submitParam){
        submit.click();
    }
    public String getValue(String labelParam){
        WebElement val = driver.findElement(By.xpath("//table//tr//td[text()='"+ labelParam + "']/../td[2]"));
        WaitSel.explicitWait(driver, ExpectedConditions.visibilityOf(val), 10);
        return val.getText();
    }
}
