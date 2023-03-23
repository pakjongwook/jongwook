package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Emp;
import java.util.List;

public class EmpService {

	private EmpDAO dao = new EmpDAO();

	/** 사번으로 사원 정보 수정 서비스
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int updateEmployee(Emp emp) throws SQLException {
		// 왜 int 이유
		// -> DML 수행 결과는 반영된(성공) 행의 개수 반환
		// --> 행의 개수는 정수형 --> int 사용
		
		Connection conn = getConnection();
		
		int result = dao.updateEmployee(conn,emp);
		
		// DML 수행 --> 트랜잭션 처리
		
		
		return 0;
	}

	/** 존재하는 사원인지, 퇴직한 사원인지 결과를 반환하는 서비스
	 * @param input
	 * @return check (0: 없는 사원, 1: 퇴직한 사원, 2: 재직중인 사원)
	 * @throws SQLException
	 */
	public int checkEmployee(int input) throws SQLException {
		
		Connection conn = getConnection();
		
		int check = dao.checkEmployee(conn, input);
		
		close(conn);
		
		return check;
	}

	/** 퇴직 처리 서비스
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public int retireEmployee(int input) throws SQLException {
		
		Connection conn = getConnection();
		
		int result = dao.retireService(conn, input); // result 없으면 성공 또는 예외
		
		// 트랙잭션 처리
		if(result >0) commit(conn);  // if(result >0) 없으면 예외 발생 시 SQL 수행이 정상적으로 진행되지 않음
		else          rollback(conn); // commit(conn); 쓰고 끝에 close
		return result;
	}

	/** 부서별 통계 조회 서비스
	 * @return mapList
	 * @throws SQLException
	 */
	public List<Map<String, Object>> selectDepartment() throws SQLException {
		
		Connection conn = getConnection();
		
		List<Map<String, Object>> mapList = dao.selectDepartment(conn);
		
		close(conn);
		
		return mapList;
	}
	
	
	
	
	
}
