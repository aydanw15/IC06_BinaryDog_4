import java.io.Serializable;

// turns on switch to allow Dogs to be written in binary
public class Dog implements Serializable

{
	
	private String mName;
	private String mBreed;
	private double mAge;

	// Parameterized constructor
	public Dog(String name, String breed, double age)
	{
		mName = name;
		mBreed = breed;
		mAge = age;
	}

	// Copy constructor
	public Dog(Dog otherDog)
	{
		mName = otherDog.mName;
		mBreed = otherDog.mBreed;
		mAge = otherDog.mAge;
	}

	public double getAge() {
		return mAge;
	}

	public String getName() {
		return mName;
	}

	public String getBreed() {
		return mBreed;
	}

	public void setAge(double newAge) {
		mAge = newAge;
	}

	public void setName(String newName) {
		mName = newName;
	}

	public void setBreed(String newBreed) {
		mBreed = newBreed;
	}

	public double ageInHumanYears() {
		if(mAge <= 2)
			return mAge * 11;
		else 
			return (mAge - 2) * 5 + 22;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Dog))
			return false;
		Dog other = (Dog) obj;

		return (mName.equals(other.mName)
		 && mBreed.equals(other.mBreed)
		 && Double.compare(mAge, other.mAge) == 0);
	}

	@Override
	public String toString() {
		return "Dog [name=" + mName + ", breed=" + mBreed + ", age=" + mAge + "]";
	}

}
