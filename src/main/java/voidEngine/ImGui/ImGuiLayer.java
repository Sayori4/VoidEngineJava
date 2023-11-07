package voidEngine.ImGui;

import imgui.ImGui;

public class ImGuiLayer {
    public void imgui() {
        ImGui.begin("ImGUI");

        ImGui.text("Works on my PC");

        ImGui.end();
    }
}
