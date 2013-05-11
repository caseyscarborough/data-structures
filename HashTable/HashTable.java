import java.util.ArrayList;

public class HashTable {
	String[] contents;
	int size, itemsInArray = 0;
	
	HashTable(int size) {
		this.size = size;
		this.contents = new String[size];
	}
	
	public void hashFunction1(String[] strings) {
		for(int n = 0; n < strings.length; n++) {
			contents[Integer.parseInt(strings[n])] = strings[n];
		}
	}
	
	public void hashFunction2(String[] strings) {
		int collisions = 0;
		for(int n = 0; n < strings.length; n++) {
			int arrayIndex = Integer.parseInt(strings[n]) % 31;
			System.out.println("Modulus Index = " + arrayIndex + " for value " + strings[n]);
			while(contents[arrayIndex] != null) {
				++arrayIndex;
				System.out.println("Collision try " + arrayIndex + " instead ");
				collisions += 1;
				arrayIndex %= size;
			}
			contents[arrayIndex] = strings[n];
		} System.out.println("There were " + collisions + " collisions.");
	}
	
	public boolean isPrime(int number) {
		if (number % 2 == 0)
			return false;
		
		for(int i = 3; i * i <= number; i+=2){
			if(number % i == 0)
				return false;
		} return true;
	}
	
	public int getNextPrime(int minNumberToCheck) {
		for(int i = minNumberToCheck; true; i++) {
			if (isPrime(i)) {
				return i;
			}
		}
	}
	
	public void increaseArraySize(int minArraySize) {
		int newArraySize = getNextPrime(minArraySize);
		moveOldArray(newArraySize);
	}
	
	public void moveOldArray(int newArraySize) {
		String[] cleanArray = removeEmptySpacesInArray(contents);
		contents = new String[newArraySize];
		size = newArraySize;
		hashFunction2(cleanArray);
	}
	
	public String[] removeEmptySpacesInArray(String[] arrayToClean) {
		ArrayList<String> stringList = new ArrayList<>();
		for(String theString : arrayToClean) {
			if(!theString.equals(null))
				stringList.add(theString);
		}
		return stringList.toArray(new String[stringList.size()]);
	}
	
	public String findKey(String key) {
		int arrayIndexHash = Integer.parseInt(key) % 31;
		while(contents[arrayIndexHash] != null) {
			if(contents[arrayIndexHash] == key) {
				System.out.println(key + " was found in index " + arrayIndexHash);
				return contents[arrayIndexHash];
			}
			++arrayIndexHash;
			arrayIndexHash %= size;
		}
		System.out.println(key + " was not found"); 
		return null;
	}
	
	private int getColumnWidth(int i) {
		// Set width to the length of the index
		int width = String.valueOf(i).length();
		// If contents exist, and are wider than the index, set width
		if(contents[i] != null) {
			if(contents[i].toString().length() > width) {
				width = contents[i].toString().length();
			} // If content doesn't exist, width = 1 for one space
		}
		return width;
	}

	private void printLine(String type, int offset, int columns) {
		for(int i = offset - columns; i < offset; i++) {
			if (i < contents.length) {
				if (type == "index") {// Print index row
					System.out.print("|");
					System.out.printf(" %-" + getColumnWidth(i) + "s ", i);
				} else if (type == "data") { // Print data row
					System.out.print("|");
					if(contents[i] != null) // If data exists
						System.out.printf(" %-" + getColumnWidth(i) + "s ", contents[i]);
					else // If data doesn't exist, print blank space
						System.out.printf(" %-" + getColumnWidth(i) + "s ", "");
				} else if (type == "lines") {
					// Output dashes to separate indices and data
						System.out.print("+");
						for(int j = 0; j < getColumnWidth(i); j++) System.out.print("-");
						System.out.print("--");
				} // If incorrect type specified, print blank space
				else { System.out.printf(" %-" + getColumnWidth(i) + "s ", ""); }
			} else { break; }
		} if (type == "data" || type == "index") System.out.println("|");
		else if (type == "lines") System.out.println("+"); 
		else System.out.println("|"); 
	}
	
	public void display() {
		int offset = 0;
		int columns = 11; // The number of columns to be displayed per line
		int rows = (int)Math.ceil(contents.length + columns-1) / columns; 
		System.out.println();
		for (int m = 0; m < rows; m++){
			offset += columns;
			printLine("lines", offset, columns);
			printLine("index", offset, columns);
			printLine("lines", offset, columns);
			printLine("data", offset, columns);
			printLine("lines", offset, columns);
			System.out.println("");
		}
		System.out.println(rows + " rows should be displayed using columns of " + columns + ".\n"); 
	}
	
	public static void main(String[] args) {
		HashTable hashTable = new HashTable(31);
		String[] strings = {"100", "510", "170", "214", "268", "398", "235", 
				"802", "900", "723", "699", "1", "16", "999", "890", "725",
				"998", "978", "988", "990", "989", "984", "320", "321", "400", 
				"415", "450", "50", "660", "624"};
		String[] strings2 = {"30", "60", "90", "120", "150", "180", "210", 
				"240", "270", "300", "330", "360", "390", "420", "450", "480",
				"510", "540", "570", "600", "630", "660", "690", "720", "750", 
				"780", "810", "840", "870", "900"};
		hashTable.hashFunction2(strings);
		// hashTable.increaseArraySize(60);
		hashTable.display();
		hashTable.findKey("6640");
		hashTable.findKey("510");
		
	}

}
