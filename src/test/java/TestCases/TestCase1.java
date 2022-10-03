package TestCases;

import Drivers.BaseTest;
import Pages.FizyHomePage;
import org.testng.annotations.Test;

@Test
public class TestCase1 extends BaseTest {
    public void fizyHomePageTest(){
        FizyHomePage fhp=new FizyHomePage(driver);
        fhp.gotoFastLoginPage();
        //Webhook için
    }
}
