package parameters;

public enum TestParam {

    AGE_RANGE ("18"),
    FILE ("file"),
    TEST_GAME("testGame"),
    PATH_TO_INSTALLER ("src/downloads/%s");

    private String title;

    TestParam(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
