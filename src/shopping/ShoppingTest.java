package shopping;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class ShoppingTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // @After
    public void tearDown() {
        closeBrowser();
    }


    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForOllieTheAppControlled() throws InterruptedException {

        Actions actions = new Actions(driver);
        WebElement hotDeal = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]"));
        WebElement bestSellers = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]/span[1]"));
        actions.moveToElement(hotDeal).moveToElement(bestSellers).click().build().perform();
        //verify bestseller
        String expectedText = "Bestsellers";
        String actualText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals(expectedText, actualText);


        WebElement sortBy = driver.findElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        WebElement aToz = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-bestsellers.one-sidebar.sidebar-first.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.clearfix div.flex-container div.column:nth-child(3) div.section div.list-container:nth-child(2) div.block.block-block.block-bestsellers:nth-child(4) div.content div.items-list.items-list-products div.list-header:nth-child(3) div.sort-box ul.display-sort.sort-crit.grid-list:nth-child(2) li.list-type-grid:nth-child(4) > a:nth-child(1)"));
        actions.moveToElement(sortBy).moveToElement(aToz).click().build().perform();
        //select the product
        clickOnElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-bestsellers.one-sidebar.sidebar-first.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.clearfix div.flex-container div.column:nth-child(3) div.section div.list-container:nth-child(2) div.block.block-block.block-bestsellers:nth-child(4) div.content div.items-list.items-list-products div.products:nth-child(4) ul.products-grid.grid-list li.product-cell.box-product:nth-child(1) div.product.productid-42 div.infoBlock div.buttons-container div.add-to-cart-button button.btn.regular-button.add-to-cart.product-add2cart.productid-42 > span:nth-child(1)"));

        //verify add to basket
        String expectedAddToBasket = "Product has been added to your cart";
        String actualAddToBasket = getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        Assert.assertEquals(expectedAddToBasket, actualAddToBasket);
        clickOnElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-bestsellers.one-sidebar.sidebar-first.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div:nth-child(1) div.status-messages-wrapper:nth-child(2) div.status-messages-wrapper2 div:nth-child(1) > a.close:nth-child(1)"));
        //Click on cart
        Thread.sleep(3000);
        clickOnElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[4]"));
        // clickOnElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-bestsellers.one-sidebar.sidebar-first.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.header-right-bar:nth-child(5) div.lc-minicart.lc-minicart-horizontal.recently-updated.expanded div.internal-popup.items-list.full-cart div.buttons-row a.regular-button.cart > span:nth-child(1)"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));
        //varify item
        String expectedItem = "Your shopping cart - 1 item";
        String actualItem = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals(expectedItem, actualItem);
        //varify subtotal
        String expectedSubTotal = "$299.00";
        String actualSubtotal = getTextFromElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-cart.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.clearfix div.flex-container div.column:nth-child(2) div.section div.list-container:nth-child(2) div.block.block-block:nth-child(3) div.content div.clearfix ul.sums li.subtotal span.cart-subtotal:nth-child(2) span.surcharge > span.surcharge-cell"));
        Assert.assertEquals(expectedSubTotal, actualSubtotal);

        //go to check out
        clickOnElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-cart.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.clearfix div.flex-container div.column:nth-child(2) div.section div.list-container:nth-child(2) div.block.block-block:nth-child(3) div.content div.clearfix div:nth-child(2) ul.totals li.button.main-button > button.btn.regular-button.regular-main-button.checkout"));
        //verify login
        String expectedLogIn = "Log in to your account";
        String actualLogIn = getTextFromElement(By.xpath("//h3[contains(text(),'Log in to your account')]"));
        Assert.assertEquals(expectedLogIn, actualLogIn);
        //enter email and continue
        sendTextToElement(By.xpath("//input[@id='email']"), "lpatel@yahoo.com");
        clickOnElement(By.xpath("//span[contains(text(),'Continue')]"));
        //verify secure checkout
        String expectedCheckOut = "Secure Checkout";
        String actualCheckOut = getTextFromElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/h1[1]"));
        Assert.assertEquals(expectedCheckOut, actualCheckOut);
        //fill the form
        sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"), "Ram");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"), "Shyam");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"), "Abc street");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"), "London");
        clickOnElement(By.xpath("//input[@id='create_profile']"));
        sendTextToElement(By.xpath("//input[@id='password']"), "123456789");
        WebElement localShipping = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[2]/ul[1]/li[2]/div[1]/label[1]/input[1]"));
        actions.moveToElement(localShipping).click().build().perform();
        // clickOnElement(By.cssSelector("#method128"));
        //  clickOnElement(By.cssSelector("#pmethod6")
        WebElement payment = driver.findElement(By.cssSelector("#pmethod6"));
        actions.moveToElement(payment).click().build().perform();

        //verifytotal

        String expectedFianlTotal = "$309.73";
        String actualFianlTotal = getTextFromElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/span[2]/span[1]/span[1]"));
        Assert.assertEquals(expectedFianlTotal, actualFianlTotal);
//
//        //plade order
        Thread.sleep(5000);
        WebElement placeOrder = driver.findElement(By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']"));
        actions.moveToElement(placeOrder).click().build().perform();
        // clickOnElement(By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']"));

//       //Thankyou
        String expectedThankYou = "Thank you for your order";
        String actualThankYOu = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals(expectedThankYou, actualThankYOu);

    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement hotDeal = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]"));
        WebElement bestSellers = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]/span[1]"));
        actions.moveToElement(hotDeal).moveToElement(bestSellers).click().build().perform();
        Thread.sleep(1000);
        //verify bestseller
        String expectedText = "Bestsellers";
        String actualText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals(expectedText, actualText);
        Thread.sleep(1000);

        //sortBy

        WebElement sortBy = driver.findElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        WebElement aToz = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-bestsellers.one-sidebar.sidebar-first.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.clearfix div.flex-container div.column:nth-child(3) div.section div.list-container:nth-child(2) div.block.block-block.block-bestsellers:nth-child(4) div.content div.items-list.items-list-products div.list-header:nth-child(3) div.sort-box ul.display-sort.sort-crit.grid-list:nth-child(2) li.list-type-grid:nth-child(4) > a:nth-child(1)"));
        actions.moveToElement(sortBy).moveToElement(aToz).click().build().perform();
        Thread.sleep(3000);
        //add in cart

        WebElement addcart = driver.findElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[8]/div[1]/div[2]/div[4]/div[1]/button[1]"));

        actions.moveToElement(addcart).click().build().perform();
        Thread.sleep(2000);
        //verify add to basket
        String expectedAddToBasket = "Product has been added to your cart";
        String actualAddToBasket = getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        Assert.assertEquals(expectedAddToBasket, actualAddToBasket);
        clickOnElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-bestsellers.one-sidebar.sidebar-first.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div:nth-child(1) div.status-messages-wrapper:nth-child(2) div.status-messages-wrapper2 div:nth-child(1) > a.close:nth-child(1)"));
        Thread.sleep(2000);
        //Click on cart
        Thread.sleep(3000);
        clickOnElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[4]"));
        // clickOnElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-bestsellers.one-sidebar.sidebar-first.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.header-right-bar:nth-child(5) div.lc-minicart.lc-minicart-horizontal.recently-updated.expanded div.internal-popup.items-list.full-cart div.buttons-row a.regular-button.cart > span:nth-child(1)"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));
        //varify item
        String expectedItem = "Your shopping cart - 1 item";
        String actualItem = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals(expectedItem, actualItem);

        //empty your cart
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));

        //Verify the text “Are you sure you want to clear your cart?” on alert
        Alert alert = driver.switchTo().alert();
        String expectedMessage4 ="Are you sure you want to clear your cart?";
        String actualMessage4 = alert.getText();
        Assert.assertEquals(actualMessage4,expectedMessage4);
        //Click “Ok” on alert
        acceptAlert();
        Thread.sleep(1000);
       // Verify the message “Item(s) deleted from your cart”
        String expectedMessage5 ="Item(s) deleted from your cart";
        String actualMessage5 = getTextFromElement(By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"));
        Assert.assertEquals(actualMessage5,expectedMessage5);

        //Verify the text “Your cart is empty”
        String expectedMessage6 ="Your cart is empty";
        String actualMessage6 = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals(actualMessage6,expectedMessage6);




    }
}
