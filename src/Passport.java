import java.util.HashMap;
import java.util.Map;

public class Passport {
    private Map<String, String> map = new HashMap<>();


    void add(String passnum, String lastname){ // добавляет пару ключ-значение

        map.put(passnum, lastname);
    }

    String getbyPassnum(String passum){ //по ключу выводит пару ключ:значение
        return passum + ":" + map.get(passum);
    }

    String getbyLastname(String lastname){  // по фамилии выдает ключ
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry: map.entrySet()) {
            if(entry.getValue() == lastname ){
                stringBuilder.append(entry.getKey());
                stringBuilder.append(" : ");
                stringBuilder.append(lastname);
                stringBuilder.append("\n");
            }

        }
        return stringBuilder.toString();
    }

    String getAll(){
        return map.toString();
    }
}
