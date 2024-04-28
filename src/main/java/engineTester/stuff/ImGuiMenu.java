package engineTester.stuff;

import imgui.ImGui;
import voidEngine.ImGui.ImGuiLayer;

public class ImGuiMenu implements ImGuiLayer {
    public void imgui() {
        ImGui.begin("ImGui");
        ImGui.text("Works on my PC");
        ImGui.end();
    }
}
