public class Account {

    public void startGame(UserBase userBase) {
        Game game = new Game();
        Boolean a = game.getWinSt();
        if (a == true) {
            User user = userBase.getUserByLogin(userBase.getLogin_user_now());
            user.addWin_count();
            userBase.updateUser(user);
        } else {
            User user = userBase.getUserByLogin(userBase.getLogin_user_now());
            user.addLose_count();
            ;
            userBase.updateUser(user);

        }
    }

    public void greeting() {
        System.out.println("В главном меню тебе доступны функции:\n" +
                "- Создание аккаунта по логину </create>\n" +
                "- Входа в аккаунт по логину </login>\n" +
                "- Просмотра всех аккаунтов в базе </users_stat>\n" +
                "- Выхода из игры </0>");
    }
}
