package model;

public abstract class Account {
	
	private String username;
	private String name;
	private String password;
	private String birthdate;
	private String gender;
	private int height;
	private int weight;
	
	public Account(String username, String name, String password, String birthdate, String gender, int height,
			int weight) {
		this.username = username;
		this.name = name;
		this.password = password;
		this.birthdate = birthdate;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	
	
}
