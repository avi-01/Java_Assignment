package stringOperator;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StringOperator implements ActionListener{

	public static StringOperator mainLayout;
	
	private Frame mainFrame;
	
	private Panel inputPanel;
	private TextField firstInput;
	private TextField secondInput;

	private Panel operationPanel;
	private Button charButton;
	private Button lowerButton;
	private Button upperButton;
	private Button reverseButton;
	private Button firstIndexButton;
	private Button lastIndexButton;
	private Button repeatButton;
	private Button concatButton;
	private Button fromButton;
	private Button beforeButton;
	private Button clearButton;
	
	private Panel resultPanel;
	private Label resultLabel;

	
	public static void main(String[] args) {
		mainLayout = new StringOperator();
	}
	
	
	StringOperator() {
		mainFrame = new Frame();
		mainFrame.setLayout(new FlowLayout());
		mainFrame.setBounds(300,300,320,400);
		mainFrame.setVisible(true);
		mainFrame.setBackground(Color.getHSBColor(56, 146, 194));
		
		Panel mainPanel = setMainPanel();

		inputPanel = initializeInputPanel();
		operationPanel = initializeOperationPanel();
		resultPanel = initializeResultPanel();
		
		mainPanel.add(inputPanel);
		mainPanel.add(operationPanel);
		mainPanel.add(resultPanel);
		
		mainFrame.add(mainPanel);
	}
	
	

	private Panel setMainPanel() {
		
		Panel panel = new Panel();
		GridLayout gridLayout = new GridLayout(3,1,20,20);

		panel.setLayout(gridLayout);
		panel.setVisible(true);
		
		return panel;
	}
	
	private Panel initializeInputPanel() {
		
		Panel panel = new Panel();
		
		Font inputFont = new Font("Serif", Font.PLAIN, 18);
		
		firstInput = new TextField(10);
		firstInput.setFont(inputFont);
		
		secondInput = new TextField(10);
		secondInput.setFont(inputFont);

		GridLayout gridLayout = new GridLayout(2,1,5,5);
		
		panel.add(firstInput);
		panel.add(secondInput);
		
		panel.setLayout(gridLayout);
		panel.setVisible(true);
		
		return panel;
	}
	

	private Panel initializeResultPanel() {
		
		Panel panel = new Panel();
		Font outputFont = new Font("Arial", Font.PLAIN, 20);
		
		resultLabel = new Label("Result: "); 
		resultLabel.setBackground(Color.white);
		resultLabel.setPreferredSize(new Dimension(250,50));
		resultLabel.setFont(outputFont);
		resultLabel.setAlignment(1);
		
					
		
		panel.add(resultLabel);

		panel.setSize(300,100);
		panel.setVisible(true);
		
		return panel;
	}


	private Panel initializeOperationPanel() {

		Panel panel = new Panel();
		
		GridLayout gridLayout = new GridLayout(4,3,10,10);
		
		
		lowerButton = new Button("toLower");
		lowerButton.addActionListener(this);
		
		upperButton = new Button("toUpper");
		upperButton.addActionListener(this);
		
		reverseButton = new Button("Reverse");
		reverseButton.addActionListener(this);
		
		charButton = new Button("CharAt");
		charButton.addActionListener(this);

		repeatButton = new Button("Repeat");
		repeatButton.addActionListener(this);
		
		firstIndexButton = new Button("First Index");
		firstIndexButton.addActionListener(this);
		
		lastIndexButton = new Button("Last Index");
		lastIndexButton.addActionListener(this);
		
		concatButton = new Button("Concat");
		concatButton.addActionListener(this);
		
		fromButton = new Button("From pos");
		fromButton.addActionListener(this);
		
		beforeButton = new Button("Before pos");
		beforeButton.addActionListener(this);
		
		clearButton = new Button("Clear");
		clearButton.addActionListener(this);
		
		
		panel.add(lowerButton);
		panel.add(upperButton);
		panel.add(charButton);
		panel.add(fromButton);
		panel.add(beforeButton);
		panel.add(repeatButton);
		panel.add(firstIndexButton);
		panel.add(lastIndexButton);
		panel.add(concatButton);
		panel.add(clearButton);

		panel.setLayout(gridLayout);
		panel.setSize(100,300);
		panel.setVisible(true);
		
		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		

		if (e.getSource() == clearButton) {
			firstInput.setText("");
			secondInput.setText("");
			resultLabel.setText("");
			return;
		}
		
		try {
			String firstVal =  firstInput.getText();
			String secondVal = secondInput.getText(); 
			
			String output = "";
			
			if (e.getSource() == lowerButton) {
				secondInput.setText("");
				output = firstVal.toLowerCase();
			}
			else if (e.getSource() == upperButton) {
				secondInput.setText("");
				output = firstVal.toUpperCase();
			}
			else if (e.getSource() == reverseButton) {
				secondInput.setText(""); 
				for (int i = 0; i<firstVal.length(); i++) 
		            output +=  firstVal.charAt(firstVal.length() - i - 1);
			}
			else if (e.getSource() == charButton) {
				int index = checkInt(secondVal);
				
				if(index < 0 || index >= firstVal.length()) {
					throw new Exception("Wrong Index");
				}
				
				output = ""+firstVal.charAt(index);
			}
			else if (e.getSource() == fromButton) {
				int index = checkInt(secondVal);
				
				if(index < 0 || index >= firstVal.length()) {
					throw new Exception("Wrong Index");
				}
				
				output = firstVal.substring(index);
			}
			else if (e.getSource() == beforeButton) {
				int index = checkInt(secondVal);
				
				if(index < 0 || index >= firstVal.length()) {
					throw new Exception("Wrong Index");
				}
				
				output = firstVal.substring(0, index);
			}
			else if (e.getSource() == repeatButton) {
				int val = checkInt(secondVal);
			
				output = firstVal.repeat(val);
			}
			else if (e.getSource() == firstIndexButton) {
				
				if(secondVal.length() != 1) {
					throw new Exception("Wrong character");
				}
				
				int index = firstVal.indexOf(secondVal.charAt(0));
				
				if(index == -1) {
					throw new Exception("Character not found");	
				}
				
				output = ""+index;
			}
			else if (e.getSource() == lastIndexButton) {
				
				if(secondVal.length() != 1) {
					throw new Exception("Wrong character");
				}
				
				int index = firstVal.lastIndexOf(secondVal.charAt(0));
				
				if(index == -1) {
					throw new Exception("Character not found");	
				}
				
				output = ""+index;
			}
			else if (e.getSource() == concatButton) {
				
				output = firstVal + secondVal;
			}
			
			
			resultLabel.setText(output);
			
		} catch (Exception error) {
			resultLabel.setText(error.getMessage());
			return;
		}
		
		
		
		
	}
	
	int checkInt(String secondVal) throws Exception {
		try {
			int index = Integer.parseInt(secondVal);
			
			return index;
		} catch(Exception e) {
			throw new Exception("Wrong Input");
		}
	}
	

}
