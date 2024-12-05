public class User {
    private String login;
    private int win_count;
    private int lose_count;
    private int games_count = win_count + lose_count;

    private int[] statistic = {win_count, lose_count, games_count};

    public User(String login) {
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

    public String getStatistic() {
        int games = this.win_count + this.lose_count;
        return "Побед: " + this.win_count + "\nПоражений: " + this.lose_count + "\nВсего игр: " + games;
    }

    public String getLogin() {
        return login;
    }

}
