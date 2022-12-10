import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTable {
	public HashNode[] Table = new HashNode[50];

	public HashTable() {
		try {
			File f = new File("C:\\Users\\hayde\\eclipse-workspace\\HW7-Minimal-Perfect-HashTable\\src\\keywords.txt");
			Scanner in = new Scanner(f);
			while (in.hasNext()) {
				String w = in.next();
				HashNode n = new HashNode(w);
				if (Table[n.getHash()] != null) {
					HashNode p = Table[n.getHash()];
					while (p.next != null) {
						p = p.next;
					}
					p.next = n;
				} else {
					Table[n.getHash()] = n;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getValue(String key) {
		if(key.length() == 0) return -1;
		HashNode n = getNode(key);
		if (n == null)
			return -1;
		else
			return n.getValue();

	}

	public HashNode getNode(String key) {
		HashNode n = new HashNode(key);
		if (Table[n.getHash()] != null) {
			HashNode p = Table[n.getHash()];
			while (p != null) {
				if (p.getKey().equals(n.getKey()))
					return p;
				p = p.next;
			}
		}
		return null;
	}

	public void checkWord(String key) {
		HashNode n = getNode(key);
		if (n != null) {
			n.setValue(n.getValue() + 1);
		}
	}

	public String toString() {
		String str = "";
		for (HashNode h : Table) {
			if (h != null) {
				if (h.next != null) {
					HashNode p = h;
					while (p.next != null) {
						str += p.getKey() + "	";
						p = p.next;
					}
					str += p.getKey() + "	";
				} else {
					str += h.getKey() + "	";
				}
			}
		}
		return str;
	}
}
