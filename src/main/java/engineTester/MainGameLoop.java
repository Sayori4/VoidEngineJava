package engineTester;

import engineTester.stuff.ImGuiMenu;
import voidEngine.ImGui.ImGuiRunner;
import voidEngine.rendering.Loader;
import voidEngine.rendering.Renderer;
import voidEngine.WindowManager;
import engineTester.shaders.StaticShader;
import voidEngine.rendering.RawModel;

import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

public class MainGameLoop {
    public static void main(String[] args) {

        WindowManager Window = new WindowManager();
        // EngineSettings config = Window.getConfig();

        //config.setResolution(1280, 720);

        Window.createWindow();
        ImGuiRunner ImGUI = new ImGuiRunner(Window.getWindow(), new ImGuiMenu());

        ImGUI.init();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        StaticShader shader = new StaticShader();

        float[] vertices = {
                -0.5f, -0.5f, 0f,
                 0.5f, -0.5f, 0f,
                -0.5f,  0.5f, 0f,
                 0.5f,  0.5f, 0f
        };

        int[] indices = {
                0,1,2,
                2,1,3
        };

        RawModel model = loader.loadToVAO(vertices, indices);

        while ( !glfwWindowShouldClose(Window.getWindow()) ) {
            renderer.prepare();
            shader.start();
            renderer.render(model);
            shader.stop();
            ImGUI.render();
            Window.updateWindow();
        }

        shader.cleanUp();
        loader.cleanUp();
        ImGUI.cleanUp();
        Window.closeWindow();
    }
}
