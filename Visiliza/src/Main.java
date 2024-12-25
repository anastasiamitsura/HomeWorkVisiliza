import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Статусы:
 * InGame - главное меню
 * Доступные функции:
 * - create - создание аккаунта
 * - login - вход в аккаунт
 * - users_stat
 * - 0 - выход из игры
 * InUser - в аккаунте
 * Доступные функции:
 * - start_game - начать игру
 * - exit - выход из аккаунта
 * - stat - статистика аккаунта
 * InGame - в игре
 */

public class Main {

    public static void main(String[] args) {
        Account account = new Account();
        Scanner in = new Scanner(System.in);
        String ent = ""; // переменная, для ввода с консоли
        statusGameF statusGamef = new statusGameF(statusGame.MainMeny); // статус
        UserBase userBase = new UserBase(); // локальная база данных игры
        System.out.println("Добрый день, уважаемый пользователь, игры Visiliza,\n" +
                "сейчас ты находишься в главном меню этой игры,\n" +
                "чтобы начать игру тебе необходимо войти в аккаунт\n" +
                "Правила игры:\n" +
                "У игрока есть 6 жизней\nЗа каждую неправильную букву снимается одна жизнь\n" +
                "Датасет слов в игре - это ITшный сленг на русском языке\n\n" +
                "Приятной игры!\n" +
                "По всем вопросам обращаться к разработчику в телеграмм @anastasiamitsura"); // вводное слово
        while (true) { // цикл игры
            if (statusGamef.getStatusGame().equals(statusGame.MainMeny)) {
                System.out.println("Введите функцию:");
                ent = in.next();
                if (ent.equals("/create")) {
                    System.out.println("Введите имя аккаунта");
                    userBase.createNewUser();
                    statusGamef.setStatusGame(statusGame.InUser);
                }
                if (ent.equals("/login")) {
                    System.out.println("Введите имя аккаунта");
                    userBase.enterUser();
                    statusGamef.setStatusGame(statusGame.InUser);
                }
                if (ent.equals("/0")) {
                    System.out.println("Выход из игры");
                    break;
                }
                if (ent.equals("/users_stat")) userBase.getUserbase();
            } else if (statusGamef.getStatusGame().equals(statusGame.InUser)) {
                account.greeting();
                System.out.println("Введите функцию:");
                ent = in.next();
                if (ent.equals("/start_game")) account.startGame(userBase);
                if (ent.equals("/exit")) statusGamef.setStatusGame(statusGame.InGame);
                if (ent.equals("/stat"))
                    System.out.println(userBase.getUserByLogin(userBase.getLogin_user_now()).getStatistic() + "");
            }
        }
    }
}
