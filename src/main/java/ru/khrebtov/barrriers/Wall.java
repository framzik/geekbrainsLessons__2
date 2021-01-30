package ru.khrebtov.barrriers;

import ru.khrebtov.Power;
import ru.khrebtov.activeEntity.Actions;

public class Wall implements Barrier {

  private final double height;

  public Wall(double height) {
    this.height = height;
  }

  public void doAction(Actions obj) {
    obj.jump();
    if (obj.getJumpPower() < height) {
      System.out.println("Сил не хватило, надо тренироваться ещё!");
      Power.setPower(false);
    } else {
      System.out.println("Молодец! Ты перепрыгнул!");
    }
  }
}
