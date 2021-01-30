package ru.khrebtov;

import java.util.ArrayList;
import ru.khrebtov.activeEntity.Actions;
import ru.khrebtov.activeEntity.Cat;
import ru.khrebtov.activeEntity.Human;
import ru.khrebtov.activeEntity.Robot;
import ru.khrebtov.barrriers.Barrier;
import ru.khrebtov.barrriers.Treadmill;
import ru.khrebtov.barrriers.Wall;

public class Main {

  public static void main(String[] args) {
    ArrayList<Actions> livingBeings = new ArrayList<>();
    ArrayList<Barrier> inanimateBeings = new ArrayList<>();

    livingBeings.add(new Cat("Barsik", 26, 5));
    livingBeings.add(new Cat("Cherniw", 25, 3));
    livingBeings.add(new Cat("Vaska", 40, 10));

    livingBeings.add(new Robot("R2d2", 100, 25));
    livingBeings.add(new Robot("3po", 80, 18));
    livingBeings.add(new Robot("Helios", 45, 70));

    livingBeings.add(new Human("Ivan", 70, 24));
    livingBeings.add(new Human("Petr", 78, 19));
    livingBeings.add(new Human("Garik", 65, 22));

    inanimateBeings.add(new Treadmill(25.2));
    inanimateBeings.add(new Treadmill(30.3));
    inanimateBeings.add(new Treadmill(18));

    inanimateBeings.add(new Wall(2.1));
    inanimateBeings.add(new Wall(25.4));
    inanimateBeings.add(new Wall(2.60));

    for (Actions living : livingBeings) {
      for (Barrier inanimate : inanimateBeings) {
        inanimate.doAction(living);
        if (!Power.isPower()) {
          Power.setPower(true);
          System.out.println();
          break;
        }
        System.out.println();
      }
    }
  }
}


