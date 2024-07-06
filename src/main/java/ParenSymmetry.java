import java.io.*;

public class ParenSymmetry {


    private Boolean isBalanced(String s) {// implement this method
        int count = 0;
        for (char c : s.toCharArray()){
            if (c == '(') count++;// count forward with (, backward with ), should be 0 if balanced
            if (c == ')') count--;
        }
        return count == 0;
    }

    private void checkFile(String filename) throws IOException {
        // open file named filename
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;//         for each line in the file
        while ((line = reader.readLine()) != null) {// read the line
            System.out.println(isBalanced(line));// print whether or not the line's parenthesis are balanced
        }
        reader.close();// count forward with (, backward with ), should be 0 if balanced
    }






    public static void main(String[] args) throws IOException {
        ParenSymmetry ps = new ParenSymmetry();


        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

        ps.checkFile("TestStrings0.txt");

    }


        private static void printResult (Boolean b0,boolean b){
            if (b0 == null) {
                System.out.println("Null Failure");
                return;
            }
            if (b0 == b) {
                System.out.println("Success");
            } else {
                System.out.println("Failure");
            }
        }
    }

