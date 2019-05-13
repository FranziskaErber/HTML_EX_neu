import java.util.HashMap;
import java.util.Map;

public class Normalizer {
	private Map<String, String> translations;

	public Normalizer() {
		translations = new HashMap<>();
		translations.put("bye", "bye bye");
		translations.put("Good", "GOOD");
	}

	public String normalize(String text) {
		for(Map.Entry<String, String> entry: translations.entrySet()) {
			text = text.replace(entry.getKey(), entry.getValue());
		}
		return text;
	}
}
