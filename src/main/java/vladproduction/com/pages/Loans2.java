package vladproduction.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Loans2 {

    private static final String URL = "http://localhost:8080/web/loans.html";
    private final WebDriver driver;

    private Loans2(WebDriver driver) {
        this.driver = driver;
    }

    public static Loans2 loansPage(WebDriver driver) {
        return new Loans2(driver);
    }

    public Loans2 goTo(){
        driver.get(URL);
        return this;
    }

    public Loans2 enterBorrowAmount(String value){
        driver.findElement(By.id("borrow")).sendKeys(value);
        return this;
    }

    public Loans2 selectTimePeriod(PeriodLoans2 period){
        Select dropdown = new Select(driver.findElement(By.id("period")));
        dropdown.selectByVisibleText(period.toString());
        return this;
    }

    public String getResultMessage(){
        var result = new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(visibilityOfElementLocated(By.id("result")));
        return result.getText();
    }

    public void verifyResultMessage(String expectedMessage){
        Assert.assertEquals(getResultMessage(), expectedMessage);
    }

    public enum PeriodLoans2{
        ONE_YEAR("1 year"),
        TWO_MONTHS("2 months"),
        ONE_MONTH("1 month");

        final String period;

        PeriodLoans2(String period) {
            this.period = period;
        }

        @Override
        public String toString() {
            return period;
        }
    }
}
