package FormTests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormTest extends BaseTest{

    @Test
    public void formTest() {
        indexPage.clickCardUp();
        String expectedUrl="https://demoqa.com/forms";
        String actualUrl=driver.getCurrentUrl();
        assertEquals(expectedUrl,actualUrl,"переход не выполнен");

        middlePage.clickPracticeBtn();
        String expectedUrl2="https://demoqa.com/automation-practice-form";
        String actualUrl2=driver.getCurrentUrl();
        assertEquals(expectedUrl2,actualUrl2,"переход не выполнен");

        formPage.inputName(ConfProperties.getProperty("name"));
        formPage.inputSurname(ConfProperties.getProperty("surname"));
        formPage.inputEmail(ConfProperties.getProperty("email"));
        formPage.selectGenderRdBtn();
        formPage.inputNumber(ConfProperties.getProperty("number"));
        formPage.selectDateOfBirth();
        formPage.selectMonth();
        formPage.selectYear();
        formPage.selectDay();
        formPage.selectSubject("subject");
        formPage.selectHobbies();
        formPage.inputAddress("address");
        formPage.selectState("state");
        formPage.selectCity("city");
        formPage.fileInput("file");
        formPage.clickSubmitBtn();

        System.out.println("Student Name: '" + formPage.getStudentName().trim() + "'");
        assertEquals(formPage.getStudentName().trim(), "Ivan Ivanov", "Student Name does not match!");

        assertEquals(formPage.getStudentEmail(), "ivan@test.ru", "Student Email does not match!");

        assertEquals(formPage.getStudentGender(), "Male", "Gender does not match!");

        assertEquals(formPage.getStudentMobile(), "1234567890", "Mobile number does not match!");

        assertEquals(formPage.getStudentBirth().trim(), "06 March,2000", "Student Birth does not match!");

        assertEquals(formPage.getStudentSubjects().trim(), "Chemistry", "Student Subjects does not match!");

        assertEquals(formPage.getStudentHobbies().trim(), "Sports, Music", "Student Hobbies does not match!");

        assertEquals(formPage.getStudentAddress().trim(), "My address", "Student Address does not match!");

        assertEquals(formPage.getStudentStateCity().trim(), "NCR Noida", "Student State and City does not match!");

        assertEquals(formPage.getStudentPicture().trim(), "Снимок.png", "Student Picture does not match!");

        formPage.clickCloseBtn();
        String expectedUrl3="https://demoqa.com/automation-practice-form";
        String actualUrl3=driver.getCurrentUrl();
        assertEquals(expectedUrl3,actualUrl3,"переход не выполнен");
    }
}
