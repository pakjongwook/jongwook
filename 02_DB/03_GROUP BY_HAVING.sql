SELECT DEPT_CODE FROM EMPLOYEE; -- 23행조회

SELECT SUM(SALARY) FROM EMPLOYEE; -- 1행 조회

-- 부서별 급여 합 조회 
SELECT DEPT_CODE, SUM(SALARY) FROM EMPLOYEE;  
-- ORA-00937: 단일 그룹의 그룹 함수가 아닙니다

SELECT DEPT_CODE ,SUM(SALARY) -- 3) 그룹별 SALARY 합계를 조회
FROM EMPLOYEE -- 1) EMPLOYEE 테이블에서 
GROUP BY DEPT_CODE; -- 2) DEPT_CODE가 같은 행끼리 그룹을 지어



------------------------------------
/* SELECT문 해석 순서
 * 
 *5* : SELECT 컬럼명, 함수, 계산식, 리터럴[[AS] 별칭]
 *1* : FROM 테이블명
 *2* : WHERE 조건식
 *3* : GROUP BY 그룹으로 묶을 컬럼명|함수
 *4* : HAVING 그룹함수를 이용한 조건식 (GROUP BY가 있어야 작성가능!)
 * 
 *6* : ORDER BY 컬럼명|별칭|컬럼순서 정렬방식 [NULL FIRST|LAST]
 *
 * */ 

-- * GROUP BY 절 : 같은 값들이 여러 개 기록된 행을 하나의 그룹으로 묶음 

-- 부서별 급여 평균
SELECT AVG(SALARY) --4
FROM EMPLOYEE   -- 1
GROUP BY DEPT_CODE --2
ORDER BY DEPT_CODE; --3

-- 부서별 급여합, 급여평균, 인원 수, 최고참 입사일, 막내 입사일 
-- 부서코드 오름차순으로 조회
SELECT SUM(SALARY), ROUND( AVG(SALARY)), COUNT(*),
		MIN(HIRE_DATE), MAX(HIRE_DATE) 
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- 각 지급코드별로 보너스를 받는 사원의 수를 조회
-- 직급코드 오름차순

SELECT JOB_CODE ,COUNT(BONUS)  -- COUNT(*) 
FROM EMPLOYEE
GROUP BY JOB_CODE 
ORDER BY JOB_CODE;

-- EMPLOYEE 테이블에서
-- 성별과 , 성별 별 급여 평균(내림처리), 급여 합, 인원 수 조회
-- 인원 수 내림차순 정렬

SELECT DECODE(SUBSTR(EMP_NO,8,1) ,'1','남','2','여') 성별
	, FLOOR(AVG(SALARY)) "급여 평균",
	  SUM(SALARY ) "급여 합",
	  COUNT(*) "인원 수"
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO,8,1),'1','남','2','여') -- *** 함수도 쓸수 있다.***
       --> SELECT절 해석이 되지 않아 성별 별칭 사용 불가능 
ORDER BY "인원 수";

-- WHERE + GROUP BY 
---> WHERE절이 GROUP BY절보다 우선 순위가 빠르다!

-- EMPLOYEE 테이블에서 부서코드가 'D5', 'D6'인 부서의 평균 급여 조회

SELECT DEPT_CODE , AVG(SALARY) -- 4) DEPT_CODE와 급여 평균 조회
FROM EMPLOYEE -- 1) EMPLOYEE 테이블에서
WHERE DEPT_CODE IN('D5','D6') -- 2) 부서코드가 D5, D6인 행만 추려서
GROUP BY DEPT_CODE;  -- 3) 추려진 결과 내에서 부서코드 별로 그룹을 지어


-- EMPLOYEE 테이블에서 직급별 2000년도 이후 입사자들의 급여 합 조회
--                      (2000년 이상)

SELECT JOB_CODE , SUM(SALARY) 
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM HIRE_DATE) >= 2000
GROUP BY JOB_CODE;

SELECT EMP_NAME ,HIRE_DATE 
FROM EMPLOYEE 
-- WHERE EXTRACT(YEAR FROM HIRE_DATE) >= 2000;
WHERE HIRE_DATE >=  TO_DATE('2000-01-01');


----------------------------------------------------------------------------

-- * 그룹 내 그룹(소규모 그룹) 만들기 *

-- EMPLOYEE 테이블에서 부서별로 같은 직급인 사원의 급여합을 
-- 부서코드 오름차순으로 조회
SELECT DEPT_CODE ,JOB_CODE ,SUM(SALARY) 
FROM EMPLOYEE
GROUP BY DEPT_CODE , JOB_CODE  
--       (큰 그룹)     (작은 그룹)
ORDER BY DEPT_CODE ;
