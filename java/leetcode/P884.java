import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class P884 {
	public String[] uncommonFromSentences(String s1, String s2) {
		Map<String, Integer> wordCounts = new HashMap<>();

		for (String word : s1.split(" ")) {
			wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
		}
		for (String word : s2.split(" ")) {
			wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
		}

		List<String> uniqueWords = new ArrayList<>();

		for (String word : wordCounts.keySet()) {
			if (wordCounts.get(word) == 1) {
				uniqueWords.add(word);
			}
		}

		return uniqueWords.toArray(new String[uniqueWords.size()]);
	}
}
