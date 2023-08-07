import java.util.*;

public class Seminar_5 {
    public static void main(String[] args){

        //task0();
        //System.out.println(task1("paper", "title"));

        task3("Мороз и солнце день чудесный\n" +
                "Еще ты дремлешь друг прелестный\n" +
                "Пора красавица проснись.");
    }

    static void task0(){
        /*
        Создать структуру для хранения паспортов и фамилий сотрудников организации.
        123456 Иванов
        321456 Васильев
        234561 Петрова
        234432 Иванов
        654321 Петрова
        345678 Иванов
        Вывести данные по сотрудникам с фамилией Иванов.
         */
        Passport passport = new Passport();
        passport.add("123456", "Иванов");
        passport.add("321456", "Васильев");
        passport.add("234561", "Петрова");
        passport.add("234432", "Иванов");
        passport.add("654321","Петрова");
        passport.add("345678","Иванов");
        System.out.println(passport.getAll());
        System.out.println(passport.getbyPassnum("321456"));
        System.out.println(passport.getbyLastname("Иванов"));
    }
    static boolean task1(String str1, String str2){
        /*
        Даны 2 строки, написать метод который вернет true, если эти строки изоморфны и false, если нет.
        Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву из второго слова, при этом:

        1. повторяющиеся буквы одного слова меняются на одну и ту жу букву с сохранением порядка следования
        (например, add - egg изоморфны)
        2.буква может не меняться, а остаться такой же. (например , note - code)

        Примеры
        s = "foo", t = "bar" -> false
        s = "paper", t = "title" -> true
         */
        if(str1.length() != str2.length()){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        char[] c1 = str1.toCharArray();   //создаем из строки массив символов
        char[] c2 = str2.toCharArray();   //создаем из строки массив символов
        for (int i = 0; i < c1.length; i++) {
            if(map.containsKey(c1[i])){      //вернет true, если такой ключ уже есть, и false, если такого ключа еще нет
                if(c2[i] != map.get(c1[i])) return false;
            }else {
                map.put(c1[i], c2[i]);
            }
        }
        return true;
    }

    //static boolean task2(String str){ //43:49
        /*
        Написать программу, которая определяет правильность расстановки скобок в выражении
        a+(d*3) истина
        [a+(1*3) ложь
         [6 + (3*3)] истина
         */
        /* Stack<Character> stack = new Stack<>();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(c[i] == '(') stack.push(c[i]);
            if(c[i] == ')'){
                if(stack.isEmpty() || stack.pop() != '(') return false;
            }*/
      //  }

    static void task3(String str){
        /*
        Взять набор строк,например:
        Мороз и солнце день чудесный
        Еще ты дремлешь друг прелестный
        Пора красавица проснись.
        Написать метод , который отсортирует эти строки по длине с помощью TreeMap.
        Строки с одинаковой длинной не должны "потеряться".
         */
        str = str.replace("\n", " ");
        str = str.replace(".", " ");
        System.out.println(str);
        String[] words = str.split(" ");
        Map<Integer, List<String>> map = new TreeMap<>();
            for (String word: words) {
                int len = word.length();
                if(map.containsKey(len)){
                    List<String> list = map.get(len);
                    list.add(word);
                } else{
                    List<String> list = new ArrayList<>();
                    list.add(word);
                    map.put(len, list);
                }
            }
            System.out.println(map);
        }

}
