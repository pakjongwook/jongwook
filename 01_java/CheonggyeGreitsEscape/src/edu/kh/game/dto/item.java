package edu.kh.game.dto;

import java.util.Objects;

public class item {

	private String name;
	private int HP;
	
	public item() {}
	
	
	public item(String name, int hP) {
		super();
		this.name = name;
		HP = hP;
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getHP() {
		return HP;
	}


	public void setHP(int hP) {
		HP = hP;
	}


	@Override
	public String toString() {
		return "item [name=" + name + ", HP=" + HP + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(HP, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		item other = (item) obj;
		return HP == other.HP && Objects.equals(name, other.name);
	}
	
	
	
	
	
	
	
	
	
	
		
		
		
	

}
