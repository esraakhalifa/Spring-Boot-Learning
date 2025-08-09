package org.example;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Student {

    private int rollNo;
    private String sName;
    private int sAge;
    @Autowired
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

    public void coding()
    {
        System.out.println("Student is coding.");
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
