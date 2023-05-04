import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        double a, b, res_;
        String oper, as, bs;

        try {
            FileReader fr = new FileReader("input.txt");
            FileWriter fw = new FileWriter("output.txt", false);

            int c;
            String sTemp;
            ArrayList<String> expressions = new ArrayList<>();
            while ((c = fr.read()) != -1) {
                sTemp = "" + (char) c;

                while ((c = fr.read()) != '\n' && c != -1) {
                    sTemp += (char)c;
                }
                expressions.add(sTemp);
            }
            fr.close();
            for (String exp : expressions) {
                sTemp = exp + " = ";
                try {

                    Scanner sc = new Scanner(exp);

                    as = sc.next();
                    oper = sc.next();
                    bs = sc.next();

                    a = Double.parseDouble(as);
                    b = Double.parseDouble(bs);
                    if (!"-+*/".contains(oper)) {
                        sTemp += "Operation Error!";
                        throw new UnsupportedOperationException("Operation Error!");
                    }
                    if (oper.equals("/") && b == 0.0) {

                        throw new ArithmeticException("Error! Division by zero");

                    }

                    res_ = calc(a, b, oper);
                    sTemp += res_;
                    fw.append(sTemp + "\n");
                    fw.flush();
                    System.out.println(sTemp);

                }

                catch (NumberFormatException nfEx) {
                    sTemp += "Error! Not number";
                    fw.append(sTemp + "\n");
                    fw.flush();
                    System.out.println("Error! Not number");


                }
                catch (UnsupportedOperationException uoEx) {
                    sTemp += "Operation Error!";
                    fw.append(sTemp + "\n");
                    fw.flush();
                    System.out.println("Operation Error!");
                }
                catch (ArithmeticException aEx) {
                    sTemp += "Error! Division by zero";
                    fw.append(sTemp + "\n");
                    fw.flush();
                    System.out.println("Error! Division by zero");
                }


            }

            fw.close();

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
