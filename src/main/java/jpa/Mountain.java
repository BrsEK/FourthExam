package jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mountains")
public class Mountain extends BaseIdentify {
    private static final int VALID_NAME_LENGTH = 4;
    private static final int VALID_NAME_OF_COUNTRY = 4;
    private static final int VALID_HEIGHT = 100;


    public Mountain() {
    }

    public Mountain(String name, String country, int height) {
        setName(name);
        setCountry(country);
        setHeight(height);
    }

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private int height;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < VALID_NAME_LENGTH)
            throw new IllegalArgumentException("name length is not be less then 4");
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country.length() < VALID_NAME_OF_COUNTRY)
            throw new IllegalArgumentException("name of country is not be less then 4");
        this.country = country;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < VALID_HEIGHT)
            throw new IllegalArgumentException(" height is not be less then 100");
        this.height = height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                '}';
    }
}
