package engineTester;

import voidEngine.WindowManager;
import voidEngine.utils.EngineSettings;

public class MainGameLoop {
    private static EngineSettings config;
    public static void main(String[] args) {
        config = new EngineSettings("VoidEngine",640,480);
        WindowManager Window = new WindowManager();
        Window.createWindow();
        Window.updateWindow();
        Window.closeWindow();
    }

    public static EngineSettings getConfig() {
        return config;
    }
}
