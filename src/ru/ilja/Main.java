package ru.ilja;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        //comment
        String expression = null;
        try {
            expression = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(expression," ",false);

            String token = null;
            double next;
            double nextnext;
            double result;

            Deque<Double>doubleDeque = new ArrayDeque<>();


            while(stringTokenizer.hasMoreTokens()) {
                token = stringTokenizer.nextToken();
                switch (token) {
                    case "+":
                        next = doubleDeque.pop();
                        nextnext = doubleDeque.pop();
                        result = next + nextnext;
                        doubleDeque.push(result);
                        break;
                    case "-":
                        next = doubleDeque.pop();
                        nextnext = doubleDeque.pop();
                        result = nextnext - next;
                        doubleDeque.push(result);
                        break;
                    case "/":
                        next = doubleDeque.pop();
                        nextnext = doubleDeque.pop();
                        if (next == 0) {
                            throw new IllegalArgumentException("Argument 'divisor' is 0");
                        }
                        result = nextnext / next;
                        doubleDeque.push(result);
                        break;
                    case "*":
                        next = doubleDeque.pop();
                        nextnext = doubleDeque.pop();
                        result = next * nextnext;
                        doubleDeque.push(result);
                        break;
                    default:
                        doubleDeque.push(Double.parseDouble(token));
                        break;
                }

            }


            if (doubleDeque.size()!=1){
                throw  new IllegalArgumentException("Expression not correct: too many arguments");
            }
            System.out.println(doubleDeque.peek());


        } catch (IOException e) {
            System.out.println("Exception " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Exception " + e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Exception " + e.getMessage());
        } catch (EmptyStackException e){
            System.out.println("Exception " + "Expression not correct: too many operations");
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
