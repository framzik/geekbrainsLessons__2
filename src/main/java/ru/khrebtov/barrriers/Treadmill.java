package ru.khrebtov.barrriers;

import ru.khrebtov.Power;
import ru.khrebtov.activeEntity.Actions;

public class Treadmill implements Barrier {

  private final double length;

  public Treadmill(double length) {
    this.length = length;
  }

  public void doAction(Actions obj) {
    obj.run();
    if (obj.getRunPower() < length) {
      System.out.println("Сил не хватило, надо тренироваться ещё!");
      Power.setPower(false);
    } else {
      System.out.println("Молодец! Ты пробежал!");
    }
  }
}
