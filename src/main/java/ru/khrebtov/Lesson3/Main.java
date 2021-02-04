package ru.khrebtov.Lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести
// список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько
// раз встречается каждое слово.
//Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных
// номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью
// метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть
// несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться
// все телефоны. Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество,
// адрес), взаимодействие с пользователем через консоль и т.д). Консоль использовать только для
// вывода результатов проверки телефонного справочника.
public class Main {

  public static void main(String[] args) {
    ArrayList<String> words = new ArrayList<>(Arrays
        .asList("лес", "хлеб", "окно", "гриб", "стул", "вода", "окно", "брат", "конь", "окно",
            "окно", "гриб", "игла", "мед", "лес"));
    uniqueWords(words);
  }

  private static void uniqueWords(ArrayList<String> words) {
    HashSet<String> uniqueWords = new HashSet<>(words);
    Map<String, Integer> countWord = new HashMap<>();
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
      countWord.put(word, count);
      count = 0;
    }
    System.out.println("В массиве содержится такие уникальные слова: " + uniqueWords);
    for (Map.Entry<String, Integer> e : countWord.entrySet()) {
      System.out.printf("Кол-во повторений слова %s - %d.\n", e.getKey(), e.getValue());
    }
  }
}


