package engineTester;

import voidEngine.rendering.Loader;
import voidEngine.rendering.Renderer;
import voidEngine.WindowManager;
import voidEngine.shaders.StaticShader;
import voidEngine.utils.EngineSettings;
import voidEngine.rendering.RawModel;

import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

public class MainGameLoop {
    private static EngineSettings config;
    public static void main(String[] args) {

        config = new EngineSettings("VoidEngine",640,480);
        WindowManager Window = new WindowManager();

        Window.createWindow();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        StaticShader shader = new StaticShader();

        float[] vertices = {
                 0.0f,  0.5f, 0f,
                -0.5f, -0.5f, 0f,
                 0.5f, -0.5f, 0f,
        };

        int[] indices = {
                0,1,2
        };

        RawModel model = loader.loadToVAO(vertices, indices);

        while ( !glfwWindowShouldClose(Window.getWindow()) ) {
            renderer.prepare();
            shader.start();
            renderer.render(model);
            shader.stop();
            Window.updateWindow();
        }

        shader.cleanUp();
        loader.cleanUp();
        Window.closeWindow();
    }

    public static EngineSettings getConfig() {
        return config;
    }

}
