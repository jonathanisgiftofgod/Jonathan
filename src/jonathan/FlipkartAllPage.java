package jonathan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartAllPage {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("(//div[@class='xtXmba'])[1]")).click();
		driver.findElement(By.xpath("(//p[@class='_1aqDWQ'])[5]")).click();
		Thread.sleep(3000);
		WebElement min = driver.findElement(By.xpath("(//select[@class='_2YxCDZ'])[1]"));
		WebElement max = driver.findElement(By.xpath("(//select[@class='_2YxCDZ'])[2]"));
		Select smin = new Select(min);
		Select smax = new Select(max);
		smin.selectByValue("4000");
		smax.selectByValue("20000");
		WebElement pagination = driver.findElement(By.xpath("//span[text()='Next']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", pagination);
		js.executeScript("arguments[0].click()", pagination);
		List<WebElement> pageList = driver.findElements(By.xpath("//nav[@class='yFHi8N']/a"));
		List<Integer> li = new ArrayList<>();
		for (int i = 0; i < pageList.size(); i++) {
			boolean paginationStatus = driver.findElement(By.xpath("//span[text()='Next']")).isEnabled();
			if (paginationStatus) {
				pagination.click();
			}
			pageList.get(i).click();
			List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
			for (int j = 0; j < prices.size(); j++) {
				Thread.sleep(2000);
				String price = prices.get(j).getText();
				char[] c = price.toCharArray();
				String cost = "";
				for (int k = 0; k < c.length; k++) {
					if (c[k]>=32 && c[k]<=47) {
						
					} else {
						cost = cost + c[k];
					}
				}
				System.out.println(cost);
			}
		}
	}
}
