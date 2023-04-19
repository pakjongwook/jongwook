
<<<<<<< HEAD
public class Study3 {
	
	public static void main(String[] args) {
		String[] spell = {"p","o","s"};
		String[] dic = {"sod","eocd","qixm","adio","soo"};
		
		System.out.print(study3(spell,dic));
	}
	
=======
public class test1 {
>>>>>>> origin/main

   public static void main(String[] args) {
      String[] dic = { "moos", "dzx", "smm", "sunmmo", "som" };
      String[] spell = { "s", "o", "m", "d" };
      int answer = 2;   // 변수 있으면 1 없으면 2 로 반환하기 위해 선언 코드를 간략하기 위해서 사용 
      for (int i = 0; i < dic.length; i++) {  // for문에서 dic 에 있는 것을 dic.length 만큼 index을 꺼내기 위해  
         int count = 0;  // count 선언 (확인용 변수) 
         for (int j = 0; j < spell.length; j++) { // spell 배열을 하나씩 꺼내기 위해   
            if (dic[i].contains(spell[j])) { // 만약 dic [i] 가 spell[j] 포함하고 있다면
               count++; //  있으면 count ++  -> 1 
            }
         }
         if (count  == spell.length ) { 
            answer = 1;  
         }
         return answer;  // 답변용
      }
      