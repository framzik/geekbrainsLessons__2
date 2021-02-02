package ru.khrebtov.Lesson2;

import ru.khrebtov.Lesson2.exceptions.MyArrayDataException;
import ru.khrebtov.Lesson2.exceptions.MyArraySizeException;

public class Main {

  public static void main(String[] args) {
    try {
      System.out.printf("Сумма в масиве составила: %d\n", arraySum(
          new String[][]{{"1", "9", "1", "1"}, {"1", "1", "1", "1"}, {"1", "9", "1", "1"},
              {"1", "1", "1", "1"}}));
    } catch (MyArrayDataException | MyArraySizeException e) {
      e.printStackTrace();
    }
  }

  private static int arraySum(String[][] array)
      throws MyArraySizeException, MyArrayDataException {

    for (String[] strings : array) {
      if (array.length != 4 || strings.length != 4) {
        throw new MyArraySizeException("Размер массива не [4][4]!");
      }
    }

    int sum = 0;
    int rowNumber = 0;
    int columnNumber = 0;
    String value = "";
    try {
      for (int row = 0; row < array.length; row++) {
        for (int column = 0; column < array.length; column++) {
          rowNumber = row;
          columnNumber = column;
          value = array[row][column];
          sum += Integer.parseInt(array[row][column]);
        }
      }
    } catch (NumberFormatException e) {
      throw new MyArrayDataException(
          "В ячеке [" + rowNumber + "][" + columnNumber + "] значение: " + value
              + ", не удалось произвести преобразование!");
    }
    return sum;
  }
}


