package com.driver;

import java.util.PriorityQueue;

public class CurrentAccount extends BankAccount{
    private String tradeLicenseId; //consists of Uppercase English characters only

    //--------------Constructor-----------------
    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount() {
    }

    //------------- Getter and Setter----------------


    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    //------------ Other Dunctions----------------

//    public void validateLicenseId() throws Exception {
//        // A trade license Id is said to be valid if no two consecutive characters are same
//        // If the license Id is valid, do nothing
//        // If the characters of the license Id can be rearranged to create any valid license Id
//        // If it is not possible, throw "Valid License can not be generated" Exception'
//        char[]arr=tradeLicenseId.toCharArray();
//        if(isValid(arr)) return;
//        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
//            return b.freq-a.freq;
//        });
//        int[] freq =new int[26];
//        int n=arr.length;
//        for (char c : arr) {
//            freq[c - 'A']++;
//        }
//        for(int i=0;i<26;i++){
//            if(freq[i]!=0){
//                pq.add(new Pair((char) (i + 'A'), freq[i]));
//            }
//        }
//        StringBuilder sb=new StringBuilder();
//        while(!pq.isEmpty()){
//            Pair p1=pq.remove();
//            sb.append(p1.c);
//            p1.freq--;
//            boolean flag=false;
//            if(!pq.isEmpty()){
//                Pair p2=pq.remove();
//                sb.append(p2.c);
//                p2.freq--;
//                flag=true;
//                if(p1.freq>0)pq.add(p1);
//                if(p2.freq>0)pq.add(p2);
//            }
//            if(flag) continue;
//            if(p1.freq>0)pq.add(p1);
//        }
//        String id=sb.toString();
//        char[]newArr=id.toCharArray();
//        if(isValid(newArr)) this.tradeLicenseId=id;
//        else throw new Exception("Valid License can not be generated");
//    }
//    private boolean isValid(char[]arr){
//        int n=arr.length;
//        for(int i=1;i<n;i++){
//            if(arr[i]==arr[i-1]) return false;
//        }
//        return true;
//    }
//    static class Pair{
//        char c;
//        int freq;
//
//        public Pair(char c, int freq) {
//            this.c = c;
//            this.freq = freq;
//        }
//
//    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        char [] charArray = this.tradeLicenseId.toCharArray();
        int i = 0;
        int j = i+1;

        while (i < charArray.length - 1 && j < charArray.length) {
            if (charArray[i] != charArray[j]) {
                i++;
                j++;
            }

            else {
                while (charArray[i] == charArray[j]) {
                    j++;
                    if (j >= charArray.length) throw new Exception("Valid License can not be generated");

                }

                char temp = charArray[i+1];
                charArray[i+1] = charArray[j];
                charArray[j] = temp;
                i++;
                j = i+1;
            }
        }

        String str = new String(charArray);
        this.tradeLicenseId = str;

    }

}
