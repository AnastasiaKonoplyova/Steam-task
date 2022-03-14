import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.JSONReader;

public class BaseTest {
    @Managed(uniqueSession=true)
    WebDriver driver;

    @Before
    public void manageBrowser(){
        driver.manage().window().maximize();
        JSONReader.loadProperty();
    }

    @After
    public void stopBrowser(){
        driver.quit();
    }
}
