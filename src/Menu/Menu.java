package Menu;

import Hisse.*;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu{
	private final int X = 700;
	private final int Y = 250;
	private JFrame frame = new JFrame("Hisse Takip");
	private JPanel list = new JPanel();
	private JPanel text = new JPanel();
	private JLabel label = new JLabel();
	private final JComboBox<String> hisseList = new JComboBox<String>(HisseFinder.getHisseList());
	
	public void start() {
		frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(X, Y);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setLayout(null);

	  hisseList.setVisible(true);
	  
    list.setBounds(0, 0, X, Y/5);
    list.add(hisseList);
    
    label.setVisible(true);
    label.setVerticalAlignment(JLabel.CENTER);
    label.setHorizontalAlignment(JLabel.CENTER);
    
    text.setBounds(0, Y/5, X, 4*Y/5);
    text.setLayout(new BorderLayout());
    text.add(label);

    frame.add(list);
    frame.add(text);
    
    String hisseName = hisseList.getSelectedItem().toString();
		Hisse hisse = HisseFinder.findHisse(hisseName);
	  label.setText(hisse.toString());
		Thread t = new Thread() {
			public void run() {
				while(hisse != null) {
					String hisseName = hisseList.getSelectedItem().toString();
					Hisse hisse = HisseFinder.findHisse(hisseName);
					HisseFinder.updateHisse(hisse);
					label.setText(hisse.toString());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		t.start();
	}
}
