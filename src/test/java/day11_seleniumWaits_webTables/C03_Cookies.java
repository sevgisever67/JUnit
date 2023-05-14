package day11_seleniumWaits_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {
    @Test
    public void test01(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSet= driver.manage().getCookies();
        int sıraNo=1;
        for (Cookie eachCookie:cookiesSet) {
            System.out.println(sıraNo +""+ cookiesSet);
            sıraNo++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedCookie=7;
        int actualCookie=cookiesSet.size();
        Assert.assertTrue(actualCookie>expectedCookie);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue= driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieeValue="USD";
        Assert.assertEquals(expectedCookieeValue,actualCookieValue);
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin
        Cookie eklenecekCookie=new Cookie("en sevdiğimcookie","çikolatali");
        driver.manage().addCookie(eklenecekCookie);
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Set<Cookie> cookiesSet2= driver.manage().getCookies();
        int sıraNo2=1;
        String ensevdiğimCookieValue="";
        for (Cookie eachCookie:cookiesSet2) {
            System.out.println(sıraNo2 +""+ cookiesSet2);
            if (eachCookie.getName().equals("en sevdiğim cookie")){
                ensevdiğimCookieValue=eachCookie.getValue();
            }
            sıraNo2++;
        }
        expectedCookieeValue="çikolatali";
        Assert.assertEquals(expectedCookieeValue,ensevdiğimCookieValue);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        //8- tum cookie’leri silin ve silindigini test edi

    }
}
