import controller.Game;
import model.Timer;

import java.sql.Time;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();

//        new Thread(new Timer(70)).start();
    }
}
