package parameters;

public enum GenreMenuParam {
    GAME_ACTION_GENRE ("action");

    private String title;

    GenreMenuParam(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
