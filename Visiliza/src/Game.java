import java.util.Scanner;

public class Game {
    private Scanner in = new Scanner(System.in);
    private final String wordStart; // слово, которое нужно отгадать
    private String wordGame; // статус слова в игре
    private Boolean winSt; // победил игрок или нет
    private int lifeCount; // количество жизней
    private final Data data = new Data(); // экземпляр класса Data

    private final ImageClass Img = new ImageClass(); // экземпляр класса ImageClass

    public Game() {
        this.wordStart = data.getRandom();
        this.wordGame = "*".repeat(this.wordStart.length());
        this.winSt = false;
        this.lifeCount = 6;
    }


    public Boolean getWinSt() { // цикл игры
        int st = 1;
        String buck = "";
        System.out.println("Начало игры, у вас 6 жизней, размер вашего слова:");
        System.out.println(wordGame);
        while (st != 0) {
            System.out.println("Введите букву");
            buck = in.next();
            st = makeHod(buck);
        }
        return winSt;
    }

    public String cheakWord(String buck) { // проверка правильности буквы и, если она правильная, то вывод нового word_game
        String newword = "";
        if (this.wordStart.contains(buck)) {
            for (int i = 0; i < this.wordStart.length(); i++) {
                if (this.wordGame.charAt(i) == '*' && this.wordStart.charAt(i) == buck.charAt(0)) {
                    newword += buck;
                } else {
                    newword += this.wordGame.charAt(i);
                }
            }
            return newword;
        }

        return "";
    }


    public int makeHod(String buck) { // процесс кода
        String w_game = this.wordGame;
        String word = cheakWord(buck);
        if (word.equals("") && this.lifeCount > 1) {
            this.lifeCount--;
            System.out.println("Не та буква");
            System.out.println("Количество жизней: " + this.lifeCount);
            System.out.println(Img.getImg(lifeCount));
            return 1;
        } else if (word.equals("") && this.lifeCount == 1) {
            this.lifeCount--;
            System.out.println("Не та буква, вы проиграли");
            System.out.println("Количество жизней: " + this.lifeCount);
            System.out.println(Img.getImg(lifeCount));
            winSt = false;
            return 0;
        } else if (word.equals(wordStart)) {
            System.out.println("Вы победили");
            System.out.println("Ваше слово: " + word);
            winSt = true;
            this.wordGame = word;
            return 0;
        } else if (word.equals(w_game) == false) {
            System.out.println("Буква верная, ваше слово: " + word);
            this.wordGame = word;
            return 1;
        }
        return 1;
    }
}
