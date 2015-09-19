package com.ndieksdroid.calc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Calc {
    public static Character[] OPERATORS={'/','X','+','-'};

    public static final String REGEXOPERATORS="[/+,-,/X,//,-]";
    public static final String REGEXDIGITS="(\\d+)";

    public static ArrayList<Character> operators=new ArrayList<Character>();
    public static ArrayList<Integer> digits=new ArrayList<Integer>();

    public Calc(){


    }

    public String solve(String math){
        //math="4+8+9";
        operators.clear();
        digits.clear();

        getDigits(math);
        getOperators(math);
        //get highest level sign
        getNextOperator(operators);
        Iterator<Integer> i=digits.iterator();
        while (i.hasNext()) {
            return String.valueOf(i.next());
        }
        return "Brian";
    }

    private static void getNextOperator(ArrayList<Character> operators) {
        for (Character op:OPERATORS) {

            A:for (int i = 0; i < operators.size(); i++) {

                if (operators.get(i) =='/') {
                    operators.remove(i);
                    digits.set(i, (digits.get(i) / digits.get(i + 1)));
                    digits.remove(i + 1);
                    i -= 1;
                    continue A;
                }
            }

            B:for (int i = 0; i < operators.size(); i++) {

                if (operators.get(i) =='X') {
                    //System.out.println("if in for");
                    operators.remove(i);
                    digits.set(i, (digits.get(i) * digits.get(i + 1)));
                    digits.remove(i + 1);
                    i -= 1;
                    continue B;
                }
            }
            for (int i = 0; i < operators.size(); i++) {

                if (operators.get(i) =='+') {
                //System.out.println("if in for");
                    operators.remove(i);
                    digits.set(i, (digits.get(i) + digits.get(i + 1)));
                    digits.remove(i + 1);
                    i -= 1;
                    continue;
                }
            }
            for (int i = 0; i < operators.size(); i++) {

                if (operators.get(i) =='-') {
                    operators.remove(i);
                    digits.set(i, (digits.get(i) - digits.get(i + 1)));
                    digits.remove(i + 1);
                    i -= 1;
                    continue;
                }
            }
        }

        //getNextOperator(operators);
    }


    public static void getDigits(String math){
        //System.out.println("Getting digits ...");

        Pattern r=Pattern.compile(REGEXDIGITS);
        Matcher m=r.matcher(math);
        while (m.find()){
            int t=Integer.parseInt(math.substring(m.start(), m.end()));
            //System.out.println(t);
            digits.add(t);
        }
        //System.out.println("\rFinished getting digits...");
    }
    public static void getOperators(String math){
        //System.out.println("Getting Operators..");
        Pattern r=Pattern.compile(REGEXOPERATORS);
        Matcher m=r.matcher(math);
        while (m.find()){
            operators.add(math.charAt(m.start()));
        }
        //System.out.println("Finished getting Operators..");

    }


}
