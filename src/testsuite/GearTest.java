package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class GearTest extends Utility {

    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
/*Mouse Hover on Gear Menu
* Click on Bags
* Click on Product Name ‘Overnight Duffle’
* Verify the text ‘Overnight Duffle’*/


        WebElement gear = driver.findElement(By.xpath("//span[text()='Gear']"));
        WebElement bags = driver.findElement(By.xpath("//a[@id='ui-id-25']"));

        Actions actions = new Actions(driver);

        /* actions.moveToElement(computer).build().perform();
        actions.moveToElement(software).click().build().perform();*/

        actions.moveToElement(gear).moveToElement(bags).click().build().perform();

        clickOnElement(By.xpath("(//img[@class='product-image-photo'])[2]"));

        String expectedText = "Overnight Duffle";
        String actualText = getTextFromElement(By.xpath("//span[@class='base']"));
        System.out.println(actualText);
        Assert.assertEquals("Verify the text",expectedText,actualText);
//Change Qty 3
        sendTextToElement(By.xpath("//input[@id='qty']"),"3");
//Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));
        sleep(300);
        //Verify the text
        //‘You added Overnight Duffle to your shopping cart'
        String expectedDuffle="You added Overnight Duffle to your shopping cart.";
        String actualDuffle=getTextFromElement(By.xpath("//div[@data-ui-id='message-success']"));
        System.out.println(actualDuffle);
        Assert.assertEquals("Expected result",expectedDuffle,actualDuffle);
        //Click on ‘shopping cart’ Link into
        //message
        clickOnElement(By.xpath(("//a[text()='shopping cart']")));
        sleep(500);


//Verify the product price ‘$135.00’
        String expectedPrice="$135.00";
        String actualPrice=getTextFromElement(By.xpath("//td[@class='col subtotal']/span/span/span"));
        System.out.println(actualPrice);
        Assert.assertEquals("Verify the Price",expectedPrice,actualPrice);

        //Change Qty to ‘5’

        sendTextToElement(By.xpath("//input[@class='input-text qty']"),"5");
        //Click on ‘Update Shopping Cart’ button

        clickOnElement(By.xpath("//span[text()='Update Shopping Cart']"));

        String expectedUpdatedPrice="$225.00";
        String actualUpdatedPrice=getTextFromElement(By.xpath("(//span[text()='$225.00'])[1]"));
        System.out.println(actualPrice);
        Assert.assertEquals("Verify the Updated Price",expectedPrice,actualPrice);

    }
}
