--　한　줄 주석

/*
 * 주석 범위
 * 
 * */


ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

-- crtl + ENTER : 선택한 SQL 수행



-- 사용자 계정 생성
CREATE USER kh_pj IDENTIFIED BY "oracle_pjw9597A";


-- 사용자 계정에 권한 부여
GRANT RESOURCE, CONNECT TO kh_pj;

-- 객체가 생성 될 수 있는 공간 할당량 지정
ALTER USER kh_pj DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;



