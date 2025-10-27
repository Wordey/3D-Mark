package com.example;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import javax.swing.*;

public class draw extends JPanel{
    
    public draw(){
        glClearColor(0.6f, 0.6f, 0.6f, 0.6f);

        glPushMatrix();
        glTranslatef(0, 0, 0);
        glBegin(GL_QUADS);
            glColor3f(1.0f, 0f, 0f);
            glVertex2f(-0.05f, -0.05f);
            glVertex2f(0.05f, -0.05f);
            glVertex2f(0.05f, 0.05f);
            glVertex2f(-0.05f, 0.05f);
        glEnd();
        glPopMatrix();
    }
    public static void main(String[] args) {
        new draw();
    } 
}
