package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator implements ActionListener {
	double input, result;
	char cal;

	JFrame frame;
	JLabel label = new JLabel();
	JTextField textView = new JTextField("");

	JButton symClr = new JButton("CLR");
	JButton symDel = new JButton("DEL");
	JButton symMul = new JButton("*");
	JButton symDiv = new JButton("/");

	JButton num7 = new JButton("7");
	JButton num8 = new JButton("8");
	JButton num9 = new JButton("9");
	JButton symMinus = new JButton("-");

	JButton num4 = new JButton("4");
	JButton num5 = new JButton("5");
	JButton num6 = new JButton("6");
	JButton symAdd = new JButton("+");

	JButton num1 = new JButton("1");
	JButton num2 = new JButton("2");
	JButton num3 = new JButton("3");
	JButton symEq = new JButton("=");

	JButton num0 = new JButton("0");
	JButton symDot = new JButton(".");

	public Calculator() {
		CreateInterface();
		InterfaceComponents();
		AddInterfaceEventListener();
	}

	private void AddInterfaceEventListener() {
		// TODO Auto-generated method stub
		symClr.addActionListener(this);
		symDel.addActionListener(this);
		symDiv.addActionListener(this);
		symMul.addActionListener(this);

		num7.addActionListener(this);
		num8.addActionListener(this);
		num9.addActionListener(this);
		symMinus.addActionListener(this);

		num4.addActionListener(this);
		num5.addActionListener(this);
		num6.addActionListener(this);
		symAdd.addActionListener(this);

		num1.addActionListener(this);
		num2.addActionListener(this);
		num3.addActionListener(this);
		symEq.addActionListener(this);

		num0.addActionListener(this);
		symDot.addActionListener(this);

	}

	private void InterfaceComponents() {
		// TODO Auto-generated method stub
		label.setBounds(10, 0, 280, 50);

		textView.setBounds(10, 40, 270, 60);
		textView.setEditable(false);
		textView.setBackground(new Color(250, 250, 250));
		textView.setHorizontalAlignment(SwingConstants.RIGHT);

		symClr.setBounds(10, 110, 60, 40);
		symDel.setBounds(80, 110, 60, 40);
		symMul.setBounds(150, 110, 60, 40);
		symDiv.setBounds(220, 110, 60, 40);

		num7.setBounds(10, 160, 60, 40);
		num8.setBounds(80, 160, 60, 40);
		num9.setBounds(150, 160, 60, 40);
		symMinus.setBounds(220, 160, 60, 40);

		num4.setBounds(10, 210, 60, 40);
		num5.setBounds(80, 210, 60, 40);
		num6.setBounds(150, 210, 60, 40);
		symAdd.setBounds(220, 210, 60, 40);

		num1.setBounds(10, 260, 60, 40);
		num2.setBounds(80, 260, 60, 40);
		num3.setBounds(150, 260, 60, 40);
		symEq.setBounds(220, 260, 60, 90);

		num0.setBounds(10, 310, 130, 40);
		symDot.setBounds(150, 310, 60, 40);

		frame.add(label);
		frame.add(textView);
		frame.add(symClr);
		frame.add(symDel);
		frame.add(symMul);
		frame.add(symDiv);
		frame.add(num7);
		frame.add(num8);
		frame.add(num9);
		frame.add(symMinus);
		frame.add(num4);
		frame.add(num5);
		frame.add(num6);
		frame.add(symAdd);
		frame.add(num1);
		frame.add(num2);
		frame.add(num3);
		frame.add(symEq);
		frame.add(num0);
		frame.add(symDot);

	}

	private void CreateInterface() {
		// TODO Auto-generated method stub
		frame = new JFrame();
		frame.setTitle("Kallu Collector");
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.multi.MultiLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setSize(305, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton obj = (JButton) e.getSource();
		if (obj == symClr) {
			textView.setText("");
			label.setText("");
		} else if (obj == symDel) {
			if (!textView.getText().equals(""))
				textView.setText(textView.getText().substring(0, textView.getText().length() - 1));
			else
				label.setText("");

		} else if (obj == symMul) {

			if (!textView.getText().equals(""))
				input = Double.parseDouble(textView.getText());
			textView.setText("");
			if (label.getText().equals("")) {
				result = 1;
			}
			result *= input;
			label.setText(result + " * ");
			cal = '*';
		} else if (obj == symDiv) {

			if (!textView.getText().equals(""))
				input = Double.parseDouble(textView.getText());
			textView.setText("");
			if (label.getText().equals("")) {
				result = 1;
			}
			result /= input;
			label.setText(result + " / ");
			cal = '/';
		} else if (obj == symMinus) {

			if (!textView.getText().equals(""))
				input = Double.parseDouble(textView.getText());
			textView.setText("");
			if (label.getText().equals("")) {
				result = input;
			} else
				result -= input;
			label.setText(result + " - ");
			cal = '-';
		} else if (obj == symAdd) {
			if (!textView.getText().equals(""))
				input = Double.parseDouble(textView.getText());
			textView.setText("");
			if (label.getText().equals("")) {
				result = input;
			} else
				result += input;
			label.setText(result + " + ");
			cal = '+';
		} else if (obj == symEq) {
			if (!textView.getText().equals(""))
				input = Double.parseDouble(textView.getText());
			textView.setText("");
			if (label.getText().equals(""))
				result = input;
			else {
				switch (cal) {
				case '+':
					result += input;
					break;
				case '-':
					result -= input;
					break;
				case '*':
					result *= input;
					break;
				case '/':
					result /= input;
					break;
				}
			}
			label.setText(result + "");
		} else if (obj == symDot) {
			if (textView.getText().contains("."))
				return;
			if ((textView.getText().equals("0") || textView.getText().equals("")))
				textView.setText("0.");
			else
				textView.setText(textView.getText() + obj.getText());
		} else {
			if ((textView.getText().equals("0") || textView.getText().equals("")) && obj.getText().equals("0"))
				textView.setText("");
			else
				textView.setText(textView.getText() + obj.getText());
		}
	}

	public static void main(String[] args) {
		new Calculator();
	}

}
