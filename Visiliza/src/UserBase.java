import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserBase {
    Scanner in = new Scanner(System.in); // сканер для ввода с консоли
    private String login_user_now; // логин пользователя, который сейчас авторизован
    private List<User> userbase = new ArrayList<>(); // локальная база пользователей
    private List<String> loginbase = new ArrayList<>(); // локальная база логинов пользователей, последовательно соотеветствует userbase



    public void createNewUser(){ // метод регистрации нового пользователь
        String login = in.next();
        if (cheakUser(login) == false){ // проверка на уникальность логина
            User user = new User(login);
            this.userbase.add(user);
            this.loginbase.add(login);
            System.out.println("Аккаунт успешно создан");
            this.login_user_now = login;
        }
        else {
            System.out.println("Такое имя пользователя уже есть");
            createNewUser(); // рекурсивный запуск этой функции, она будет запускаться до тех пор, пока имя пользователя не станет уникальным
        }
    }

    public void enterUser(){ // функция авторизации пользователя
        String login = in.next();
        if (cheakUser(login) == true){ // проверка на существование такого пользователя
            System.out.println("Вход в аккаунт выполнен");
            this.login_user_now = login;

        }
        else {
            System.out.println("Неверное имя пользователя"); // после этого выкидывает обратно в главное меню
        }

    }

    public void updateUser(User user){ // Обновляет данные о пользователе
        int ind = this.loginbase.indexOf(user.getLogin());
        this.userbase.set(ind, user);
    }

    public User getUserByLogin(String login){ // получает данные о пользователе по логину
        int ind = this.loginbase.indexOf(login);
        User user = this.userbase.get(ind);
        return this.userbase.get(ind);
    }

    public void getUser(int ind){ // Получить и вывести все данные о пользователе
        User user = this.userbase.get(ind);
        String login = user.getLogin();
        System.out.println("Логин: " + login);
        int games = user.getWin_count() + user.getLose_count();
        System.out.println("Количество побед: " + user.getWin_count());
        System.out.println("Количество проигрышев: " + user.getLose_count());
        System.out.println("Количество игр: " + games);
        System.out.println();
    }

    public boolean cheakUser(String login){ // проверка на существование пользователя

        return this.loginbase.contains(login);
    }

    public String getLogin_user_now() {
        return this.login_user_now;
    } //получение акктуального пользователя

    public List<User> getUserbase() { // вывод данных по базе пользователей
        for(int i = 0; i < this.userbase.size(); i++){
            getUser(i);
        }
        return userbase;
    }

}
