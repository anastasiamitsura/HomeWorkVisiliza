import java.util.Scanner;

public class Game extends Data {

    Scanner in = new Scanner(System.in);
    private String word_start;
    private String word_game;

    private int win_st = 0;

    private int life_count = 6;


    public int game(){
        int st = 1;
        String buck = "";
        this.word_start = getRandom();
        this.word_game = "*".repeat(this.word_start.length());
        System.out.println("Начало игры, у вас 6 жизней, размер вашего слова:");
        System.out.println(word_game);
        while (st != 0){
            System.out.println("Введите букву");
            buck = in.next();
            st = hod(buck);
        }
        return win_st;
    }

    public String cheakWord(String buck){
        String newword = "";
        if (this.word_start.contains(buck)){
            for(int i = 0; i < this.word_start.length(); i++){
                if (this.word_game.charAt(i) == '*' && this.word_start.charAt(i) == buck.charAt(0)){
                    newword += buck;
                }
                else{
                    newword += this.word_game.charAt(i);
                }
            }
            return newword;
        }

        return "";
    }

    public int hod(String buck){
        String w_game = this.word_game;
        String word = cheakWord(buck);
        if (word.equals("") && this.life_count > 1){
            this.life_count--;
            System.out.println("Не та буква");
            System.out.println("Количество жизней: " + this.life_count);
            if (this.life_count == 5){
                System.out.println(
                        "\n" +
                        " \n" +
                        "  \n" +
                        "  \n" +
                        "  \n" +
                        "  \n" +
                        "=========");
            } else if (this.life_count == 4) {
                System.out.println(
                        "+--------+\n" +
                                "  |        \n" +
                                "  |        \n" +
                                "  |        \n" +
                                "  |         \n" +
                                "  |   \n" +
                                "=========");
            } else if (this.life_count == 3) {
                System.out.println(
                        "+--------+\n" +
                                "  |      |\n" +
                                "  |      O\n" +
                                "  |      |\n" +
                                "  |        \n" +
                                "  |   \n" +
                                "=========");
            } else if (this.life_count == 2) {
                System.out.println(
                        "+--------+\n" +
                                "  |      |\n" +
                                "  |      O\n" +
                                "  |     /|| \n" +
                                "  |       \n" +
                                "  |   \n" +
                                "=========");

            }
            return 1;
        }
        else if (word.equals("") && this.life_count == 1){
            this.life_count--;
            System.out.println("Не та буква, вы проиграли");
            System.out.println("Количество жизней: " + this.life_count);
            System.out.println(
                    "+--------+\n" +
                    "  |      |\n" +
                    "  |      O\n" +
                    "  |     /|| \n" +
                    "  |      /| \n" +
                    "  |   \n" +
                    "=========");
            win_st = 0;
            return 0;
        }
        else if (word.equals(word_start)){
            System.out.println("Вы победили");
            System.out.println("Ваше слово: " + word);
            win_st = 1;
            this.word_game = word;
            return 0;
        }
        else if (word.equals(w_game) == false){
            System.out.println("Буква верная, ваше слово: " + word);
            this.word_game = word;
            return 1;
        }
        return 1;
    }
}
