package hometask9;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {


    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
        int[] ints = {1, 4, 5, 6, 7, 3};
        System.out.println(containsDuplicate(ints));
        System.out.println(Arrays.toString(twoSum(ints, 8)));
    }

    //DONE
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) return false;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) left++;
            else if (!Character.isLetterOrDigit(s.charAt(right))) right--;
            else {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;

            }
        }
        return true;

    }

    //DONE
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> ints = new HashSet<>();
        for (int num : nums) {
            if (!ints.contains(num)) {
                ints.add(num);
            } else return true;
        }
        return false;
    }

    //DONE
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> ints = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!ints.containsKey(nums[i])) {
                ints.put(target - nums[i], i);
            } else return new int[]{ints.get(nums[i]), i};
        }
        return new int[0];
    }
}
