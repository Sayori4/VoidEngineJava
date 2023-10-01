package voidEngine;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;


public class WindowManager {
    private long window;
    public void createWindow() {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit()) {
            throw new IllegalStateException("Can't initialize GLFW");
        }

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        //creates the window
        //to change name,width and height of window change them inside the engine settings
        window = glfwCreateWindow(EngineSettings.WIDTH, EngineSettings.HEIGHT, EngineSettings.WindowName, NULL, NULL);

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
    }

    public void updateWindow() {
        GL.createCapabilities();

        //set Color Clear
        glClearColor(0.0f,0.0f,0.0f,0.0f);


        while ( !glfwWindowShouldClose(window) ) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); //clear framebuffer
            glfwSwapBuffers(window); // swap color buffers
            glfwPollEvents();
        }
    }

    public void closeWindow() {
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
}
