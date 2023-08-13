import java.util.* ;
import java.io.*;
import java.util.Scanner;

class ComplexNumbers {
    // Write your code here
    int real;
    int imag;
    public ComplexNumbers(int real,int imag){
        this.real = real;
        this.imag = imag;
    }
    public void plus(ComplexNumbers c){
        this.real = this.real + c.real;
        this.imag = this.imag + c.imag;
    }

    public void multiply(ComplexNumbers c){
        int updatedReal = this.real * c.real - (this.imag*c.imag);
        //imag must use old real value not updatedReal
        this.imag = this.real *c.imag + this.imag*c.real;
        this.real = updatedReal;
    }
    public void print(){
        System.out.println(this.real+" + "+"i"+this.imag);
    }
}

class SolutionComplexNumbers {

    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);
        int real1=0,imag1=0;
        real1 = ob.nextInt();
        imag1 = ob.nextInt();
        ComplexNumbers c1 = new ComplexNumbers(real1, imag1);

        int real2=0,imag2=0;
        real2 = ob.nextInt();
        imag2 = ob.nextInt();
        ComplexNumbers c2 = new ComplexNumbers(real2, imag2);

        int operation = ob.nextInt();
        switch(operation){
            case 1:
                c1.plus(c2);
                c1.print();
                break;

            case 2:
                c1.multiply(c2);
                c1.print();
                break;


        }
    }
}
