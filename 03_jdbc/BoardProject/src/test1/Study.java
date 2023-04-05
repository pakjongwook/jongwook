package test1;

public class Study {
	
	public static void main(String[] args) {
	      
	      int[][] score1 = {{80, 70}, {90, 50}, {40, 70}, {50, 80}};
	      int[][] score2 = {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};
	      
	      int[] answer1 = solution(score1);
	      int[] answer2 = solution(score2);
	      
	      // [1, 2, 4, 3]
	      for(int i : answer1) 
	         System.out.print(i + " ");
	      
	      System.out.println();
	      
	      // [4, 4, 6, 2, 2, 1, 7]
	      for(int i : answer2)
	         System.out.print(i + " ");
	   }
	   
	   public static int[] solution(int[][] score) {
	      int[] answer = {};

	        return answer;
	   }

}


