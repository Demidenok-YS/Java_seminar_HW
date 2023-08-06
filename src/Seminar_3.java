import java.util.*;

public class Seminar_3 {
    public static void main(String[] args) {
        //task0();
        //task1(createList(10, 0, 9));
        //task2();
        task3();
    }

    static void task0(){
    /*Даны следующие строки, сравнить их с помощью == и метода equals() класса Object
    String s1 = "hello";
    String s2 = "hello";
    String s3 = s1;
    String s4 = "h" + "e" + "l" + "l" + "o";
    String s5 = new String ("hello");
    String s6 = new String(new char[]{'h','e', 'l', 'l', 'o'});
    */
        String s1 = "hello"; // создали в памяти hello и s2,s3,s4 будут ссылать на тот же раздел памяти, что и s1
        String s2 = "hello";
        String s3 = s1;
        String s4 = "h" + "e" + "l" + "l" + "o";
        String s5 = new String ("hello");  // создание Нового обьекта , информация в котором будет ссылаться на другую часть памяти
        String s6 = new String(new char[]{'h','e', 'l', 'l', 'o'}); // -||-
        //System.out.println( s1 == s2); // == сравнивает ссылки на обьекты
        //System.out.println( s2 == s3);
        //System.out.println( s3 == s4);
        //System.out.println( s4 == s5);
        //System.out.println( s5 == s6);
        System.out.println( s1.equals(s2)); // equals помимо ссылок на объект сравнивает и сами объекты
        System.out.println( s2.equals(s3));
        System.out.println( s3.equals(s4));
        System.out.println( s4.equals(s5));
        System.out.println( s5.equals(s6));
    }

    static void task1(List<Integer> arrayList){
    /* Заполнить список десятью случайными числами. Отсортировать список методом sort() и вывести его на экран.
     Коллекции - способ хранения данных.*/
        // List - это интерфейс,  ArrayList - это класс
        // Интерфейс - это набор методов, которые должен содержать наследник этого интерфейса, класс который его реализует.
        // Реализации интерфейса List: ArrayList, LinkedList - эти реализации должны содержать методы, которые прописаны в интерфейсе List
        //Comparator - правила сортировки
        Collections.sort(arrayList); // сортировка по возрастанию, по убыванию Collections.sort(arrayList, Comparator.reverseOrder());
        System.out.println(arrayList);
    }
    // В отличии от массива в список можно добавлять элементы в процессе работы (т.к. массив фиксированного размера).
    static List<Integer> createList(int size, int min, int max) { //метод для формирования списка случайных чисел
        List<Integer> list = new ArrayList<>(size); // создадим список нужного нам размера size
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * (max - min + 1) + min));
        }
        return list;
    }
    static void task2(){
    /* Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа. Пройти по списку, найти и удалить целые числа.
     */
        List list = new ArrayList<>();
        list.add("dsdsdhg");
        list.add(1);
        list.add("yhyhy");
        list.add("mmmmmm");
        list.add(21);
        list.add(11);

        //Iterator - объект , который может пробежаться по коллекции
        Iterator iterator = list.iterator(); // итератор коллекции list
        while (iterator.hasNext()){
            Object o = iterator.next();
            if(o instanceof Integer){
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    static void task3(){
        /* Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так, что на 0й
        позиции каждого внутреннего списка содержится название жанра, а на остальных позициях - названия книг.
        Напишите метод для заполнения данной структуры.*/
        //фантастика, марсианин
        // классика, над пропастью во ржи
        // роман, евгений онегин
        List<List<String>> books = new ArrayList<>();
        addBook("фантастика", "Марсианин", books);
        addBook("классика", "над пропастью во ржи", books);
        addBook("роман", "онегин", books);
        addBook("фантастика", "Аватар", books);
        addBook("роман", "Гроза", books);
        addBook("фантастика", "Хоббит", books);

        System.out.println(books);

    }
    static void addBook(String ganre, String name, List<List<String>> bookShop){
        for (int i = 0; i < bookShop.size(); i++) {
            if(bookShop.get(i).get(0).equals(ganre)){
                bookShop.get(i).add(name);
                return;
            }
        }
        List<String> list = new ArrayList<>();
        list.add(ganre);
        list.add(name);
        bookShop.add(list);
    }
}
