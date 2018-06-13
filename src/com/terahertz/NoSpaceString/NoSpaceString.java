package com.terahertz.NoSpaceString;

import java.util.HashSet;
import java.util.Set;

public class NoSpaceString {

    private static boolean breakWordsDP(Set<String> dict, String noSpaces){
        int T[][] = new int[noSpaces.length()][noSpaces.length()];
        int[][] Y = new int[noSpaces.length()][noSpaces.length()];

        for(int i = 0; i < noSpaces.length(); i++){
            for( int j = 0; j < noSpaces.length(); j++){
                T[i][j] = -1;
            }
        }

        //First loop l is for how many characters we are looking at at a time
        for(int l = 1; l <= noSpaces.length(); l++){
            //i and j are the left and right indexes
            for(int i = 0; i < noSpaces.length() - l + 1; i++){
                int j = i + l-1;
                String str = noSpaces.substring(i, j+1);
                //Check if it's in the dictionary
                if(dict.contains(str)){
                    T[i][j] = i;
                    continue;
                }

                //Find k between i and j such that T[i][k-1] and T[k][j] are both true
                //Finding split point where both sides are words
                for(int k = i+1; k <= j; k++){
                    if(T[i][k-1] != -1 && T[k][j] != -1){
                        T[i][j] = k;
                        break;
                    }
                }
            }
        }

        if(T[0][noSpaces.length()-1] == -1){
            return false;
        } else {
            return true;
        }



    }

    public static void main(String[] args) {
	// write your code here
        Set<String> dictionary = new HashSet<>();
        dictionary.add("pea");
        dictionary.add("nut");
        dictionary.add("peanut");
        dictionary.add("but");
        dictionary.add("butt");
        dictionary.add("butter");

        String init = "peanutbutter";

        System.out.println(breakWordsDP(dictionary, init));

    }
}
