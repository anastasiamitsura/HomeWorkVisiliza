import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserBase {

    private String login_user_now;
    Scanner in = new Scanner(System.in);

    private List<User> userbase = new ArrayList<>();
    private List<String> loginbase = new ArrayList<>();



    public void createNewUser(){
        String login = in.next();
        if (cheakUser(login) == false){
            User user = new User(login);
            this.userbase.add(user);
            this.loginbase.add(login);
            System.out.println("Аккаунт успешно создан");
            this.login_user_now = login;
        }
        else {
            System.out.println("Такое имя пользователя уже есть");
            createNewUser();
        }
    }

    public void enterUser(){
        String login = in.next();

        if (cheakUser(login) == true){
            System.out.println("Вход в аккаунт выполнен");
            this.login_user_now = login;

        }
        else {
            System.out.println("Неверное имя пользователя");
            enterUser();
        }

    }

    public void updateUser(User user){
        int ind = this.loginbase.indexOf(user.getLogin());
        this.userbase.set(ind, user);
    }

    public User getUserByLogin(String login){
        int ind = this.loginbase.indexOf(login);
        User user = this.userbase.get(ind);
        return this.userbase.get(ind);
    }

    public void getUser(int ind){
        User user = this.userbase.get(ind);
        String login = user.getLogin();
        System.out.println("Логин: " + login);
        int games = user.getWin_count() + user.getLose_count();
        System.out.println("Количество побед: " + user.getWin_count());
        System.out.println("Количество проигрышев: " + user.getLose_count());
        System.out.println("Количество игр: " + games);
        System.out.println();
    }

    public boolean cheakUser(String login){
        return this.loginbase.contains(login);
    }

    public String getLogin_user_now() {
        return this.login_user_now;
    }

    public List<User> getUserbase() {
        for(int i = 0; i < this.userbase.size(); i++){
            getUser(i);
        }
        return userbase;
    }

}
