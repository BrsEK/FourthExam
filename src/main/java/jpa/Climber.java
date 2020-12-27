package jpa;

import javax.persistence.*;

@Entity
@Table(name = "climbers")
public class Climber extends BaseIdentify {

    private static final int VALID_NAME_LENGTH = 3;
    private static final int VALID_ADDRESS_LENGTH = 5;
    private static final int VALID_AGE = 18;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private int age;



    public Climber() {
    }

    public Climber(String name, String address, int age) {
        setName(name);
        setAddress(address);
        setAge(age);
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        if (name.length() < VALID_NAME_LENGTH)
            throw new IllegalArgumentException("name length is not be less then 3");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.length() < VALID_ADDRESS_LENGTH)
            throw new IllegalArgumentException("address length is not be less then 5");
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < VALID_AGE)
            throw new IllegalArgumentException("Age is not be less then 18");
        this.age = age;
    }


    @Override
    public String toString() {
        return "Climber{" +
                "name='" + name + '\'' +
                '}';
    }
}
