import java.util.* ;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Polynomial{
    // Don't change this name.
    public int coef[]= new int[200];  // name of the array -> coefficients

    int capacity=200;

    // Complete the class.


    public Polynomial(int c, int d) {

        this.coef[d] = c;
    }

    public Polynomial(Polynomial p) {
        Polynomial copyPoly = p;
    }
    // Overload the 'plus' , 'minus', and 'times' function used for adding, subtracting and multiplying polynomials.
    public Polynomial plus(Polynomial p){

        Polynomial plusPoly = new Polynomial(0, 0);
        for(int i=0;i<capacity;i++){
            plusPoly.coef[i]=this.coef[i]+p.coef[i];
        }

        return plusPoly;
    }

    public Polynomial minus(Polynomial p){
        Polynomial minusPoly = new Polynomial(0, 0);
        for(int i=0;i<capacity;i++){
            minusPoly.coef[i]=this.coef[i]-p.coef[i];
        }

        return minusPoly;
    }

    public Polynomial times(Polynomial p){
        Polynomial timesPoly = new Polynomial(0, 0);
        for(int i=0;i<this.capacity;i++){
            for(int j=0;j<p.capacity;j++){
                if((i+j)<200){
                    if(timesPoly.coef[i+j]!=0){
                        timesPoly.coef[i+j]=timesPoly.coef[i+j]+this.coef[i]*p.coef[j];
                    }
                    else{
                        timesPoly.coef[i+j]=this.coef[i]*p.coef[j];
                    }
                }
            }
        }

        return timesPoly;
    }

    public void print(){
        for(int i=0;i<capacity;i++){
            if(this.coef[i]!=0){
                System.out.print(this.coef[i]+"x"+i+" ");
            }
        }
    }
}

class SolutionPolyNomial {
    // test client
    public static void main( String[] args ) throws IOException {

        int count1, count2, choice;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count1 = Integer.parseInt(br.readLine().split(" ")[0]);

        int[] degree1 = new int[count1];
        int[] coeff1 = new int[count1];

        String nm[] = br.readLine().split(" ");
        for (int i = 0; i < count1; i++) {
            degree1[i] = Integer.parseInt(nm[i]);
        }

        nm = br.readLine().split(" ");
        for (int i = 0; i < count1; i++) {
            coeff1[i] = Integer.parseInt(nm[i]);
        }

        Polynomial first = new Polynomial(0,0);
        for (int i = 0; i < count1; i++) {
            first = first.plus(new Polynomial(coeff1[i],degree1[i]));
        }

        count2 = Integer.parseInt(br.readLine().split(" ")[0]);

        int[] degree2 = new int[count2];
        int[] coeff2 = new int[count2];

        nm = br.readLine().split(" ");
        for (int i = 0; i < count2; i++) {
            degree2[i] = Integer.parseInt(nm[i]);
        }

        nm = br.readLine().split(" ");
        for (int i = 0; i < count2; i++) {
            coeff2[i] = Integer.parseInt(nm[i]);
        }

        Polynomial second = new Polynomial(0,0);
        for (int i = 0; i < count2; i++) {
            second = second.plus(new Polynomial(coeff2[i],degree2[i]));
        }

        choice = Integer.parseInt(br.readLine().split(" ")[0]);

        Polynomial result = new Polynomial(0,0);
        switch (choice) {
            // Add
            case 1 : {
                result = first.plus(second);
                result.print();
                break;
            }
            // Subtract
            case 2 : {
                result = first.minus(second);
                result.print();
                break;
            }
            // Multiply
            case 3 : {
                result = first.times(second);
                result.print();
                break;
            }
            case 4 : // Copy constructor
            {
                Polynomial third = new Polynomial(first);
                if (third.coef == first.coef) {
                    System.out.println("false");
                } else {
                    System.out.println("true");
                }
                break;
            }
            case 5 : // Copy assignment operator
            {
                Polynomial fourth = new Polynomial(first);
                if (fourth.coef == first.coef) {
                    System.out.println("false");
                } else {
                    System.out.println("true");
                }
                break;
            }
        }
    }
}