package parameters;

public enum GameParameters {
    ORIG_PRICE ("original_price"),
    FINAL_PRICE ("final_price"),
    SALE ("discount_pct"),
    NAME ("item_name");

    private String title;

    GameParameters(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
