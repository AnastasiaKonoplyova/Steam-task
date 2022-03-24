package utils;

import model.Game;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class GameUtil {

    private GameUtil(){}
    public static Game convertToGame(String name, String sale, String finalPrice, String origPrice){
        return new Game(name, Integer.parseInt(sale), finalPrice, origPrice);
    }

    public static Game findGameWithMaxSale(List<Game> gameList){
        Optional<Game> maxSaleGame = gameList.stream().max(Comparator.comparingInt(Game::getSale));
        return maxSaleGame.orElse(null);
    }

}
