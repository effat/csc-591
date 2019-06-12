package Project_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Project1<E> {

	private static LinkedList<String> list1;
	private static BufferedWriter writer;
	private static int compressedC;
	private static int uncompressedC;
	public static void main(String[] args) throws IOException {
		
		compressedC = 0;
		uncompressedC = 0;
		System.out.print("Please input the file name: ");
		String fileName;
		Scanner keyboard = new Scanner(System.in);
		fileName = keyboard.nextLine();
		System.out.println();
		System.out.print("Please input the output file name: ");
		String outFile = keyboard.nextLine();
		System.out.println();
		writer = new BufferedWriter(new FileWriter(outFile));
		//writer.write(String.valueOf(123));
		//writer.close();
		// check if the filename isn't empty
		//if(fileName.isEmpty() == false) {
			
		LinkedList list = new LinkedList<>();
		//LinkedList list2 = new LinkedList<>();
		//list.addFront(list.size(), "hey");
		//list.addFront(list.size(), "bye");
		//list.addFrontLast(3);
		//for(int i = 0; i < list.size(); i++) {
		//	System.out.println(list.get(i)); 
		//}
		File file = new File(fileName);
		list1 = new LinkedList<String>();

		Scanner filesc = new Scanner(file);
		if(filesc.next().equals("0")) {
			decompress(file);
		} else
		{
			compress(file);
		}
		writer.close();
		System.out.println("done");
		
		
		String word;
		int index = 0;
		boolean found = false;
//		while(filesc.hasNext()) {
//			word = filesc.next();
//			if(list.size() == 0) {
//				list.addFront(0, word);
//				System.out.println(word);
//			} else {
//				int secondIndx = 0;
//				for(int i = 0; i < list.size(); i++) {
//					if(word.equals(list.get(i))) {
//						secondIndx = i + 1;
//						System.out.println(secondIndx);
//						list.remove(i);
//						//list.set(i, secondIndx);
//						found = true;
//						
//					}
//				}
//				if( found == true) {
//					list.addFront(0, word);
//				} else {
//					System.out.println(word);
//					list.addFront(0, word);
//				} 
//				/*
//				if(found == false) {
//				list.addFront(0, word);
//				System.out.println(word);
//				} else {
//					list.addFront(0, secondIndx);
//					//System.out.println(secondIndx);
//				}*/
//				
//				found = false;
//			}
//			//System.out.println(word);
//			//System.out.println();
//			index++;
//		} 
		//for(int i = 0; i < list.size(); i++) {
				//	System.out.println(list.get(i)); 
				//}
		
		// check if the file exists
		
		//}
	}
	public static void compress(File file) throws IOException {
		Scanner filesc = new Scanner(file);
		writer.write(String.valueOf(0));
		writer.write(" ");
		//System.out.print("0 ");
		String line;
		String word = "";
		int index = 0;
		boolean found = false;
		while(filesc.hasNextLine()) {
			line = filesc.nextLine();
			uncompressedC += line.length();
			//System.out.println(line); 
			char[] charAr = new char[ line.length()];
			
			//String line1 = String.copyValueOf(charAr);
			//int idx = 0;
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) != ' ' && line.charAt(i) != '.' && line.charAt(i) != ',' && line.charAt(i) != '/' && line.charAt(i) != '%' && line.charAt(i) != '&' && line.charAt(i) != '!' && line.charAt(i) != '@' && line.charAt(i) != '#' && line.charAt(i) != '$' && line.charAt(i) != '?' && line.charAt(i) != '-' && line.charAt(i) != '_' && line.charAt(i) != '>' && line.charAt(i) != '<' && line.charAt(i) != '\'') {
					//System.out.print(line.charAt(i));
					word += line.charAt(i);
					//charAr[idx] = line.charAt(i);
					//System.out.print(charAr[idx]);
					//idx++;
				} 
				else {
					
					if(word.length() != 0) {
						//word = new String (charAr);
						int val = compressWord(word);
						//System.out.print(word);
						if( val == -1) {
							//System.out.print(word);
							writer.write(word);
						} else {
							writer.write(String.valueOf(val));
						//System.out.print(val);
						}
						word = "";
						
						//charAr = new char[ line.length()];
						// do the compression algorithm
						//charAr = null; // reset the array
						//idx = 0;
					} 
					//word =  new String(charAr);
					//word = String.copyValueOf(charAr);
					//if(word != null) {
					//	System.out.print(word);
						
				//	}
					//charAr = null;
					//idx = 0;
					compressedC += 1;
					writer.write(line.charAt(i));
					//System.out.print(line.charAt(i));
					
					
				}
 			}
			if(word.length() > 0) {
				//System.out.print(word);
				int val = compressWord(word);

				if( val == -1) {
					writer.write(word);
					//System.out.print(word);
				} else {
					writer.write(String.valueOf(val));
				//System.out.print(val);
				}
				word = "";
			}
			writer.newLine();
			//System.out.println();

		}
		writer.write(String.valueOf(0));
		writer.write(" ");
		writer.write("Uncompressed: ");
		writer.write(String.valueOf(uncompressedC));
		writer.write(" bytes;  ");
		writer.write("Compressed: ");
		writer.write(String.valueOf(compressedC));
		writer.write(" bytes");
		//System.out.print("0 ");
	}
	public static int compressWord(String word) {
		boolean found = false;
		int secondIndx = 0;
		if(list1.size() == 0) {
			list1.addFront(0, word);
			compressedC += word.length();
			return -1;
		} else {
			secondIndx = 0;
			for(int i = 0; i < list1.size(); i++) {
				if(word.equals(list1.get(i))) {
					secondIndx = i + 1;
					//System.out.println(secondIndx);
					list1.remove(i);
					//list.set(i, secondIndx);
					found = true;
					
				}
			}
			if( found == true) {
				list1.addFront(0, word);
				int length = (int)(Math.log10(secondIndx) + 1); 
				compressedC += length;
				return secondIndx;
			} else {
				//System.out.println(word);
				list1.addFront(0, word);
				compressedC += word.length();
				return -1;
			} 
			
		}
		
	}
	public static void decompress(File file) throws IOException {
		int firstZero = 0;
		Scanner filesc = new Scanner(file);
		String line;
		String word = "";
		while(filesc.hasNextLine()) {
			line = filesc.nextLine();
			
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) != ' ' && line.charAt(i) != '.' && line.charAt(i) != ',' && line.charAt(i) != '/' && line.charAt(i) != '%' && line.charAt(i) != '&' && line.charAt(i) != '!' && line.charAt(i) != '@' && line.charAt(i) != '#' && line.charAt(i) != '$' && line.charAt(i) != '?' && line.charAt(i) != '-' && line.charAt(i) != '_' && line.charAt(i) != '>' && line.charAt(i) != '<' && line.charAt(i) != '\'' ) {
					if(i == 0) {
						if(line.charAt(i) == '0') {
							firstZero++;
						} else {
							word += line.charAt(i);
						}
					} else {
					word += line.charAt(i);
					}
				} else {
					
//					if(line.charAt(i) == '0' && i == 0)  {
//						firstZero++;
//					}
					if(firstZero == 2) {
						return;
					}
					
					if(word.length() != 0) {
						//word = new String (charAr);
						 decompressWord(word);
						//System.out.print(word);
						
						word = "";
						
						//charAr = new char[ line.length()];
						// do the compression algorithm
						//charAr = null; // reset the array
						//idx = 0;
					}
					if(line.charAt(i) == '0' && i == 0 ) {
						
					} else if(i == 1 && line.charAt(i - 1) == '0') {}
					else {
						writer.write(line.charAt(i));
					}
				}
			}
			if(word.length() > 0) {
				//System.out.print(word);
				decompressWord(word);

				
				word = "";
			}
			if(filesc.hasNextLine()) {
			 writer.newLine();
			}
		}

	}
	public static void decompressWord(String word) throws IOException {
		boolean found = true;
		boolean fdigit = true;
		String wordTemp = "";
		int digit;
		int secondIndx = 0;
//		if(list1.size() == 0) {
//			list1.addFront(0, word);
//			//compressedC += word.length();
//			writer.write(word);
//		} else {
			
			 for (char c : word.toCharArray()) {
			    {
			        if (!Character.isDigit(c)) {
			        	fdigit = false;
			        }
			    }
			 }
			 if(fdigit == true) {
				digit = Integer.parseInt(word);
				wordTemp = list1.get(digit - 1);
				writer.write(wordTemp);
				list1.remove(digit - 1);
				list1.addFront(0, wordTemp);
			 } else {
				 list1.addFront(0, word);
				 writer.write(word);
			 }
			secondIndx = 0;
//			for(int i = 0; i < list1.size(); i++) {
//				if(word.equals(list1.get(i))) {
//					secondIndx = i + 1;
//					//System.out.println(secondIndx);
//					list1.remove(i);
//					//list.set(i, secondIndx);
//					found = true;
//					
//				}
			}
//			if( found == true) {
//				list1.addFront(0, word);
//				int length = (int)(Math.log10(secondIndx) + 1); 
//				compressedC += length;
//				return secondIndx;
//			} else {
//				//System.out.println(word);
//				list1.addFront(0, word);
//				compressedC += word.length();
//				return -1;
//			} 
			
//		}
	
}


