-- 1번문제
SELECT EMP_NAME "사원명" , FLOOR(ABS(HIRE_DATE - SYSDATE)) "근무일수1", -- 입사일-오늘 ABS(절대 값)--> 양수되도록 처리
FLOOR(ABS(SYSDATE-HIRE_DATE)) "근무일수2" -- 오늘-입사일   소수점버림 --> FLOOR 
FROM EMPLOYEE;

-- 2번문제
SELECT EMP_ID ,EMP_NAME ,EMAIL ,PHONE 
FROM EMPLOYEE
-- WHERE MOD(EMP_ID,2)=1;  -- WHERE 어디에 홀수번쨰 사원이있는지  MOD--> 나머지 구하는 함수
-- 짝수 SELECT * FROM EMPLOYEE WHERE MOD(INDEX,2)=0;  
WHERE SUBSTR(EMP_ID,-1,1) IN(1,3,5,7,9);  -- SUBSTR(EMP_ID,-1,1) ==> 맨끝에 자리수가 나옴 
-- 3번 문제
SELECT *
FROM EMPLOYEE
WHERE (MONTHS_BETWEEN(SYSDATE,HIRE_DATE) / 12) >=20; -- WHERE 사원이 어디에있는지 확인 
-- MONTHS_BETWEEN(SYSDATE,HIRE_DATE) / 12 근무 N년차 MONTHS_BETWEEN(날짜, 날짜 ) 두 날짜의 개월 수 차이 
-- WHERE EXTRACT (YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) >= 20;
--4번 문제
SELECT EMP_NAME, SUBSTR(EMP_NO , 1 , 8) || '******' 주민등록번호 -- 주민등록번호 맨 끝 '' 리터럴 표시해도 되고 안해도됨(문자니까) --> 8000000 '원' AS 별칭(단위)
FROM EMPLOYEE;
-- REPLACE(EMP_NO,SUBSTR(EMP_NO,9),'******') 주민등록번호 / REPLACE : '문자열' or 열 이름, '바꾸려는 문자열', '바뀔 문자열'
-- RPAD(SUBSTR(EMP_NO,1,8),14,'*')주민등록번호 RPAD -> 오른쪽으로 칸 수 설정 14칸(주민등록번호) --> SUBSTR,1,8로 뽑고 나머지는*로 채운다 

-- 5번문제
SELECT EMP_NAME , JOB_CODE , NVL((SALARY+(SALARY*BONUS))*12, SALARY*12) "연봉(원)"  -- NVL(P1,P2) P1: NULL데이터를 처리할 컬럼명 혹은 값  P2: NULL값을 대체하고자 하는 값 (연봉만)
FROM EMPLOYEE;
-- TO_CHAR ((SALARY + (SALARY *NVL(BONUS,0) )) * 12, 'L999,999,999') "연봉(원)" 
-- TO_CHAR ==> 문자열로 반환 , DB의 설정된 나라의 화폐의 표시가나옴  /((SALARY(보너스 받은 직원) + (SALARY(월급) * NVL(BONUS,0) )) * 12 ==> 보너스을 받지 않은 직원 , 1입력시 ==> 100% 보너스가 상승하기 때문에 0으로 설정
																	
-- '' : 값, 리터럴
-- "" : 계정명, 비밀번호, 컬럼명, 테이블명(리터럴X)
--      값이 아닌 것들에 대한 대소문자 구분


--6번

SELECT EMP_ID ,EMP_NAME ,DEPT_CODE ,HIRE_DATE 
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D5' OR DEPT_CODE = 'D9') --()의 친 이유는 따로 따로 처리해야되서  
AND EXTRACT(YEAR FROM HIRE_DATE) = 2004;

--1) WHERE DEPT_CODE IN('D5','D9')
--   AND EXTRACT(YEAR FROM HIRE_DATE) = 2004;
--2) AND TO_CHAR(HIRE_DATE,'YYYY') = '2004';  문자열로 바꾸고 문자열로 비교 ''리터럴표시 -- 문자열 
-- 7번 
SELECT EMP_NAME ,HIRE_DATE , LAST_DAY(HIRE_DATE) - HIRE_DATE +1 "입사한 달의 근무 일수" 
-- LAST_DAY 해당월의 마지막 입사일  - 입사한 날  -- 일단위로 나온다
-- EX) 내가 오늘 입사가 8일 , 말까지 일하겠다하면 31일 => 31 -8 = 23(근무 일수)  
FROM EMPLOYEE;                                                                                                          

-- 8번			                                              -- SUBSTR(EMP_NO,1,6)
SELECT EMP_NAME ,DEPT_CODE,  TO_CHAR(TO_DATE(SUBSTR(EMP_NO, 1,INSTR(EMP_NO,'-')-1)), 'YY"년" MM"월" DD"일"') 년월일 , 
							-- SUBSTR(EMP_NO,1,2) || '년' 1첫번째칸 2개씩					
							-- SUBSTR(EMP_NO,3,2) || '월' 					
							-- SUBSTR(EMP_NO,5,2) || '일' 생년월일					
-- TRUNC((SYSDATE - TO_DATE(SUBSTR(EMP_NO,1,6)))/365) "만 나이"   -- 365 일수을 계산하기위해 --> 윤년 포함되지 않아서 항상 1년이 365일이 아니기 때문에 
   FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO,1,6))) / 12) "만 나이" -- 양수 버림(TRUCK)에서 내림(FLOOR) 똑같음, 음수는 틀림
FROM EMPLOYEE; 																-- MONTHS_BETWEEN(윤년(2월 29일(4년에 한번씩))이포함) 은 정확한 달의 차이을 나타내기 때문에 	

