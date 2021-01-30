package ru.khrebtov.activeEntity;

public class Robot implements Actions {

  private final String model;
  private final double runPower;
  private final double jumpPower;


  public Robot(String model, double runPower, double jumpPower) {
    this.model = model;
    this.runPower = runPower;
    this.jumpPower = jumpPower;
  }

  @Override
  public double getRunPower() {
    return runPower;
  }

  public double getJumpPower() {
    return jumpPower;
  }

  @Override
  public void run() {
    System.out.println("Робот модель " + model + " произвел пробежку");
  }

  @Override
  public void jump() {
    System.out.println("Робот модель " + model + " произвел прыжок");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Robot robot = (Robot) o;

    if (Double.compare(robot.runPower, runPower) != 0) {
      return false;
    }
    if (Double.compare(robot.jumpPower, jumpPower) != 0) {
      return false;
    }
    return model != null ? model.equals(robot.model) : robot.model == null;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = model != null ? model.hashCode() : 0;
    temp = Double.doubleToLongBits(runPower);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(jumpPower);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "Robot{" +
        "model='" + model + '\'' +
        ", runPower=" + runPower +
        ", jumpPower=" + jumpPower +
        '}';
  }
}
