package decisionTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Node {
	/* Node class of the tree */
	Node parent;
	List<Node> children;
	List<Integer> dataRows;
	List<Integer> criteriaCols;
	boolean leaf;
	String classVal;
	int question;
	String ansParentQuestion = "";
	int level;
	int id;

	Node(Node pa, List<Integer> dataRows2, List<Integer> criteriaCols2, String ans, int lev, int i) {
		parent = pa;
		children = new ArrayList<>();
		dataRows = new ArrayList<>(dataRows2);
		criteriaCols = new ArrayList<>(criteriaCols2);
		leaf = false;
		classVal = "";
		level = lev;
		ansParentQuestion = ans;
		id = i;
	}

	Node(Node pa, List<Integer> dataRows2, List<Integer> criteriaCols2, String classVal2, String ans, int lev, int i) {
		parent = pa;
		children = new ArrayList<>();
		dataRows = new ArrayList<>(dataRows2);
		criteriaCols = new ArrayList<>(criteriaCols2);
		leaf = true;
		classVal = classVal2;
		ansParentQuestion = ans;
		question = -1;
		id = i;
		level = lev;
	}

}

public class decision {
	static List<String[]> trainData;
	static List<String[]> testData;
	static List<Set<String>> uniqueData;
	static int[] preDefinedWeights;
	static Node root;
	static String[] colNames;
	static int totalCol;
	static int mode;
	static int classCol;

	public static void main(String[] args) throws FileNotFoundException {
		/* Function to read input */
		readInput(args);
		String className = args[2];
		mode = Integer.parseInt(args[3]);
		for (int i = 0; i < totalCol; i++)
			if (colNames[i].equals(className))
				classCol = i;
		System.out.println("The mode used is " + mode + " on train file " + args[0]);
		
		/* preprocess columns for mode 1*/
		if (mode == 1)
			preProcessWeights();
		
		/* Function to start building the tree */
		buildTree();

	}
	
	/* Function to print tree in a readable manner */ 
	public static void printTree(Node node) {
		if (node.leaf) {
			System.out.println("Leaf Node at Level: " + node.level + " .Node id: " + node.id + " .Parent Node id: "
					+ node.parent.id + " .Class value: " + node.classVal + " .Node value for parent question: "
					+ node.ansParentQuestion);
		} else {
			if (node.parent != null)
				System.out.println("Tree Node at Level: " + node.level + " .Node id: " + node.id + " .Parent Node id: "
						+ node.parent.id + " .Question for this node(col num): " + node.question
						+ " .Question Col Name: " + colNames[node.question] + " .Node value for parent question: "
						+ node.ansParentQuestion + " .Number of Children: " + node.children.size());
			else
				System.out.println("Tree Node at Level: " + node.level + " .Node id: " + node.id
						+ " .No Parent id .Question for this node(col num): " + node.question + " .Question Col Name: "
						+ colNames[node.question] + " .Node value for parent question: " + node.ansParentQuestion
						+ " .Number of Children: " + node.children.size());

			for (Node n : node.children) {
				printTree(n);
			}
		}
	}

	/* Function to read input */ 
	public static void readInput(String[] args) {
		File inputTrain = new File(args[0]);
		File inputTest = new File(args[1]);

		trainData = new ArrayList<String[]>();
		testData = new ArrayList<String[]>();

		String line = "";
		String cvsSplitBy = ",";
		int rows = -1;

		try (BufferedReader br = new BufferedReader(new FileReader(inputTrain))) {
			while ((line = br.readLine()) != null) {
				rows++;
				if (rows == 0) {
					colNames = line.split(cvsSplitBy);
					totalCol = colNames.length;
				} else {
					trainData.add(line.split(cvsSplitBy));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		rows = -1;
		try (BufferedReader br = new BufferedReader(new FileReader(inputTest))) {
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				rows++;
				if (rows != 0) {
					testData.add(line.split(cvsSplitBy));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Function to call helper to build tree recursively */ 
	public static void buildTree() {
		List<Integer> data = new ArrayList<>();
		for (int i = 0; i < trainData.size(); i++) {
			data.add(i);
		}
		// System.out.println("DATA SIZE: "+data);
		List<Integer> cols = new ArrayList<>();
		root = buildTreeRec(null, data, cols, null, -100, 0);

		System.out.println(
				"------------------------------------------------------------Printing Tree---------------------------------------------------------------");
		printTree(root);
		System.out.println(
				"--------------------------------------------------------Finish Printing Tree--------------------------------------------------------------");

		evaluateTree(root);
	}

	/* Function to calculate weights for strategy 2 */
	public static void preProcessWeights() {
		preDefinedWeights = new int[totalCol];
		int j = 0;
		for (int i = 0; i < totalCol; i++) {
			if (i == classCol)
				continue;
			if (totalCol - 1 - j == classCol)
				j++;
			preDefinedWeights[i] = totalCol - 1 - j;
			j++;
		}
	}

	/* Function to find class for test data in a loop*/
	public static String findClass(Node root, String[] data) {
		Node node = root;
		while (!node.leaf) {
			// System.out.println(node.id);
			int flag = 0;
			String curVal = data[node.question];
			for (Node n : node.children) {
				if (n.ansParentQuestion.equals(curVal)) {
					node = n;
					flag = 1;
					continue;
				}

			}
			if (flag == 0) {
				node = node.children.get(0);
			}

		}
		// System.out.println(node.id);
		return node.classVal;
	}

	/* Function to predict class of test dataset */ 
	public static void evaluateTree(Node root) {
		/* Store newer predictions */
		System.out.println("Starting Prediction:");
		String prediction[] = new String[testData.size()];
		for (int i = 0; i < testData.size(); i++) {// trainData.size()
			prediction[i] = findClass(root, testData.get(i));
		}
//		for(int i=0;i<15;i++)
//		System.out.println(prediction[i]);
		// Now calculate prediction with class label and do confusion matrix
		int truPos = 0, truNeg = 0, falPos = 0, falNeg = 0;
		for (int i = 0; i < prediction.length; i++) {
			if (testData.get(i)[classCol].equals("1")) {
				// 1
				if (prediction[i].equals("1"))
					truPos++;
				else
					falPos++;

			} else {
				// 0
				if (prediction[i].equals("0"))
					truNeg++;
				else
					falNeg++;
			}
		}
		System.out.println("TRUE POSITIVE: " + truPos);
		System.out.println("FALSE POSITIVE: " + falPos);
		System.out.println("TRUE NEGATIVE: " + truNeg);
		System.out.println("FALSE NEGATIVE: " + falNeg);

	}

	/* Function to check if the current node is a leaf */ 
	public static boolean checkLeaf(List<Integer> data) {
		String val = trainData.get(data.get(0))[classCol];
		for (int i = 1; i < data.size(); i++)
			if (!trainData.get(data.get(i))[classCol].equals(val))
				return false;
		return true;
	}

	/* Function to find number of unique elements in a column */ 
	public static void findUniqueElements() {
		uniqueData = new ArrayList<>(totalCol);
		for (int i = 0; i < totalCol; i++) {
			Set<String> s = new HashSet<>();
			for (int j = 0; j < trainData.size(); j++) {
				s.add(trainData.get(j)[i]);
			}
			uniqueData.add(s);
		}

	}
	
	/* Function to calculate entropy */ 
	public static double B(double q) {
		if (q == 0 || q == 1)
			return 0;
		return -(q * (Math.log(q) / Math.log(2)) + (1 - q) * (Math.log(1 - q) / Math.log(2)));
	}

	/* Function to calculate the positive rows in the data */ 
	public static int findPos(List<Integer> data) {
		int totalPos = 0;
		// System.out.println(data);
		for (int k : data) {
			// System.out.println("datainttoalpos: "+ trainData.get(k)[classCol]);
			if (trainData.get(k)[classCol].equals("1")) {
				totalPos++;

			}
		}
		// System.out.println("TOTALPOS: "+totalPos);
		return totalPos;
	}
	
	/* Function to calculate information gain */ 
	public static double infoGain(Map<String, List<Integer>> segData, int totalPos, int total) {

		double oldGain = B((double) totalPos / total);
		// System.out.println("OLDGAIN: "+oldGain);
		for (String key : segData.keySet()) {
			double curEntropy;
			int curTotal = segData.get(key).size();
			int posTotal = findPos(segData.get(key));
			curEntropy = ((double) curTotal / total) * B((double) posTotal / curTotal);
			// System.out.println("Key "+key+" oldgain loop: "+oldGain+" postotal
			// "+posTotal+" curToa "+curTotal+" curEn "+curEntropy);
			oldGain = oldGain - curEntropy;

		}

		return oldGain;
	}

	/* Function to partition data on a column */ 
	public static Map<String, List<Integer>> partition(int col, List<Integer> data) {
		Map<String, List<Integer>> segData = new HashMap<>();
		Set<String> s = new HashSet<>();
		// System.out.println("data: "+data);
		for (int i : data) {
			String curVal = trainData.get(i)[col];
			s.add(curVal);
			if (segData.containsKey(curVal))
				segData.get(curVal).add(i);
			else {
				segData.put(curVal, new ArrayList<>());
				segData.get(curVal).add(i);
			}
		}
//		System.out.println("In partiton: col "+col+" set s: "+s);
//		System.out.println(segData.get("0"));
//		System.out.println(segData.get("1"));
//		System.out.println(segData.size());
		// System.out.println("In partiton: col "+col+" set s: "+s);
		return segData;
	}

	/* Function to find split column for second strategy */ 
	public static int findSplit1(List<Integer> data, List<Integer> criteria) {
		// What if all creiteria has benn used already
		int bestCol = -1;
		if (criteria.size() == totalCol - 1) {
			return bestCol;// and make leaf node
		}

		for (int i = 0; i < preDefinedWeights.length; i++) {
			if (i == classCol)
				continue;
			int colTemp = preDefinedWeights[i];
			if (!criteria.contains(colTemp))// not to repeat it again in the path
			{
				// System.out.println(i+" "+colTemp);
				Map<String, List<Integer>> segData = partition(colTemp, data);
				if (segData.size() <= 1) { // if split results in only one node
					// System.out.println("skipped i as split is: "+i);
					continue;
				}
				return colTemp;
			}
		}
		return bestCol;
	}
	
	/* Function to find split column for IG */
	public static int findSplit(List<Integer> data, List<Integer> criteria) {
		// What if all creiteria has benn used already
//		if(criteria.size()==totalCol-1) {
//			return and make leaf node	
//		}
		double bestGain = Double.MIN_VALUE;
		int bestCol = -1;

		for (int i = 0; i < totalCol; i++) {
			if (i == classCol)
				continue;
			if (!criteria.contains(i))// not to repeat it again in the path
			{
				// int totalUnique=uniqueData.get(i).size();
				// for(String value:uniqueData.get(i))
				// System.out.println("Checkpartiiton i: "+i);
				Map<String, List<Integer>> segData = partition(i, data);
				if (segData.size() <= 1) { // if split results in only one node
					// System.out.println("skipped i as split is: "+i);
					continue;
				}
				// System.out.println("data before pos: "+data);
				int totalPos = findPos(data);
				// System.out.println("findSplit i: "+i);
				double gain = infoGain(segData, totalPos, data.size());
				// System.out.println("GAIN IS: "+gain+" pos: "+totalPos+" size: "+data.size());
				if (gain >= bestGain) {
					bestGain = gain;
					bestCol = i;
				}

			}
		}
		if (bestGain == 0) {
			System.out.println("BESTGAIN IS 0");
			return -1;
		}
		return bestCol;
	}

	/* Function to find majority class of a impure leaf node */
	public static String findMajorityClass(List<Integer> data) {
		int posCount = 0;
		int negCount = 0;
		for (int i : data) {
			if (trainData.get(i)[classCol].equals("0"))
				negCount++;
			else
				posCount++;
		}
		if (negCount > posCount) {
			return "0";
		}
		return "1";
	}

	static int id = 0;
	
	/* Function to build tree recursively */
	public static Node buildTreeRec(Node parent, List<Integer> newData, List<Integer> criteria, String ans,
			int bestColOld, int level) {
		Node current;
		if (checkLeaf(newData)) {
			// create leaf node
			// System.out.println("Creating a leaf Node: ");
			current = new Node(parent, newData, criteria, trainData.get(newData.get(0))[classCol], ans, level, id);
			id++;
			if (parent != null) {
				parent.children.add(current);
				parent.question = bestColOld;
			}
		} else {
			// System.out.println("Creating a Normal Node: ");
			// add ans
			// System.out.println("findsplit for node id: "+id+" crit: "+criteria);
			int bestCol;
			switch (mode) {
			case 0:
				bestCol = findSplit(newData, criteria);
				break;
			case 1:
				bestCol = findSplit1(newData, criteria);
				break;
			default:
				bestCol = findSplit(newData, criteria);

			}

			if (bestCol == -1) {
				// System.out.println("BESTCOL: -1:" + id);
				String classMajority = findMajorityClass(newData);
				current = new Node(parent, newData, criteria, classMajority, ans, level, id);
				id++;
				if (parent != null) {
					parent.children.add(current);
					parent.question = bestColOld;
				}
				return current; // create and return leaf node
			}
			current = new Node(parent, newData, criteria, ans, level, id);
			id++;
			if (parent != null) {
				parent.children.add(current);
				parent.question = bestColOld;
			}
			// find the split
			// System.out.println("BESTCOL IS:"+bestCol);

			// Again partition
			// add parent question

			Map<String, List<Integer>> segData = partition(bestCol, newData);

			// System.out.println(segData.size());
			for (String key : segData.keySet()) {
				// System.out.println();
				List<Integer> newCriteria = new ArrayList<>(criteria);
				newCriteria.add(bestCol);
				// System.out.println(newCriteria);
				buildTreeRec(current, segData.get(key), newCriteria, key, bestCol, level + 1);
				// break;
			}
		}

		return current;
	}

}
