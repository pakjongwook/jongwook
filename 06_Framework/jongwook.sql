ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

-- 계정 생성
CREATE USER project IDENTIFIED BY "project1234";

-- 권한 부여
GRANT CONNECT, RESOURCE, CREATE VIEW TO project;

-- 객체 생성 공간 할당
ALTER USER project DEFAULT TABLESPACE SYSTEM
QUOTA UNLIMITED ON SYSTEM;

---------------------------------------------------------------------

DROP TABLE "MEMBER";
-- 잘못 될경우 DROP TABLE 실행 시키고 권한 부여, 객체 생성 공간 할당을 따로 안해도 됨 --> CREATE 부터 실행 시키면 됨

-- 관리자권한 오류 뜨면 관리자 계정 바꾸고 권한부여 , 객체생성공간할당 실행하고 project로 바꾸고 실행
CREATE TABLE "MEMBER" (
	"MEMBER_NO"	NUMBER		NOT NULL,
	"MEMBER_EMAIL"	VARCHAR2(50)		NOT NULL,
	"MEMBER_PW"	VARCHAR2(100)		NOT NULL,
	
	"MEMBER_NICKNAME" VARCHAR2(30) NOT NULL,
	
	"MEMBER_TEL"	CHAR(11)		NOT NULL,
	"MEMBER_ADDR"	VARCHAR2(300)		NULL,
	"PROFILE_IMG"	VARCHAR2(300)		NULL,
	"ENROLL_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"MEMBER_DEL_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"AUTHORITY"	NUMBER	DEFAULT 1	NOT NULL
);

COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원번호(SEQ_MEMBER_NO)';

COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" IS '회원이메일';

COMMENT ON COLUMN "MEMBER"."MEMBER_PW" IS '회원비밀번호(암호화 적용)';

COMMENT ON COLUMN "MEMBER"."MEMBER_NICKNAME" IS '회원이름(별명)';

COMMENT ON COLUMN "MEMBER"."MEMBER_TEL" IS '전화번호(-없음)';

COMMENT ON COLUMN "MEMBER"."MEMBER_ADDR" IS '회원주소';

COMMENT ON COLUMN "MEMBER"."PROFILE_IMG" IS '프로필이미지저장경로';

COMMENT ON COLUMN "MEMBER"."ENROLL_DATE" IS '회원가입일';

COMMENT ON COLUMN "MEMBER"."MEMBER_DEL_FL" IS '탈퇴여부(N:탈퇴X, Y:탈퇴O)';

COMMENT ON COLUMN "MEMBER"."AUTHORITY" IS '회원권한(1:일반, 2: 관리자)';

ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	"MEMBER_NO"
);

-- 탈퇴여부 CHECK 제약 조건
ALTER TABLE "MEMBER" ADD CONSTRAINT "CH_MEMBER_DEL_FL"
CHECK("MEMBER_DEL_FL" IN('N','Y'));

-- 권한 CHECK 제약 조건
ALTER TABLE "MEMBER" ADD CONSTRAINT "CH_AUTHORITY"
CHECK("AUTHORITY" IN('1','2'));


-- 시퀀스 생성
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;
-- 1부터 1씩 생성


-- 샘플 계정 추가
INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user01@kh.or.kr','pass01!'
		,'유저일','01012341234', '04540,,서울시 중구 남대문로 120,,2층',
		NULL, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user02@kh.or.kr','pass02!'
		,'이번유저','01043214321', '04540,,서울시 중구 남대문로 120,,2층',
		NULL, DEFAULT, DEFAULT, DEFAULT);
	
COMMIT;


-- 로그인 SQL
SELECT MEMBER_NO, MEMBER_EMAIL, MEMBER_NICKNAME,
	MEMBER_TEL, MEMBER_ADDR, PROFILE_IMG , AUTHORITY,
	
	TO_CHAR(ENROLL_DATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"')  AS ENROLL_DATE
	
FROM "MEMBER" 
WHERE MEMBER_DEL_FL ='N'
AND MEMBER_EMAIL = 'user01@kh.or.kr'
AND MEMBER_PW ='pass01!';


-- user01의 비밀번호 변경
UPDATE "MEMBER" SET
MEMBER_PW = '$2a$10$Bpolx5IpJ6Kzz5q/tAb6X.rqEugZuqEiEqMUomuyFft.xiwFK9uVS'

COMMIT;


SELECT * FROM "MEMBER";

UPDATE MEMBER
SET MEMBER_ADDR = REPLACE(MEMBER_ADDR, ',,', '^^^')
WHERE INSTR(MEMBER_ADDR, ',,') > 0;

COMMIT;

-- 회원 정보 수정
--UPDATE 테이블명 SET
--컬럼명 = 값,
--컬럼명 = 값,
--컬럼명 = 값
--WHERE  조건
--;

--UPDATE "MEMBER" SET
--MEMBER_NICKNAME = 값,
--MEMBER_TEL = 값,
--MEMBER_ADDR = 값
--WHERE MEMBER_NO = 값

DELETE FROM "MEMBER" 
WHERE MEMBER_NICKNAME = '유저삼';
COMMIT;


-- 회원번호가 일치하는 회원의 비밀번호 조회
SELECT MEMBER_PW FROM "MEMBER"
WHERE MEMBER_NO = '4';

-- 회원 번호가 일치하는 회원의 비밀번호 변경
--UPDATE "MEMBER" 
--SET MEMBER_PW = #{memberPw}
--WHERE MEMBER_NO = #{memberNo} 

-- 회원 탈퇴 
UPDATE "MEMBER" 
SET MEMBER_DEL_FL = 'Y'
WHERE MEMBER_DEL_FL = #{memberNo};

ROLLBACK;

SELECT * FROM "MEMBER" ;

DELETE FROM "MEMBER" 
WHERE MEMBER_NICKNAME = '유저사';
COMMIT;



