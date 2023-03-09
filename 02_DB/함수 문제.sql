-- 1번문제
SELECT EMP_NAME "사원명" , ABS(FLOOR(HIRE_DATE - SYSDATE)) "근무일수1", -- 입사일-오늘 ABS(절대 값)
ABS(TRUNC(SYSDATE-HIRE_DATE)) "근무일수2" -- 오늘-입사일
FROM EMPLOYEE;

-- 2번문제
SELECT EMP_ID ,EMP_NAME ,EMAIL ,PHONE 
FROM EMPLOYEE
WHERE MOD(EMP_ID,2)=1;  -- WHERE 어디에 홀수번쨰 사원이있는지 
-- 짝수 SELECT * FROM EMPLOYEE WHERE MOD(INDEX,2)=0;  

-- 3번 문제
SELECT *
FROM EMPLOYEE
WHERE (MONTHS_BETWEEN(SYSDATE,HIRE_DATE) / 12) >=20; -- WHERE 사원이 어디에있는지 확인 
-- MONTHS_BETWEEN(SYSDATE,HIRE_DATE) / 12 근무 N년차 MONTHS_BETWEEN(날짜, 날짜 ) 두 날짜의 개월 수 차이 

--4번 문제
SELECT EMP_NAME, SUBSTR(EMP_NO , 1 , 7) || '******' 주민등록번호 -- 주민등록번호 맨 끝 '' 리터럴 표시해도 되고 안해도됨(문자니까) --> 8000000 '원' AS 별칭(단위)
FROM EMPLOYEE;

-- 5번문제
SELECT EMP_NAME , JOB_CODE , NVL((SALARY+(SALARY*BONUS))*12, SALARY*12) "연봉(원)"  -- NVL(P1,P2) P1: NULL데이터를 처리할 컬럼명 혹은 값  그냥 연봉만
																						--      P2: NULL 값을 대체하고자 하는 값 "()" --> 특수문자
FROM EMPLOYEE;

-- '' : 값, 리터럴
-- "" : 계정명, 비밀번호, 컬럼명, 테이블명(리터럴X)
--      값이 아닌 것들에 대한 대소문자 구분


--6번

SELECT EMP_ID ,EMP_NAME ,DEPT_CODE ,HIRE_DATE 
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D5' OR DEPT_CODE = 'D9') --()의 친 이유는 따로 따로 처리해야되서  
AND EXTRACT(YEAR FROM HIRE_DATE) = 2004;

-- 7번 
SELECT EMP_NAME ,HIRE_DATE , LAST_DAY(HIRE_DATE) - HIRE_DATE +1 "입사한 달의 근무 일수" -- LAST_DAY 해당월의 마지막 입사일  - 입사한 날 EX) 내가 오늘 입사가 8일 , 말까지 일하겠다하면 31일 => 31 -8 = 23(근무 일수)  
FROM EMPLOYEE;

-- 8번
SELECT EMP_NAME ,DEPT_CODE,  TO_CHAR(TO_DATE(SUBSTR(EMP_NO, 1,INSTR(EMP_NO,'-')-1)), 'YY"년" MM"월" DD"일"') 년월일 , 
TRUNC((SYSDATE - TO_DATE(SUBSTR(EMP_NO,1,6)))/365) 만나이   -- 365 일수을 계산하기위해
FROM EMPLOYEE;
-- SUBSTR(EMP_NO,1,6)
