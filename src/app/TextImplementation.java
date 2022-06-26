package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import codigo.GrainText;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class TextImplementation {

	private JFrame frame;
	private JTextField tfOriginText;
	private JTextField tfEncodedText;
	private JTextField tfDecodedText;
	private JTextField tfKey;
	private JTextField tfSeed;
	
	private JButton btnEncode;
	private JButton btnDecode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextImplementation window = new TextImplementation();
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
	public TextImplementation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tfOriginText = new JTextField();
		tfOriginText.setBounds(71, 34, 289, 20);
		frame.getContentPane().add(tfOriginText);
		tfOriginText.setColumns(10);
		
		tfOriginText.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (tfOriginText.getText().length() >= 20 )
		            e.consume(); 
		    }  
		});
		
		JLabel lblTextoOriginal = new JLabel("Texto Original");
		lblTextoOriginal.setBounds(71, 9, 289, 14);
		frame.getContentPane().add(lblTextoOriginal);
		
		JLabel lblTextoCodificado = new JLabel("Texto Codificado");
		lblTextoCodificado.setBounds(71, 106, 289, 14);
		frame.getContentPane().add(lblTextoCodificado);
		
		tfEncodedText = new JTextField();
		tfEncodedText.setColumns(10);
		tfEncodedText.setBounds(71, 131, 289, 20);
		frame.getContentPane().add(tfEncodedText);
		
		tfEncodedText.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (tfEncodedText.getText().length() >= 160 )
		            e.consume(); 
		    }  
		});
		
		btnEncode = new JButton("Codificar");
		btnEncode.setBounds(127, 72, 175, 23);
		frame.getContentPane().add(btnEncode);
		
		btnDecode = new JButton("Decodificar");
		btnDecode.setBounds(127, 187, 175, 23);
		frame.getContentPane().add(btnDecode);
		
		JLabel lblTextoDecodificado = new JLabel("Texto Decodificado");
		lblTextoDecodificado.setBounds(71, 221, 289, 14);
		frame.getContentPane().add(lblTextoDecodificado);
		
		tfDecodedText = new JTextField();
		tfDecodedText.setColumns(10);
		tfDecodedText.setBounds(71, 246, 289, 20);
		frame.getContentPane().add(tfDecodedText);
		
		tfKey = new JTextField();
		tfKey.setBounds(10, 364, 161, 20);
		frame.getContentPane().add(tfKey);
		tfKey.setColumns(10);
		
		JLabel lblLlave = new JLabel("Llave");
		lblLlave.setBounds(10, 339, 161, 14);
		frame.getContentPane().add(lblLlave);
		
		tfKey.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (tfKey.getText().length() >= 10 )
		            e.consume(); 
		    }  
		});
		
		JLabel lblSemilla = new JLabel("Semilla");
		lblSemilla.setBounds(263, 339, 161, 14);
		frame.getContentPane().add(lblSemilla);
		
		
		
		tfSeed = new JTextField();
		tfSeed.setColumns(10);
		tfSeed.setBounds(263, 364, 161, 20);
		frame.getContentPane().add(tfSeed);
		
		tfSeed.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (tfSeed.getText().length() >= 8 )
		            e.consume(); 
		    }  
		});
		
		tfKey.setText("california");
		tfSeed.setText("absolute");
		
		initializeButtons();
	}

	private void initializeButtons() {
		btnEncode.addActionListener(e -> encode());
		btnDecode.addActionListener(e -> decode());
	}

	private Object encode() {
		String clave = tfKey.getText();
		String semilla = tfSeed.getText();
		if (clave.length() < 10) {
			JOptionPane.showMessageDialog(frame,
					"La clave tiene que ser igual a 10 caracteres",
				    "NO SE PUEDE REALIZAR ESTA ACCION",
				    JOptionPane.WARNING_MESSAGE);
			return null;
		}
			
		if (semilla.length() < 8) {
			JOptionPane.showMessageDialog(frame,
				    "La semilla tiene que ser igual a 8 caracteres",
				    "NO SE PUEDE REALIZAR ESTA ACCION",
				    JOptionPane.WARNING_MESSAGE);
			return null;
		}
		
		String mensaje = tfOriginText.getText();
		if (mensaje != null && !mensaje.isEmpty()) {
			GrainText grain = new GrainText(clave, semilla);
			String criptograma = grain.encrypt(mensaje);
			tfEncodedText.setText(criptograma);
		}
		
		return null;
	}
	
	private Object decode() {
		String clave = tfKey.getText();
		String semilla = tfSeed.getText();
		if (clave.length() < 10) {
			JOptionPane.showMessageDialog(frame,
					"La clave tiene que ser igual a 10 caracteres",
				    "NO SE PUEDE REALIZAR ESTA ACCION",
				    JOptionPane.WARNING_MESSAGE);
			return null;
		}
			
		if (semilla.length() < 8) {
			JOptionPane.showMessageDialog(frame,
				    "La semilla tiene que ser igual a 8 caracteres",
				    "NO SE PUEDE REALIZAR ESTA ACCION",
				    JOptionPane.WARNING_MESSAGE);
			return null;
		}
		
		String criptograma = tfEncodedText.getText();
		if (criptograma != null && !criptograma.isEmpty()) {
			GrainText grain = new GrainText(clave, semilla);
			String descifrado = grain.decrypt(criptograma);
			tfDecodedText.setText(descifrado);
		}
		
		return null;
	}
}
