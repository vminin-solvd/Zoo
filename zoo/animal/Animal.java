package zoo.animal;

public abstract class Animal {

    private String location;
    private Sex sex;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public abstract void makeSound();
}
