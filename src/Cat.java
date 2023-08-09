import java.util.List;

public class Cat {
            /*
        1. Продумайте структуру класса Кот. Какие поля и методы будут актуальны для приложения, которое является
        а) информационной системой ветеринарной клиники
        б) архивом выставки котов
        в) информационной системой Театра кошек Ю. Д. Куклачёва
        Можно записать в текстовом виде, необязательно реализовывать в java.
         */
    // описание полей класса
    private String name;
    private String breed;
    private int age;
    private String owner;
    private List<String> history;

    public Cat(String name, String breed, Integer age, String owner) {// создадим конструктор, конструктор всегда называется также , как и класс
        this.name = name; //this обращается к объекту, к которому мы применяем метод
        this.breed = breed;
        this.age = age;
        this.owner = owner;
    }

    @Override
    public String toString() { //создадим удобный формат вывода данных
        return "name :  " + name + " " + "breed : " + age + " " + "owner : " + owner + " ";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {      // this ссылки на объекты cat1, cat2, cat3, если ссылки на объект равны то это true
            return true;
        }
        if (!(obj instanceof Cat)) { //является ли объектом класса Cat? если не является (!(obj instanceof Cat))
            return false;
        }
        Cat cat = (Cat) obj; // наш объект перезаписали в переменную cat и теперь можем пользоваться любыми полями,
        // так как теперь это объект класса Cat
        return name.equals(cat.name) && owner.equals(cat.owner) && age == cat.age && breed.equals(cat.breed);
        // если имена, возраст, владельцы, породы одинаковы, то кошка одна и та же
    }

    @Override
    public int hashCode() {  // чтобы не выводилось повторений
        return 7 * name.hashCode() + 11 * owner.hashCode() + 3 * breed.hashCode() + 4 * age;
    }
}
