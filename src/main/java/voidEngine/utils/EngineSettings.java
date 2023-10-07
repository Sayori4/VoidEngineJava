package voidEngine.utils;

public class EngineSettings {
    private final String windowName;
    private final int WIDTH,HEIGHT;

    public EngineSettings(String windowName, int WIDTH, int HEIGHT) {
        this.windowName = windowName;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public String getWindowName() {
        return windowName;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}