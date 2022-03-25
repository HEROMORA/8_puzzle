package com.puzzle;

public class Util {
   public static int [] getArrSequence(String sequence){
       int[] numbers = new int[9];
       
       for (int i = 0; i < 9; i++) {
           numbers[i] = sequence.charAt(i) - '0';
       }
       return numbers;
   }
   public static String getSequenceFromArr(String[] newStateArr)
   {
       return String.join("", newStateArr);
   }
}
