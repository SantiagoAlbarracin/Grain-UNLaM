package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnTextGrain = new JButton("Texto");
		btnTextGrain.setBounds(57, 99, 89, 23);
		frame.getContentPane().add(btnTextGrain);
		
		JButton btnImage = new JButton("Imagen");
		btnImage.setBounds(294, 99, 89, 23);
		frame.getContentPane().add(btnImage);
	}
}
