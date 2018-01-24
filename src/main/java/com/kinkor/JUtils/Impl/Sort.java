package com.kinkor.JUtils.Impl;

import java.lang.reflect.Array;

import com.kinkor.JUtils.Interface.ISort;

public class Sort<T extends Comparable<T>> implements ISort<T> {

	/**
	 * ’˝–Ú
	 */
	public final static int SORT_ASC = 1;

	/**
	 * µπ–Ú
	 */
	public final static int SORT_DESC = 0;

	/**
	 * µ±«∞µƒ≈≈–Ú∑Ω Ω
	 */
	private int sortWay = 0;

	/**
	 * 
	 */
	public Sort() {
		this.sortWay = Sort.SORT_ASC;
	}

	/**
	 * 
	 * @param sortWay
	 */
	public Sort(int sortWay) {
		if (sortWay == Sort.SORT_ASC || sortWay == Sort.SORT_DESC) {
			this.sortWay = sortWay;
		} else {
			this.sortWay = Sort.SORT_ASC;
		}
	}

	/**
	 * 
	 * @param sortWay
	 */
	public void setSortWay(int sortWay) {
		if (sortWay == Sort.SORT_ASC || sortWay == Sort.SORT_DESC) {
			this.sortWay = sortWay;
		} else {
			this.sortWay = Sort.SORT_ASC;
		}
	}

	/**
	 * ≤Â»Î≈≈–Ú - ÷±Ω”≤Â»Î≈≈–Ú
	 * 
	 * @param t
	 */
	public void directIns(T[] t) {
		int i, j;
		T target = null;
		switch (this.sortWay) {
		case Sort.SORT_ASC:
			for (i = 1; i < t.length; i++) {
				target = t[i];
				j = i;
				while (j >= 1 && target.compareTo(t[j - 1]) < 0) {
					t[j] = t[j - 1];
					j--;
				}
				t[j] = target;
			}
			break;
		case Sort.SORT_DESC:
			for (i = 1; i < t.length; i++) {
				target = t[i];
				j = i;
				while (j >= 1 && target.compareTo(t[j - 1]) > 0) {
					t[j] = t[j - 1];
					j--;
				}
				t[j] = target;
			}
			break;
		}
	}

	/**
	 * ≤Â»Î≈≈–Ú - œ£∂˚≈≈–Ú
	 * 
	 * @param t
	 */
	public void shell(T[] t) {
		int gap = t.length >> 1;
		T target = null;
		switch (this.sortWay) {
		case Sort.SORT_ASC:
			while (gap >= 1) {
				for (int i = gap; i < t.length; i++) {
					int j = i;
					target = t[i];
					while (j >= gap && target.compareTo(t[j - gap]) < 0) {
						t[j] = t[j - gap];
						j = j - gap;
					}
					t[j] = target;
				}
				gap = gap >> 1;
			}
			break;
		case Sort.SORT_DESC:
			while (gap >= 1) {
				for (int i = gap; i < t.length; i++) {
					int j = i;
					target = t[i];
					while (j >= gap && target.compareTo(t[j - gap]) > 0) {
						t[j] = t[j - gap];
						j = j - gap;
					}
					t[j] = target;
				}
				gap = gap >> 1;
			}
			break;
		}
	}

	/**
	 * —°‘Ò≈≈–Ú - ºÚµ•—°‘Ò≈≈–Ú
	 * 
	 * @param t
	 */
	public void simpleSel(T[] t) {
		switch (this.sortWay) {
		case Sort.SORT_ASC:
			int min = 0;
			for (int i = 0; i < t.length - 1; i++) {
				min = i;
				for (int j = i + 1; j < t.length; j++) {
					if (t[min].compareTo(t[j]) > 0) {
						min = j;
					}
				}
				if (i != min) {
					T temp = t[min];
					t[min] = t[i];
					t[i] = temp;
				}
			}
			break;
		case Sort.SORT_DESC:
			int max = 0;
			for (int i = 0; i < t.length - 1; i++) {
				max = i;
				for (int j = i + 1; j < t.length; j++) {
					if (t[max].compareTo(t[j]) < 0) {
						max = j;
					}
				}
				if (i != max) {
					T temp = t[max];
					t[max] = t[i];
					t[i] = temp;
				}
			}
			break;
		}
	}

	/**
	 * ¥Û∏˘∂—
	 * 
	 * @param t
	 * @param heapSize
	 * @param index
	 */
	private void maxHeapify(T[] t, int heapSize, int index) {
		int left = (index << 1) + 1;
		int right = (index << 1) + 2;
		int largest = index;
		if (left < heapSize && t[largest].compareTo(t[left]) < 0) {
			largest = left;
		}
		if (right < heapSize && t[largest].compareTo(t[right]) < 0) {
			largest = right;
		}
		if (largest != index) {
			T temp = t[index];
			t[index] = t[largest];
			t[largest] = temp;
			maxHeapify(t, heapSize, largest);
		}
	}

	/**
	 * –°∏˘∂—
	 * 
	 * @param t
	 * @param heapSize
	 * @param index
	 */
	private void minHeapify(T[] t, int heapSize, int index) {
		int left = (index << 1) + 1;
		int right = (index << 1) + 2;
		int min = index;
		if (left < heapSize && t[min].compareTo(t[left]) > 0) {
			min = left;
		}
		if (right < heapSize && t[min].compareTo(t[right]) > 0) {
			min = right;
		}
		if (min != index) {
			T temp = t[index];
			t[index] = t[min];
			t[min] = temp;
			minHeapify(t, heapSize, min);
		}
	}

	/**
	 * —°‘Ò≈≈–Ú - ∂—≈≈–Ú
	 */
	public void heap(T[] t) {
		int startIndex = (t.length - 1) >> 1;
		switch (this.sortWay) {
		case Sort.SORT_ASC:
			for (int i = startIndex; i >= 0; i--) {
				maxHeapify(t, t.length, i);
			}
			for (int j = t.length - 1; j > 0; j--) {
				T temp = t[0];
				t[0] = t[j];
				t[j] = temp;
				maxHeapify(t, j, 0);
			}
			break;
		case Sort.SORT_DESC:
			for (int i = startIndex; i >= 0; i--) {
				minHeapify(t, t.length, i);
			}
			for (int j = t.length - 1; j > 0; j--) {
				T temp = t[0];
				t[0] = t[j];
				t[j] = temp;
				minHeapify(t, j, 0);
			}
			break;
		}
	}

	/**
	 * Ωªªª≈≈–Ú - √∞≈›≈≈–Ú
	 */
	public void bubble(T[] t) {
		int i, j;
		switch (this.sortWay) {
		case Sort.SORT_ASC:
			for (i = 1; i < t.length; i++) {
				for (j = 0; j < t.length - i; j++) {
					if (t[j].compareTo(t[j + 1]) > 0) {
						T temp = t[j];
						t[j] = t[j + 1];
						t[j + 1] = temp;
					}
				}
			}
			break;
		case Sort.SORT_DESC:
			for (i = 1; i < t.length; i++) {
				for (j = 0; j < t.length - i; j++) {
					if (t[j].compareTo(t[j + 1]) < 0) {
						T temp = t[j];
						t[j] = t[j + 1];
						t[j + 1] = temp;
					}
				}
			}
			break;
		}
	}

	/**
	 * øÏÀŸ≈≈–Ú - ’˝–Ú
	 * 
	 * @param t
	 * @param left
	 * @param right
	 */
	private void quickAsc(T[] t, int left, int right) {
		if (left >= right) {
			return;
		}
		int i = left, j = right;
		T target = t[left];
		while (i < j) {
			while (j > i && t[j].compareTo(target) > 0) {
				j--;
			}
			t[i] = t[j];
			while (j > i && t[i].compareTo(target) < 0) {
				i++;
			}
			t[j] = t[i];
		}
		t[i] = target;
		quickAsc(t, left, i - 1);
		quickAsc(t, i + 1, right);
	}

	/**
	 * øÏÀŸ≈≈–Ú - µπ–Ú
	 * 
	 * @param t
	 * @param left
	 * @param right
	 */
	private void quickDesc(T[] t, int left, int right) {
		if (left >= right) {
			return;
		}
		int i = left, j = right;
		T target = t[left];
		while (i < j) {
			while (i < j && t[j].compareTo(target) < 0) {
				j--;
			}
			t[i] = t[j];
			while (i < j && t[i].compareTo(target) > 0) {
				i++;
			}
			t[j] = t[i];
		}
		t[i] = target;
		quickDesc(t, left, i - 1);
		quickDesc(t, i + 1, right);
	}

	/**
	 * øÏÀŸ≈≈–Ú
	 */
	public void quick(T[] t) {
		switch (this.sortWay) {
		case Sort.SORT_ASC:
			quickAsc(t, 0, t.length - 1);
			break;
		case Sort.SORT_DESC:
			quickDesc(t, 0, t.length - 1);
			break;
		}
	}

	/**
	 * πÈ≤¢≈≈–Ú - πÈ≤¢
	 * 
	 * @param t
	 * @param start
	 * @param mid
	 * @param end
	 * @param sortWay
	 */
	@SuppressWarnings("unchecked")
	private void merge(T[] t, int start, int mid, int end, int sortWay) {
		int i = start;
		int j = mid + 1;
		int k = 0;
		T[] tempArr = (T[]) Array.newInstance(t.getClass().getComponentType(), end - start + 1);
		while (i <= mid && j <= end) {
			switch (sortWay) {
			case Sort.SORT_ASC:
				if (t[i].compareTo(t[j]) > 0) {
					tempArr[k] = t[j];
					j++;
					k++;
				} else {
					tempArr[k] = t[i];
					i++;
					k++;
				}
				break;
			case Sort.SORT_DESC:
				if (t[i].compareTo(t[j]) < 0) {
					tempArr[k] = t[j];
					j++;
					k++;
				} else {
					tempArr[k] = t[i];
					i++;
					k++;
				}
				break;
			}
		}
		while (i <= mid) {
			tempArr[k] = t[i];
			i++;
			k++;
		}
		while (j <= end) {
			tempArr[k] = t[j];
			j++;
			k++;
		}
		for (int l = 0; l < tempArr.length; l++) {
			t[l + start] = tempArr[l];
		}
	}

	/**
	 * πÈ≤¢≈≈–Ú - ∑÷Ω‚
	 * 
	 * @param t
	 * @param start
	 * @param end
	 * @param sortWay
	 */
	private void merge(T[] t, int start, int end, int sortWay) {
		if (start < end) {
			int mid = (start + end) >> 1;
			merge(t, start, mid, sortWay);
			merge(t, mid + 1, end, sortWay);
			merge(t, start, mid, end, sortWay);
		}
	}

	/**
	 * πÈ≤¢≈≈–Ú
	 */
	public void merge(T[] t) {
		merge(t, 0, t.length - 1, this.sortWay);
	}

}
