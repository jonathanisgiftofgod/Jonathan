package greensSeleniumTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GreenSeleniumTest {
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://leafground.com");
		//Window Handling
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h5[contains(text(),'Window')]")).click();
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(2000);
		driver.findElement(By.id("home")).click();
		Set<String> handles = driver.getWindowHandles();
		System.out.println("Total Windows :" + handles.size());
		for (String newWindow : handles) {
			driver.switchTo().window(newWindow);
		}
		driver.findElement(By.xpath("(//h5[contains(text(),'Button')])[1]")).click();
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.navigate().back();
		//WebTable
		driver.findElement(By.xpath("(//h5[contains(text(),'Table')])[1]")).click();
		String progressValue = driver.findElement(By.xpath("//td[normalize-space()='Learn to interact with Elements']//following::td[1]")).getText();
		System.out.println("Progress value "+progressValue);
		//TakesScreenshot
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Britto\\Desktop\\JAVA\\Green Excersise\\Selenium\\ScreenShot\\final.png");
		FileHandler.copy(source, dest);
		//JavascriptExecutor insert values
		driver.navigate().to("https://www.facebook.com/");
		WebElement userId = driver.findElement(By.id("email"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='britto'", userId);
		//Scrolldown and scroll up
		WebElement help = driver.findElement(By.xpath("//a[@title='Visit our Help Centre.']"));
		js.executeScript("arguments[0].scrollIntoView(true)", help);
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(false)", userId);
		//FramesCount
		driver.navigate().to("http://leafground.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//h5[@class='wp-categories-title'])[10]")).click();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Frames count : "+frames.size());
		driver.navigate().back();
		//DropDown
		driver.findElement(By.xpath("(//h5[@class='wp-categories-title'])[5]")).click();
		WebElement dropDown = driver.findElement(By.id("dropdown1"));
		Select s = new Select(dropDown);
		s.selectByIndex(2);
		Thread.sleep(2000);
		s.selectByValue("4");
		Thread.sleep(2000);
		s.selectByVisibleText("UFT/QTP");
		List<WebElement> list = s.getOptions();
		for (WebElement allValues : list) {
			System.out.println(allValues.getText());
		}
		Thread.sleep(2000);
		WebElement multiSelect = driver.findElement(By.xpath("//*[@id='contentblock']/section/div[6]/select"));
		Select ss = new Select(multiSelect);
		ss.selectByIndex(0);
		ss.selectByIndex(1);
		ss.selectByIndex(2);
		List<WebElement> multipleBox = ss.getAllSelectedOptions();
		for (WebElement multi : multipleBox) {
			System.out.println("Selected Options : "+multi.getText());
		}
		ss.deselectByIndex(0);
		Thread.sleep(2000);
		ss.deselectByValue("2");
		Thread.sleep(2000);
		ss.deselectByVisibleText("Selenium");
		ss.selectByIndex(1);
		Thread.sleep(2000);
		ss.selectByIndex(2);
		ss.deselectAll();
		//MouseOverAction
		driver.navigate().to("http://greenstech.in/selenium-course-content.html");
		WebElement course = driver.findElement(By.xpath("//div[@title='Courses']"));
		Actions a = new Actions(driver);
		a.moveToElement(course).perform();
		//DragandDrop
		driver.navigate().to("http://leafground.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h5[contains(text(),'Droppable')]")).click();
		WebElement dragFrom = driver.findElement(By.id("draggable"));
		WebElement dropTo = driver.findElement(By.id("droppable"));
		a.clickAndHold(dragFrom).moveToElement(dropTo).release().perform();
		driver.navigate().to("https://www.facebook.com/");
		WebElement userEmail = driver.findElement(By.id("email"));
		userEmail.sendKeys("joseph");
		a.doubleClick(userEmail).perform();
		a.contextClick(userEmail).perform();
		Robot r = new Robot();
		for (int i = 0; i <=2; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("login"))));
	
		driver.navigate().to("http://adactinhotelapp.com/");
		driver.findElement(By.id("username")).sendKeys("britto619");
		driver.findElement(By.id("password")).sendKeys("SR185Y");
		Wait<WebDriver> w = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);
		WebElement submit = w.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver t) {
				return t.findElement(By.id("login"));
			}
		});
		submit.click();
		
		//Get fon size and color  
		WebElement text = driver.findElement(By.xpath("//a[text()='Booked Itinerary']"));
		Dimension size = text.getSize();
		int height = size.height;
		int width = size.width;
		System.out.println("Height: "+height);
		System.out.println("Width: "+width);
		
		Point l = text.getLocation();
		int x = l.getX();
		int y = l.getY();
		System.out.println(x);
		System.out.println(y);
		
		String x1 = text.getCssValue("font-size");
		System.out.println(x1);
		String x2 = text.getCssValue("color");
		System.out.println(x2);
		String x3 = text.getCssValue("font-family");
		System.out.println("font family "+x3);
		String x4 = text.getCssValue("font-weight");
		System.out.println("font weight "+x4);
		String x5 = text.getCssValue("background");
		System.out.println(x5);
		
		//Highlight the WebElement
		driver.navigate().back();
		WebElement user = driver.findElement(By.id("username"));
		js.executeScript("arguments[0].setAttribute('style','background:green;border:solid 2px red');", user);
 		user.sendKeys("britto619");
		
		//Alert
		driver.navigate().to("http://leafground.com/pages/Alert.html");
		driver.findElement(By.xpath("//button[@onclick='confirmPrompt()']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("britto");
		alert.accept();
	}
}
