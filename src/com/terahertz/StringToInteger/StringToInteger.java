package com.terahertz.StringToInteger;

public class StringToInteger {

    //works
    private static int countingMultiply(String number){
        boolean negative = false;
        int count = 0;
        int i = 0;
        if(number.charAt(0) == '-'){
            negative = true;
            i++;
        }

        for(; i < number.length(); i++){
            count *= 10;
            count += number.charAt(i) - '0'; //subtracting '0' converts the ascii value to a digit
        }

        if(negative){
            count *= -1;
        }

        return count;
    }

    public static void main(String[] args) {
        // write your code here

        System.out.println(countingMultiply("1001"));
        System.out.println(countingMultiply("-1001"));
    }
}
