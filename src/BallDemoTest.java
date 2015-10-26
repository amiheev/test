import javax.swing.*;

/**
 * Created by Alexey on 16.10.2015.
 */
public class BallDemoTest {
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGui();
            }
        });
    }
    public static void createGui(){

        SimpleBallDemo simpleBallDemo = new SimpleBallDemo();
        simpleBallDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        simpleBallDemo.setVisible(true);

    }
}
