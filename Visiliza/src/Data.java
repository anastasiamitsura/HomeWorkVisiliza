import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data {
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

    public String getRandom() {
        int rnd = new Random().nextInt(data.length);
        return data[rnd];
    }
}
