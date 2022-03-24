package com.puzzle;

public class Util {
    public static int [] getArrSequence(int sequence){
        String seq = String.valueOf(sequence);
        int[] numbers = new int[9];
        if(seq.length() < 9) {
            numbers[0] = 0;
        } else {
            numbers[0] = seq.charAt(0) - '0';
        }
        int start = (sequence < 100000000)? 0 : 1;
        for (int i = start; i < seq.length(); i++) {
            numbers[i] = seq.charAt(i) - '0';
        }
        return numbers;
    }
}
