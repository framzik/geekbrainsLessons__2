package ru.khrebtov.activeEntity;

public class Cat implements Actions {

  private final String name;
  private final double runPower;
  private final double jumpPower;

  public Cat(String name, double runPower, double jumpPower) {
    this.name = name;
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
    System.out.println("Кот " + name + " произвел пробежку");
  }

  @Override
  public void jump() {
    System.out.println("Кот " + name + " произвел прыжок");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Cat cat = (Cat) o;

    if (Double.compare(cat.runPower, runPower) != 0) {
      return false;
    }
    if (Double.compare(cat.jumpPower, jumpPower) != 0) {
      return false;
    }
    return name != null ? name.equals(cat.name) : cat.name == null;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = name != null ? name.hashCode() : 0;
    temp = Double.doubleToLongBits(runPower);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(jumpPower);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "Cat{" +
        "name='" + name + '\'' +
        ", runPower=" + runPower +
        ", jumpPower=" + jumpPower +
        '}';
  }
}
