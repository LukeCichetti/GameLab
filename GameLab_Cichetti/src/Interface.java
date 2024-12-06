import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame implements ActionListener {

	public JTextArea gameTextArea;
	private JTextField UserInputField;
	private JButton submitButton;
	private JLabel directions;
	private JPanel borderLayoutSouth;

	
	public Interface() {
		buildWindow();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String s = UserInputField.getText();
		Game.processCommand(s);
		JButton j = (JButton) event.getSource();

	}

	private void buildWindow() {
		setTitle("Echos of the Cell");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameTextArea = new JTextArea();
		gameTextArea.setFont(new Font(null, Font.BOLD, 16));
		
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		
		directions = new JLabel("What would you like to do?");
		UserInputField = new JTextField();
		
		borderLayoutSouth = new JPanel();
		borderLayoutSouth.setLayout(new GridLayout(3, 1));
		borderLayoutSouth.add(submitButton);
		borderLayoutSouth.add(directions);
		borderLayoutSouth.add(UserInputField);
		
		
		add(gameTextArea, BorderLayout.CENTER);
		add(borderLayoutSouth, BorderLayout.SOUTH);
		
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
