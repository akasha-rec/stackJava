package dataStructure.ch03;

/*
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;
import java.util.List;

public class StringArray {
	static void showList(String topic, String[] list) {
		System.out.println(topic);
		for (String item : list) {
			System.out.println(item + " ");
		}
		System.out.println();
	}

	static String[] mergeList(String[] s1, String[] s2) {

		int i = 0, j = 0, k = 0;
		String[] s3 = new String[10];

		s3 = new String[s1.length + s2.length];
		while (i < s1.length && j < s2.length) { // 두 배열의 요소를 사전식 순서로 정렬하기 위해 비교 > s1 혹은 s2 배열 중 한 배열의 요소가 모두 s3에 추가가 되면 종료
			if (s1[i].compareTo(s2[j]) < 0) { // s1 요소가 s2 요소보다 우선시
				s3[k++] = s1[i++];
			} else { // s2 요소가 s1 요소보다 우선시
				s3[k++] = s2[j++];
			}
		}

		while (i < s1.length) { // s1 배열에 남은 요소를 s3 배열에 추가
			s3[k++] = s1[i++];
		}

		while (j < s2.length) { // s2 배열에 남은 요소를 s3 배열에 추가
			s3[k++] = s2[j++];
		}

		return s3;
	}

	public static void main(String[] args) {
		String[] s1 = { "홍길동", "강감찬", "을지문덕", "계백", "김유신" };
		String[] s2 = { "독도", "울릉도", "한산도", "영도", "우도" };

		// s1, s2 각 배열 요소를 사전순(오름차순) 정렬 
		Arrays.sort(s1); // comparable or comparator interface 구현이 돼있어야 > String 클래스는 이미 Comparable<String>을 구현하고 있어서 사용 가능
		Arrays.sort(s2); // String 뿐만 아니라 Integer, Double 같은 Java의 기본 래퍼 클래스들도 Comparable interface를 구현하고 있다고 함.
		showList("s1배열 = ", s1);
		showList("s2배열 = ", s2);

		String[] s3 = mergeList(s1, s2);
		showList("스트링 배열 s3 = s1 + s2:: ", s3);
	}
}
