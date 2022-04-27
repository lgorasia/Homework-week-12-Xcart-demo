package homepage;

import net.bytebuddy.build.ToStringPlugin;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    @Test

    public void verifyUserShouldNavigateToShippingPageSuccessfully() {
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[3]/a[1]/span[1]"));
        String actualText = getTextFromElement(By.id("page-title"));
        String expectedText = "Shipping";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[4]/a[1]/span[1]"));
        String actualText = getTextFromElement(By.id("page-title"));
        String expectedText = "New arrivals";
        Assert.assertEquals(expectedText, actualText);
        Thread.sleep(2000);

    }

    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[5]/a[1]/span[1]"));
        String actualText = getTextFromElement(By.id("page-title"));
        String expectedText = "Coming soon";
        Assert.assertEquals(expectedText, actualText);
        Thread.sleep(2000);
    }
@Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[6]/a[1]/span[1]"));
        String actualText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        String expectedText = "Contact us";
        Assert.assertEquals(expectedText,actualText);
}
}


