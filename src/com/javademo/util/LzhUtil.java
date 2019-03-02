package com.javademo.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LzhUtil {
	public static void main(String[] args) {
		ceshiMapPutReturn();
		int[] nums1 = new int[] { 1, 5, 6, 10 };
		int[] nums2 = new int[] { 2, 4, 8, 9 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
		;
	}

	/**
	 * 测试map返回值
	 */
	public static void ceshiMapPutReturn() {
		LinkedHashMap<String, String> link = new LinkedHashMap<String, String>();
		System.out.println(link.put("a", "1"));
		System.out.println(link.put("a", "2"));
		System.out.println(link.get("a"));
	}

	/**
	 * 在一个数组中找到两个数相加得到目标数
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	/**
	 * 两个各自形成单向链表的数相加
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			if (l1 == null)
				return l2;
		}
		int val1 = l1.val, val2 = l2.val;
		ListNode result = null;
		ListNode tempResult = null;
		boolean isForward = false;
		do {
			int calcResult = val1 + val2 + (isForward ? 1 : 0);
			int currentNum;
			isForward = calcResult > 9;
			currentNum = isForward ? calcResult - 10 : calcResult;
			if (result == null) {
				tempResult = result = new ListNode(currentNum);
			}
			else {
				tempResult = tempResult.next = new ListNode(currentNum);
			}
			if (l1 != null && l1.next != null) {
				l1 = l1.next;
				val1 = l1.val;
			}
			else {
				val1 = 0;
				l1 = null;
			}
			if (l2 != null && l2.next != null) {
				l2 = l2.next;
				val2 = l2.val;
			}
			else {
				val2 = 0;
				l2 = null;
			}
		}
		while (l1 != null || l2 != null);
		if (isForward) {
			tempResult.next = new ListNode(1);
		}
		return result;
	}

	/**
	 * 给定一个字符串找出其中不含有重复字符的最长子串的长度
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			}
			else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int allLength = nums1.length + nums2.length;
		int index = (int) Math.round(allLength / 2.0);
		int temp;
		int first = 0;
		for (int i = 0; i < nums1.length;) {
			for (int j = 0; j < nums2.length;) {
				if (nums1[i] >= nums2[j]) {
					temp = nums2[j];
					j++;
				}
				else {
					temp = nums1[i];
					i++;
				}
				if (i + j == index) {
					if (allLength % 2 > 0) {
						return temp;
					}
					first = temp;
					continue;
				}
				else if (i + j == index + 1) {
					return (first + temp) / 2.0;
				}
			}
		}
		return 0;
	}

	/**
	 * 找出一个字符串最长的回文子串
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		if("".equals(s)) {
			return s;
		}
		String[] ss = s.split("");
		int ans = 0;
		int start = 0;
		int end = 0;
		for (int i = 1; i < ss.length - 1; i++) {
			int len = -1;
			for (int j = i, k = i; j >= 0 && k < ss.length;) {
				if (ss[j].equals(ss[k])) {
					len++;
					j--;
					k = 2*i -j;
				} else {
					break;
				}
			}
			if(len > ans) {
				start = i - len;
				end = i + len;
				ans = len;
			}
		}
		return s.substring(start, end + 1);
	}
}
