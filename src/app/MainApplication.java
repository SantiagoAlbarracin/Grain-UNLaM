package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainApplication {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplication window = new MainApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnTextGrain = new JButton("<html>Implementación<br/>en Texto</html>");
		btnTextGrain.setBounds(10, 67, 136, 183);
		frame.getContentPane().add(btnTextGrain);
		btnTextGrain.addActionListener(e -> openText());
		
		JButton btnImage = new JButton("<html>Implementación<br/>en Imágenes</html>");
		btnImage.setBounds(288, 67, 136, 183);
		frame.getContentPane().add(btnImage);
		
		JLabel lblNewLabel = new JLabel("Cifrado Grain");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 45);
		frame.getContentPane().add(lblNewLabel);
		btnImage.addActionListener(e -> openImage());
	}
	
	private void openText() {
		TextImplementation.main(null);
		frame.dispose();
	}
	
	private void openImage() {
		ImageImplementation.main(null);
		frame.dispose();
	}
}
