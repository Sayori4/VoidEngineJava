package engineTester;

import voidEngine.rendering.Loader;
import voidEngine.rendering.Renderer;
import voidEngine.WindowManager;
import voidEngine.utils.EngineSettings;
import voidEngine.rendering.RawModel;
import voidEngine.utils.Logger;

import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

public class MainGameLoop {
    private static EngineSettings config;
    private static Logger logger;
    public static void main(String[] args) {

        config = new EngineSettings("VoidEngine",640,480);
        logger = new Logger("VoidEngineLog");
        WindowManager Window = new WindowManager();

        Window.createWindow();

        Loader loader = new Loader();
        logger.log("Initialized the loader");
        Renderer renderer = new Renderer();
        logger.log("Initialized the renderer");

        float[] vertices = {
                 0.0f,  0.5f, 0f,
                -0.5f, -0.5f, 0f,
                 0.5f, -0.5f, 0f,
        };

        RawModel model = loader.loadToVAO(vertices);

        while ( !glfwWindowShouldClose(Window.getWindow()) ) {
            renderer.prepare();
            renderer.render(model);
            Window.updateWindow();
        }

        loader.cleanUp();
        Window.closeWindow();
        logger.save();
    }

    public static EngineSettings getConfig() {
        return config;
    }

    public static Logger getLogger() {
        return logger;
    }
}
