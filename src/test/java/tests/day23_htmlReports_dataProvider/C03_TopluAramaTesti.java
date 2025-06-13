package tests.day23_htmlReports_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C03_TopluAramaTesti {

    @Test
    public void topluAramaTesti(){



        /*
            Toplu test çalıştırdığımızda
            failed olan ilk ürün için kod çalıştırmayı durdurur

            eğer tüm ürünleri test etmesini isterseniz
            try-catch / softAssert oluşturup
            tüm ürünleri aratmasını sağlayabiliriz
         */


        // apple, shoe, java, samsung, dress, çokoprens, nutella
        List<String> aranacakUrunlerListesi = new ArrayList<>(Arrays.asList("apple", "shoe", "java", "samsung", "dress", "cokoprens", "nutella" ));

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // yukarıda liste olarak verilen urunlerden
        // her birini aratıp

        // arama sonucunda ürün bulunabildiğini test edin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < aranacakUrunlerListesi.size(); i++){

            String aranacakKelime = aranacakUrunlerListesi.get(i);
            testotomasyonuPage.aramaKutusu.sendKeys(aranacakKelime + Keys.ENTER);

            String unExpectedAramaSonucu = ConfigReader.getProperty("toUnExpectedSonucYazisi");
            testotomasyonuPage = new TestotomasyonuPage();
            String actualAramaSonucu = testotomasyonuPage.aramaSonucYaziElementi.getText();

            softAssert.assertNotEquals(actualAramaSonucu, unExpectedAramaSonucu, aranacakKelime + " bulunamadı");
        }
        softAssert.assertAll();
    }
}
