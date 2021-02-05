package ru.khrebtov.Lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

  public static void main(String[] args) {
    ArrayList<String> words = new ArrayList<>(Arrays
        .asList("лес", "хлеб", "окно", "гриб", "стул", "вода", "окно", "брат", "конь", "окно",
            "окно", "гриб", "игла", "мед", "лес"));
    uniqueWords(words);

    Phonebook phonebook = new Phonebook();
    phonebook.add("Ульянов", "+79787878935");
    phonebook.add("Петров", "+79787878998");
    phonebook.add("Ульянов", "+79787878936");
    phonebook.add("Васильев", "+79787878987");
    phonebook.add("Ульянов", "+79787878937");
    phonebook.add("Васильев", "+79787878988");
    phonebook.add("Ульянов", "+79787878938");

    System.out.printf("Васильев - %s\n", phonebook.get("Васильев"));
    System.out.printf("Петров - %s\n", phonebook.get("Петров"));
    System.out.printf("Ульянов - %s\n", phonebook.get("Ульянов"));
    System.out.printf("Ленин - %s\n", phonebook.get("Ленин"));
  }

  /*
   * Метод для определения уникальных слов в листе, вывода в консоль уникальных слов, и кол-ва повторений каждого
   * слова
   * @param words - список слов для проверки
   * */
  private static void uniqueWords(ArrayList<String> words) {
    HashSet<String> uniqueWords = new HashSet<>(words);
    System.out.println("В массиве содержится такие уникальные слова: " + uniqueWords);
    int count = 0;
    for (String word : uniqueWords) {
      for (String allWord : words) {
        if (word.equals(allWord)) {
          count++;
        }
      }
      if (count == 0) {
        count++;
      }
      System.out.printf("Кол-во повторений слова %s - %d.\n", word, count);
      count = 0;
    }
  }
}


