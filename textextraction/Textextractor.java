package textextraction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Textextractor {
	private String[] patterns;

	public Textextractor() {
		patterns = new String[]{
				"Hell",
				"d!",
				};
	}

	public String extractText(String text) {
		for(String p: patterns) {
			Pattern pattern = Pattern.compile(p);
			text = pattern.matcher(text).replaceAll("");
		}
		return text;
	}
}
