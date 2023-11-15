package uitest.m4_introduction;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import vladproduction.com.helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static vladproduction.com.helper.Pages.SAVINGS;

public class ScrapeTableDataTest {

    @Test
    public void scrapeTableDataTest(){

        WebDriver driver = DriverFactory.newDriver();
        driver.get(SAVINGS);

        Table<Integer, Integer, String> tableObject = HashBasedTable.create();
        WebElement table = driver.findElement(By.id("rates"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        int rowIndex = 0;
        int colIndex = 0;
        for (WebElement row: rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col: cols) {
                tableObject.put(rowIndex, colIndex++, col.getText());
            }
            rowIndex++;
            colIndex = 0;
        }
        System.out.println(tableObject);
        System.out.println("Best rate: " + tableObject.get(1,3));

        driver.quit();

//        {0={0=, 1=6 months, 2=1 year, 3=2 years}, 1={0=Us, 1=4%, 2=5%, 3=6%}, 2={0=Competition, 1=2%, 2=3%, 3=4%}}
//        Best rate: 6%

    }
}
