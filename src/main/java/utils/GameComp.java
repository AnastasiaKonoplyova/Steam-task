package utils;

import model.Game;

import java.util.Comparator;

public class GameComp implements Comparator<Game> {
    public int compare(Game a, Game b) {
        return Integer.compare(b.getSale(), a.getSale());
    }
}