
import javax.swing.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.*;

public class GUI extends JFrame {

	Password pass;

	OptionsPanel pan;
	InputPanel in;

	// Constructor:
	public GUI() {
		// JFrame f = new JFrame();
		setTitle("Password Generator");
		setMinimumSize(new Dimension(400, 400)); // default size is 0,0
		setLocation(10, 200); // default is 0,0 (top left corner)
	//	OptionsPanel pan;
	//	InputPanel in;
		GridLayout grid = new GridLayout(1, 1, 10, 2);

		pan = new OptionsPanel();
		in = new InputPanel();

		JPanel container = new JPanel();
		container.setLayout(grid);
		container.setSize(200, 200);
		pan.setSize(new Dimension(50, 50));
		in.setSize(new Dimension(50, 50));

		container.add(pan);
		container.add(in);
		add(container);

		pack();
		in.setVisible(true);
		pan.setVisible(true);
		setVisible(true);

		in.createPass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				pass = new Password();
				repaint();
				String n = new String(" ");
				in.output.setText("n");
				in.output.setFont(new Font("serif", 50,35) );
				//pan.capitalLetters.setSelected(false);
				//pan.lowerCaseOption.setSelected(false);
				//pan.symbols.setSelected(false);

				//pass.setPasswordLength(pan.passwordLength.getItemAt(pan.passwordLength.getSelectedIndex()));
				pass.setPasswordLength(pan.getBoxLength());

				if (pan.isCapitalLetterSelected() == true) {
					pass.setCapitals(true);
				} else
					pass.setCapitals(false);

				if (pan.isSymbolsSelected()== true) {
					pass.setSymbols((true));
				} else
					pass.setSymbols(false);
				
				if(pan.islowerCaseLetterSelected() == true){
					pass.setLower(true);
				}
				else pass.setLower(false);
	//			pass.setSymbols(pan.symbols.isSelected());

				pass.generatePlaceholders();
				pass.convertToPassword();
				StringBuilder t = pass.getFinalPassword();
				String s = String.valueOf(t);

				in.output.setText(s);
			

			}
		});

		// Window Listeners
		// addWindowListener(new WindowAdapter() {
		// public void windowClosing(WindowEvent e) {
		// System.exit(0);
		// }
		// } );

	}
}// windowClosing
