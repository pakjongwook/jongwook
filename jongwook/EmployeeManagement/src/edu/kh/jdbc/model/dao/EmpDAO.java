package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import edu.kh.jdbc.model.dto.Emp;
 

public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	/** 이메일, 전화번호, 급여, 보너스 수정
	 * @param conn
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int updateEmployee(Connection conn, Emp emp) throws SQLException {
		
		// 1. 결과 저장용 변수/객체 선언
		int result = 0; // 행의 갯수를 저장 
		
		try {
		// 2. SQL 구문 작성
		//    PreparedStatement (생성할 때)  / Statement 생성 (실행할 때)
		String sql = "UPDATE EMPLOYEE \r\n"
				+ "SET PHONE  = ?,\r\n"
				+ "	EMAIL  = ?,\r\n"
				+ "	SALARY = ?,\r\n"
				+ "	BONUS  = ?,\r\n"
				+ "WHERE EMP_ID = ?";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, emp.getPhone());
		
		// 3. 수행 후 결과 반환 받아 결과 저장용 변수에 저장
		// SELECT문 : executeQuery([SQL]), 
		// DML문    : excuteUpdate([SQL])
		// [SQL] 작성하는 경우 : Statement 객체 사용 할 때
		
		result = pstmt.executeUpdate();
		
		} finally {
		
		// 4. JDBC 객체 자원 반환
			close(pstmt);
		}
		// 5. 결과 반환
		return result;
	}


	/** 존재하는 사원인지, 퇴직한 사원인지 조회하는 SQL 수행 후 결과 반환
	 * @param conn
	 * @param input
	 * @return check
	 * @throws SQLException
	 */
	public int checkEmployee(Connection conn, int input) throws SQLException {
		int check = 0; // 결과를 반환하는 정수 선언
		
		try {
			String sql = "SELECT CASE \r\n"
					+ "	   WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = ?) = 0  \r\n"
					+ "	   THEN 0\r\n"
					+ "	   \r\n"
					+ "	   WHEN  (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = ? AND ENT_YN = 'Y' ) = 1\r\n"
					+ "	   THEN 1\r\n"
					+ "	   \r\n"
					+ "	   ELSE 2\r\n"
					+ "	END \"CHECK\" "
					+ "\r\n"
					+ "FROM DUAL;";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			pstmt.setInt(2, input);
			
			rs = pstmt.executeQuery(); // ? 가 있을 때 사용
			// executeQuery : select 구문을 호출할 때 Resultset(select 결과) 반환
			// executeupdate : update이 된 갯수 반환 
			
			
			if(rs.next()) { // SELECT 단일 행 (값 하나)
				check = rs.getInt("CHECK");
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return check;
	}


	/** 퇴직 처리 SQL 수행
	 * @param conn
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public int retireService(Connection conn, int input) throws SQLException {
		
		try {
			String sql = "UPDATE EMPLOYEE \r\n"
					+ "SET ENT_YN = 'Y',\r\n"
					+ "	ENT_DATE = SYSDATE \r\n"
					+ "WHERE EMP_ID = ?;";
		
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			pstmt.executeQuery();
			
		}finally {
			close(pstmt);
		}
		
	
		
		return 0;
	}


	/** 부서별 통계 조회 SQL 수행 후 결과 반환
	 * @param conn
	 * @return mapList
	 * @throws SQLException
	 */
		
	public List<Map<String, Object>>selectDepartment(Connection conn) throws SQLException {
		
		// 1. 결과 저장용 객체 생성
		java.util.List<Map<String, Object>> mapList = new ArrayList<>();
		
		try {
		// 2. SQL 작성 후 수행
			String sql = "SELECT DEPT_CODE ,NVL(DEPT_TITLE, '부서없음') DEPT_TITLE,  \r\n"
					+ " COUNT(*) 인원 , FLOOR( AVG( SALARY) ) 평균\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "GROUP BY DEPT_CODE, DEPT_TITLE\r\n"
					+ "ORDER BY DEPT_CODE";
			
			
			
			stmt = conn.createStatement(); // ? 가 없을 때 사용
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String deptTitle = rs.getString("DEPT_TITLE");
				int count = rs.getInt("인원");
				int avg = rs.getInt("평균");
				
				Map<String, Object> map = new LinkedHashMap<>();
										// 입력 순서가 유지되는 Map
				
				map.put("deptTitle", deptTitle);
				map.put("count", count);
				map.put("avg", avg);
				
				// Map을 List에 추가
				mapList.add(map);
				
			}
					
		}finally {
			close(rs);
			close(stmt);
		}
		
		
		// 5. 결과 반환
		return null;
	}



}
