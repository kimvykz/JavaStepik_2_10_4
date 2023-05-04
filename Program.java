import java.io.FileReader;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        //Scanner sc = new Scanner(System.in);


        double a, b;
        String oper, as, bs;




        try (FileReader fr = new FileReader("input.txt")) {
            Scanner sc = new Scanner(fr);

            as = sc.next() ;
            oper = sc.next();
            bs = sc.next();

            a = Double.parseDouble(as);
            b = Double.parseDouble(bs);
            if (!"-+*/".contains(oper)) {
                throw new UnsupportedOperationException("Operation Error!");
            }
            if (oper.equals("/") && b == 0.0) {
                throw new ArithmeticException("Error! Division by zero");
            }
            System.out.println(calc(a, b, oper));

        }
        catch (NumberFormatException nfEx) {
            System.out.println("Error! Not number");
        }
        catch (UnsupportedOperationException uoEx) {
            System.out.println("Operation Error!");
        }
        catch (ArithmeticException aEx) {
            System.out.println("Error! Division by zero");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    static double calc(double a, double b, String oper){
        double res = 0;
        if (oper.equals("+")) {
            res = a + b;
        }
        else if (oper.equals("-")) {
            res = a - b;
        }
        else if (oper.equals("*")) {
            res = a * b;
        }
        else if (oper.equals("/")) {
            res = a / b;
        }

        return res;

    }


}
