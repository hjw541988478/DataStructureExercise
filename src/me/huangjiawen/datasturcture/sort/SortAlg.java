package me.huangjiawen.datasturcture.sort;

import java.util.Random;

/**
 * 排序分为内排序与外排序，其中外排序需要在内外存多次交换才能进行�?�内排序主要又分�?4类：交换、比较�?�插入与归并�?
 * 
 * �?单算法：冒泡、�?�择、插�? 改进算法：快排�?�堆、希尔�?�归�?
 * 
 * 从最好情况看，基本有序的情况下，�?单算法更有优势； 从最差情况看，堆排序与归并排序最优，优于快排，其中前两种稳定，后�?种不稳定�?
 * 从稳定�?�来看，归并排序�?优；
 * 
 * 从数据记录长度看，数据越少，越�?�合�?单排序，越多，越适合改进排序�?
 * 
 * 综合各种因素，改进版的快速排序是�?优的，但也有看情况�??
 * 
 * @author Administrator
 *
 */
public class SortAlg {

	/**
	 * 冒泡排序(交换):两两比较相邻记录的关键字，如果反序就交换，直到没有反序的记录为止�?
	 * 
	 * 时间复杂度：O(n²)
	 * 
	 * @param toBeSortIntArray
	 */
	public static void bubbleSort(int[] toBeSortIntArray) {
		boolean flag = true;
		for (int i = 0; i < toBeSortIntArray.length && flag; i++) {
			flag = false;
			for (int j = toBeSortIntArray.length - 1; j > i; j--) {
				if (toBeSortIntArray[j] < toBeSortIntArray[j - 1]) {
					swap(toBeSortIntArray, j, j - 1);
					flag = true;
				}
			}
		}
	}

	/**
	 * 选择排序（比较）：�?�过n-i次关键字的比较，在n-i+1中�?�出关键字最小的记录，并与第i个记录交换之�?
	 * 
	 * 时间复杂度：O(n²)
	 * 
	 * 移动次数少，性能略优于冒泡排�?
	 * 
	 * @param toBeSortIntArray
	 */
	public static void selectSort(int[] toBeSortIntArray) {
		for (int i = 0; i < toBeSortIntArray.length; i++) {
			int min = i;
			for (int j = toBeSortIntArray.length - 1; j > i; j--) {
				if (toBeSortIntArray[j] < toBeSortIntArray[min]) {
					min = j;
				}
			}
			if (i != min) {
				swap(toBeSortIntArray, min, i);
			}
		}
	}

	/**
	 * 插入排序（插入）：将1个记录插入到有序表中，从而得�?1个新的有序记录数+1的有序表�?
	 * 
	 * 时间复杂度：O(n²)
	 * 
	 * 性能比冒泡和选择排序都好
	 * 
	 * @param toBeSortIntArray
	 */
	public static void insertionSort(int increment, int[] toBeSortIntArray) {
		int i, j;
		for (i = increment; i < toBeSortIntArray.length; i++) {
			if (toBeSortIntArray[i] < toBeSortIntArray[i - increment]) {
				int tmp = toBeSortIntArray[i];
				for (j = i - increment; j >= 0 && toBeSortIntArray[j] > tmp; j -= increment) {
					toBeSortIntArray[j + increment] = toBeSortIntArray[j];
				}
				toBeSortIntArray[j + increment] = tmp;
			}
		}
	}

	/**
	 * 希尔排序（插入改进版）：把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减�?1时，整个文件恰被分成�?组�??
	 * 
	 * 好的增量序列的共同特�?: 1.�?后一个增量必须为1 2.应该尽量避免序列中的�?(尤其是相邻的�?)互为倍数的情�?
	 * 
	 * 时间复杂度：O(n^3/2)
	 * 
	 * 插入排序的改进，但属于内排序中不稳定的排�?
	 * 
	 * @param toBeSortIntArray
	 */
	public static void shellSort(int[] toBeSortIntArray) {
		int increment = toBeSortIntArray.length;
		for (increment /= 2; increment > 0; increment /= 2) {
			insertionSort(increment, toBeSortIntArray);
		}
	}

	/**
	 * 堆排序（选择改进版）：具有完全二叉树的结构，根节点大于或等于左右子节点的堆为大顶堆，根节点小于或等于左右子节点的堆为小顶堆�??
	 * 
	 * 构建�?->互换->再构�?
	 * 
	 * 时间复杂度：O(nlogn)
	 * 
	 * 比较次数较多不�?�用于元素较少的情况，跳跃式的比较属于不稳定的排�?
	 *
	 * @param toBeSortIntArray
	 */
	public static void heapSort(int[] toBeSortIntArray) {
		int arraySize = toBeSortIntArray.length;
		for (int i = arraySize / 2; i >= 0; i--) {
			buildHeap(toBeSortIntArray, i, arraySize);
		}
		for (int i = arraySize - 1; i >= 0; i--) {
			swap(toBeSortIntArray, i, 0);
			buildHeap(toBeSortIntArray, 0, i);
		}
	}

	/**
	 * 将较大子节点调整为根节点,左子节点等于2*n,右子节点等于2*n+1
	 * 
	 * @param toBeSortIntArray
	 * @param rootNodeIndex
	 * @param arraySize
	 */
	private static void buildHeap(int[] toBeSortIntArray, int rootNodeIndex, int arraySize) {
		int tmp, j;
		tmp = toBeSortIntArray[rootNodeIndex];
		for (j = rootNodeIndex * 2 + 1; j < arraySize && (j + 1) < arraySize; j = 2 * j + 1) {
			if (toBeSortIntArray[j + 1] > toBeSortIntArray[j]) {
				j++;
			}
			if (tmp > toBeSortIntArray[j]) {
				break;
			}
			toBeSortIntArray[rootNodeIndex] = toBeSortIntArray[j];
			rootNodeIndex = j;
		}
		toBeSortIntArray[rootNodeIndex] = tmp;
	}

	/**
	 * 归并排序（归并）：将N个记录看成N组长度为1有序的子序列，然后两两归并，直到得到�?个长度为N的有序序列�?�称为二路归并排序�??
	 * 
	 * 时间复杂�?: O(nlogn)
	 * 
	 * @param toBeSortIntArray
	 */
	public static void mergeSort(int[] toBeSortIntArray, int[] sortedIntArray) {
		mergeSortRecursively(toBeSortIntArray, sortedIntArray, 0, toBeSortIntArray.length - 1);
	}

	/*
	 * 归并排序的迭代实�?
	 * 
	 * 空间复杂度：O(n)
	 * 
	 * 性能优于递归实现
	 */
	public static void mergeSortIterationly(int[] toBeSortIntArray) {
		int[] sortedIntArray = new int[toBeSortIntArray.length];
		int continuousLen = 1;
		while (continuousLen < toBeSortIntArray.length) {
			mergeSortIterate(toBeSortIntArray, sortedIntArray, continuousLen, sortedIntArray.length);
			continuousLen = continuousLen * 2;
			// 又归并回来到原待排序的数�?
			mergeSortIterate(sortedIntArray, toBeSortIntArray, continuousLen, sortedIntArray.length);
			continuousLen = continuousLen * 2;
		}
	}

	/**
	 * 将toBeSortIntArray中next长度相邻的子序列两两归并到sortedIntArray
	 * 
	 * @param toBeSortIntArray
	 * @param sortedIntArray
	 * @param next
	 * @param length
	 */
	private static void mergeSortIterate(int[] toBeSortIntArray, int[] sortedIntArray, int continuousLen,
			int totalLen) {
		int i = 0, j;
		while (i < totalLen - 2 * continuousLen - 1) {
			mergeSortedArray(toBeSortIntArray, sortedIntArray, i, i + continuousLen, i + 2 * continuousLen);
			i = i + 2 * continuousLen + 1;
		}

		if (i < totalLen - continuousLen - 1) {
			mergeSortedArray(toBeSortIntArray, sortedIntArray, i, i + continuousLen, totalLen - 1);
		} else {
			for (j = i; j < totalLen; j++) {
				sortedIntArray[j] = toBeSortIntArray[j];
			}
		}
	}

	/**
	 * 归并排序的�?�归实现
	 * 
	 * 时间复杂度：O(nlogn) 空间复杂度：O(n+nlogn)
	 * 
	 * 占用内存，但效率高稳�?
	 * 
	 * @param toBeSortIntArray
	 * @param sortedArray
	 * @param first
	 * @param last
	 */
	public static void mergeSortRecursively(int[] toBeSortIntArray, int[] sortedArray, int first, int last) {
		if (first == last) {
			sortedArray[first] = toBeSortIntArray[first];
		} else {
			int[] sortedTmpEmptyArray = new int[toBeSortIntArray.length];
			int mid = (first + last) / 2;
			mergeSortRecursively(toBeSortIntArray, sortedTmpEmptyArray, first, mid);
			mergeSortRecursively(toBeSortIntArray, sortedTmpEmptyArray, mid + 1, last);
			mergeSortedArray(sortedTmpEmptyArray, sortedArray, first, mid, last);
		}
	}

	/**
	 * �?2个有序的子序列归并合�?1个有序的子序�?
	 * 
	 * @param partialSortedArray
	 * @param sortedArray
	 * @param first
	 * @param mid
	 * @param last
	 */
	private static void mergeSortedArray(int[] partialSortedArray, int[] sortedArray, int first, int mid, int last) {
		int i, j, k, l;
		for (i = first, j = mid + 1, k = i; i <= mid && j <= last; k++) {
			if (partialSortedArray[i] < partialSortedArray[j]) {
				sortedArray[k] = partialSortedArray[i++];
			} else {
				sortedArray[k] = partialSortedArray[j++];
			}
		}
		if (i <= mid) {
			for (l = 0; l <= mid - i; l++) {
				sortedArray[k + l] = partialSortedArray[i + l];
			}
		}
		if (j <= last) {
			for (l = 0; l <= last - j; l++) {
				sortedArray[k + l] = partialSortedArray[j + l];
			}
		}
	}

	/**
	 * 快�?�排序（冒泡改进版）：�?�过�?趟排序将待排记录分割成独立的两部分，其中�?部分记录的关键字比另�?部分关键字小，可分别对这两部分记录进行排序，直至有序�?
	 * 
	 * 时间复杂度：O(nlogn)
	 * 
	 * 不稳定的排序
	 * 
	 * @param toBeSortedArray
	 */
	public static void quickSort(int[] toBeSortArray) {
		qSort(toBeSortArray, 0, toBeSortArray.length - 1);
	}

	private static void qSort(int[] toBeSortArray, int first, int last) {
		int pivot;
		// if(first < last) {
		// pivot = partition(toBeSortArray, first, last);
		// qSort(toBeSortArray, first, pivot - 1);
		// qSort(toBeSortArray, pivot + 1, last);
		// }
		// 尾�?�归优化
		while (first < last) {
			pivot = partition(toBeSortArray, first, last);
			qSort(toBeSortArray, first, pivot - 1);
			first = pivot + 1;
		}
	}

	/**
	 * 快排的核心方法，选择�?个记录为枢轴(pivot)，使得在枢轴左边的记录都比它小，右边的都比它�?
	 * 
	 * 枢轴优化�? 1. 3数取中或9数取�? 2. 尾�?�归优化
	 * 
	 * @param toBeSortArray
	 * @param first
	 * @param last
	 */
	private static int partition(int[] toBeSortArray, int first, int last) {
		int pivotKey = toBeSortArray[first];
		int tmp = pivotKey;

		while (first < last) {
			while (first < last && toBeSortArray[last] >= pivotKey) {
				last--;
			}
			// 减少不必要的交换
			toBeSortArray[first] = toBeSortArray[last];
			// swap(toBeSortArray, first, last);
			while (first < last && toBeSortArray[first] <= pivotKey) {
				first++;
			}
			toBeSortArray[last] = toBeSortArray[first];
			// swap(toBeSortArray, first, last);
		}
		toBeSortArray[first] = tmp;
		return first;
	}

	// public static void main(String[] args) {
	// int[] toBeSortIntArray = new int[10000];
	// // int[] sortedIntArray = new int[toBeSortIntArray.length];
	// initToBeSortIntArray(toBeSortIntArray);
	// print("before sort:", toBeSortIntArray);
	// long start = System.currentTimeMillis();
	// // bubbleSort(toBeSortIntArray);
	// // selectSort(toBeSortIntArray);
	// // insertionSort(1, toBeSortIntArray);
	// // shellSort(toBeSortIntArray);
	// // heapSort(toBeSortIntArray);
	// // mergeSort(toBeSortIntArray, sortedIntArray);
	// // toBeSortIntArray = sortedIntArray;
	// // mergeSortIterationly(toBeSortIntArray);
	// quickSort(toBeSortIntArray);
	// long end = System.currentTimeMillis();
	// System.out.println("cost time:" + (end - start) + "ms");
	// print("after sort:", toBeSortIntArray);
	// }

	public static void swap(int[] sortArray, int fromIndex, int toIndex) {
		int swapItem = sortArray[fromIndex];
		sortArray[fromIndex] = sortArray[toIndex];
		sortArray[toIndex] = swapItem;
	}

	public static void print(String initialHint, int[] toBePrintArray) {
		StringBuilder sb = new StringBuilder(initialHint);
		for (int sortItem : toBePrintArray) {
			sb.append(sortItem + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}

	/**
	 * 随机获取不重复的长度�? toBeSortIntArray的int数组
	 * 
	 * @param toBeSortIntArray
	 */

	public static void initToBeSortIntArray(int[] toBeSortIntArray) {
		int size = toBeSortIntArray.length;
		for (int i = 0; i < size; i++) {
			toBeSortIntArray[i] = i + 1;
		}
		Random random = new Random(size);
		for (int index = 0; index < size; index++) {
			int value = Math.abs(random.nextInt() % size);
			int median = toBeSortIntArray[index];
			toBeSortIntArray[index] = toBeSortIntArray[value];
			toBeSortIntArray[value] = median;
		}
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int size = nums1.length + nums2.length;
		int[] nums3 = new int[size];
		int i, j, k, l;
		for (i = 0, j = 0, k = 0; j < nums1.length && k < nums2.length && i < nums3.length; i++) {
			if (nums1[j] <= nums2[k]) {
				nums3[i] = nums1[j++];
			} else {
				nums3[i] = nums2[k++];
			}
		}
		if (j < nums1.length) {
			for (l = j; l < nums1.length; l++) {
				nums3[i++] = nums1[l];
			}
		}
		if (k < nums2.length) {
			for (l = k; l < nums2.length; l++) {
				nums3[i++] = nums2[l];
			}
		}
		print("after sort:", nums3);
		if ((size & 1) == 1) {
			return nums3[size >> 1];
		} else {
			return (nums3[(size >> 1) - 1] + nums3[size >> 1]) * 1.0d / 2;
		}

	}

	public static void main(String[] args) {
		int[] nums1 = { 5, 6, 7 };
		int[] nums2 = { 1, 2, 3 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
