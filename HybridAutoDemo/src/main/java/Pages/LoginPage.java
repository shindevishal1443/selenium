package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement User;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement Pass;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement Button;

    public void Login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(User)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(Pass)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(Button)).click();
    }
}
