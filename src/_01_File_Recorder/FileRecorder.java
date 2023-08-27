package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a file name:");
		try {
		String fileName = scan.next();
		FileWriter fw = new FileWriter("src/_01_File_Recorder/moretext.txt", true);
		fw.write(fileName);
		fw.close();
		scan.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
