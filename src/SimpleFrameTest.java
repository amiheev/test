import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class SimpleFrameTest {

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createGui();
			}
		});
	}

	static public void createGui() {
		SimpleFrame ourFrame = new SimpleFrame("Another title");
		ourFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ourFrame.setVisible(true);

	}

}

class SimpleFrame extends JFrame {

	private String title = "Default title";

	SimplePanel panel;

	private void constructFrame() {
		setTitle(title);

		setSize(800, 600);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		setLocation((int) width / 2 - getWidth() / 2, (int) height / 2
				- getHeight() / 2);
		setResizable(true);

		panel = new SimplePanel("1");
		panel.setBorder(BorderFactory.createLineBorder(Color.RED, 5));

		this.add(panel, BorderLayout.CENTER);
	}

	SimpleFrame() {
		super();
		constructFrame();

	}

	SimpleFrame(String t) {
		super();

		title = t;
		constructFrame();
	}

}

class SimplePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private int xPos = 0;
	private int yPos = 0;

	String id = "";

	SimplePanel() {
		super();
	}

	SimplePanel(String i) {
		super();
		id = i;

		Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				xPos++;
				yPos++;
				repaint();
			}
		}, 0, 100);

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				xPos = e.getX();
				yPos = e.getY();

				repaint();
			}

		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawOval(xPos - 25, yPos - 25, 50, 50);

	}
}


