public class User {
    private String login; // логие пользователя
    private int win_count; // количесво побед
    private int lose_count; // количество проигрышев

    public User(String login) { // консруктор
        this.login = login;
        this.win_count = 0;
        this.lose_count = 0;
    }

    public int getWin_count() {
        return this.win_count;
    }

    public void addWin_count() {
        this.win_count++;
    }

    public int getLose_count() {
        return this.lose_count;
    }

    public void addLose_count() {
        this.lose_count++;
    }

    public String getStatistic() { //вывод статистики по пользователю
        int games = this.win_count + this.lose_count;
        return "Побед: " + this.win_count + "\nПоражений: " + this.lose_count + "\nВсего игр: " + games;
    }

    public String getLogin() {
        return login;
    }

}
