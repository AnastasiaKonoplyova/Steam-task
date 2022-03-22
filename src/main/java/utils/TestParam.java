package utils;

public enum TestParam {

    AGE_RANGE ("18"),
    ORIG_PRICE ("original_price"),
    FINAL_PRICE ("final_price"),
    SALE ("discount_pct"),
    NAME ("item_name"),
    PATH_TO_INSTALLER ("src/downloads/%s"),
    GAME_GENRE ("action"),
    SUBMENU ("genre");

    private String title;

    TestParam(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
