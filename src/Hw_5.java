/*
Задание
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован
по убыванию числа телефонов.
 */

import java.util.*;

public class Hw_5 {
    public static void main(String[] args) {
        Map<String, List<String>> telephonBooks = new HashMap<>();
        addTb("Elena","123456", telephonBooks);
        addTb("Igor","677777", telephonBooks);
        addTb("Anna","909090", telephonBooks);
        addTb("Elena","765458", telephonBooks);
        addTb("Elena","454545", telephonBooks);
        printTb(telephonBooks);
    }

    static void addTb(String key, String value, Map<String, List<String>> map){
        if (map.containsKey(key)) {
            List<String> list = map.get(key);
            list.add(value);
        } else {
            List<String> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }

    static void printTb(Map<String, List<String>> map){
        for (var item: map.entrySet()) {
            String result = " ";
            for (var el : item.getValue()) {
                result = result + el + " ";

            }
            System.out.printf("%s: %s \n", item.getKey(), result);
        }
    }
}
