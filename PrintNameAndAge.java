
import java.util.* ;
import java.io.*;
class Person {

    // Complete the class
    private String name;
    private int age;
    public Person(String n,int a){
        name=n;
        age=a;
    }
    //getter
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    //setter
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString(){
        return "The name of the person is "+this.name+" and the age is "+this.age+".";
    }
}

class Solution {

    public static void main(String args[]) {

        Scanner ob = new Scanner(System.in);
        String name = ob.nextLine();
        int age = ob.nextInt();
        Person p = new Person(name,age);
        System.out.println(p);
    }
}
