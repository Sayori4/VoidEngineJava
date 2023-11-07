package voidEngine.ImGui;

import imgui.ImGui;
import imgui.flag.ImGuiConfigFlags;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;
import org.lwjgl.glfw.GLFW;

public class ImGuiRunner {
    private final ImGuiImplGlfw imGuiGlfw = new ImGuiImplGlfw();
    private final ImGuiImplGl3 imGuiGl3 = new ImGuiImplGl3();

    private final long window;
    private final ImGuiLayer imGuiLayer;
    public ImGuiRunner(long window, ImGuiLayer layer) {
        this.window = window;
        this.imGuiLayer = layer;
    }

    public void init() {
        initImGui();
        imGuiGl3.init();
        imGuiGlfw.init(window, true);
    }

    public void cleanUp() {
        imGuiGl3.dispose();
        imGuiGlfw.dispose();
        ImGui.destroyContext();
    }

    public void render() {
        imGuiGlfw.newFrame();
        ImGui.newFrame();

        imGuiLayer.imgui();

        ImGui.render();
        imGuiGl3.renderDrawData(ImGui.getDrawData());

        if (ImGui.getIO().hasConfigFlags(ImGuiConfigFlags.ViewportsEnable)) {
            final long backupWindow = org.lwjgl.glfw.GLFW.glfwGetCurrentContext();
            ImGui.updatePlatformWindows();
            ImGui.renderPlatformWindowsDefault();
            GLFW.glfwMakeContextCurrent(backupWindow);
        }
    }

    private void initImGui() {
        ImGui.createContext();
    }




}
