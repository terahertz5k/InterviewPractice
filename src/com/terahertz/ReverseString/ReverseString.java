package com.terahertz.ReverseString;

public class ReverseString {

    public static String reverseStringInPlaceWithStringBuilder(String text){
        StringBuilder sb = new StringBuilder(text);
        for(int i = 0; i < text.length()/2; i++){
            char temp = sb.charAt(i);
            int rightIndex = text.length() - 1 - i;
            sb.setCharAt(i, sb.charAt(rightIndex));
            sb.setCharAt(rightIndex, temp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
	// write your code here
        System.out.println(reverseStringInPlaceWithStringBuilder("LOLHIBBQSEX"));
        System.out.println(reverseStringInPlaceWithStringBuilder("123456789"));

    }
}
