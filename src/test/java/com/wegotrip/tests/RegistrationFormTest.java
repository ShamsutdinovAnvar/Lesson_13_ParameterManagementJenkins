package com.wegotrip.tests;

import com.wegotrip.pages.RegistrationFormPage;
import com.wegotrip.pages.testdata.UserTestData;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationFormTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void checkFormTest() {
        step("Open registrations form", () -> {
            registrationFormPage.openPage();
        });
        step("Fill form", () -> {
            registrationFormPage.setFirstName(UserTestData.firstName)
                    .setLastName(UserTestData.lastName)
                    .setUserEmail(UserTestData.email)
                    .setGender(UserTestData.gender)
                    .setUserNumber(UserTestData.mobile)
                    .setBirthDate(UserTestData.day, UserTestData.month, UserTestData.year)
                    .subjectsInput(UserTestData.subjects)
                    .setHobbies(UserTestData.hobbie)
                    .uploadPicture(UserTestData.picture)
                    .setAddress(UserTestData.address, UserTestData.state, UserTestData.city)
                    .clickSubmit();
        });
        //Check results
        step("Check form results", () -> {
            registrationFormPage.checkResultsTable()
                    .checkResult("Student Name", UserTestData.firstName + " " + UserTestData.lastName)
                    .checkResult("Student Email", UserTestData.email)
                    .checkResult("Gender", UserTestData.gender)
                    .checkResult("Mobile", UserTestData.mobile)
                    .checkResult("Date of Birth", UserTestData.birthDay)
                    .checkResult("Subjects", UserTestData.subjects)
                    .checkResult("Hobbies", UserTestData.hobbie)
                    .checkResult("Picture", UserTestData.picture)
                    .checkResult("Address", UserTestData.address)
                    .checkResult("State and City", UserTestData.state + " " + UserTestData.city);
        });
    }
}

