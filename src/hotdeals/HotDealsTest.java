package hotdeals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class HotDealsTest extends Utility {
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
    public void verifyProductArrangeAlphabetically() {
        Actions actions = new Actions(driver);
        WebElement hotDeals = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) > span.primary-title:nth-child(1)"));
        WebElement sale = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) ul:nth-child(2) li.leaf:nth-child(1) a:nth-child(1) > span:nth-child(1)"));
        actions.moveToElement(hotDeals).moveToElement(sale).click().build().perform();
        //verify sale
        String actualText = getTextFromElement(By.id("page-title"));
        String expectedText = "Sale";
        Assert.assertEquals(expectedText, actualText);
        // sory by a-z

        WebElement sortBy = driver.findElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        WebElement nameAToZ = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-sale-products.one-sidebar.sidebar-first.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.clearfix div.flex-container div.column:nth-child(3) div.section div.list-container:nth-child(2) div.block.block-block.block-sale-products:nth-child(3) div.content div.items-list.items-list-products.sale-products div.list-header:nth-child(3) div.sort-box ul.display-sort.sort-crit.grid-list:nth-child(2) li.list-type-grid:nth-child(5) > a:nth-child(1)"));
        actions.moveToElement(sortBy).moveToElement(nameAToZ).click().build().perform();
        // List<WebElement> productList= driver.findElements(By.className("products"));
    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() {


        Actions actions = new Actions(driver);
        WebElement hotDeals1 = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) > span.primary-title:nth-child(1)"));
        WebElement sale1 = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) ul:nth-child(2) li.leaf:nth-child(1) a:nth-child(1) > span:nth-child(1)"));
        actions.moveToElement(hotDeals1).moveToElement(sale1).click().build().perform();
        //verify sale
        String actualText1 = getTextFromElement(By.id("page-title"));
        String expectedText1 = "Sale";
        Assert.assertEquals(expectedText1, actualText1);
        // sory by low to high

        WebElement sortBy1 = driver.findElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        WebElement nameAToZ1 = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-sale-products.one-sidebar.sidebar-first.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.clearfix div.flex-container div.column:nth-child(3) div.section div.list-container:nth-child(2) div.block.block-block.block-sale-products:nth-child(3) div.content div.items-list.items-list-products.sale-products div.list-header:nth-child(3) div.sort-box ul.display-sort.sort-crit.grid-list:nth-child(2) li.list-type-grid:nth-child(3) > a:nth-child(1)"));

        actions.moveToElement(sortBy1).moveToElement(nameAToZ1).click().build().perform();
        //  List<WebElement> productList = driver.findElements(By.className("products"));

    }

    @Test
    public void verifySaleProductsArrangeByRates() {
        Actions actions = new Actions(driver);
        WebElement hotDeals1 = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) > span.primary-title:nth-child(1)"));
        WebElement sale1 = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) ul:nth-child(2) li.leaf:nth-child(1) a:nth-child(1) > span:nth-child(1)"));
        actions.moveToElement(hotDeals1).moveToElement(sale1).click().build().perform();
        //verify sale
        String actualText1 = getTextFromElement(By.id("page-title"));
        String expectedText1 = "Sale";
        Assert.assertEquals(expectedText1, actualText1);
        // sory by rates

        WebElement sortBy1 = driver.findElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        WebElement nameAToZ1 = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-sale-products.one-sidebar.sidebar-first.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.clearfix div.flex-container div.column:nth-child(3) div.section div.list-container:nth-child(2) div.block.block-block.block-sale-products:nth-child(3) div.content div.items-list.items-list-products.sale-products div.list-header:nth-child(3) div.sort-box ul.display-sort.sort-crit.grid-list:nth-child(2) li.list-type-grid:nth-child(7) > a:nth-child(1)"));

        actions.moveToElement(sortBy1).moveToElement(nameAToZ1).click().build().perform();

    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() {
        Actions actions = new Actions(driver);
        WebElement hotDeals1 = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) > span.primary-title:nth-child(1)"));
        WebElement sale1 = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) ul:nth-child(2) li.leaf:nth-child(1) a:nth-child(1) > span:nth-child(1)"));
        actions.moveToElement(hotDeals1).moveToElement(sale1).click().build().perform();
        //verify sale
        String actualText1 = getTextFromElement(By.id("page-title"));
        String expectedText1 = "Sale";
        Assert.assertEquals(expectedText1, actualText1);
        // sory by z to A

        WebElement sortBy1 = driver.findElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        WebElement nameAToZ1 = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-sale-products.one-sidebar.sidebar-first.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.clearfix div.flex-container div.column:nth-child(3) div.section div.list-container:nth-child(2) div.block.block-block.block-sale-products:nth-child(3) div.content div.items-list.items-list-products.sale-products div.list-header:nth-child(3) div.sort-box ul.display-sort.sort-crit.grid-list:nth-child(2) li.list-type-grid:nth-child(6) > a:nth-child(1)"));

        actions.moveToElement(sortBy1).moveToElement(nameAToZ1).click().build().perform();

    }
    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow(){
        Actions actions = new Actions(driver);
        WebElement hotDeals1 = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) > span.primary-title:nth-child(1)"));
        WebElement sale1 = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) ul:nth-child(2) li.leaf:nth-child(1) a:nth-child(1) > span:nth-child(1)"));
        actions.moveToElement(hotDeals1).moveToElement(sale1).click().build().perform();
        //verify sale
        String actualText1 = getTextFromElement(By.id("page-title"));
        String expectedText1 = "Sale";
        Assert.assertEquals(expectedText1, actualText1);
        // sory by high to low

        WebElement sortBy1 = driver.findElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        WebElement nameAToZ1 = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-sale-products.one-sidebar.sidebar-first.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.clearfix div.flex-container div.column:nth-child(3) div.section div.list-container:nth-child(2) div.block.block-block.block-sale-products:nth-child(3) div.content div.items-list.items-list-products.sale-products div.list-header:nth-child(3) div.sort-box ul.display-sort.sort-crit.grid-list:nth-child(2) li.list-type-grid:nth-child(4) > a:nth-child(1)"));

        actions.moveToElement(sortBy1).moveToElement(nameAToZ1).click().build().perform();

    }
    @Test
    public void verifyBestSellersProductsArrangeByRates(){
        Actions actions = new Actions(driver);
        WebElement hotDeals1 = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) > span.primary-title:nth-child(1)"));
        WebElement sale1 = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) ul:nth-child(2) li.leaf:nth-child(1) a:nth-child(1) > span:nth-child(1)"));
        actions.moveToElement(hotDeals1).moveToElement(sale1).click().build().perform();
        //verify sale
        String actualText1 = getTextFromElement(By.id("page-title"));
        String expectedText1 = "Sale";
        Assert.assertEquals(expectedText1, actualText1);
        // sory by rates

        WebElement sortBy1 = driver.findElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        WebElement nameAToZ1 = driver.findElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-sale-products.one-sidebar.sidebar-first.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.clearfix div.flex-container div.column:nth-child(3) div.section div.list-container:nth-child(2) div.block.block-block.block-sale-products:nth-child(3) div.content div.items-list.items-list-products.sale-products div.list-header:nth-child(3) div.sort-box ul.display-sort.sort-crit.grid-list:nth-child(2) li.list-type-grid:nth-child(7) > a:nth-child(1)"));

        actions.moveToElement(sortBy1).moveToElement(nameAToZ1).click().build().perform();

    }
}
