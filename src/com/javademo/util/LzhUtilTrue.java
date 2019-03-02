package com.javademo.util;

public class LzhUtilTrue {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}

	/**
	 * 滑动窗口
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		int[] index = new int[128]; // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			i = Math.max(index[s.charAt(j)], i);
			ans = Math.max(ans, j - i + 1);
			index[s.charAt(j)] = j + 1;
		}
		return ans;
	}

	/**
	 * 返回两个从小到大的有序数列的中位数
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		if (m > n) {
			int[] temps = nums1;
			nums1 = nums2;
			nums2 = temps;
			int temp = m;
			m = n;
			n = temp;
		}
		int i = m / 2, halfLen = (m + n + 1) / 2;// n >= m
		while (i <= m) {
			int j = halfLen - i;
			if (i > 0 && nums1[i - 1] > nums2[j]) {
				i--;
			}
			else if (i < m && nums2[j - 1] > nums1[i]) {
				i++;
			}
			else {
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = nums2[j - 1];
				}
				else if (j == 0) {
					maxLeft = nums1[i - 1];
				}
				else {
					maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
				}
				if ((m + n) % 2 > 0) {
					return maxLeft;
				}
				int minRight = 0;
				if (i == m) {
					minRight = nums2[j];
				}
				else if (j == n) {
					minRight = nums1[i];
				}
				else {
					minRight = Math.min(nums1[i], nums2[j]);
				}
				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}
	
	/**
	 * 计算最长子串且是回文
	 * 中心扩展算法
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
	    if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}
	
	public static String longestPalindromeDynamic(String s) {
		return "";
	}
	
	public static String longestPalindromeManacher(Stirng s) {
		
	}
}
