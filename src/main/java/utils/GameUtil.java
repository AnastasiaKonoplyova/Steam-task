package utils;

import model.Game;
import java.util.List;

public class GameUtil {

    public static Game convertToGame(String name, int sale, String finalPrice, String origPrice){
        return new Game(name, sale, finalPrice, origPrice);
    }

    public static Game findGameWithMaxSale(List<Game> gameList){
        return  gameList.stream().max(new GameComp()).get();
    }

}
