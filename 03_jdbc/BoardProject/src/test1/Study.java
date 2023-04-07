package test1;

public static void main(String[] args) {
    
//    int[][] score1 = {{80, 70}, {90, 50}, {40, 70}, {50, 80}};
//    int[][] score2 = {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};
//    
//    int[] answer1 = solution(score1);
//    int[] answer2 = solution(score2);
//    
//    // [1, 2, 4, 3]
//    for(int i : answer1) 
//       System.out.print(i + " ");
//    
//    System.out.println();
//    
//    // [4, 4, 6, 2, 2, 1, 7]
//    for(int i : answer2)
//       System.out.print(i + " ");

 
	public static void main(String[] args) {
		int[][] number = {{80,70},{90,50},{40,70},{50,80}};
		double[] avg = new double[number.length]; // number.length number 총 개수
		int[] answer = new int[avg.length]; // 등수 개수 
		
		int rank =1;
		
		for(int i =0; i< number.length; i++) {
			avg[i] = ((number[i][0] + number[i][1] ) / 2);
//			avg[i] 의 i가[0~4 번째 의 평균 값]
		}
		
		
		
		 
	}
}


