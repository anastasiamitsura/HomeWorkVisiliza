import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ent = ""; // переменная, для ввода с консоли
        int status_game = 0; // статус игры   см. внизу кода пояснение
        UserBase userBase = new UserBase(); // локальная база данных игры
        System.out.println("Добрый день, уважаемый пользователь, игры Visiliza,\n" +
                "сейчас ты находишься в главном меню этой игры,\n" +
                "чтобы начать игру тебе необходимо войти в аккаунт\n" +
                "Правила игры:\n" +
                "У игрока есть 6 жизней\nЗа каждую неправильную букву снимается одна жизнь\n" +
                "Датасет слов в игре - это ITшный сленг на русском языке\n\n" +
                "Приятной игры!\n" +
                "По всем вопросам обращаться к разработчику в телеграмм @anastasiamitsura"); // вводное слово
        while(true){ // цикл игры
            if (status_game == 0){

                System.out.println("В главном меню тебе доступны функции:\n" +
                        "- Создание аккаунта по логину </create>\n" +
                        "- Входа в аккаунт по логину </login>\n" +
                        "- Просмотра всех аккаунтов в базе </users_stat>\n" +
                        "- Выхода из игры </0>");
                System.out.println("Введите функцию:");
                ent = in.next();
                if (ent.equals("/create")){
                    System.out.println("Введите имя аккаунта");
                    userBase.createNewUser();
                    status_game = 1;
                }
                if (ent.equals("/login")){
                    System.out.println("Введите имя аккаунта");
                    userBase.enterUser();
                    status_game = 1;
                }
                if (ent.equals("/0")){
                    System.out.println("Выход из игры");
                    break;
                }
                if(ent.equals("/users_stat")){
                    userBase.getUserbase();
                }
            }
            else if (status_game == 1){

                System.out.println("В меню аккаунта тебе доступны функции:\n" +
                        "- Начала новой игры </start_game>\n" +
                        "- Просмотра статистики аккаунта </stat>\n" +
                        "- Выхода из аккаунта </exit>\n");
                System.out.println("Введите функцию:");
                ent = in.next();
                if (ent.equals("/start_game")){
                    Game game = new Game();
                    int a = game.game();
                    if (a == 1){
                        User user = userBase.getUserByLogin(userBase.getLogin_user_now());
                        user.addWin_count();
                        userBase.updateUser(user);
                    }
                    else {
                        User user = userBase.getUserByLogin(userBase.getLogin_user_now());
                        user.addLose_count();;
                        userBase.updateUser(user);

                    }
                }
                if (ent.equals("/exit")){
                    status_game = 0;
                }
                if (ent.equals("/stat")){
                    System.out.println(userBase.getUserByLogin(userBase.getLogin_user_now()).getStatistic() + "");
                }
            }
        }
    }
}
/*
Статусы:
0 - главное меню
Доступные функции:
- create - создание аккаунта
- login - вход в аакаунт
- users_stat
- 0 - выход из игры
1 - в аккаунте
Доступные функции:
- start_game - начать игру
- exit - выход из аккаунта
- stat - статистика аккаунта
2 - в игре
 */