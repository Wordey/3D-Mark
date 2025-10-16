import javax.swing.*;

public class window extends JFrame{
    public window(){
        setTitle("3D Mark(alpha 0.0.1)");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocation(500,500);
        setVisible(true);
    }

    public static void main(String[] args){
        window w = new window();
    }
}