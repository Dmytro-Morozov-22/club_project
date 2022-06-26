package com.ua.lviv.club;

public class Animal {
	private String animalKind;
	private String animalName;

	public Animal(String animalKind, String animalName) {
		super();
		this.animalKind = animalKind;
		this.animalName = animalName;
	}

	public String getAnimalKind() {
		return animalKind;
	}

	public void setAnimalKind(String animalKind) {
		this.animalKind = animalKind;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((animalKind == null) ? 0 : animalKind.hashCode());
		result = prime * result
				+ ((animalName == null) ? 0 : animalName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (animalKind == null) {
			if (other.animalKind != null)
				return false;
		} else if (!animalKind.equals(other.animalKind))
			return false;
		if (animalName == null) {
			if (other.animalName != null)
				return false;
		} else if (!animalName.equals(other.animalName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Animal [animalKind=" + animalKind + ", animalName=" + animalName
				+ "]";
	}


	
	
}
