package model;

public class Person {
    protected int id;
    protected String name;
    protected int age;
    protected String bloodGroup;
    protected String phone;

    public Person(int id, String name, int age, String bloodGroup, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getPhone() {
        return phone;
    }

    public void showDetails() {
        System.out.println("ID         : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("BloodGroup : " + bloodGroup);
        System.out.println("Phone      : " + phone);
    }
}