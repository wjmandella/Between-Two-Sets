// My solution to the HackerRank problem "Between Two Sets." (Note: this solution does NOT require the use of LCM and GCD.)
// https://www.hackerrank.com/challenges/between-two-sets/problem

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BetweenTwoSetsApp {
    static int getTotalX(int[] a, int[] b) {
    	Arrays.sort(a);
    	int maxNbrA = a[a.length-1];
    	int minNbrA = a[0];
    	
    	Arrays.sort(b);
    	int maxNbrB = b[b.length-1];
    	int minNbrB = b[0];
    	
    	int maxNbr = Math.max(maxNbrA, maxNbrB);
    	int minNbr = Math.min(minNbrA, minNbrB);
    	
    	ArrayList<Integer>tempArray1 = new ArrayList<>();
    	ArrayList<Integer>tempArray2 = new ArrayList<>();
    	
    	for(int i = minNbr; i <= maxNbr; i++) {
    		tempArray1.add(i);
    	}
    	
    	for(int n = 0; n <(tempArray1.size()-1); n++) {
    		for(int i = 0; i < a.length; i++) {
    			if(tempArray1.get(n) % a[i] != 0) {
    				tempArray1.remove(n);
    			}
    		}
    	}
    	
    	for(int j = 0; j < b.length; j++) {
    		for(int m = 0; m < (tempArray1.size()); m++) {
    			if(tempArray1.get(m) != null) {
    				if(b[j] % tempArray1.get(m) != 0) {
    					tempArray1.set(m, null);
    					continue;
    				}
    			}	
    		}
    	}
    	
    	for(int i = 0; i < tempArray1.size(); i++) {
    		if(tempArray1.get(i) != null) {
    			tempArray2.add(tempArray1.get(i));				
    		}
    	}

    	System.out.println(tempArray2.toString());   		    	
    	System.out.println("Temp Array 2: " + tempArray2.toString());
    	int total = tempArray2.size();
    	return total;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements of set A: ");
        int n = in.nextInt();
        System.out.print("Enter the number of elements of set B: ");
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            System.out.print("Enter an element of set A: ");
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            System.out.print("Enter an element of set B: ");
            b[b_i] = in.nextInt();           
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}



