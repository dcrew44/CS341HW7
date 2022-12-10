import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	private File file;
	public int lineCount;
	public int keywordsCount;
	public double time;
	
	
	public FileReader(File f) {
		Stopwatch timer = new Stopwatch();
		try {
			timer.start();
			Scanner in = new Scanner(f);
			HashTable keywords = new HashTable();
			while(in.hasNext()) {
				String line = in.nextLine();
				
				if (!line.isBlank()) {
					if (line.contains("/*")) {
						while (!line.contains("*/")) {
							line = in.nextLine();
						}
					}
					else {
						lineCount++;
						line = line.replace("(", " ");
						line = line.replace(")", " ");
						line = line.replace(";", "");
						for (String word: line.split(" ")) {
							word = word.strip();
							if (keywords.getValue(word) != -1) {
								keywords.checkWord(word);
								keywordsCount++;
							}
						}
					}
				}
			}
			timer.stop();
			time = timer.getTime();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String summary() {
		StringBuilder str = new StringBuilder();
		str.append("Lines: "+lineCount);
		str.append("\nkeywords: " +keywordsCount);
		str.append("\nTime: "+time +" milliseconds");
		return str.toString();
		}
	
	
}
