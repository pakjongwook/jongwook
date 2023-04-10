package test1;

public class Study2 {
	
	public static void main(String[] args) {
		String[] id_pw = {"meossenug", "1234"};
		String[][] db = {{"rardss","123"},{"yyoom","1234"},{"meosseugi","1234"}};
		
		System.out.print(study2(id_pw,db));
	}
	
	public static String study2(String[] id_pw, String[][] db) {
		String answer = "";
		
		for(int i =0; i< db.length; i++) {
			if(id_pw[0].equals(db[i][0]) && id_pw[1].equals(db[i][1])){
				answer = "login";
				break;
			} else if(id_pw[0].equals(db[i][0]) && id_pw[1] != (db[i][1])) {
				answer = "wrong pw";
				
			}else {
				answer = "fail";
			}
			
		}

		return answer;
	}
}