package FormTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
    public WebDriver driver;
    public IndexPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[2]")
    private WebElement cardUp;

    public void clickCardUp(){
        cardUp.click();
    }
}
