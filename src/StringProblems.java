import java.util.ArrayList;
import java.util.HashMap;

public class StringProblems {

	public static void main(String[] args) {
		String inputStr[] = {
				"This is first String to test.",
				"Here is another test. This, has: more punctuations!! You like this, don't you??",
				"Programmer : (Neha Heera) Version: 10",
				"Jupiter and Venus hung like grapes in the evening sky, frozen and untwinkling, "
				+ "You could have reached and up and picked them. And the trout swam. Snow muffled "
				+ "the world, silenced the dog, silenced the wind... The man said, I can "
				+ "show you the trout. He was glad of the company. He reached into their tiny pool, rescued a dozen, one by one," 
				+ "sorting and choosing, dividing the sheep from the goats of them. And this was the miracle of the fishes,"
				+ "that they were beautiful. Even when clubbed and gutted, insides glittering like jewels. See this? he said, the trout heart"
				+ "pulsed like a ruby in his hand. The kids love this.  He put it down, and it kept beating. The kids, they go wild for it."
				+ "He said, we feed the guts to the pigs. They're pets now, They won't be killed. See? We saw, huge as horses they loomed on the side of the hill."
		};
		for (int i = 0; i < inputStr.length; i++) {
			System.out.println("\nString : " + inputStr[i] + "\n Top " + i * 2 + " words:");
			ArrayList<String> list = findTopKWords(inputStr[i], i * 2);
			for (String string : list) {
				System.out.println("  " + string);
			}
		}
		
	}

	/**
	 * Finds and returns the k number of words which occur in the given string
	 * most often.
	 * 
	 * @param inputStr
	 *            - Input string
	 * @param k
	 *            - Top number of words to be found
	 * @return - ArrayList of size k
	 */
	private static ArrayList<String> findTopKWords(String inputStr, int k) {
		// Ignoring case of words, assuming - "This" is same as "this". 
		char[] inputArray = inputStr.toLowerCase().toCharArray();
		
		StringBuilder builder = new StringBuilder();
		
		// Find words in the string if they are separated by a space or some other special character.
		// Assumption - numbers are also considered words.
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < inputArray.length; i++) {
			if ((inputArray[i] >= 'a' && inputArray[i] <= 'z') || (inputArray[i] >= '0' && inputArray[i] <= '9')) {
				// We haven't encountered a space or special character yet, add this character to the builder.
				if (builder == null) {
					builder = new StringBuilder();
				}
				builder.append(inputArray[i]);
			} else if (builder != null) {
				// Found a word, add it to the map.
				updateMap(builder.toString(), map);
				builder = null;
			}
		}
		// Fall over for any remaining elements in the String builder.
		if (builder != null) {
			updateMap(builder.toString(), map);
			builder = null;
		}
		
		ArrayList<String> list = new ArrayList<String>(k);
		int maxCount = 0;
		String maxStr = null;
		
		// Find Top k elements in the Map.
		for (int i = 0; i < k; i++) {
			for (String string : map.keySet()) {
				int count = map.get(string);
				
				// If two strings have same count, pick the one lower in
				// lexicographical order
				if ((count == maxCount && string.compareTo(maxStr) < 0) || count > maxCount) {
					maxCount = count;
					maxStr = string;
				}
			}
			list.add(i, maxStr);
			map.remove(maxStr);
			maxStr = null;
			maxCount = 0;
		}
		return list;
	}

	/**
	 * If the given word is not present in hash map already, add it and set the
	 * count to 1. If it is already present in the map, increment the count.
	 * 
	 * @param word
	 *            - the word to be added to the map.
	 * @param map
	 *            - hash map
	 */
	private static void updateMap(String word, HashMap<String, Integer> map) {
		int count = map.containsKey(word) ? map.get(word) + 1 : 1;
		map.put(word, count);
	}
}
/*
Complexity :

Parsing the characters = O(n) 
Say we found ‘m’ number of words. m will always be < n. In worst case, when all the words are single character, m = n/2. In best case, when the entire string is only one word, m = 1.
To find top most element from Map of size m = O(m)
To find second top most element from Map of size m = O(m-1)
To find top most ‘k’ elements from Map of size m 
= O(m * k - (1 + 2 + … +k)) 
approx = O(m * k)
= O((n/j) * k) (where m = n / j)

To parse characters + Find topmost k elements =
O(n + (n/j) * k)

If the value of k is small compared to the huge input string n, the complexity will be ~= O(n + (n/j)
since n/j <= n, complexity ~= O(n).
*/
