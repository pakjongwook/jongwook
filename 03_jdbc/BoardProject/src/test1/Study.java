package test1;

import java.util.Arrays;

public class Study {

	public static void main(String[] args) {
		int[][] number = { { 80, 70 }, { 90, 50 }, { 40, 70 }, { 50, 80 } };
//		배열 두개을 선언 하고 할당
		double[] avg = new double[number.length]; // number.length (number 총 개수)
		int[] answer = new int[avg.length]; // Rank 등수 갯수(int) 선언

		for (int i = 0; i < number.length; i++) {  // for 문으로 평균을 구하기
			avg[i] = ((number[i][0] + number[i][1]) / 2.0); // 2.0으로 나누는 이유는 평균을 double 자료형으로 선언했기 때문에
//			avg[i] 의 i가[0~4 번째 의 평균 값]                       2로 나눌 경우 소수점이 나오지 않음
		}

		for (int j = 0; j < number.length; j++) { // 이중 for문 중 첫번째 for문을 이용해서 해당 값의 순위를 1로 시작
			int rank = 1;

			for (int k = 0; k < number.length; k++) { // 두번째 for문은 첫번째 rank가 나온 값과 비교하기 위해 for문을 돌리면서 순위를 정하기
				if (avg[j] < avg[k])  // 기존데이터가 나머지데이터와 비교했을떄 적으면 rank 카운트
					rank++;
				answer[j] = rank; // j는 최종 순위을 매기기 위해서 선언
			}
		}
//		Arrays.toString메소드에 배열을 인자로 받게 된다면 String으로 반환
		System.out.println(Arrays.toString(avg)); 
		System.out.println(Arrays.toString(answer));
	}
	
	public void study2() {
		
	}
}

	
	



