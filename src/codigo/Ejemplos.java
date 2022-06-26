package codigo;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Ejemplos {

	public static void main(String[] args) {
		
		try {
			
			//Ejemplo 1 de textos en los que esta todo OK
			
			/*
			String clave = "california";
			String semilla = "absolute";
			String mensaje = "Hola UNLaM! :D";
			GrainText grain = new GrainText(clave, semilla);
			String criptograma = grain.encrypt(mensaje);
			System.out.println(criptograma);
			String descifrado = grain.decrypt(criptograma);
			System.out.println(descifrado);
			*/
			
			
			
			
			
			//Ejemplo 2 de textos en los cuales se modifica el criptograma
			
			/*
			String clave = "california";
			String semilla = "absolute";
			String mensaje = "Hola UNLaM! :D";
			GrainText grain = new GrainText(clave, semilla);
			String criptograma = grain.encrypt(mensaje);
			System.out.println(criptograma);
			criptograma = criptograma.replace("11110", "00001");
			System.out.println(criptograma);
			String descifrado = grain.decrypt(criptograma);
			System.out.println(descifrado);
			*/
			
			
			
			
			
			//Ejemplo 3 de textos en los cuales cambia la clave
			
			
			String clave = "california";
			String semilla = "absolute";
			String mensaje = "Hola UNLaM! :D";
			GrainText grain = new GrainText(clave, semilla);
			String criptograma = grain.encrypt(mensaje);
			System.out.println(criptograma);
			String clave2 = "california";
			String semilla2 = "ahsaluta";
			GrainText grain2 = new GrainText(clave2, semilla2);
			String descifrado = grain2.decrypt(criptograma);
			System.out.println(descifrado);
			
			
			
			
			
			
			//Ejemplo 1 de imagenes en el que se cifra y esta todo OK
			
			/*
			byte[] clave = "california".getBytes();
			byte[] semilla = "absolute".getBytes();
			BufferedImage  imagenPlano =  ImageIO.read(new File("ejemplo1/imagen.bmp"));
			byte[] imagenByteArray = ImageConverter.imageToByteArray(imagenPlano);
			GrainImages grain = new GrainImages(clave, semilla, imagenByteArray);
			BufferedImage imagenCifrada = ImageConverter.byteArrayToImage(grain.convert());
			ImageIO.write(imagenCifrada, "bmp", new File("ejemplo1/cifrado.bmp"));
			*/
			
			
			//Ejemplo 1 de imagenes en el que se descifra y esta todo OK

			
			/*
			byte[] clave = "california".getBytes();
			byte[] semilla = "absolute".getBytes();
			BufferedImage  imagenPlano =  ImageIO.read(new File("ejemplo1/cifrado.bmp"));
			byte[] imagenByteArray = ImageConverter.imageToByteArray(imagenPlano);
			GrainImages grain = new GrainImages(clave, semilla, imagenByteArray);
			BufferedImage imagenCifrada = ImageConverter.byteArrayToImage(grain.convert());
			ImageIO.write(imagenCifrada, "bmp", new File("ejemplo1/decifrado.bmp"));
			*/
			
			
			
			
			
			
			
			//Ejemplo 2 de imagenes en el que se cifra y cambia la clave

			
			/*
			byte[] clave = "california".getBytes();
			byte[] semilla = "absolute".getBytes();
			BufferedImage  imagenPlano =  ImageIO.read(new File("ejemplo2/imagen.bmp"));
			byte[] imagenByteArray = ImageConverter.imageToByteArray(imagenPlano);
			GrainImages grain = new GrainImages(clave, semilla, imagenByteArray);
			BufferedImage imagenCifrada = ImageConverter.byteArrayToImage(grain.convert());
			ImageIO.write(imagenCifrada, "bmp", new File("ejemplo2/cifrado.bmp"));
			*/
			
			
			//Ejemplo 2 de imagenes en el que se descifra y cambia la clave

			/*
			byte[] clave = "calinarnia".getBytes();
			byte[] semilla = "absolute".getBytes();
			BufferedImage  imagenPlano =  ImageIO.read(new File("ejemplo2/cifrado.bmp"));
			byte[] imagenByteArray = ImageConverter.imageToByteArray(imagenPlano);
			GrainImages grain = new GrainImages(clave, semilla, imagenByteArray);
			BufferedImage imagenCifrada = ImageConverter.byteArrayToImage(grain.convert());
			ImageIO.write(imagenCifrada, "bmp", new File("ejemplo2/descifrado.bmp"));
			*/
			
			
			
			
			
			
			//Ejemplo 3 de imagenes en el que se cifra y modifica el criptograma

			
			/*
			byte[] clave = "california".getBytes();
			byte[] semilla = "absolute".getBytes();
			BufferedImage  imagenPlano =  ImageIO.read(new File("ejemplo3/imagen.bmp"));
			byte[] imagenByteArray = ImageConverter.imageToByteArray(imagenPlano);
			GrainImages grain = new GrainImages(clave, semilla, imagenByteArray);
			BufferedImage imagenCifrada = ImageConverter.byteArrayToImage(grain.convert());
			ImageIO.write(imagenCifrada, "bmp", new File("ejemplo3/cifrado.bmp"));
			*/
			
			
			//Ejemplo 3 de imagenes en el que se descifra y modifica el criptograma
			
			/*
			byte[] clave = "california".getBytes();
			byte[] semilla = "absolute".getBytes();
			BufferedImage  imagenPlano =  ImageIO.read(new File("ejemplo3/cifrado.bmp"));
			byte[] imagenByteArray = ImageConverter.imageToByteArray(imagenPlano);
			GrainImages grain = new GrainImages(clave, semilla, imagenByteArray);
			BufferedImage imagenCifrada = ImageConverter.byteArrayToImage(grain.convert());
			ImageIO.write(imagenCifrada, "bmp", new File("ejemplo3/descifrado.bmp"));
			*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
