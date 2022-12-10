public class HashNode {
	private String key;
	private int value;
	private int hash;
	public HashNode next;
	
	public HashNode(String key) {
		this.key = key;
		this.value=0;
		hash = generateHash();
		next = null;
	}
	
	public int generateHash() {
		return hashCode(key);
	}
	
	public int hashCode(String key) {
		int h;
		h = (key.length()+26*key.charAt(0)+31*key.charAt(key.length()-1))%50;
		return h;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getHash() {
		return hash;
	}

	
}

