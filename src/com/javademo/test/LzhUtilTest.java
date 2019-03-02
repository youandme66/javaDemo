package com.javademo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.javademo.util.ListNode;
import com.javademo.util.LzhUtil;
import com.javademo.util.LzhUtilTrue;

public class LzhUtilTest {

	@Test
	public void testTwoSum() {
		int[] nums = new int[] { 2, 7, 11, 15 };
		int[] nums1 = new int[] { 3, 2, 4 };
		assertArrayEquals(new int[] { 0, 1 }, LzhUtil.twoSum(nums, 9));
		assertArrayEquals(new int[] { 1, 2 }, LzhUtil.twoSum(nums1, 6));
	}

	@Test
	public void testAddTwoNumbers() {
		ListNode li1 = new ListNode(2);
		li1.next = new ListNode(4);
		li1.next.next = new ListNode(3);
		ListNode li2 = new ListNode(5);
		li2.next = new ListNode(6);
		li2.next.next = new ListNode(4);
		ListNode result = LzhUtil.addTwoNumbers(li1, li2);
		assertArrayEquals(new int[] { 7, 0, 8 }, new int[] { result.val, result.next.val, result.next.next.val });
	}

	@Test
	public void testLengthOfLongestSubstring() {
		String s = "abcbbac";
		assertEquals(3, LzhUtil.lengthOfLongestSubstring(s));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testFindMedianSortedArrays() {
		int[] nums1 = new int[] { 1, 5, 6, 10 };
		int[] nums2 = new int[] { 2, 4, 8, 9 };
		int[] nums3 = new int[] { 1, 3 };
		int[] nums4 = new int[] { 2 };
		//		assertEquals(5.5, LzhUtil.findMedianSortedArrays(nums1, nums2));
		assertEquals(5.5, LzhUtilTrue.findMedianSortedArrays(nums3, nums4));
	}

	@Test
	public void testLongestPalindrome() {
		assertEquals("bab", LzhUtil.longestPalindrome("babad"));
		assertEquals("", LzhUtil.longestPalindrome(""));
		assertEquals("aba", LzhUtil.longestPalindrome("abaagasdfa"));
		assertEquals("bcadndacb", LzhUtil.longestPalindrome("abacbcadndacb"));
		assertEquals("bb", LzhUtil.longestPalindrome("cbba"));
	}
}
