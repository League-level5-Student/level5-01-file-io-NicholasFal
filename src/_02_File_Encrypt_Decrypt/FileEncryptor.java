package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String:");
		String normalText = scan.nextLine();
		Scanner scanTwo = new Scanner(System.in);
		System.out.println("Enter the shifting key:");
		Integer key = scan.nextInt();
		try {
		FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/encryptor.txt", true);
		fw.write(encryptor(normalText, key));
		fw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(encryptor(normalText, key));
		}
	public static String encryptor(String str, int key) {
		String newStr = "";
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				newStr+=" ";
			} else if( ((str.charAt(i) ) >= 123-key)  ) {
			newStr+= (char) (str.charAt(i) - 26 + key);
			} else {
				newStr+=(char) (str.charAt(i) + key);
			}
		}
		return newStr;
	}
}
//Copyright © 2019 Nicholas Falstad