import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class OlxSearch {

	public static void main(String[] args) throws IOException {
		File file = new File("/Users/arizona/Downloads/chromedriver");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.olx.ua/nedvizhimost/kvartiry-komnaty/arenda-kvartir-komnat/");
		
		// get all rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='offers_table']/tbody//tr[@class='wrap']"));
		// for every line store column
		for (WebElement row : rows) {
		    WebElement key = row.findElement(By.xpath("./td"));
		    String keyOutput = key.getText();
		    System.out.println(keyOutput);
		    
		    PrintWriter out = new PrintWriter(new FileWriter("test.txt", true));
		    out.println(keyOutput + "\t");
		    out.flush();
		}

	
		
//		driver.close();
//		driver.quit();

	}

}
