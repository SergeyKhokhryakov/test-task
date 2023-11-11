package ru.ostrovcy.qademo.base;

import lombok.Getter;
import net.datafaker.Faker;
import java.util.Locale;

public class TestData {
  private Faker faker = new Faker(new Locale("ru"));
  private Faker fakerEng = new Faker(new Locale("en-US"));
  @Getter private String userName;
  @Getter private String userEmail;
  @Getter private String currentAddress;
  @Getter private String permanentAddress;
  private String promptText = "Test name";

  public TestData(){
    userName = faker.name().nameWithMiddle();
    userEmail = fakerEng.internet().emailAddress();
    currentAddress = faker.address().fullAddress();
    permanentAddress = faker.address().fullAddress();
  }

}
