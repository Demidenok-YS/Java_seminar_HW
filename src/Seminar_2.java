import java.io.FileWriter;
import java.util.Arrays;
import java.util.Formatter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Seminar_2 {
    public static void main(String[] args) {
        //System.out.println(task0(20, 'a','h'));
        //System.out.println(task1("aaaabbbcdd"));
        //System.out.println(task2("aabca"));
        //saveToFile(repeat(100, "TEST"));
        task4(repeat(20,"TEST"));
    }
    static String task0(int n, char c1, char c2) {
    /*0. Текст задачи: Дано четное число N (>0) и символы c1 и c2. Написать метод,
    который вернет строку длины N, которая состоит из чередующихся символов c1 и c2, начиная с c1. */
        if(n % 2 == 0){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n / 2; i++) {
                stringBuilder.append(c1).append(c2);
            }
            return stringBuilder.toString();

        }else {
            System.out.println("n нечетное число");
            return null;
        }
    }

    static String task1(String str){
    /*1. Текст задачи: Напишите метод, который сжимает строку. Пример: вход aaaabbbcdd., вывод - a4b3cd2. */
        char[] chars = str.toCharArray(); //разобьем строку на символы и сделаем из этого массив
        Arrays.sort(chars); //отсортируем массив в алфавитном порядке
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] == chars[i - 1]) {
                count++;
            }else {
                stringBuilder.append(chars[i - 1]).append(count + 1);
                count = 0;
            }
        }
        stringBuilder.append(chars[chars.length - 1]).append(count + 1);
        return stringBuilder.toString();
    }

    static boolean task2(String str){
    /*2. Текст задачи: Напишите метод, который принимает на вход строку (String) и определяет
    является ли строка палиндромом (возвращает boolean значение).*/
        StringBuilder stringBuilder = new StringBuilder(str);// помещаем нашу входную строку в stringBuilder
        String str2 = stringBuilder.reverse().toString(); // переворачиваем строку в обратном направлении
        // и делаем из нее строку(т.к. был использован stringBuilder)
        return str2.equals(str); //сравнение, если строки одинаковые вернет - true, если разные -  false
    }


    /*3. Текст задачи: Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод,
     который запишет эту строку в простой текстовый файл, обработайте исключения.*/
    static String repeat(int n, String str){ //метод для формирования строки с определенным количество повторений входной строки
        return str.repeat(n); //можно через stringBuilder // метод repeat сделает определенное кол-во повторений входной строки
    }
    static void  saveToFile(String str){ // метод, который будет записывать в файл
        String path = "text.txt";
        try (FileWriter writer = new FileWriter(path)){ //если обнаружиться ошибка // если нам не нужно/нужно , чтобы каждый запуск добавлял строки:try (FileWriter writer = new FileWriter(path, false/true)){
            writer.write(str);
            writer.flush(); // аналогия commit
        } catch (Exception e){
            e.printStackTrace();// выведи ее в стек ошибок
        }

    }

    static void task4(String str){
    /*4. текст задачи: Произвести логирование и исключение ошибок.*/
        String path = "/ssssssss///text.txt";
        Logger logger = Logger.getAnonymousLogger(); //создаем объект типа логгер
        FileHandler fileHandler = null;   // с помощью этого класса происходит запись логов (пока он пуст)
        try {
            fileHandler = new FileHandler("log.txt"); //запись в этот файл
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.addHandler(fileHandler); // привязываем fileHandler к логеру
        SimpleFormatter formatter = new SimpleFormatter(); // формат отображения логов
        fileHandler.setFormatter(formatter);

        try (FileWriter writer = new FileWriter(path, true)){ //запись
            writer.write(str);
            writer.flush(); // аналогия commit
        } catch (Exception e){
            e.printStackTrace();// выведи ее в стек ошибок
            logger.log(Level.WARNING, e.getMessage());
        }
        fileHandler.close();
        logger.getHandlers()[0].close();

    }

}
