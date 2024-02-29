import java.util.HashMap;
import java.util.LinkedHashMap;

public class P12 {
	public String intToRoman(int num) {
		HashMap<Integer, String> romanTable = new LinkedHashMap<>() {{ put(1000, "M"); put(900, "CM"); put(500, "D"); put(400, "CD"); put(100, "C"); put(90, "XC"); put(50, "L"); put(40, "XL"); put(10, "X"); put(9, "IX"); put(5, "V"); put(4, "IV"); put(1, "I"); }};
		String roman = "";
		for (Integer i : romanTable.keySet()) {
			int count = num / i;
			num %= i;
			for (int j = 0; j < count; j++) {
				roman += romanTable.get(i);
			}
		}
		return roman;
	}
}
