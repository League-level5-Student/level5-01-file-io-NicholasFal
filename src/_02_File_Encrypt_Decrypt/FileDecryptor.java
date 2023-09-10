package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/encryptor.txt");
			int read = fr.read();
			String file = "";
			while(read != -1) {
				file+= (char) read;
				read = fr.read();
			}
			Scanner key = new Scanner(System.in);
			System.out.println("Enter the same shifting key:");
			String keyI = key.nextLine();
			JOptionPane.showMessageDialog(null, decryptor(file, Integer.parseInt(keyI)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String decryptor(String str, int key) {
		String newStr = "";
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				newStr+=" ";
			} else if((str.charAt(i)) <= 96+key) {
				newStr += (char) (str.charAt(i) + 26 - key);
				System.out.println("L0L");
			} else {
				newStr += (char) (str.charAt(i) - key);
			}
		}
		return newStr;
		
	}
}
//Copyright © 2019 Nicholas Falstad