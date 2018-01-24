package com.kinkor.JUtils.Interface;

/**
 * 数据结构 - 内排序
 * 
 * @author Guohui Zhou
 * @version 0.0.1
 *
 */
public interface ISort<T> {
	
	/**
	 * 插入排序 - 直接插入排序 
	 * 
	 * 稳定
	 * 
	 * 时间复杂度T(n)	AVG: O(n*n) GOOD: O(n) BAD: O(n*n)
	 * 空间复杂度S(n)	O(1)
	 * 
	 * @param t
	 */
	public void directIns(T[] t);
	
	/**
	 * 插入排序 - 希尔排序
	 * 
	 * 不稳定
	 * 
	 * 时间复杂度T(n)	AVG: O(n*Math.sqrt(n)) GOOD: O(n) BAD: O(n*n)
	 * 空间复杂度S(n)	O(1)
	 * 
	 * @param t
	 */
	public void shell(T[] t);

	/**
	 * 选择排序 - 简单选择排序
	 * 
	 * 不稳定
	 * 
	 * 时间复杂度T(n)	AVG: O(n*n) GOOD: O(n*n) BAD: O(n*n)
	 * 空间复杂度S(n)	O(1)
	 * 
	 * @param t
	 */
	public void simpleSel(T[] t);

	/**
	 * 选择排序 - 堆排序
	 * 
	 * 不稳定
	 * 
	 * 时间复杂度T(n)	AVG: O(nlogn) GOOD: O(nlogn) BAD: O(nlogn)
	 * 空间复杂度S(n)	O(1)
	 * 
	 * @param t
	 */
	public void heap(T[] t);

	/**
	 * 交换排序 - 冒泡排序
	 * 
	 * 稳定
	 * 
	 * 时间复杂度T(n)	AVG: O(n*n) GOOD: O(n) BAD: O(n*n)
	 * 空间复杂度S(n)	O(1)
	 * 
	 * @param t
	 */
	public void bubble(T[] t);

	/**
	 * 交换排序 - 快速排序
	 * 
	 * 不稳定
	 * 
	 * 时间复杂度T(n)	AVG: O(nlogn) GOOD: O(nlogn) BAD: O(n*n)
	 * 空间复杂度S(n)	O(nlogn)
	 * 
	 * @param t
	 */
	public void quick(T[] t);

	/**
	 * 归并排序
	 * 
	 * 稳定
	 * 
	 * 时间复杂度T(n)	AVG: O(nlogn) GOOD: O(nlogn) BAD: O(nlogn)
	 * 空间复杂度S(n)	O(1)
	 * 
	 * @param t
	 */
	public void merge(T[] t);

	/**
	 * 基数排序
	 * 
	 * 稳定
	 * 
	 * 时间复杂度T(n)	AVG: O(d(r+n)) GOOD: O(d(n+rd) BAD: O(d(r+n))
	 * 空间复杂度S(n)	O(rd+n)
	 * 
	 * r:代表关键字的基数  d:代表长度   n:代表关键字的个数
	 * 
	 * @param t
	 */
}
