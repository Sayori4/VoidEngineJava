package engineTester.stuff;

import imgui.ImGui;

public class ImGuiLayer {
    public void imgui() {
        ImGui.begin("ImGui");
        ImGui.text("Works on my PC");
        ImGui.end();
    }
}
