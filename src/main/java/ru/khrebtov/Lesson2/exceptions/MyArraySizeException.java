package ru.khrebtov.Lesson2.exceptions;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {

  public MyArraySizeException(String s) {
    super(s);
  }
}
