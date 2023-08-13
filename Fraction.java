import java.util.* ;
import java.io.*;

class Fraction {
    int num;
    int deno;
    // Complete the class
    public Fraction(int num,int deno){
        this.num = num;
        this.deno = deno;
    }
    public int GCD(int a, int b) {
        if (b == 0) return a;
        else return (GCD (b, a % b));
    }
    public int LCM(int a,int b){
        return (a*b)/GCD(a,b);
    }
    public void add(Fraction f){
        int lcm = LCM(this.deno,f.deno);
        int num1 = lcm/this.deno;
        int num2 = lcm/f.deno;
        int numerator = num1*this.num + num2*f.num;
        this.num = numerator;
        this.deno = lcm;
    }
    public void multiply(Fraction f){
        this.num = this.num*f.num;
        this.deno = this.deno*f.deno;
    }
    public void simplify(){
        int d;
        d = GCD(this.num, this.deno);
        this.num = this.num / d;
        this.deno = this.deno / d;
    }
    public void print(){
        System.out.println(this.num+"/"+this.deno);
    }
}

class SolutionFraction {

    public static void main(String args[]) {

        Scanner ob = new Scanner(System.in);
        int a = ob.nextInt();
        int b = ob.nextInt();
        Fraction f1 = new Fraction(a,b);
        int t = ob.nextInt();
        while(t!=0){
            int query = ob.nextInt();
            int c = ob.nextInt();
            int d = ob.nextInt();
            Fraction f2 = new Fraction(c,d);
            switch(query){
                case 1:
                    f1.add(f2);
                    f1.simplify();
                    f1.print();
                    break;
                case 2:
                    f1.multiply(f2);
                    f1.simplify();
                    f1.print();
                    break;

            }
            t-=1;
        }

    }
}
