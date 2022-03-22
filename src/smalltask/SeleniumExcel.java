package smalltask;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumExcel {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> iphone = driver.findElements(By.xpath("//span[contains(text(),'Apple iPhone ')]"));
		File f = new File("C:\\Users\\Britto\\eclipse-workspace\\jonathan\\Driver\\Excel.xlsx");
		f.createNewFile();

		for (int i = 0; i < iphone.size(); i++) {
			String text = iphone.get(i).getText();
			System.out.println(text);
		}
	}
}
