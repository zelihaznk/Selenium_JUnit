package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilites.TestBaseBeforeClassAfterClass;

import java.util.List;

public class homework2 extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1() {

        login();


    }

    private void login() {

        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");

        //Username : manager
        //Password : Manager1!
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager2!").
                sendKeys(Keys.ENTER).
                perform();




    }
}
