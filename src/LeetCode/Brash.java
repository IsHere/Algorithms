package LeetCode;

import java.util.Arrays;

public class Brash {
    public static void main(String[] args) {

    }

    public static void nextPermutation(int[] nums) {
        boolean flag = true;
        for (int i = nums.length-1; i >0 ; i--) {
            if (nums[i-1]<nums[i]){
                flag=false;
                int larger = nums[i];
                int min = nums[i-1];
                int index = i;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j]>min && nums[j]<larger){
                        larger = nums[j];
                        index = j;

                    }
                }
                swapArray(nums,i-1,index);
                Arrays.sort(nums,i,nums.length);
                break;
            }
        }
        if (flag){
            Arrays.sort(nums);
        }
    }

    public static void swapArray(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
