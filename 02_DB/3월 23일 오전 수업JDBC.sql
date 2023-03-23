-- TO_CHAR(ENT_DATE,'YYYY"년" MM"월" DD"일"') ENT_DATE --2 퇴직한 사원의 2023넌 3월 22일 나오게하는 구문 그래서 이클립스에서 String 한 이유


/*5. 사번으로 사원 정보 수정*/
UPDATE EMPLOYEE 
SET PHONE  = ?,
	EMAIL  = ?,
	SALARY = ?,
	BONUS  = ?,
WHERE EMP_ID = ?
;

-- 입력 받은 사번의 사원이 존재하지 않으면 0
-- 사원은 있는데 퇴직처리된 사원이면 1
-- 사원도 있고, 재직중인 사원이면 2 조회
-- SELECT 서브쿼리 + 리터럴(0,1,2)
-- FROM DUAL;

-- 선택함수 DECODE / CASE (코드가 길어질때는)
-- SELECT CASE 
--	   WHEN 조건식
--	   THEN 조건식 참일 경우
--	   
--	   WHEN 조건식
--	   THEN 조건식 참일 경우
--	   
--	   ELSE 모두 거짓일 때 
--	END
--
-- FROM DUAL;

SELECT CASE 
	   -- 존재하지 않는 사원?
	   WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = 200) = 0  
	   THEN 0
	   
	   -- 존재하지만 퇴직한 사원?
	   WHEN  (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = 200 AND ENT_YN = 'Y' ) = 1
	   THEN 1
	   
	   -- 존재는 하지만 퇴직하지 않은 사원!
	   ELSE 2
	END "CHECK" -- CHECK 라는 별칭

FROM DUAL;





SELECT CASE 
		
	  -- 남자인 사원 				
	  WHEN 	
      
	
	
	END
	
	
	
	
	
-- 7 퇴직 처리
UPDATE EMPLOYEE 
SET ENT_YN = 'Y',
	ENT_DATE = SYSDATE 
WHERE EMP_ID = ?;


/* 8.	가장 최근(입사일이 늦은) 사원 5명의 사번, 이름, 부서명, 입사일을
	입사일 내림차순으로 조회 */
-- ROWNUM, 인라인뷰(FROM 절 서브쿼리)
SELECT * FROM 
 (SELECT EMP_ID, EMP_NAME, NVL( DEPT_TITLE, '부서없음') DEPT_TITLE , HIRE_DATE
  FROM EMPLOYEE 
  LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
  ORDER BY HIRE_DATE DESC)
WHERE ROWNUM <= 5;
-- DELETE 확인


-- 9. 
SELECT DEPT_CODE ,NVL(DEPT_TITLE, '부서없음') DEPT_TITLE,  
 COUNT(*) 인원 , FLOOR( AVG( SALARY) ) 평균
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY DEPT_CODE, DEPT_TITLE
ORDER BY DEPT_CODE;





























