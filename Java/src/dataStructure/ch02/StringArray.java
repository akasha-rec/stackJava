// Chapter 02. 기본 자료구조
package dataStructure.ch02;

public class StringArray {
	public static void main(String[] args) {
		String[] data = {"apple","grape","persimmon", "pear","blueberry", "strawberry", "melon", "oriental melon"};

		showData(data); // 정렬 전 배열 내용 출력
		sortData(data); // 사전식 순서(오름차순)으로 정렬
		showData(data); // 정렬 후 배열 내용 출력
	}

	static void showData(String[] arr) {
		for(String name : arr) // 배열의 각 요소를 순서대로 name 변수에 저장
			System.out.print(name+" ");
		System.out.println();
	}

	static void swap(String[] arr, int ind1, int ind2) { // 배열 내 요소의 위치 교환
		String tmp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = tmp;
	}

	static void sortData(String[] arr) {
		for (int i = 0; i < arr.length; i++) // 각 배열의 요소 차례대로 출력
			for (int j = i+1; j < arr.length; j++) { // 
				if(arr[i].compareTo(arr[j])>0) {//compareTo() 사용하는 것 오름차순
					swap(arr, i, j); // arr[i].compareTo(arr[j])>0 : arr[i]가 arr[j]보다 순서상 뒤에 있어야
				}
			}
		}

}

