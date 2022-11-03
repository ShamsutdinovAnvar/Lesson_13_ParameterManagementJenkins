package com.wegotrip.pages.testdata;

import com.github.javafaker.Faker;
import com.wegotrip.pages.utils.RandomUtil;

public class UserTestData {
    private static final Faker faker = new Faker();

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            mobile = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(10, 28)),
            month = RandomUtil.getRandomMonth(),
            year = String.valueOf(faker.number().numberBetween(1985, 2022)),
            birthDay = day + " " + month + "," + year,
            subjects = "English",
            hobbie = "Sports",
            picture = "image.png",
            address = faker.address().fullAddress(),
            state = "NCR",
            city = "Noida";
}
