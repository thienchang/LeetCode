package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findFirstNonRepeatCharacter("sawiss"));
		
		System.out.println(areAnagrams("listen", "silent"));
		
		System.out.println(findLongestWord("Java programming is funnnnnnnnnnn"));
		
		List<String> input = Arrays.asList("Java", "來", null, "is", "fun");
		System.out.println(concatenateFilterAndReverse(input));
		
		String[] arr = {"apple", "banana", "eagle", "ice", "orange", "zebra"};
	    List<String> result = processWords(arr);
	    System.out.println("Input: " + Arrays.toString(arr));
	    System.out.println("Output" + result);
		
		 Map<Character, Integer> frequencyMap = new HashMap<>();
		 frequencyMap = characterFrequency("Hello world!!!");
		 frequencyMap.forEach((k,v) -> System.out.println("Key = " + k + ", Value = " + v));
	}
	
	public static String findFirstNonRepeatCharacter(String input) {
		String temp;
		String ignore = null;
		for (int i = 0; i < input.length(); i++) {
			temp = String.valueOf(input.charAt(i));
			if (temp.equals(ignore)) {
				continue;
			}
			if (!input.substring(i + 1).contains(temp)) {
				return String.valueOf(input.charAt(i));
			} else {
				ignore = temp;
			}
		}
		return "Not found";
	}
	
	public static boolean areAnagrams(String str1, String str2) {
		if (str1.trim().length() != str2.trim().length()) {
			return false;
		}
		// Convert the string to a character array
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        // Sort the character array
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(arr1);
        System.out.println(arr2);
		for (int i = 0; i < str1.length(); i++) {
			if (!Objects.equals(arr1[i], arr2[i])) {
				return false;
			}
		}
		return true;
	}
	
	public static String findLongestWord(String sentence) {
		Map <String, Integer> map = new HashMap<String, Integer>();
		int startIndex = 0;
		for (int i = 0; i < sentence.length(); i++) {
			if (Character.isSpaceChar(sentence.charAt(i))) {
				map.put(sentence.substring(startIndex, i), i - startIndex);
				startIndex = i + 1;
			}
			if (i == sentence.length() - 1) {
				map.put(sentence.substring(startIndex, i + 1), i + 1 - startIndex);
			}
		}
		int max = 0;
		for (Integer values: map.values()) {
			if (max < values) {
				max = values;
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue().equals(max)) {
				return entry.getKey();
			}
		}
//		map.forEach((k,v) -> System.out.println("Key = " + k + ", Value = " + v));
		Stream<Map.Entry<String, Integer>> sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue());
		sorted.forEach(System.out::println);
		return "";
	}
	
	public static String concatenateFilterAndReverse(List<String> strings) {
		String result = "";
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i) == null || !strings.get(i).matches(".*[a-zA-Z].*")) {
//				strings.remove(i);
			} else {
				result = result.concat(strings.get(i));
			}
		}
		return new StringBuilder(result).reverse().toString();
	}
	
	public static List<String> processWords(String[] words) {
        return Arrays.stream(words)
                .filter(str -> str.matches("^[aeiouAEIOU].*")) // Filter strings that start with a vowel
                .map(String::toUpperCase) // Convert to uppercase
                .sorted(Comparator.comparingInt(String::length) // Sort by length
                .thenComparing(String::compareTo)) // If same length, sort alphabetically
                .collect(Collectors.toList()); // Collect into a new list
    }
	
	public static Map<Character, Integer> characterFrequency(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        // Spaces (\\s) and punctuation (\\p{Punct}).
        String processedInput = input.replaceAll("[\\s\\p{Punct}]", "").toLowerCase();

        for (char c : processedInput.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        return frequencyMap;
    }
}
