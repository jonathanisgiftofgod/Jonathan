package jonathan;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstProgram {

	public static void main(String[] args) {
		int a[] = {1,2,4,5,6,9,10};
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
		l.add(a[i]);
		}
		System.out.println("Given array: "+l);
		List<Integer> m = new ArrayList<>();
		for (int i = 1; i <=10; i++) {
			m.add(i);
		}
		System.out.println(m);
		m.removeAll(l);
		System.out.println("Final Array : "+m);
	}	
}
 