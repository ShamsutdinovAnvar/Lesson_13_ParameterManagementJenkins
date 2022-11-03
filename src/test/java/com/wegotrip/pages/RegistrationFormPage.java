package com.wegotrip.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import com.wegotrip.pages.components.CalendarComponent;
import com.wegotrip.pages.components.AddressComponent;
import com.wegotrip.pages.components.ResultComponent;

public class RegistrationFormPage {

    private final static String TITLE_TEXT = "Student Registration Form";
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final AddressComponent addressComponent = new AddressComponent();
    private final ResultComponent resultComponent = new ResultComponent();
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        //executeJavaScript("document.body.style.zoom='75%'");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
    public RegistrationFormPage setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }
    public RegistrationFormPage setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }
    public RegistrationFormPage setUserEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }
    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setUserNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }
    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationFormPage subjectsInput(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }
    public RegistrationFormPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage uploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }
    public RegistrationFormPage setAddress(String address, String state, String city) {
        addressComponent.setAddress(address, state, city);
        return this;
    }
    public RegistrationFormPage clickSubmit() {
        $("#submit").click();
        return this;
    }
    public RegistrationFormPage checkResultsTable() {
        resultComponent.checkVisible();
        return this;
    }
    public RegistrationFormPage checkResult(String key, String value) {
        resultComponent.checkResult(key, value);
        return this;
    }
}
