package chapter6;

public class Tasks extends ObjectWithKey {
	private String description;

	public Tasks(int key, String description) {
		super();
		super.setKey(key);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Tasks [description=" + description + "]";
	}

}
