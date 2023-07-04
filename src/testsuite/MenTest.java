package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class MenTest extends Utility {

    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldAddProductSuccessFullyToShoppingCart() {

        /*Mouse Hover on Men Menu
* Mouse Hover on Bottoms
* Click on Pants*/
        WebElement men = driver.findElement(By.xpath("//span[text()='Men']"));
        WebElement bottoms = driver.findElement(By.xpath("//a[@id='ui-id-18']"));
        WebElement pants = driver.findElement(By.xpath("(//span[text()='Pants'])[2]"));

        Actions actions = new Actions(driver);

        /* actions.moveToElement(computer).build().perform();
        actions.moveToElement(software).click().build().perform();*/

        actions.moveToElement(men).moveToElement(bottoms).moveToElement(pants).click().build().perform();

        //WebElement cronus=driver.findElement(By.xpath("(//div[@class='product details product-item-details'])[1]"));
        // WebElement colour=driver.findElement(By.xpath("((//div[@id='option-label-size-143-item-175'])[1]"));
        sleep(100);
        clickOnElement(By.xpath(("//div[@id='option-label-size-143-item-175'][1]")));
        sleep(100);
        clickOnElement(By.xpath(("//div[@id='option-label-color-93-item-49'][1]")));
        sleep(100);
        clickOnElement(By.xpath(("//button[@class='action tocart primary'][1]")));
       // getTextFromElement(By.xpath("//div[@class='message-success success message']"));
        sleep(100);
        String expectedText="You added Cronus Yoga Pant to your shopping cart.";
        String actualText=getTextFromElement(By.xpath("//div[@data-ui-id='message-success']"));
        System.out.println(actualText);
        Assert.assertEquals("Expected result",expectedText,actualText);
        clickOnElement(By.xpath(("//a[text()='shopping cart']")));

        String expectedCart="Shopping Cart";
        String actualCart=getTextFromElement(By.xpath("//span[@class='base']"));
        System.out.println(actualCart);
        Assert.assertEquals("Verify the text",expectedCart,actualCart);

        String expectedProductName="Cronus Yoga Pant";
        String actualProductName=getTextFromElement(By.xpath("(//div[@class='product-item-details']/strong/a)[1]"));



        String expectedSize="32";
        String actualSize=getTextFromElement(By.xpath("//dl[@class='item-options']/dd[1]"));
        System.out.println(actualSize);
        Assert.assertEquals("Verify the Size",expectedSize,actualSize);


        String expectedColour="Black";
        String actualColour=getTextFromElement(By.xpath("//dl[@class='item-options']/dd[2]"));
        System.out.println(actualColour);
        Assert.assertEquals("Verify the colour",expectedColour,actualColour);



    }
}