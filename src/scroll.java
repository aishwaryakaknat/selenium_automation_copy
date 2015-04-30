import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class scroll {

	public static void main(String[] args) {
		WebDriver driver= new FirefoxDriver();
		driver.get("https://st-portal.onlifehealth.com/test_auth/hcsc");
		driver.manage().window().maximize();
		driver.findElement(By.id("http:__schemas.xmlsoap.org_ws_2005_05_identity_claims_name")).sendKeys("7653343");
        driver.findElement(By.name("commit")).click();
        WebElement element=driver.findElement(By.id("member-agreement"));
        Actions act= new Actions(driver);
        act.moveToElement(element).perform();
        act.sendKeys(Keys.PAGE_DOWN);
	}

}
