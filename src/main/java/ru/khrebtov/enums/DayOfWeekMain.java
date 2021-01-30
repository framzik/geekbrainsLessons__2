package ru.khrebtov.enums;

public class DayOfWeekMain {

  private static final int WORKING_HOURS_PER_DAY = 8;

  public static void main(String[] args) {
    //System.out.println(getWorkingHours(DayOfWeek.SATURDAY));
    for (DayOfWeek day : DayOfWeek.values()) {
      System.out
          .printf("Сегодня %s, до конца недели осталось рабочих часов: %s! \n", day.getRusName(),
              getWorkingHours(day));
    }

  }

  private static String getWorkingHours(DayOfWeek day) {
    if (day.name().equals(DayOfWeek.SUNDAY.name()) || day.name()
        .equals(DayOfWeek.SATURDAY.name())) {
      return " УПС! Сегодня выходной";
    } else {
      return Integer.toString((5 - day.ordinal()) * 8);
    }
  }

}
