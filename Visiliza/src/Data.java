import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data { // класс для хранения датасета данных
    private String[] data = {
            "хакатон"
            , "бэкенд"
            , "фронтенд"
            , "бот"
            , "баг"
            , "софт"
            , "бэклог"
            , "гитхаб"
            , "айтишник"
            , "мобилка"};
    int rnd = new Random().nextInt(data.length);

    public String getRandom() {
        return data[rnd];
    }
}
