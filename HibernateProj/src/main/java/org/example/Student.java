package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    private int rollNo;
    private String sName;
    private int sAge;
    @OneToMany(mappedBy = "student")
    private List<Laptop> laptops;

    public int getRollNo() {
        return rollNo;
    }

    public int getsAge() {
        return sAge;
    }

    public String getsName() {
        return sName;
    }

    public void setRollNo(int rollNo)
    {
        this.rollNo = rollNo;
    }

    public   void setsAge(int sAge)
    {
        this.sAge = sAge;
    }

    public void setsName(String sName)
    {
        this.sName = sName;
    }


    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                ", laptops=" + laptops +
                '}';
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }


}
