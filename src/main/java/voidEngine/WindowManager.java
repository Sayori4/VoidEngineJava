package voidEngine;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;
import voidEngine.utils.EngineSettings;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;


public class WindowManager {
    private long window;
    private final EngineSettings config = new EngineSettings("VoidEngine",640,480);
    public void createWindow() {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit()) {
            throw new IllegalStateException("Can't initialize GLFW");
        }

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);

        //creates the window
        //to change name,width and height of window change them inside the engine settings
        window = glfwCreateWindow(config.getWIDTH(),config.getHEIGHT(),config.getWindowName(), NULL, NULL);
        if (window == NULL) {
            throw new RuntimeException("Failed to create GLFW window");
        }

        glfwSetKeyCallback(window,(window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS) {
                glfwSetWindowShouldClose(window, true);
            }
        });

        glfwMakeContextCurrent(window); //set opengl context state to current
        glfwSwapInterval(1); //vsync

        glfwShowWindow(window); //show the window

        GL.createCapabilities();//Enable OPENGL

        //set Color Clear
        glClearColor(0.0f,0.0f,0.0f,0.0f);

    }

    public void updateWindow() {
        glfwSwapBuffers(window); // swap color buffers
        glfwPollEvents();
    }

    public void closeWindow() {
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public long getWindow() {
        return window;
    }

    public EngineSettings getConfig() {
        return config;
    }
}
