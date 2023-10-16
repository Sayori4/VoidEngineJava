package voidEngine;

import engineTester.MainGameLoop;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;
import voidEngine.utils.EngineSettings;
import voidEngine.utils.Logger;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;


public class WindowManager {
    private long window;
    private final EngineSettings config = MainGameLoop.getConfig();
    private final Logger logger = MainGameLoop.getLogger();
    public void createWindow() {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit()) {
            throw new IllegalStateException("Can't initialize GLFW");
        }
        logger.log("Initialized GLFW");

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        //creates the window
        //to change name,width and height of window change them inside the engine settings
        window = glfwCreateWindow(config.getWIDTH(),config.getHEIGHT(),config.getWindowName(), NULL, NULL);
        logger.log("Created Window");
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
        logger.log("Enabled OpenGL");

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
        logger.log("Destroyed Window");

        glfwTerminate();
        glfwSetErrorCallback(null).free();
        logger.log("Closed Engine");
    }

    public long getWindow() {
        return window;
    }
}
