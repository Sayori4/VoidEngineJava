package voidEngine.shaders;

public class StaticShader extends ShaderLoader{

    private static final String VERTEX_FILE = "src/main/java/engineTester/shaders/vertexShader.glsl";
    private static final String FRAGMENT_FILE = "src/main/java/engineTester/shaders/fragmentShader.glsl";

    public StaticShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
    }
}
