import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import org.junit.Assert;





public class Beymensetfile {


        public static <string> void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:/Users/Atakan/Selenium/Chromedriver/chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            driver.get("https://www.beymen.com/");// go with driver to the page

            driver.manage().window().maximize();// make max window

           // WebElement search=driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/div/div/input"));//Go to the search box

            //search.sendKeys("şort");

            driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/div/div/input")).clear();


            WebElement gömlek=driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/div/div/input"));

            gömlek.sendKeys("gömlek");//set gömlek for search

            gömlek.sendKeys(Keys.ENTER);//press enter keyboard



            Thread.sleep(1000);

            WebElement selectPro =driver.findElement(By.cssSelector("#productList > div:nth-child(32) > div > div > div.m-productCard__detail > a:nth-child(2) > span"));//Select a product if location change of product the others will not work now we get passed for all and price should be 1299

            selectPro.click();

            driver.findElement(By.xpath("//*[@id=\"sizes\"]/div/span[3]")).click();//select size to add

            Thread.sleep(1500);

            WebElement sepetekle=driver.findElement(By.xpath("//*[@id=\"addBasket\"]"));

            sepetekle.click();

            Thread.sleep(1000);

           WebElement sepetim=driver.findElement(By.cssSelector("body > header > div > div > div.col.col-xl-3.d-flex.justify-content-end > div > a.o-header__userInfo--item.bwi-cart-o.-cart > svg"));

            sepetim.click();

            WebElement SepetTutar=driver.findElement(By.cssSelector("body > div.wrapper > div > div > div > div.col-12.col-md-12.col-lg-4 > div.m-orderSummary > div.m-orderSummary__body > ul > li.m-orderSummary__item.-grandTotal > span.m-orderSummary__value"));

            System.out.println(SepetTutar.getText());

           String MyTotal="1.299,00 TL";

           Assert.assertEquals(MyTotal,SepetTutar.getText());

           System.out.println("Price is okeyy");

           WebElement Onemore=driver.findElement(By.cssSelector("#quantitySelect0-key-0 > option:nth-child(2)"));//make piece 2

           Onemore.click();

           System.out.println(Onemore.getText());//take piece of cart

           String Adet="2 adet"; // it must be 2

           Assert.assertEquals(Adet,Onemore.getText()); // check the piece of cart

           System.out.println("piece=2 passed the case"); // if it is true

           Thread.sleep(1000);

           WebElement del=driver.findElement(By.xpath("//*[@id=\"removeCartItemBtn0-key-0\"]")); // delete product

           del.click();

           Thread.sleep(2000);// page gives short pop-up to if we go for locators directly it does not find dey

           WebElement dey=driver.findElement(By.xpath("//*[@id=\"emtyCart\"]/div/strong"));

           String Massage="SEPETINIZDE ÜRÜN BULUNMAMAKTADIR";

           Assert.assertEquals(Massage,dey.getText());

           System.out.println("Urun silinmiştir!!");

           driver.close();

           System.out.println("All Cases passed");



    }
}
