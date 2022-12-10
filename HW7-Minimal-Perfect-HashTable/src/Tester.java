import java.io.File;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\hayde\\eclipse-workspace\\HW7-Minimal-Perfect-HashTable\\src\\HashNode.java");
		FileReader fileReader = new FileReader(file);
		
		System.out.println(fileReader.summary());

	}

}
