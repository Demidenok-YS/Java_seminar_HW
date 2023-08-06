import java.util.*;

public class Seminar_4 {
    public static void main(String[] args) {
        //task0();
        //task1();
        //task2();
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println(myStack.size());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.empty());
        myStack.pop();
        System.out.println(myStack.empty());
    }
    static void task0(){
        /*
        1) Замерьте время, за которое в ArrayList добавятся 10000 элементов.
        ArrayList - как массив, можем получать элементы по индексу
        2) Замерьте время, за которое LinkedList добавятся 10000 элементов. Сравните с предыдущим.
        LinkedList - имеет ссылку на следующий и на предыдущий элементы
         */
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list1.add(i);
            //list1.add(0, i);
        }
        long middleTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list2.add(i);
            //list2.add(0, i)
        }
        long finish = System.currentTimeMillis();
        System.out.println(middleTime - start);
        System.out.println(finish - middleTime);
    }
    static void task1(){
        /*
        Реализовать консольное приложение, которое:
        1. Принимает от пользователя строку вида
        text~num
        Нужно рассплитить эту строку по ~ , сохранить text в связный список на позицию num.
        2. Если введено print~num , выводит строку из позиции num в связном списке и удаляет ее из списка.
         */

        LinkedList<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean work = true;
        while (work){
            System.out.println("Введите команду: ");
            String line = scanner.nextLine();
            String[] arr = line.split("~"); // text~num print~num
                                                  // 0 1 эл-т 0 1 эл-т
            String text = arr[0];
            int num = Integer.parseInt(arr[1]);
            switch (text){
                case "print":     //print~0
                    System.out.println(list.remove(num));
                    break;
                case "exit":     //exit~0
                    System.out.println("Bye! ");
                    work = false;
                    break;
                default:
                    list.add(num, text);

            }
        }
    }
    static void task2(){
        /*
        Реализовать консольное приложение , которое:
        1.Принимает от пользователя и запоминает строки
        2. Если введено print, выводит строки так, чтобы последняя введенная строка была в списке первой,
        а первая - последней.
        3. Если введено revert, удаляет предыдущую строку из памяти
         */
        LinkedList<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean work = true;
        while (work){
            System.out.println("Введите команду: ");
            String line = scanner.nextLine();

            switch (line){
                case "print":     //print~0
                    ListIterator listIterator = list.listIterator(list.size());
                    while(listIterator.hasPrevious()){
                        System.out.println(listIterator.previous());
                    }
                    break;
                case "exit":     //exit~0
                    System.out.println("Bye! ");
                    work = false;
                    break;
                case "revert":
                    list.removeLast();
                    break;
                default:
                    list.add(line);
            }
        }
    }
    static void task3(){
        /*
        Стек - коллекция , которая обладает принципом, первый зашел - последним вышел.
        Реализовать стэк с помощью массива. Нужно реализовать методы:
        size(), empty(), push(), peek(), pop()
         */

    }
}
