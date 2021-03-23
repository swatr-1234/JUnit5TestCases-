package com.gslab.JUnit5.execution;

public class StringHelper {

    public String reverse(String input){
        if(input == null){
            return null;
        }
        if("".equals( input )){
            return "";
        }
        char []ch = input.toCharArray();
        int start = 0;
        int end = ch.length-1;
        while(start<end){
            char temp=ch[start];
            ch[start]=ch[end];
            ch[end]=temp;
            start++;
            end--;

        }
        return new String(ch);
    }
}
