package ru.khrebtov.Lesson5;

public class Main {
  private static final int SIZE = 10000000;

  public static void main(String[] args) {
    notMultithreadedMethod();
    multithreadedMethod();
  }

  public static void notMultithreadedMethod() {
    float[] arr = new float[SIZE];
    for (int i = 0; i < SIZE; i++) {
      arr[i] = 1;
    }
    long startTime = System.currentTimeMillis();
    subtract(arr);
    long endTime = System.currentTimeMillis();
    System.out.println("Время выполнения без многопоточности:" + (endTime - startTime));
  }

  public static void multithreadedMethod() {
    int half = SIZE / 2;
    float[] arr = new float[SIZE];
    for (int i = 0; i < SIZE; i++) {
      arr[i] = 1;
    }
    long startTime = System.currentTimeMillis();
    Thread tr1 = new Thread(() -> {
      float[] halfArr1 = new float[half];
      System.arraycopy(arr, 0, halfArr1, 0, half);
      subtract(halfArr1);
      System.arraycopy(halfArr1, 0, arr, 0, half);
    });

    Thread tr2 = new Thread(() -> {
      float[] halfArr2 = new float[half];
      System.arraycopy(arr, half, halfArr2, 0, half);
      subtract(halfArr2);
      System.arraycopy(halfArr2, 0, arr, half, half);
    });
    tr1.start();
    tr2.start();

    try {
      tr1.join();
      tr2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Время выполнения с многопоточностью:" + (endTime - startTime));
  }

  private static void subtract(float[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
  }

  private static void printArr(float[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

}


