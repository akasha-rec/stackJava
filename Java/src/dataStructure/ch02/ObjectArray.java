// Chapter 02. 기본 자료구조
package dataStructure.ch02;

import java.util.Arrays;
import java.util.Collections;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData>{//Comparable 인터페이스를 구현할 때 어떤 타입의 객체끼리 비교할 것인지 명시
	String name; // 멤버 변수
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) { // 생성자 : 인스턴스 생성 시 초기화하기 위해
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public String toString() { //객체의 정보를 문자열로 출력
		return "[" + name + ", " + height + ", " + vision + "]";
	}

	@Override
	public int compareTo(PhyscData p) { // 이름을 기준으로
		if (this.name.compareTo(p.name) == 0) { // 이름이 같다면
			if(this.height==p.height) { // 키를 비교했을 때도 같다면
				if(this.vision==p.vision) { // 시력으로 비교
					return 0;
				} else { // 키는 같지만, 시력이 다르다면
					return this.vision > p.vision? 1 : -1;
				}
			}
			else { // 키로 비교
				return this.height > p.height? 1 : -1;
			}
				
		} else {
			return this.name.compareTo(p.name);
		}
//		 else if (this.name.compareTo(p.name) < 0) // 사전식 순서로 앞에 위치
//			return -1;
//		 else 
//			return 0; // 같다
	}

	public int equals(PhyscData p) {
		if (this.name.compareTo(p.name) == 0) 
			return 0;
		else
			return -1;
	}
}
	
	public class ObjectArray {
		static void swap(PhyscData[] arr, int ind1, int ind2) {
			PhyscData tmp = arr[ind1];
			arr[ind1] = arr[ind2];
			arr[ind2] = tmp;
		}

		static void sortData(PhyscData[] arr) {
			for (int i = 0; i < arr.length; i++)
				for (int j = i+1; j < arr.length; j++)
					if (arr[i].compareTo(arr[j])>0) // 현재는 오름차순 / <0으로 바꾸면 내림차순
						swap(arr, i, j);					
		}

		public static void main(String[] args) {
			PhyscData[] data = {
					new PhyscData("홍길동", 162, 0.3), //객체
					new PhyscData("홍길동", 160, 0.4),
					new PhyscData("홍동", 164, 1.3),
					new PhyscData("홍길", 152, 0.7),
					new PhyscData("김홍길동", 172, 0.3),
					new PhyscData("이길동", 182, 0.6),
					new PhyscData("박길동", 167, 0.2),
					new PhyscData("최길동", 169, 0.5),
			};
			showData(data);
			sortData(data); // Arrays.sort(data); // 두 코드 모두 오름차순 정렬
//			Arrays.sort(data, Collections.reverseOrder()); // 내림차순 정렬
			showData(data);
		}

		static void showData(PhyscData[] arr) {
			for (PhyscData i : arr) {
				System.out.println(i + " ");
			}
			System.out.println();
		}

	}
