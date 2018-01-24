package com.kinkor.JUtils.Interface;

/**
 * ���ݽṹ - ������
 * 
 * @author Guohui Zhou
 * @version 0.0.1
 *
 */
public interface ISort<T> {
	
	/**
	 * �������� - ֱ�Ӳ������� 
	 * 
	 * �ȶ�
	 * 
	 * ʱ�临�Ӷ�T(n)	AVG: O(n*n) GOOD: O(n) BAD: O(n*n)
	 * �ռ临�Ӷ�S(n)	O(1)
	 * 
	 * @param t
	 */
	public void directIns(T[] t);
	
	/**
	 * �������� - ϣ������
	 * 
	 * ���ȶ�
	 * 
	 * ʱ�临�Ӷ�T(n)	AVG: O(n*Math.sqrt(n)) GOOD: O(n) BAD: O(n*n)
	 * �ռ临�Ӷ�S(n)	O(1)
	 * 
	 * @param t
	 */
	public void shell(T[] t);

	/**
	 * ѡ������ - ��ѡ������
	 * 
	 * ���ȶ�
	 * 
	 * ʱ�临�Ӷ�T(n)	AVG: O(n*n) GOOD: O(n*n) BAD: O(n*n)
	 * �ռ临�Ӷ�S(n)	O(1)
	 * 
	 * @param t
	 */
	public void simpleSel(T[] t);

	/**
	 * ѡ������ - ������
	 * 
	 * ���ȶ�
	 * 
	 * ʱ�临�Ӷ�T(n)	AVG: O(nlogn) GOOD: O(nlogn) BAD: O(nlogn)
	 * �ռ临�Ӷ�S(n)	O(1)
	 * 
	 * @param t
	 */
	public void heap(T[] t);

	/**
	 * �������� - ð������
	 * 
	 * �ȶ�
	 * 
	 * ʱ�临�Ӷ�T(n)	AVG: O(n*n) GOOD: O(n) BAD: O(n*n)
	 * �ռ临�Ӷ�S(n)	O(1)
	 * 
	 * @param t
	 */
	public void bubble(T[] t);

	/**
	 * �������� - ��������
	 * 
	 * ���ȶ�
	 * 
	 * ʱ�临�Ӷ�T(n)	AVG: O(nlogn) GOOD: O(nlogn) BAD: O(n*n)
	 * �ռ临�Ӷ�S(n)	O(nlogn)
	 * 
	 * @param t
	 */
	public void quick(T[] t);

	/**
	 * �鲢����
	 * 
	 * �ȶ�
	 * 
	 * ʱ�临�Ӷ�T(n)	AVG: O(nlogn) GOOD: O(nlogn) BAD: O(nlogn)
	 * �ռ临�Ӷ�S(n)	O(1)
	 * 
	 * @param t
	 */
	public void merge(T[] t);

	/**
	 * ��������
	 * 
	 * �ȶ�
	 * 
	 * ʱ�临�Ӷ�T(n)	AVG: O(d(r+n)) GOOD: O(d(n+rd) BAD: O(d(r+n))
	 * �ռ临�Ӷ�S(n)	O(rd+n)
	 * 
	 * r:����ؼ��ֵĻ���  d:������   n:����ؼ��ֵĸ���
	 * 
	 * @param t
	 */
}
