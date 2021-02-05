package ru.khrebtov.Lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Phonebook {

  private final Map<String, HashSet<String>> phonebook = new HashMap<>();

  /*
   * Метод добавляет информацию в телефонный справочник в формате Фамилия-Телефон
   * @param surname-фамилия, telephone- телефон
   */
  public void add(String surname, String telephone) {
    HashSet<String> phones = new HashSet<>();
    if (phonebook.isEmpty()) {
      phones.add(telephone);
      phonebook.put(surname, phones);
      return;
    }
    for (Map.Entry<String, HashSet<String>> e : phonebook.entrySet()) {
      if (e.getKey().equals(surname)) {
        phones = e.getValue();
      }
      phones.add(telephone);
    }
    phonebook.put(surname, phones);
  }

  /*
   * Метод позволяет искать номер телефона по фамилии, под одной фамилией может быть несколько телефонов
   * @param surname-фамилия, по которой выполняется поиск
   */
  public HashSet<String> get(String surname) {
    HashSet<String> telephones = new HashSet<String>();
    for (Map.Entry<String, HashSet<String>> e : phonebook.entrySet()) {
      if (e.getKey().equals(surname)) {
        return e.getValue();
      }
    }
    if (telephones.isEmpty()) {
      telephones.add("В телефонном справочнике данная фамилия не найдена.");
    }
    return telephones;
  }
}
