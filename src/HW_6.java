import java.util.*;

public class HW_6 {
    public static void main(String[] args) {

        Set<Notebook> notebooks = new HashSet<>();
        Notebook nb1 = new Notebook("DEXP Aquilon", "128", "Windows", "серебристый",
                "Intel Celeron N3020", "1920x1080");
        Notebook nb2 = new Notebook("Lenovo V15 ADA", "256", "Windows", "серый",
                "AMD 3020e", "1366x768");
        Notebook nb3 = new Notebook("ASUS Vivobook 15", "512", "Windows", "серебристый",
                "ARM Ryzen 5 5500U", "1920x1080");
        Notebook nb4 = new Notebook("Tecno Megabook T1", "512", "Ubuntu", "голубой",
                "Intel UHD Graphics", "1920x1080");
        Notebook nb5 = new Notebook("MSI Modern 15", "256", "Windows", "черный",
                "Intel UHD Graphics", "1920x1080");
        Notebook nb6 = new Notebook("Maibenben X668", "1024", "Linux", "черный",
                "Intel Core i7-12700H", "1920x1080");
        notebooks.add(nb1);
        notebooks.add(nb2);
        notebooks.add(nb3);
        notebooks.add(nb4);
        notebooks.add(nb5);
        notebooks.add(nb6);

        Map<Integer, String> filterNb = new HashMap<>();
        filterNb.put(1, "model");
        filterNb.put(2, "ssd");
        filterNb.put(3, "os");
        filterNb.put(4, "color");
        filterNb.put(5, "cpu");
        filterNb.put(6, "screen");

        Map<String, Notebook> totalResult = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        Integer criterion = enterFilterNb();

        if (filterNb.containsKey(criterion)) {
            switch (criterion) {
                case 1: {
                    System.out.println("Введите модель ноутбука:");
                    String value = scanner.nextLine();
                    Notebook.getModel(notebooks, value, totalResult);
                    outputResult(totalResult);
                    break;
                }
                case 2: {
                    System.out.println("Введите объём SSD:");
                    String value = scanner.nextLine();
                    Notebook.getSsd(notebooks, value, totalResult);
                    outputResult(totalResult);
                    break;
                }
                case 3: {
                    System.out.println("Введите операционнную систему ноутбука:");
                    String value = scanner.nextLine();
                    Notebook.getOs(notebooks, value, totalResult);
                    outputResult(totalResult);
                    break;
                }
                case 4: {
                    System.out.println("Введите цвет ноутбука:");
                    String value = scanner.nextLine();
                    Notebook.getColor(notebooks, value, totalResult);
                    outputResult(totalResult);
                    break;
                }
                case 5: {
                    System.out.println("Введите процессор ноутбука:");
                    String value = scanner.nextLine();
                    Notebook.getCpu(notebooks, value, totalResult);
                    outputResult(totalResult);
                    break;
                }
                case 6: {
                    System.out.println("Введите разрешение экрана ноутбука:");
                    String value = scanner.nextLine();
                    Notebook.getScreen(notebooks, value, totalResult);
                    outputResult(totalResult);
                    break;
                }
                default:
                    break;
            }
        }
        scanner.close();
    }

    static Integer enterFilterNb() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Приветствую! \n Выберите критерий для поиска ноутбука: \n 1 - Модель \n 2 - Объём SSD \n" +
                " 3 - ОС \n 4 - Цвет \n 5 - Процессор \n 6 - Разрешение экрана");
        System.out.println("Критерий : ");
        return Integer.parseInt(scanner1.nextLine());
    }

    static void outputResult(Map<String, Notebook> totalResult) {
        System.out.println("Рекомендуем присмотреться к следующим моделям: ");
        for (var entry : totalResult.entrySet()) {
            System.out.printf("%s\n%s\n\n", entry.getKey(), entry.getValue().toString());
        }
    }
}





