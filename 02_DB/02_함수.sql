-- 함수 : 컬럼의 값을 읽어서 연산 결과를 반환

-- 단일행 함수 : N개의 행의 값을 전달하여 N개의 결과를 반환

-- 그룹 함수 : N개의 행의 값을 하나의 그룹으로 묶어 
--          그룹 수 만큼의 결과를 반환 

-- 함수는 SELECT절 ,WHERE절, ORDER BY절, GROUP BY절, HAVING절 사용 가능


/**************단일행 함수******************/

--<문자열 관련 함수>

-- LENGTH(문자열 | 컬럼명) : 문자열 길이 반환
SELECT 'HELLO WORLD', LENGTH('HELLO WORLD') FROM DUAL; --DUAL 가짜 테이블

-- EMPLOYEE 테이블에서 이메일이 12글자인 사원의
-- 이름, 이메일 조회
SELECT EMP_NAME ,EMAIL 
FROM EMPLOYEE
WHERE LENGTH(EMAIL) = 12;

-- EMPLOYEE 테이블에서 이메일 길이 오름차순으로 조회
SELECT EMP_NAME ,EMAIL 
FROM EMPLOYEE
ORDER BY LENGTH(EMAIL) ASC; 

--------------------------------------------------------------
-- INSTR(문자열 | 컬럼명, '찾을 문자열' [, 찾을 시작 위치 [, 순번] ]) [](생략)
-- 찾을 시작 위치부터 지정된 순번째에 찾을 문자열의 시작 위치 반환

-- 문자열 에서 맨 앞에있는 B의 위치 조회
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA','B') FROM DUAL;

-- 문자열을 5번째 부터 검색하여 처음 찾는 B의 위치 조회 
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA','B', 5) FROM DUAL;

-- 문자열을 5번째 부터 검색하여 두번째로 찾는 B의 위치 조회 
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA','B', 5,2) FROM DUAL;											

-- EMPLOYEE 테이블에서
-- 사원명,이메일, 이메일 중 '@' 위치 조회
SELECT EMP_NAME ,EMAIL ,INSTR(EMAIL,'@') 
FROM EMPLOYEE; 

------------------------------------------------------------------

-- SUBSTR(문자열 | 컬럼명, 시작 위치, [, 길이])
-- 문자열을 시작 위치부터 지정된 길이 만큼 잘라내서 반환
-- 길이 미작성 시 시작 위치 부터 끝까지 잘라내서 반환
SELECT SUBSTR('ABCDEF',3,3) FROM DUAL; -- CDE 

SELECT SUBSTR('ABCDEF',3) FROM DUAL; -- CDEF

-- EMPLOYEE 테이블에서 사원명과 사원의 이메일 아이디만 조회
-- 아이디 오름차순
SELECT EMP_NAME,SUBSTR(EMAIL, 1, INSTR(EMAIL, '@') -1 ) 아이디
FROM EMPLOYEE
ORDER BY 아이디;

-------------------------------------------------------------------

-- TRIM([ [옵션] 문자열 | 컬럼명 FROM] 문자열 | 컬럼명)
-- 주어진 문자열의 앞쪽|뒤쪽|양쪽에 존재하는 지정된 문자열을 제거

-- 옵션 : LEADING(앞쪽), TRAILING(뒤쪽), BOTH(양쪽, 기본값)

SELECT '#####K H#####',
	TRIM(LEADING '#' FROM '#####K H#####' ),
	TRIM(TRAILING '#'FROM '#####K H#####'),
	TRIM(BOTH '#' FROM '#####K H#####')
FROM DUAL;

-- 문자열 앞뒤 공백 제거 (해당 용도로 가장 많이 사용됨)
SELECT TRIM('     K H     ') FROM DUAL; -- 'K H' 

----------------------------------------------------------------

-- REPLACE(문자열 | 컬럼명, 찾을 문자열, 바꿀 문자열)
-- 찾을 문자열을 바꿀 문자열로 변경하여 문자열 반환  
SELECT REPLACE (NATIONAL_NAME, '한국','대한민국') 
-- '국' ,'대한민국' 실행하면
--한대한민국
--일본
--중(국)->대한민국
--미(국)->대한민국
--러시아
FROM NATIONAL;


-----------------------------------------------------------------
-----------------------------------------------------------------

--<숫자 관련 함수>

--MOD(숫자 | 컬럼명, 숫자 | 컬럼명) 나머지 값 반환
SELECT EMP_NAME ,MOD(SALARY, 1000000)
FROM EMPLOYEE;

-- ABS(숫자 | 컬럼명) : 절대값
SELECT ABS(10),ABS(-10)FROM DUAL;

-- CEIL(숫자 | 컬럼명) : 올림
-- FLOOR(숫자 | 컬럼명) : 내림
---> 둘 다 소수점 첫째 자리에서 처리 -> 정수 결과 반환

SELECT 123.5,CEIL(123.5), FLOOR(123.5) FROM DUAL; 


 
