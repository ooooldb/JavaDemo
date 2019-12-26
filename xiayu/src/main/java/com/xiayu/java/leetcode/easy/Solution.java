package com.xiayu.java.leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    /*
        给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
        不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     */
    public static int removeDuplicates(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                length++;
                continue;
            }
            if (nums[i] != nums[length - 1]) {
                swap(nums, length, i);
                length++;
            }
        }
        return length;
    }

    /*
        27. 移除元素
        给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
        不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
        元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     */
    public static int removeElement(int[] nums, int val) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                swap(nums, length, i);
                length++;
            }
        }
        return length;
    }

    /*
        28. 实现 strStr()
        实现 strStr() 函数。
        给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出
        needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     */
    public static int strStr(String haystack, String needle) {
        int length = haystack.length();
        int needleLength = needle.length();
        if (needleLength == 0) {
            return 0;
        }
        for (int i = 0; i < length; i++) {
            boolean isSuccess = false;
            for (int j = 0; j <= needleLength && j + i <= length; j++) {
                if (j == needleLength) {
                    isSuccess = true;
                    break;
                }
                if (j + i == length || (haystack.charAt(i + j) != needle.charAt(j))) {
                    break;
                }
            }
            if (isSuccess) {
                return i;
            }
        }
        return -1;
    }

    /*
        35
        给定一个排序数组和一个目标值，在数组中找到目标值，
        并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        int i = (low + high) / 2;
        for (; low < high; i = (low + high) / 2) {
            if (target > nums[i]) {
                low = i + 1;
            } else if (target == nums[i]) {
                break;
            } else {
                high = i - 1 >= 0 ? i - 1 : i;
            }
        }
        int min = i - 1 > 0 ? i - 1 : i;
        int max = i + 1 >= nums.length ? i : i + 1;
        for (int j = min; j <= max; j++) {
            if (target > nums[j]) {
                i = j + 1;
            }
        }
        return i;
    }

    private static void swap(int[] arr, int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }

    /*
        38.报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

        1.     1
        2.     11
        3.     21
        4.     1211
        5.     111221
        1 被读作  "one 1"  ("一个一") , 即 11。
        11 被读作 "two 1s" ("两个一"）, 即 21。
        21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

        给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

        注意：整数顺序将表示为一个字符串。
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String string = countAndSay(n - 1);
        int strLength = string.length();
        String res = "";
        int length = 1;
        for (int i = 1; i < strLength; i++) {
            if (string.charAt(i) != string.charAt(i - 1)) {
                res += length + "" + string.charAt(i - 1);
                length = 1;
            } else {
                length++;
            }
        }
        res += length + "" + string.charAt(strLength - 1);
        return res;
    }

    /*
        53.
        给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     */
    public int maxSubArray(int[] nums) {

        return 0;
    }

    /*
        58. 最后一个单词的长度
        给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

        如果不存在最后一个单词，请返回 0 。

        说明：一个单词是指由字母组成，但不包含任何空格的字符串。

     */
    public static int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int i = s.lastIndexOf(" ");
        if (i != -1) {
            if (s.length() - i - 1 == 0) {

            }
            return s.length() - i - 1;
        }
        return 1;
    }

    public static int getLength(String s, int endLength) {
        int length = 0;
        for (int i = endLength; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            } else {
                length++;
            }
        }
        if (length == 0) {
            return getLength(s, endLength - 1);
        }
        return length;
    }

    /*
        66. 加一
        给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

        最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

        你可以假设除了整数 0 之外，这个整数不会以零开头。
     */
    public int[] plusOne(int[] digits) {
        int length = digits.length - 1;
        for (int i = length; i >= -1; i--) {
            if (i == -1) {
                int[] tmp = new int[length + 2];
                System.arraycopy(digits, 0, tmp, 1, length + 1);
                tmp[0] = 1;
                digits = tmp;
                break;
            }
            if (!add(digits, i)) {
                break;
            }
        }
        return digits;
    }

    public boolean add(int[] arr, int index) {
        if (arr[index] == 9) {
            arr[index] = 0;
            return true;
        } else {
            arr[index]++;
            return false;
        }
    }

    /*
        67. 二进制求和
        给定两个二进制字符串，返回他们的和（用二进制表示）。

        输入为非空字符串且只包含数字 1 和 0。
     */
    public String addBinary(String a, String b) {
        String res = a.length() > b.length() ? a : b;
        int length = res.length();
        boolean isAdd = false;
        for (int i = length; i >= -1; i--) {
            if (i == -1) {
                return "1" + res;
            }
            int aIndex = a.length() - (res.length() - length);
            char aValue = aIndex >= 0 ? a.charAt(aIndex) : '0';
            int bIndex = b.length() - (res.length() - length);
            char bValue = bIndex >= 0 ? b.charAt(bIndex) : '0';
            if (aValue == '1') {
                
            }
        }
        return "";
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test27() {
        int[] arr = {3, 2, 2, 3};
        removeElement(arr, 3);
        System.out.println("a");
    }

    @Test
    public void test28() {
        System.out.println(strStr("mississippi", "mississippi"));
    }

    @Test
    public void test35() {
        int[] arr = {1, 3, 5, 6};
        System.out.println(searchInsert(arr, 5));
        System.out.println(searchInsert(arr, 2));
        System.out.println(searchInsert(arr, 7));
        System.out.println(searchInsert(arr, 0));
        int[] arr1 = {1, 3};
        System.out.println(searchInsert(arr1, 2));
        int[] arr2 = {3, 5, 7, 9, 10};
        System.out.println(searchInsert(arr2, 8));
    }

    @Test
    public void test38() {
        System.out.println(countAndSay(5));
    }

    @Test
    public void test58() {
        System.out.println(lengthOfLastWord("a "));
    }

    @Test
    public void test66() {
        int[] arr = {7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1,
                1, 1, 7, 4, 0, 0, 6};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
}