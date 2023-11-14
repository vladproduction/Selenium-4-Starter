package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Loans {

    private static final String URL = "http://localhost:8080/web/loans.html";
    private final WebDriver driver;

    private Loans(WebDriver driver) {
        this.driver = driver;
    }

    public static Loans loansPage(WebDriver driver) {
        return new Loans(driver);
    }

    public void goTo(){
        driver.get(URL);
    }

    public void enterBorrowAmount(String value){
        driver.findElement(By.id("borrow")).sendKeys(value);
    }

    public void selectTimePeriod(Period period){
        Select dropdown = new Select(driver.findElement(By.id("period")));
        dropdown.selectByVisibleText(period.toString());
    }

    public String getResultMessage(){
        var result = new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(visibilityOfElementLocated(By.id("result")));
        return result.getText();
    }

    public void verifyResultMessage(String expectedMessage){
        Assert.assertEquals(getResultMessage(), expectedMessage);
    }

    public enum Period{
        ONE_YEAR("1 year"),
        TWO_MONTHS("2 months"),
        ONE_MONTH("1 month");

        final String period;

        Period(String period) {
            this.period = period;
        }

        @Override
        public String toString() {
            return period;
        }
    }
}
