package com.example;

import com.example.draw;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;
import javax.swing.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class win extends JFrame{
    public long window;
    public float posX = 0.0f;
    public float posY = 0.0f;

    public void run(){
            init(); //the initialize window function
            loop();

            glfwFreeCallbacks(window);
            glfwDestroyWindow(window);

            glfwTerminate();
            glfwSetErrorCallback(null).free();
    }


    private void init(){
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit()){
            throw new IllegalStateException("Error: Unable to initialize GLFW LIB");
        }

        // Config GLFW
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        window = glfwCreateWindow(800, 600, "3D Mark(GLFW)",
         NULL, NULL);
        if (window == NULL){
            throw new RuntimeException("Error: Unable Create GLFW Window");
        }

        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE ){
                glfwSetWindowShouldClose(window, true);
            }
        });

        try (MemoryStack stack = stackPush()){
            IntBuffer Width = stack.mallocInt(1);
            IntBuffer Height = stack.mallocInt(1);

            glfwGetWindowSize(window, Width, Height);
            GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            glfwSetWindowPos(window, (vidMode.width() - Width.get(0)) / 2 , (vidMode.height() - Height.get(0)) / 2);
        }
        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        glfwShowWindow(window);
    }

    private void loop(){
        GL.createCapabilities();

        glClearColor(0.0f,0.0f, 0.0f, 1.0f);

        while(!glfwWindowShouldClose(window)){
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            add(new draw());
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

    public static void main(String[] args) {
        new win().run();
    }
}