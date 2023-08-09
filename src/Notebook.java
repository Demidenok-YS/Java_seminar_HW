import java.util.Map;
import java.util.Set;

public class Notebook {
    /*
    Урок 6. Хранение и обработка данных ч3: множество коллекций Set
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
     */
    private String model;
    private String ssd;
    private String os;
    private String color;
    private String cpu;
    private String screen;

    public Notebook(String model, String ssd, String os, String color, String cpu, String screen){
        this.model = model;
        this.ssd = ssd;
        this.os = os;
        this.color = color;
        this.cpu = cpu;
        this.screen = screen;
    }

    public static void getModel(Set<Notebook> notebooks, String value, Map<String, Notebook> totalResult){
        Integer count = 1;
        for (Notebook entry: notebooks) {
            if(entry.model.contains(value)){
                totalResult.put(String.format(" %d. ",count),entry);
                count++;
            }
        }
    }

    public static void getSsd(Set<Notebook> notebooks, String value, Map<String, Notebook> totalResult){
        Integer count = 1;
        for (Notebook entry: notebooks) {
            if(entry.ssd.contains(value)){
                totalResult.put(String.format(" %d. ",count),entry);
                count++;
            }
        }
    }

    public static void getOs(Set<Notebook> notebooks, String value, Map<String, Notebook> totalResult){
        Integer count = 1;
        for (Notebook entry: notebooks) {
            if(entry.os.contains(value)){
                totalResult.put(String.format(" %d. ",count),entry);
                count++;
            }
        }
    }

    public static void getColor(Set<Notebook> notebooks, String value, Map<String, Notebook> totalResult){
        Integer count = 1;
        for (Notebook entry: notebooks) {
            if(entry.color.contains(value)){
                totalResult.put(String.format(" %d. ",count),entry);
                count++;
            }
        }
    }

    public static void getCpu(Set<Notebook> notebooks, String value, Map<String, Notebook> totalResult){
        Integer count = 1;
        for (Notebook entry: notebooks) {
            if(entry.cpu.contains(value)){
                totalResult.put(String.format(" %d. ",count),entry);
                count++;
            }
        }
    }

    public static void getScreen(Set<Notebook> notebooks, String value, Map<String, Notebook> totalResult){
        Integer count = 1;
        for (Notebook entry: notebooks) {
            if(entry.screen.contains(value)){
                totalResult.put(String.format(" %d. ",count),entry);
                count++;
            }
        }
    }

    @Override
    public String toString() {
        return "Модель: " + model + "\n" + "Объём ЖД: " + ssd + "ГБ \n" + "ОС: " + os + "\n" + "Цвет: " + color + "\n"
                + "Процессор: " + cpu + "\n" + "Разрешение экрана: " + screen + "\n";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Notebook)) {
            return false;
        }
        Notebook notebook = (Notebook) obj;
        return model.equals(notebook.model) && ssd.equals(notebook.ssd) && os.equals(notebook.os)
                && color.equals(notebook.color) && cpu.equals(notebook.cpu)  && screen.equals(notebook.screen);
    }

    @Override
    public int hashCode() {
        return 8*model.hashCode() + 3*ssd.hashCode() + 6*os.hashCode() + 2*color.hashCode()
                + 7*cpu.hashCode() + 6*screen.hashCode();
    }

}
