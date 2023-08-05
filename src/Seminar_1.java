import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;     // импорт класса Scanner

public class Seminar_1 {
    public static void main(String[] args) {
        //task0();
        //task1();
        //task2();
        //System.out.println(task3("Добро пожаловать на курс Java"));
        System.out.println(task4());

    }

    static void task0() {
    /* 0. В консоли запросить имя пользователя.
    В зависимости от текущего времени, вывести приветствие вида
    "Доброе утро, <имя> !" , если время от 05:00 до 11:59
    "Добрый день, <имя> !" , если время от 12:00 до 17:59
    "Добрый вечер, <имя> !" , если время от 18:00 до 22:59
    "Доброй ночи, <имя> !" , если время от 23:00 до 04:59 */

        System.out.println("What is your name?"); //вывод информации в консоль sout
        Scanner scanner = new Scanner(System.in); //объект класса Scanner, который будет считывать информацию от пользователя
        String line = scanner.nextLine(); // запись той информации, которую считал scanner, в переменную line

        LocalTime time = LocalTime.now(); // объект класса LocalTime
        int hour = time.getHour(); // записывает час на данный момент времени
        if(hour >= 5 && hour < 12){
            System.out.println("Доброе утро, " + line);
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Добрый день, " + line);
        } else if (hour >= 18 && hour < 23) {
            System.out.println("Добрый вечер, " + line);
        }else {
            System.out.println("Доброй ночи, " + line);
        }
        scanner.close();
    }

    static void task1() {
    /* 1. Дан массив двоичных чисел, пример [1, 1, 0, 1, 1, 1].
     Вывести максимальное количеcтво подряд идущих 1.*/
        int[] arr = {1, 1, 0, 1, 1, 1};
        int max0nes = 0;     // макс кол-во подряд идущих единиц
        int temp = 0;       // счетчик единиц
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] == 1) temp++;
            else if(temp > max0nes){
                max0nes = temp;
                temp = 0;
            }
        }
        if(temp > max0nes) max0nes = temp;
        System.out.println(max0nes);
    }

    static void task2() {
    /* 2. Дан массив nums = [3, 2, 2, 3] и число val = 3.
      Если в массиве есть числа, равные заданному, нужно перенести эти эл-ты в конец массива.
       Т.о. первые несколько (или все) эл-тов массива должны быть отличны от заданного,
       а остальные - равные ему.*/
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int count = 0;
        int[] nums2 = new int[nums.length];
        Arrays.fill(nums2, val);      //объект класса Arrays, заполняет пустой массив одним значением val
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums2[count] = nums[i];     // либо можно записать nums2[count++] = nums[i]; начнет с count = 0
                count++;
            }
        }
        System.out.println(Arrays.toString(nums2));    // вывод массива на экран с использованием класса Arrays
    }

    static String task3(String str) {  //метод строковый, передавать будем в него строку str
    /* 3. Во фразе "Добро пожаловать на курс Java" переставить слова в обратном порядке. */
        str = str.toLowerCase(); //перевод всех букв в нижний регистр
        String[] words = str.split(" "); //создадим массив строк words, str (пришедшую строку)
        // разделим по пробелам, в итоге мы получим массив из слов (5 элементов)
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            stringBuilder.append(words[words.length - i - 1]).append(" "); // метод append stringBuilder-А, который формирует строку
        }
        return stringBuilder.toString(); // stringBuilder это не строка, и чтобы вывести результат,
        // необходимо преобразовать stringBuilder в строку
    }
    static double task4() {
        /* 4. Реализовать функцию возведения числа a в степень b.
        Сводя количество выполняемых действий к минимуму.*/
        System.out.println("a : ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(); // int a = Integer.parseInt(scanner.nextLine());
        System.out.println("b : ");
        int b = scanner.nextInt(); // int a = Integer.parseInt(scanner.nextLine());

        if(a == 1 || b == 0) return 1;
        double res = 1;
        for (int i = 0; i < Math.abs(b); i++) {
           res *= a;
        }
        return b > 0 ? res : 1 /res;//лямбда выражение: если b > 0, то возвращаем res,
        // если условие b > 0 не выполняется, то возвращаем 1 /res
        // (отрицательное значение в степени , это 1 деленное на это значение степени)


    }
}