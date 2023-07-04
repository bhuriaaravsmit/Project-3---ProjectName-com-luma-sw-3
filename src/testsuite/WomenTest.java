package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {

    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
/*Mouse Hover on Women Menu
* Mouse Hover on Tops
* Click on Jackets*/

        WebElement women = driver.findElement(By.xpath("//span[text()='Women']"));
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        WebElement jackets= driver.findElement(By.xpath("(//span[text()='Jackets'])[1]"));
        Actions actions=new Actions(driver);

        /* actions.moveToElement(computer).build().perform();
        actions.moveToElement(software).click().build().perform();*/

        actions.moveToElement(women).moveToElement(tops).moveToElement(jackets).click().build().perform();
/*
/*Select Sort By filter “Product Name”
* Verify the products name display in
alphabetical order*/
        WebElement dropDown = driver.findElement(By.id("sorter"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Product Name");

        List<WebElement> elementList = driver.findElements(By.xpath("//a[@class='product-item-link']"));
        List<String> list=new ArrayList();
        List<String> sortedlist=new ArrayList();

        System.out.println("Total Products are " + elementList.size());
        for (WebElement web : elementList) {
            list.add(web.getText());
            sortedlist.add(web.getText());
            System.out.println(web.getText());
        }
        Collections.sort(sortedlist);
        Assert.assertTrue(list.equals(sortedlist));

    }
@Test
    public void verifyTheSortByPriceFilter(){

    WebElement women = driver.findElement(By.xpath("//span[text()='Women']"));
    WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
    WebElement jackets= driver.findElement(By.xpath("(//span[text()='Jackets'])[1]"));
    Actions actions=new Actions(driver);

        /* actions.moveToElement(computer).build().perform();
        actions.moveToElement(software).click().build().perform();*/

    actions.moveToElement(women).moveToElement(tops).moveToElement(jackets).click().build().perform();

    WebElement dropDown = driver.findElement(By.id("sorter"));
    Select select = new Select(dropDown);

    select.selectByVisibleText("Price");
    List<WebElement> elementList = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));
    List<String> list=new ArrayList();
    List<String> sortedlist=new ArrayList();
/*Select Sort By filter “Price”
* Verify the products price display in
Low to High*/
    System.out.println("Total Prices are " + elementList.size());
    for (WebElement web : elementList) {
        list.add(web.getText());
        sortedlist.add(web.getText());
        System.out.println(web.getText());
    }
    Collections.sort(sortedlist);
    Assert.assertTrue(list.equals(sortedlist));

}
    @After
    public void tearDown() {
//        closeBrowser();
    }

}



