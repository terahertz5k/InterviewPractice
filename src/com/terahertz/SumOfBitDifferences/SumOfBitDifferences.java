package com.terahertz.SumOfBitDifferences;

public class SumOfBitDifferences {

    private static int sumOfBitDifferences(int[] array){

        int sum = 0;

        //scan all bits
        for(int i = 0; i < 32; i++){
            int sumForBit = 0;

            //for every int in the array
            for (int number : array) {
                //check the bit at i
                if ((number & (1 << i)) == 0) {
                    sumForBit++;
                }
            }
            //add sum of bit set * sum of bit not set * 2
            //multiply by 2 because of the symmetrical pattern
            //of the bit differences that appears because of the
            //reversed pairs such as (1,2) and (2,1)
            sum += sumForBit * (array.length - sumForBit) * 2;
        }

        return sum;
    }

    public static void main(String[] args){
        int[] array = {1,3,5,9,11};
        System.out.println(sumOfBitDifferences(array));
    }
}
