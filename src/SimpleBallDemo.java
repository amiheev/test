import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;

public class SimpleBallDemo extends JFrame {
    JPanel panel = new JPanel();
    Graphics g;


    public SimpleBallDemo(){
        setTitle("title");
        setSize(800, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        setLocation((int) width / 2 - getWidth() / 2, (int) height / 2
                - getHeight() / 2);
        setResizable(true);

        panel.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        this.add(panel, BorderLayout.CENTER);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new BallThread(panel).start();
            }
        });


    }



}

class BallThread extends Thread {
    JPanel panel;
    private int xPos = 0;
    private int yPos = 0;
    private int xPos1 = 1;
    private int yPos1 = 1;

    BallThread(JPanel p){
        this.panel = p;

        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                xPos+=xPos1;
                yPos+=yPos1;
                paint(panel.getGraphics());
                if (xPos == 800-50 || xPos==0){
                    xPos1=-xPos1;

                }
                if (yPos == 600-50 || yPos==0){
                    yPos1=-yPos1;

                }
                paint(panel.getGraphics());
            }
        }, 0, 100);
    }


    /*public void run(){
        java.util.Timer timer = new java.util.Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                xPos += xPos1;
                yPos += yPos1;
                paint(panel.getGraphics());
                if (xPos == 800 - 50 || xPos == 0) {
                    xPos1 = -xPos1;

                }
                if (yPos == 600 - 50 || yPos == 0) {
                    yPos1 = -yPos1;

                }
                paint(panel.getGraphics());
            }

    }, 0, 10);
}*/


    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(50, 50, 25, 25);
        g.setColor(Color.WHITE);
        g.drawOval(50 + 1, 50 + 1, 25, 25);
        try {
            sleep(3000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        //�������� ������
        g.setColor(panel.getBackground());
        g.drawOval(50, 50, 25, 25);
    }
}
