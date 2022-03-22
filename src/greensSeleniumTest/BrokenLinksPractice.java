package greensSeleniumTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksPractice {
	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links : "+links.size());
		
		for (int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);
			String link_url = element.getAttribute("href");
			verifyAllLinks(link_url);
		}
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println(images.size());
		
		System.out.println("**********************ALL LINKS CHECKED************************");
		driver.quit();		
	}

	public static void verifyAllLinks(String linkURL) {
		try {
			URL url = new URL(linkURL);
			HttpURLConnection httpURLConnect = (HttpURLConnection)url.openConnection();
			httpURLConnect.setConnectTimeout(4000);
			httpURLConnect.connect();
			
			if (httpURLConnect.getResponseCode()==200) {
				System.out.println(linkURL + " is " +httpURLConnect.getResponseMessage() + "Response code is : " + httpURLConnect.getResponseCode());
			} else {
				System.out.println("=======Broken=========");
				System.out.println(linkURL + " is " +httpURLConnect.getResponseMessage() + "Response code is : " + httpURLConnect.getResponseCode());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
