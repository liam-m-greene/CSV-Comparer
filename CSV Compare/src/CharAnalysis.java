import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class CharAnalysis {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		int print = 0;

		LinkedList<String> BootsProducts = new LinkedList<String>();  

		Scanner scanner = new Scanner(new File("C:/Users/Liam/Downloads/MB Compare/Boots Beauty.csv"));
		String text = scanner.useDelimiter("\\A").next();
		String cs1 = text.replaceAll("-", " ");
		String[] cs2 = cs1.split("\\n");

		for(int i =0; i < cs2.length; i++) {
			String[] temp = cs2[i].split(",");
			BootsProducts.add(temp[1]);
		}	

		LinkedList<String> MedipharmProducts = new LinkedList<String>();  

		Scanner scanner2 = new Scanner(new File("C:/Users/Liam/Downloads/MB Compare/Medipharm Beauty.csv"));
		String text2 = scanner2.useDelimiter("\\A").next();
		String cs3 = text2.replaceAll("-", " ");
		String[] cs4 = cs3.split("\\n");

		for(int i =0; i < cs4.length; i++) {
			String[] temp = cs4[i].split(",");
			MedipharmProducts.add(temp[0]);
		}

		for(int i = 0; i<MedipharmProducts.size(); i++) {
			for (int j = 0; j < MedipharmProducts.size(); j++) {

				int len = MedipharmProducts.get(i).length();
				Map<Character, Integer> numChars = new HashMap<Character, Integer>(Math.min(len, 26));

				for (int a = 0; a < len; ++a)
				{
					char charAt = MedipharmProducts.get(i).toLowerCase().charAt(a);

					if (!numChars.containsKey(charAt))
					{
						numChars.put(charAt, 1);
					}
					else
					{
						numChars.put(charAt, numChars.get(charAt) + 1);
					}
				}

				int len2 = BootsProducts.get(j).length();
				Map<Character, Integer> numChars2 = new HashMap<Character, Integer>(Math.min(len2, 26));

				for (int a = 0; a < len2; ++a)
				{
					char charAt = BootsProducts.get(j).toLowerCase().charAt(a);

					if (!numChars2.containsKey(charAt))
					{
						numChars2.put(charAt, 1);
					}
					else
					{
						numChars2.put(charAt, numChars2.get(charAt) + 1);
					}
				}

				int counter =0;

				String s1 = numChars.keySet().toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "").toString();
				String s2 = numChars2.keySet().toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "").toString();

				String v1 = numChars.values().toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "").toString();
				String v2 = numChars2.values().toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "").toString();


				int length1 = numChars.keySet().toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "").length();
				int length2 = numChars2.keySet().toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "").length();

				int difference = 0;

				for(int b = 0; b < length1; b++) {
					for(int c = 0; c < length2; c++) {



						int a1 = Character.getNumericValue(v1.charAt(b));
						int a2 = Character.getNumericValue(v2.charAt(c));



						if(s1.charAt(b) == s2.charAt(c)) {
							difference = Math.abs(a1 - a2);
							counter = counter + difference;
						}

						if(s1.charAt(b) != s2.charAt(c)) {
							difference = 1;
							counter = counter + difference;		
						}
					}
				}

				if (Math.abs(s1.length() - counter) >  (s1.length()*.8)) {
					print = 1;
				}

			}

			if(print == 1) {
				System.out.println(MedipharmProducts.get(i).toString());
				print = 0;
			}
		}

		scanner.close();
		scanner2.close();

	}

}
