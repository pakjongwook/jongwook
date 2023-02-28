package edu.kh.collection.list.service;

import java.util.ArrayList;
import java.util.List;
import edu.kh.collection.list.dto.Student;

public class StudentService { // 컬렉션
	
	private List<Student> studentList = new ArrayList<Student>();
	

	
	
	public StudentService() {
		                             // 띄어쓰기 "홍길동 " 조심 ==> 오류 발생 
		studentList.add(new Student("홍길동", 3,5,7, "서울시 중구", 'M',75));
		studentList.add(new Student("강지영", 2,6,3, "서울시 은평구", 'F',95));
		studentList.add(new Student("박종욱", 6,2,19, "서울시 서대문구", 'M',100));
		studentList.add(new Student("강아명", 2,5,8, "경기도 안산시", 'F',95));
		studentList.add(new Student("최원석", 3,6,11, "서울시 종로구", 'M',85));
		
	}
		
		/** StudentList에 학생 추가  alt + shift + j
		 * @param std
		 * @return true
		 */
		public boolean addStudent(Student std) {
			return studentList.add(std);
	}
		
		
		/** 학생 전체 조회 서비스
		 * @return
		 */
		public List<Student> selcetAll() { // List<Student> 반환명
			return studentList;
		}

		/** 학생 정보 수정 서비스
		 * @param index
		 * @param std
		 * @return s:Student (수정되기 전 학생 정보)
		 */
		public Student updateStudent(int index, Student std) {
			
			// set (int index, E e) : 1) index에 위치하는 요소를 e로 변경
			//						  2) 기존에 있던 요소 e2를 반환	
			
			return studentList.set(index, std);
		}

		/** 학생 정보 제거 서비스
		 * @param index
		 * @return S:Student (제거된 학생 정보)
		 */
		public Student removeStudent(int index) {
			
			// E remove(int index) : index번째 요소를 List에서 제거하여 반환
			
			// boolean remove(E e) : List에서 일치하는 E와 일치하는 요소를 찾아서
			//                       있으면 제거하고 true
			//						 없으면 false 반환
			
			
			
			return studentList.remove(index);
		}

		/** 학생 이름 검색 서비스
		 * @param name
		 * @return list : List<Student>  이름이 일치하는 학생 리스트
		 */
		public List<Student> selectName(String name) {
			
			// 1) 검색 결과를 저장할 List<Student> 생성
			List<Student> list = new ArrayList<Student>();
			
			// 2) StudentList의 모든 요소를 순차 접근하면서 이름이 일치하는 학생을 
			// 	  list에서 추가
			
			for(Student s : studentList) {
				if(s.getName().equals(name)) list.add(s); // list 추가해라 
			}
			
			
			
			//3) 검색 결과 반환
			return list;
		}

		/** 학생 주소 검색 서비스
		 * @param input
		 * @return list:List<Student> 검색어가 주소에 포함된 학생 리스트 
		 */
		public List<Student> selectAddress(String input) {
			
			List<Student> list = new ArrayList<Student>();
			
			// String.contains("문자열") : String에 '문자열'이 포함되어 있으면 true 반환
			for(Student s : studentList) { // 꺼내쓰는게 s 전달 input
				if(s.getAddress().contains(input)) list.add(s); // String 반환 
				
				
			}
			return list;
		}

		/** 학년별 검색
		 * @param input
		 * @return list:List<Student> 검색어가 학년에 포함된 학생 리스트
		 */
		public List<Student> selectgrade(int input) {
			
			List<Student> list = new ArrayList<>(); 
									// 제네릭의 타입 추론 유추가능 = 앞 Student ... 반대로는 안됨
									// - 생성되는 컬렉션 객체의 제네릭을 별도 작성하지 않아도
									// 참조 변수의 제네릭을 통해 제한되는 타입을 유추(추론)
			
			for(Student s : studentList) {
				if(s.getGrade() == input) list.add(s);  // input : 검색할 학년  list 추가 
			}
			return list;
		}
		
		/** 성별 조회 서비스
		 * @param inputGender
		 * @return
		 */
		public List<Student> selectGender(char inputGender){
			List<Student> list = new ArrayList<>();
			
			for(Student s : studentList) {
				if(s.getGender() == inputGender) list.add(s);
			}
			
			return list;
		}
		

		
		
}
