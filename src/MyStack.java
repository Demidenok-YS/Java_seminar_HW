public class MyStack {
    /*
        Стек - коллекция , которая обладает принципом, первый зашел - последним вышел.
        Реализовать стэк с помощью массива. Нужно реализовать методы:
        size(), empty(), push(), peek(), pop()
         */
    private Integer[] arr = new Integer[10];
    private int size = 0;

    int size(){
        return size;
    }

    boolean empty(){ //говорит нам о том, пуст стэк(true) или нет(false)
        return size == 0;
    }

    void push(int num){ // добавление в список
        if(size == arr.length){
            Integer[] arr2 = new Integer[arr.length * 2];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            arr = arr2;
        }
        arr[size++] = num;
    }

    int peek(){ // возвращает значение последнего элемента стэка
        return arr[size -1];
    }

    int pop(){ //возвращает значение последнего элемента стэка и удаляет его
        return arr[--size];
    }
}
