package ru.khrebtov.enums;


public enum DayOfWeek {
  MONDAY("Понедельник"), TUESDAY("Вторник"), WEDNESDAY("Среда"), THURSDAY("Четверг"), FRIDAY(
      "Пятница"), SATURDAY("Суббота"), SUNDAY("Воскресенье");

  private final String rusName;

  DayOfWeek(String rusName) {
    this.rusName = rusName;
  }

  public String getRusName() {
    return rusName;
  }

}
