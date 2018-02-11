import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @summary Panel that displays the output for the generated password
 */
public class InputPanel extends JPanel {

	private JLabel pass;
	public JTextField output;
	
	public JButton createPass;
	
	
	
	InputPanel(){
		
		 createPass = new JButton("Create");
		BorderLayout bLay = new BorderLayout();
		
		setLayout(bLay);
		
		output = new JTextField();
		output.setSize(20,20);
		
		add(pass = new JLabel("password:"), BorderLayout.CENTER);
		add(output, BorderLayout.CENTER);
		add(createPass, BorderLayout.PAGE_END);
		
		
		
	}
}
