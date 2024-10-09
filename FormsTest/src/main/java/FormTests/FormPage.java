package FormTests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FormPage extends MiddlePage{
    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement surnameField;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]")
    private WebElement genderRdBtn;

    @FindBy(xpath = "//input[@id='userNumber']")
    private WebElement numberField;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    private WebElement dateOfBirthField;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']//option[@value='2']")
    private WebElement monthSelect;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement yearSelect;

    @FindBy(xpath = "//div[contains(@class, 'react-datepicker__day') and @aria-label='Choose Monday, March 6th, 2000']")
    private WebElement day;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;

    @FindBy(xpath = "//div[contains(@class, 'subjects-auto-complete__option')]")
    private List<WebElement> suggestionList;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement sportsChBox;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    private WebElement musicChBox;

    @FindBy(id="currentAddress")
    private WebElement addressField;

    @FindBy(id = "react-select-3-input")
    private WebElement stateInput;

    @FindBy(xpath = "//div[@id='react-select-3-option-0' and text()='NCR']")
    private WebElement NCRState;

    @FindBy(id = "react-select-4-input")
    private WebElement cityInput;

    @FindBy(xpath = "//div[@id='react-select-4-option-2' and text()='Noida']")
    private WebElement NoidaCity;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement inputFile;

    @FindBy(xpath = "//div[@class='text-right col-md-2 col-sm-12']//button[@id='submit']")
    private WebElement submitBtn;

    public void inputName(String name) {
        nameField.sendKeys("Ivan"); }

    public void inputSurname(String surname) {
        surnameField.sendKeys("Ivanov"); }

    public void inputEmail(String email) {
        emailField.sendKeys("ivan@test.ru"); }

    public void selectGenderRdBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(genderRdBtn));
        wait.until(ExpectedConditions.elementToBeClickable(genderRdBtn));
        if (!genderRdBtn.isSelected()) {
            genderRdBtn.click();
        }
    }
    public void inputNumber(String number) {
        numberField.sendKeys("1234567890"); }

    public void selectDateOfBirth(){
        dateOfBirthField.click();
    }
    public void selectMonth(){
        monthSelect.click();
    }
    public void selectYear(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(yearSelect));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yearSelect);

        Select select = new Select(yearSelect);
        select.selectByValue("2000");
        //yearSelect.click();
    }
    public void selectDay(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(day));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", day);

        day.click();
    }

    public void selectSubject(String subject) {
        subjectsInput.sendKeys("Chemistry");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(suggestionList));

        for (WebElement suggestion : suggestionList) {
            if (suggestion.getText().equalsIgnoreCase("Chemistry")) {
                suggestion.click();
                break;
            }
        }
    }

    public void selectHobbies(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(sportsChBox));
        wait.until(ExpectedConditions.visibilityOf(sportsChBox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sportsChBox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sportsChBox);

        wait.until(ExpectedConditions.elementToBeClickable(musicChBox));
        wait.until(ExpectedConditions.visibilityOf(musicChBox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", musicChBox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", musicChBox);

    }
    public void inputAddress(String address){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        addressField.sendKeys("My address");
    }

    public void selectState(String state)  {
        stateInput.sendKeys("NCR");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(NCRState));
        wait.until(ExpectedConditions.visibilityOf(NCRState));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", NCRState);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", NCRState);

    }


    public void selectCity(String city) {
        cityInput.sendKeys("Noida");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(NoidaCity));
        wait.until(ExpectedConditions.visibilityOf(NoidaCity));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", NoidaCity);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", NoidaCity);
    }
    public void fileInput (String file){

        file="C://Users//aparneva//Downloads//Снимок.png";
        inputFile.sendKeys(file);
    }
        public void clickSubmitBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(submitBtn));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);
    }

    @FindBy(xpath = "//td[text()='Student Name']/following-sibling::td")
    private WebElement studentName;

    @FindBy(xpath = "//td[text()='Student Email']/following-sibling::td")
    private WebElement studentEmail;

    @FindBy(xpath = "//td[text()='Gender']/following-sibling::td")
    private WebElement studentGender;

    @FindBy(xpath = "//td[text()='Mobile']/following-sibling::td")
    private WebElement studentMobile;

    @FindBy(xpath = "//td[text()='Date of Birth']/following-sibling::td")
    private WebElement studentBirth;

    @FindBy(xpath = "//td[text()='Subjects']/following-sibling::td")
    private WebElement studentSubjects;

    @FindBy(xpath = "//td[text()='Hobbies']/following-sibling::td")
    private WebElement studentHobbies;

    @FindBy(xpath = "//td[text()='Address']/following-sibling::td")
    private WebElement studentAddress;

    @FindBy(xpath = "//td[text()='State and City']/following-sibling::td")
    private WebElement studentStateCity;

    @FindBy(xpath = "//td[text()='Picture']/following-sibling::td")
    private WebElement studentPicture;

    @FindBy(xpath ="//button[@id='closeLargeModal']")
    private WebElement closeBtn;

    public String getStudentName() {
        return studentName.getText();
    }

    public String getStudentEmail() {
        return studentEmail.getText();
    }

    public String getStudentGender() {
        return studentGender.getText();
    }

    public String getStudentMobile() {
        return studentMobile.getText();
    }

    public String getStudentBirth() {
        return studentBirth.getText();
    }

    public String getStudentSubjects() {
        return studentSubjects.getText();
    }

    public String getStudentHobbies() {
        return studentHobbies.getText();
    }

    public String getStudentAddress() {
        return studentAddress.getText();
    }

    public String getStudentStateCity() {
        return studentStateCity.getText();
    }

    public String getStudentPicture(){
        return studentPicture.getText();
    }

    public void clickCloseBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(closeBtn));
        wait.until(ExpectedConditions.elementToBeClickable(closeBtn));

        closeBtn.click();
    }
}
