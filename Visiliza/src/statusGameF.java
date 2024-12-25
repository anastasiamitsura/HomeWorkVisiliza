import jdk.jshell.Snippet;

public class statusGameF {
    private statusGame statusGame1 = statusGame.InGame;

    public statusGameF(statusGame statusGame1) {
        this.statusGame1 = statusGame1;
    }


    public statusGame getStatusGame() {
        return statusGame1;
    }

    public void setStatusGame(statusGame statusGame) {
        this.statusGame1 = statusGame;
    }
}