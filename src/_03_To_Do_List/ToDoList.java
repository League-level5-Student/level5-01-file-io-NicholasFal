package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener{
	  /*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	JFrame frame = new JFrame("To Do List");
		JPanel panel;
		JButton add;
		JButton view;
		JButton remove;
		JButton save;
		JButton load;
		ArrayList<String> list;
	public static void main(String[] args) {
		new ToDoList().test();
	}
	public void test() {
		list = new ArrayList<String>();
		panel = new JPanel();
		add = new JButton();
		view = new JButton();
		remove = new JButton();
		save = new JButton();
		load = new JButton();
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		add.setText("Add Task");
		add.addActionListener(this);
		view.setText("View Tasks");
		view.addActionListener(this);
		remove.setText("Remove Task");
		remove.addActionListener(this);
		save.setText("Save List");
		save.addActionListener(this);
		load.setText("Load List");
		load.addActionListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		String loadedFile = "";
		try {
			FileReader fr = new FileReader("src/_03_To_Do_List/list.txt");
			int c = fr.read();
			while(c != -1) {
				loadedFile+=((char) c);
				c = fr.read();
			}
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		String[] splits = loadedFile.split(", ");
		for(int i = 0; i < splits.length; i++) {
			list.add(splits[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == add) {
			String task = JOptionPane.showInputDialog("Enter a task:");
			list.add(task);
		} else if(arg0.getSource() == view) {
			String str = "";
			for(String task : list) {
				str+=task;
				str+=", ";
			}
			JOptionPane.showMessageDialog(null, str);
		} else if(arg0.getSource() == remove) {
			String task = JOptionPane.showInputDialog("Enter a task to remove:");
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).equalsIgnoreCase(task)) {
					list.remove(i);
				}
			}
		} else if(arg0.getSource() == save) {
			String str = "";
			for(String task : list) {
				str+=task;
				str+=", ";
			}
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/list.txt", true);
				fw.write(str);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if(arg0.getSource() == load) {
			String location = JOptionPane.showInputDialog("Location of File: ");
			String loadedFile = "";
			try {
				FileReader fr = new FileReader(location);
				int c = fr.read();
				while(c != -1) {
					loadedFile+=((char) c);
					c = fr.read();
				}
				fr.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "The file has loaded: " + loadedFile);
		}
	}
}
