package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Game {

    private String name;
    private int sale;
    private String finalPrice;
    private String originPrice;

}
