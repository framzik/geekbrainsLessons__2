package ru.khrebtov;

public class Power {

  private static boolean power = true;

  public static boolean isPower() {
    return power;
  }

  public static void setPower(boolean power) {
    Power.power = power;
  }
}
