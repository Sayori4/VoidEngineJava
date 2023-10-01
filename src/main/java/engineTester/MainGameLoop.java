package engineTester;

import voidEngine.WindowManager;

public class MainGameLoop {
    public static void main(String[] args) {
        WindowManager Window = new WindowManager();
        Window.createWindow();
        Window.updateWindow();
        Window.closeWindow();
    }
}
