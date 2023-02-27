package edu.kh.collection.list.service;

import java.util.ArrayList;
import java.util.List;
import edu.kh.collection.list.dto.Student;

public class StudentService { // 컬렉션
	
	private List<Student> studentList = new ArrayList<Student>();
	

	
	
	public StudentService() {
		
		studentList.add(new Student("홍길동 ", 3, 5, 7, "서울시 중구", 'M',75));
		studentList.add(new Student("강지영 ", 2, 6, 3, "서울시 은평구", 'F',95));
		studentList.add(new Student("박종욱 ", 6, 2, 19, "서울시 서대문구", 'M',100));
		studentList.add(new Student("강아명 ", 2, 5, 8, "경기도 안산시", 'F',95));
		studentList.add(new Student("최원석 ", 3, 6, 11, "서울시 종로구", 'M',85));
		
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
	
}
