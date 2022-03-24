package parameters;

public enum MainMenuParam {
    GENRE_MENU ("genre");

    private String title;

    MainMenuParam(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
