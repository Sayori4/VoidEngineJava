package engineTester;

import voidEngine.Loader;
import voidEngine.Renderer;
import voidEngine.WindowManager;
import voidEngine.utils.EngineSettings;
import voidEngine.utils.RawModel;

import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

public class MainGameLoop {
    private static EngineSettings config;
    public static void main(String[] args) {

        config = new EngineSettings("VoidEngine",640,480);
        WindowManager Window = new WindowManager();

        Window.createWindow();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();

        float[] vertices = {
                -0.5f, 0.5f, 0f,
                -0.5f, -0.5f, 0f,
                0.5f, -0.5f, 0f,
                0.5f, -0.5f, 0f,
                0.5f, 0.5f, 0f,
                -0.5f, 0.5f, 0f
        };

        RawModel model = loader.loadToVAO(vertices);

        while ( !glfwWindowShouldClose(Window.getWindow()) ) {
            renderer.prepare();
            renderer.render(model);
            Window.updateWindow();
        }

        loader.cleanUp();
        Window.closeWindow();
    }

    public static EngineSettings getConfig() {
        return config;
    }
}
