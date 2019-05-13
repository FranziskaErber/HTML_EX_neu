import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import textextraction.Textextractor;

public class Main {

	public static void main(String[] args) {
		// check if program was executed correctly
		//if (args.length != 1) {
		//	System.err.println("Usage: java Main <html_file>");
		//	System.exit(1);
		//}
		//String infile = args[0];

		// use scanner on windows
		System.err.println("Gib einen Dateinamen an: ");
		Scanner sc = new Scanner(System.in);  // never close scanner backed up with System.in !!
		String path = sc.next();

		// this string will be filled with read input
		String text = "";

		// read input file
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;

			// append lines to text until the buffer is empty
			while((line = br.readLine()) != null) {
				text += line + System.getProperty("line.separator");
			}
		} catch (FileNotFoundException e) {
			System.err.println("Datei nicht gefunden!");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Ein Fehler ist aufgetreten!");
			// e.printStackTrace();
			System.exit(1);
		}

		// extract human readable text from input text
		Textextractor extractor = new Textextractor();
		String extractedText = extractor.extractText(text);

		// normalize html characters
		Normalizer normalizer = new Normalizer();
		String normalizedText = normalizer.normalize(extractedText);
		
		// print the resulting text
		System.out.println(normalizedText);
	}

}
