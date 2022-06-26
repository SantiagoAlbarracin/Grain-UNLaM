package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

import codigo.GrainImages;
import codigo.ImageConverter;
import java.awt.Font;

public class ImageImplementation {

	private JFrame frame;
	private BufferedImage originImage;
	private BufferedImage encodedImage;
	private BufferedImage decodedImage;
	private JTextField tfKey;
	private JTextField tfSeed;
	
	private ImagePanel originPanel;
	private ImagePanel encodedPanel;
	private ImagePanel decodedPanel;
	
	private JButton btnReturn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageImplementation window = new ImageImplementation();
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
	public ImageImplementation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 860, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblImagenOriginal = new JLabel("Imagen Original");
		lblImagenOriginal.setBounds(10, 11, 149, 14);
		frame.getContentPane().add(lblImagenOriginal);
		
		originPanel = new ImagePanel();
		originPanel.setBounds(10, 36, 200, 200);
		frame.getContentPane().add(originPanel);
		
		JButton btnUploadOriginImage = new JButton("Cargar Imagen");
		btnUploadOriginImage.setBounds(10, 252, 200, 23);
		frame.getContentPane().add(btnUploadOriginImage);
		
		JLabel lblImagenCodificada = new JLabel("Imagen Codificada");
		lblImagenCodificada.setBounds(324, 11, 149, 14);
		frame.getContentPane().add(lblImagenCodificada);
		
		encodedPanel = new ImagePanel();
		encodedPanel.setBounds(324, 36, 200, 200);
		frame.getContentPane().add(encodedPanel);
		
		JButton btnUploadEncodedImage = new JButton("Cargar Imagen");
		btnUploadEncodedImage.setBounds(324, 252, 200, 23);
		frame.getContentPane().add(btnUploadEncodedImage);
		
		JLabel lblImagenDecodificada = new JLabel("Imagen Decodificada");
		lblImagenDecodificada.setBounds(634, 11, 149, 14);
		frame.getContentPane().add(lblImagenDecodificada);
		
		decodedPanel = new ImagePanel();
		decodedPanel.setBounds(634, 36, 200, 200);
		frame.getContentPane().add(decodedPanel);
		
		JLabel lblLlave = new JLabel("Llave");
		lblLlave.setBounds(10, 348, 161, 14);
		frame.getContentPane().add(lblLlave);
		
		JLabel lblSemilla = new JLabel("Semilla");
		lblSemilla.setBounds(263, 348, 161, 14);
		frame.getContentPane().add(lblSemilla);
		
		tfKey = new JTextField();
		tfKey.setText("california");
		tfKey.setColumns(10);
		tfKey.setBounds(10, 373, 161, 20);
		frame.getContentPane().add(tfKey);
		tfKey.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        if (tfKey.getText().length() >= 10 )
		            e.consume(); 
		    }
		});
		
		tfSeed = new JTextField();
		tfSeed.setText("absolute");
		tfSeed.setColumns(10);
		tfSeed.setBounds(263, 373, 161, 20);
		frame.getContentPane().add(tfSeed);
		tfSeed.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        if (tfSeed.getText().length() >= 8 )
		            e.consume(); 
		    }
		});
		
		JButton btnEncodeImage = new JButton("Codificar");
		btnEncodeImage.setBounds(221, 34, 89, 209);
		frame.getContentPane().add(btnEncodeImage);
		
		JButton btnDecodeImage = new JButton("Decodificar");
		btnDecodeImage.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDecodeImage.setBounds(536, 34, 89, 209);
		frame.getContentPane().add(btnDecodeImage);
		
		btnReturn = new JButton("Volver");
		btnReturn.setBounds(745, 372, 89, 23);
		frame.getContentPane().add(btnReturn);
		
		btnUploadOriginImage.addActionListener(e -> uploadOriginImage());
		btnUploadEncodedImage.addActionListener(e -> uploadEncodedImage());
		btnEncodeImage.addActionListener(e -> encodeImage());
		btnDecodeImage.addActionListener(e -> decodeImage());
		btnReturn.addActionListener(e -> openMenu());
	}
	
	private void openMenu() {
		MainApplication.main(null);
		frame.dispose();
	}
	
	public class ImagePanel extends JPanel {
	    public BufferedImage image;
	    public ImagePanel() {
	       try {                
	          image = ImageIO.read(new File("C:\\Users\\facut\\Documents\\GitHub\\Grain-UNLaM\\images\\noImage.png"));
	       } catch (IOException ex) {
	            // handle exception...
	       }
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, 200, 200, null);        
	    }
	}
	
	private void uploadOriginImage() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("C:\\Users\\facut\\Documents\\GitHub\\Grain-UNLaM\\images"));
		int result = fileChooser.showOpenDialog(frame);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    try {
		    	this.originImage = ImageIO.read(selectedFile);
				originPanel.image = this.originImage;
				originPanel.repaint();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void uploadEncodedImage() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("C:\\Users\\facut\\Documents\\GitHub\\Grain-UNLaM\\images"));
		int result = fileChooser.showOpenDialog(frame);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    try {
		    	this.encodedImage = ImageIO.read(selectedFile);
				encodedPanel.image = this.encodedImage;
				encodedPanel.repaint();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void encodeImage() {
		String clave = tfKey.getText();
		String semilla = tfSeed.getText();
		if (clave.length() < 10) {
			JOptionPane.showMessageDialog(frame,
					"La clave tiene que ser igual a 10 caracteres",
				    "NO SE PUEDE REALIZAR ESTA ACCION",
				    JOptionPane.WARNING_MESSAGE);
			return;
		}
			
		if (semilla.length() < 8) {
			JOptionPane.showMessageDialog(frame,
				    "La semilla tiene que ser igual a 8 caracteres",
				    "NO SE PUEDE REALIZAR ESTA ACCION",
				    JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if (originImage == null) {
			JOptionPane.showMessageDialog(frame,
				    "La imagen de origen no puede estar vacia",
				    "NO SE PUEDE REALIZAR ESTA ACCION",
				    JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		GrainImages grain;
		try {
			byte[] imagenByteArray = ImageConverter.imageToByteArray(originImage);
			grain = new GrainImages(clave.getBytes(), semilla.getBytes(), imagenByteArray);
			BufferedImage imagenCifrada = ImageConverter.byteArrayToImage(grain.convert());
			ImageIO.write(imagenCifrada, "bmp", new File("images/imagenCifrada.bmp"));
			this.encodedImage = imagenCifrada;
			encodedPanel.image = this.encodedImage;
			encodedPanel.repaint();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void decodeImage() {
		String clave = tfKey.getText();
		String semilla = tfSeed.getText();
		if (clave.length() < 10) {
			JOptionPane.showMessageDialog(frame,
					"La clave tiene que ser igual a 10 caracteres",
				    "NO SE PUEDE REALIZAR ESTA ACCION",
				    JOptionPane.WARNING_MESSAGE);
			return;
		}
			
		if (semilla.length() < 8) {
			JOptionPane.showMessageDialog(frame,
				    "La semilla tiene que ser igual a 8 caracteres",
				    "NO SE PUEDE REALIZAR ESTA ACCION",
				    JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if (originImage == null) {
			JOptionPane.showMessageDialog(frame,
				    "La imagen codificada no puede estar vacia",
				    "NO SE PUEDE REALIZAR ESTA ACCION",
				    JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		GrainImages grain;
		try {
			byte[] imagenByteArray = ImageConverter.imageToByteArray(encodedImage);
			grain = new GrainImages(clave.getBytes(), semilla.getBytes(), imagenByteArray);
			BufferedImage imagenDescifrada = ImageConverter.byteArrayToImage(grain.convert());
			ImageIO.write(imagenDescifrada, "bmp", new File("images/imagenDescifrada.bmp"));
			this.decodedImage = imagenDescifrada;
			decodedPanel.image = this.decodedImage;
			decodedPanel.repaint();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
