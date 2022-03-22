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

public class NewBrokenImages {
	public static void main(String[] args) {
		VerifyBrokenImages();
	}
	public static void VerifyBrokenImages() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total images : " + images.size());
		
		for (WebElement image : images) {
			String linksrc = image.getAttribute("src");
			
			try {
				URL url = new URL(linksrc);
				URLConnection urlConnection = url.openConnection();
				HttpURLConnection httpUrlConnection = (HttpURLConnection)urlConnection;
				
				httpUrlConnection.setConnectTimeout(4000);
				httpUrlConnection.connect();
				
				if (httpUrlConnection.getResponseCode()==200) {
					System.out.println(linksrc + ">>" + httpUrlConnection.getResponseCode() +" >> " + httpUrlConnection.getResponseMessage());
				} else {
					System.err.println(linksrc + ">>" + httpUrlConnection.getResponseCode() +" >> " + httpUrlConnection.getResponseMessage());
				}
				httpUrlConnection.disconnect();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		driver.close();
	}
}
