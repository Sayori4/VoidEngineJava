package voidEngine.utils;

public class EngineSettings {
    private String windowName;
    private int WIDTH,HEIGHT;

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

    public void setResolution(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public void setName(String windowName) {
        this.windowName = windowName;
    }
}