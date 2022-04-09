import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;


public class BagOfWords {

	public static void boots() throws FileNotFoundException {
		LinkedList<String> BootsProducts = new LinkedList<String>();  
		LinkedList<String> BootsProducts2 = new LinkedList<String>();  


		Scanner scanner = new Scanner(new File("C:/Users/Liam/Downloads/MB Compare/Boots.csv"));
		String text = scanner.useDelimiter("\\A").next();
		String cs1 = text.replaceAll("-", " ");
		String[] cs2 = cs1.split("\\n");

		for(int i =0; i < cs2.length; i++) {
			String[] temp = cs2[i].split(",");
			BootsProducts.add(temp[1]);
		}	

		for(int i =0; i < BootsProducts.size(); i++) {
			String[] temp = BootsProducts.get(i).split(" ");
			for (int j = 0; j < temp.length; j++) {
				BootsProducts2.add(temp[j]);
			}
		}

		Map<String, Integer> hm = new HashMap<String, Integer>(); 

		for (String i : BootsProducts2) { 
			Integer j = hm.get(i); 
			hm.put(i, (j == null) ? 1 : j + 1); 
		} 

		// displaying the occurrence of elements in the arraylist 
		for (Map.Entry<String, Integer> val : hm.entrySet()) { 
			System.out.println(val.getKey() + "," + val.getValue()); 
		} 
		
		scanner.close();
	}

	public static void medipharm() throws FileNotFoundException {

		LinkedList<String> MedipharmProducts = new LinkedList<String>(); 
		LinkedList<String> MedipharmProducts2 = new LinkedList<String>();  

		Scanner scanner2 = new Scanner(new File("C:/Users/Liam/Downloads/MB Compare/Medipharm.csv"));
		String text2 = scanner2.useDelimiter("\\A").next();
		String cs3 = text2.replaceAll("-", " ");
		String[] cs4 = cs3.split("\\n");

		for(int i =0; i < cs4.length; i++) {
			String[] temp = cs4[i].split(",");
			MedipharmProducts.add(temp[0]);
		}

		for(int i =0; i < cs4.length; i++) {
			String[] temp = MedipharmProducts.get(i).split(" ");
			for (int j = 0; j < temp.length; j++) {
				MedipharmProducts2.add(temp[j]);
			}
		}

		Map<String, Integer> hm2 = new HashMap<String, Integer>(); 

		for (String i : MedipharmProducts2) { 
			Integer j = hm2.get(i); 
			hm2.put(i, (j == null) ? 1 : j + 1); 
		} 

		// displaying the occurrence of elements in the arraylist 
		for (Map.Entry<String, Integer> val : hm2.entrySet()) { 
			System.out.println(val.getKey() + "," + val.getValue()); 
		} 
		scanner2.close();
	} 
}

