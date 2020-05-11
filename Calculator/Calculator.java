package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
	
	public static Calculator mainLayout;
	
	private Frame mainFrame;
	
	private Panel inputPanel;
	private TextField firstNumberInput;
	private TextField secondNumberInput;

	private Panel operationPanel;
	private Button addButton;
	private Button subButton;
	private Button mulButton;
	private Button divButton;
	private Button modButton;
	private Button powButton;
	private Button andButton;
	private Button orButton;
	private Button xorButton;
	private Button clearButton;
	private int operationCode = 0;

	private Panel resultPanel;
	private Label resultLabel;

	
	public static void main(String[] args) {
		mainLayout = new Calculator();
	}
	
	
	Calculator() {
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
		
		Font inputFont = new Font("Serif", Font.PLAIN, 20);
		
		firstNumberInput = new TextField(10);
		firstNumberInput.setPreferredSize(new Dimension(20,5));
		firstNumberInput.setFont(inputFont);
		
		secondNumberInput = new TextField(10);
		secondNumberInput.setPreferredSize(new Dimension(20,5));
		secondNumberInput.setFont(inputFont);

		GridLayout gridLayout = new GridLayout(1,2,5,5);
		
		panel.add(firstNumberInput);
		panel.add(secondNumberInput);
		
		panel.setLayout(gridLayout);
		panel.setVisible(true);
		
		return panel;
	}
	

	private Panel initializeResultPanel() {
		
		Panel panel = new Panel();
		
		resultLabel = new Label("Result: "); 
		resultLabel.setBackground(Color.white);
		resultLabel.setPreferredSize(new Dimension(200,50));
		resultLabel.setAlignment(1);
		
					
		
		panel.add(resultLabel);

		panel.setSize(300,100);
		panel.setVisible(true);
		
		return panel;
	}


	private Panel initializeOperationPanel() {

		Panel panel = new Panel();
		
		GridLayout gridLayout = new GridLayout(4,3,10,10);
		
		addButton = new Button("+");
		addButton.addActionListener(this);
		
		subButton = new Button("-");
		subButton.addActionListener(this);
		
		mulButton = new Button("*");
		mulButton.addActionListener(this);
		
		divButton = new Button("/");
		divButton.addActionListener(this);
		
		modButton = new Button("%");
		modButton.addActionListener(this);
		
		powButton = new Button("^");
		powButton.addActionListener(this);
		
		andButton = new Button("and");
		andButton.addActionListener(this);
		
		orButton = new Button("or");
		orButton.addActionListener(this);
		
		xorButton = new Button("xor");
		xorButton.addActionListener(this);
		
		clearButton = new Button("Clear");
		clearButton.addActionListener(this);
		
		
		panel.add(addButton);
		panel.add(subButton);
		panel.add(mulButton);
		panel.add(divButton);
		panel.add(modButton);
		panel.add(powButton);
		panel.add(andButton);
		panel.add(orButton);
		panel.add(xorButton);
		panel.add(clearButton);

		panel.setLayout(gridLayout);
		panel.setSize(100,300);
		panel.setVisible(true);
		
		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		

		if (e.getSource() == clearButton) {
			operationCode = 0;
			firstNumberInput.setText("");
			secondNumberInput.setText("");
			resultLabel.setText("");
			return;
		}
	
		
		String operationSymbol = (((Button)e.getSource()).getLabel());
		
		try {
			double firstNumber = Double.parseDouble(firstNumberInput.getText()); 
			double secondNumber = Double.parseDouble(secondNumberInput.getText()); 
			double result = 0;
			
			if (e.getSource() == addButton) {
				result = firstNumber + secondNumber;
			}
			else if (e.getSource() == subButton) {
				result = firstNumber - secondNumber;
			}
			else if (e.getSource() == mulButton) {
				result = firstNumber * secondNumber;
			}
			else if (e.getSource() == divButton) {
				result = firstNumber / secondNumber;
			}
			else if (e.getSource() == modButton) {
				result = firstNumber % secondNumber;
			}
			else if (e.getSource() == powButton) {
				result = (float) Math.pow(firstNumber,  secondNumber);
			}
			
			else {
				long intFirstNumber = (long)firstNumber;
				long intSecondNumber = (long)secondNumber;
				
				firstNumberInput.setText(""+intFirstNumber);
				secondNumberInput.setText(""+intSecondNumber);
				
				if (e.getSource() == andButton) {
					result = intFirstNumber & intSecondNumber;
				}
				else if (e.getSource() == orButton) {
					result = intFirstNumber | intSecondNumber;
				}
				else if (e.getSource() == xorButton) {
					result = intFirstNumber ^ intSecondNumber;
				}
			}
				
			long longResult = (long) result;
			
			String output = firstNumberInput.getText()+" "+operationSymbol+" "+secondNumberInput.getText()+" = ";
			
			if(longResult == result) 
				resultLabel.setText(output + longResult);
			else
				resultLabel.setText(output + result);
			
		} catch (Exception error) {
			resultLabel.setText("Wrong Input");
			return;
		}
		
		
		
		
	}

	
	
	
	
	
	
	
	
	

	
	
}
