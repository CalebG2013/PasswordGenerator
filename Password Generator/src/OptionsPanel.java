

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

//Panel that adds options to the form
public class OptionsPanel extends JPanel{

	JPanel panel;

	//comboBox to change the length of the password
	private int[] passLength = { 5,6,7,8,9,10,11,12,13};
	private JComboBox<Integer> passwordLength = new JComboBox<Integer>();

	//checkboxes to include letters and symbols
	private JCheckBox capitalLetters;
	private JCheckBox symbols;
	private JCheckBox lowerCaseOption;


	//Labels for the password options
	private JLabel lengthOption;
	private JLabel capitalOption;
	private JLabel symbolsOption;
	private JLabel lowerCaseLetters;

	public void setSelectedLength(int i){
		passwordLength.setSelectedItem(i);
	}

	public int getBoxLength(){

		return passwordLength.getItemAt(passwordLength.getSelectedIndex());
	}



	public boolean isCapitalLetterSelected(){
		if(capitalLetters.isSelected()){
			return true;}
		else 
			return false;
	}

	public boolean isSymbolsSelected(){
		if(symbols.isSelected()){
			return true;}
		else
			return false;
	}


	public boolean islowerCaseLetterSelected(){
		if(lowerCaseOption.isSelected()){
			return true;}
		else 
			return false;
	}






	OptionsPanel(){
		lengthOption = new JLabel("Length of Password: ");
		capitalOption = new JLabel("Include Capital Letters?: ");
		symbolsOption = new JLabel("Include Symbols?: ");
		lowerCaseLetters = new JLabel("Include lowercase letters?: ");

		capitalLetters = new JCheckBox();
		symbols  = new JCheckBox();
		lowerCaseOption  = new JCheckBox();


		for(int i : passLength){
			passwordLength.addItem(i);
		}




		GridLayout layout = new GridLayout(4,4,5,3);
		//sets panel to have a grid layout
		setLayout(layout);

		add(lengthOption);
		add(passwordLength);

		passwordLength.setMaximumSize(new Dimension(50,50));
		passwordLength.setPreferredSize(new Dimension(50,50));

		add(capitalOption);
		add(capitalLetters);


		add(symbolsOption);
		add(symbols);

		add(lowerCaseLetters);
		add(lowerCaseOption);







	}












}
