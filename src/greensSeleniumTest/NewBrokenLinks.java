package greensSeleniumTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewBrokenLinks {
	public static void main(String[] args) {
		VerifyBrokenLinks();
	}
	public static void VerifyBrokenLinks() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for (WebElement link : links) {
			String linkhref = link.getAttribute("href");
			
			try {
				URL url = new URL(linkhref);
				URLConnection urlConnection = url.openConnection();
				HttpURLConnection httpUrlConnection= (HttpURLConnection) urlConnection;
				
				httpUrlConnection.setConnectTimeout(4000);
				httpUrlConnection.connect();
				
				if (httpUrlConnection.getResponseCode()==200) {
					System.out.println(linkhref + " >> " + httpUrlConnection.getResponseCode() + " >> " + httpUrlConnection.getResponseMessage());
				} else {
					System.err.println(linkhref + " >> " + httpUrlConnection.getResponseCode() + " >> " + httpUrlConnection.getResponseMessage());
				}
				httpUrlConnection.disconnect();
			} catch (IOException e) {
				System.err.println(linkhref	);
			}
		}
		driver.close();
	}
}
