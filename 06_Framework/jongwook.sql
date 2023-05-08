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
WHERE MEMBER_NO ='11';

COMMIT;


DELETE FROM "MEMBER" 
WHERE MEMBER_NICKNAME = '유저사';
COMMIT;

-- MEMBER의 탈퇴 동의 취소
UPDATE "MEMBER" 
SET MEMBER_DEL_FL  = 'N'
WHERE MEMBER_NO ='8';

COMMIT;

ROLLBACK;

-- 이메일 중복 검사
SELECT COUNT(*) FROM "MEMBER" 
WHERE MEMBER_EMAIL ='user01@kh.or.kr'
AND MEMBER_DEL_FL ='N';



-- 이메일로 회원 정보 조회
SELECT MEMBER_NO, MEMBER_EMAIL,MEMBER_NICKNAME,MEMBER_TEL ,
		MEMBER_ADDR,
		TO_CHAR(ENROLL_DATE,'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"') AS ENROLL_DATE  
FROM "MEMBER"
WHERE MEMBER_EMAIL ='user01@kh.or.kr'
AND MEMBER_DEL_FL ='N';


-- 이메일이 일부라도 일치하는 모든회원 조회
SELECT MEMBER_NO ,MEMBER_EMAIL ,MEMBER_NICKNAME 
FROM "MEMBER" 
WHERE MEMBER_DEL_FL ='N'
AND MEMBER_EMAIL LIKE '%user%'
ORDER BY MEMBER_NO ;

---------------------------------------------------

-- 이메일 인증
DROP TABLE "AUTH_KEY";

CREATE TABLE "AUTH_KEY" (
	"AUTH_KEY_NO"	NUMBER		NOT NULL,
	"CODE"	CHAR(6)		NOT NULL,
	"EMAIL"	VARCHAR2(50)		NOT NULL,
	"CREATE_TIME"	DATE	DEFAULT SYSDATE	NOT NULL
);

COMMENT ON COLUMN "AUTH_KEY"."AUTH_KEY_NO" IS '인증키 구분 번호(SEQ_AUTH_KEY_NO)';

COMMENT ON COLUMN "AUTH_KEY"."CODE" IS '코드';

COMMENT ON COLUMN "AUTH_KEY"."EMAIL" IS '이메일';

COMMENT ON COLUMN "AUTH_KEY"."CREATE_TIME" IS '인증 코드 생성 시간';

ALTER TABLE "AUTH_KEY" ADD CONSTRAINT "PK_AUTH_KEY" PRIMARY KEY (
	"AUTH_KEY_NO"
);

-- alt + x

CREATE SEQUENCE SEQ_AUTH_KEY_NO NOCACHE;


UPDATE "AUTH_KEY" SET
CODE = #{authkey},
CREATE_TIME = sysdate
WHERE EMAIL = #{email};

INSERT INTO "AUTH_KEY" VALUES(SEQ_AUTH_KEY_NO.NEXTVAL, #{authkey}, #{email}, DEFAULT);

SELECT * FROM "AUTH_KEY";

--SELECT COUNT(*) FROM "AUTH_KEY"
--WHERE EMAIL = #{email}
--AND CODE = #{inputKey}

------------------------------------------------------------------------------------------------------------------

-- ctrl + A ,  Alt + x --> 전체 실행

-- 게시판 종류
CREATE TABLE "BOARD_TYPE"(
	"BOARD_CODE" NUMBER CONSTRAINT "PK_BOARD_TYPE" PRIMARY KEY,
	"BOARD_NAME" VARCHAR2(30) NOT NULL
);

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_CODE" IS '게시판 코드(SEQ_BOARD_CODE)';

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_NAME" IS '게시판 이름';

CREATE SEQUENCE SEQ_BOARD_CODE NOCACHE;

-- 게시판 종류 추가
INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL,'공지사항');

INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL,'자유게시판');

INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL,'테스트 게시판');

INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL,'질문 게시판');

COMMIT;

SELECT * FROM "BOARD_TYPE";



CREATE TABLE "BOARD" (
	"BOARD_NO"	NUMBER		NOT NULL,
	"BOARD_TITLE"	VARCHAR2(150)		NOT NULL,
	"BOARD_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"B_CREATE_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"B_UPDATE_DATE"	DATE		NULL,
	"READ_COUNT"	NUMBER	DEFAULT 0	NOT NULL,
	"BOARD_DEL_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"BOARD_CODE"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글 번호(SEQ_BOARD_NO)';

COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글 제목';

COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글 내용';

COMMENT ON COLUMN "BOARD"."B_CREATE_DATE" IS '게시글 작성일';

COMMENT ON COLUMN "BOARD"."B_UPDATE_DATE" IS '마지막 수정일(수정 시 UPDATE)';

COMMENT ON COLUMN "BOARD"."READ_COUNT" IS '조회수';

COMMENT ON COLUMN "BOARD"."BOARD_DEL_FL" IS '삭제 여부(N : 삭제X , Y : 삭제O)';

COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '작성자 회원 번호';

COMMENT ON COLUMN "BOARD"."BOARD_CODE" IS '게시판 코드 번호';



----------------------------------------------------------------------

CREATE TABLE "BOARD_IMG" (
	"IMG_NO"	NUMBER		NOT NULL,
	"IMG_PATH"	VARCHAR2(300)		NOT NULL,
	"IMG_RENAME"	VARCHAR2(30)		NOT NULL,
	"IMG_ORIGINAL"	VARCHAR2(300)		NOT NULL,
	"IMG_ORDER"	NUMBER		NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD_IMG"."IMG_NO" IS '이미지 번호(SEQ_IMG_NO)';

COMMENT ON COLUMN "BOARD_IMG"."IMG_PATH" IS '이미지 저장 폴더 경로';

COMMENT ON COLUMN "BOARD_IMG"."IMG_RENAME" IS '변경된 이미지 파일 이름';

COMMENT ON COLUMN "BOARD_IMG"."IMG_ORIGINAL" IS '원본 이미지 파일 이름';

COMMENT ON COLUMN "BOARD_IMG"."IMG_ORDER" IS '이미지 파일 순서 번호';

COMMENT ON COLUMN "BOARD_IMG"."BOARD_NO" IS '이미지가 첨부된 게시글 번호';


----------------------------------------------------------------------


CREATE TABLE "BOARD_LIKE" (
	"BOARD_NO"	NUMBER		NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD_LIKE"."BOARD_NO" IS '게시글 번호';

COMMENT ON COLUMN "BOARD_LIKE"."MEMBER_NO" IS '좋아요 누른 회원 번호';


----------------------------------------------------------------------


CREATE TABLE "COMMENT" (
	"COMMENT_NO"	NUMBER		NOT NULL,
	"COMMENT_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"C_CREATE_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"COMMENT_DEL_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"PARENT_NO"	NUMBER	
);

COMMENT ON COLUMN "COMMENT"."COMMENT_NO" IS '댓글 번호(SEQ_COMMENT_NO)';

COMMENT ON COLUMN "COMMENT"."COMMENT_CONTENT" IS '댓글 내용';

COMMENT ON COLUMN "COMMENT"."C_CREATE_DATE" IS '댓글 작성일';

COMMENT ON COLUMN "COMMENT"."COMMENT_DEL_FL" IS '댓글 삭제 여부(N : 삭제X, Y : 삭제O)';

COMMENT ON COLUMN "COMMENT"."BOARD_NO" IS '댓글이 작성된 게시글 번호';

COMMENT ON COLUMN "COMMENT"."MEMBER_NO" IS '댓글 작성자 회원 번호';

COMMENT ON COLUMN "COMMENT"."PARENT_NO" IS '부모 댓글 번호';

----------------------------------------------------------------------


--ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
--	"MEMBER_NO"
--);

ALTER TABLE "BOARD" ADD CONSTRAINT "PK_BOARD" PRIMARY KEY (
	"BOARD_NO"
);

ALTER TABLE "BOARD_IMG" ADD CONSTRAINT "PK_BOARD_IMG" PRIMARY KEY (
	"IMG_NO"
);

ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "PK_BOARD_LIKE" PRIMARY KEY (
	"BOARD_NO",
	"MEMBER_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "PK_COMMENT" PRIMARY KEY (
	"COMMENT_NO"
);

--ALTER TABLE "BOARD_TYPE" ADD CONSTRAINT "PK_BOARD_TYPE" PRIMARY KEY (
--	"BOARD_CODE"
--);

ALTER TABLE "BOARD" ADD CONSTRAINT "FK_MEMBER_TO_BOARD_1" FOREIGN KEY (
	"MEMBER_NO"
)

REFERENCES "MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "BOARD" ADD CONSTRAINT "FK_BOARD_TYPE_TO_BOARD_1" FOREIGN KEY (
	"BOARD_CODE"
)
REFERENCES "BOARD_TYPE" (
	"BOARD_CODE"
);

ALTER TABLE "BOARD_IMG" ADD CONSTRAINT "FK_BOARD_TO_BOARD_IMG_1" FOREIGN KEY (
	"BOARD_NO"
)
REFERENCES "BOARD" (
	"BOARD_NO"
);

ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "FK_BOARD_TO_BOARD_LIKE_1" FOREIGN KEY (
	"BOARD_NO"
)
REFERENCES "BOARD" (
	"BOARD_NO"
);

ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "FK_MEMBER_TO_BOARD_LIKE_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_BOARD_TO_COMMENT_1" FOREIGN KEY (
	"BOARD_NO"
)
REFERENCES "BOARD" (
	"BOARD_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_MEMBER_TO_COMMENT_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_COMMENT_TO_COMMENT_1" FOREIGN KEY (
	"PARENT_NO"
)
REFERENCES "COMMENT" (
	"COMMENT_NO"
);


-- 시퀀스 생성
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE; -- 게시글 번호
CREATE SEQUENCE SEQ_IMG_NO NOCACHE; -- 게시글 이미지 번호
CREATE SEQUENCE SEQ_COMMENT_NO NOCACHE; -- 댓글 번호


-- BOARD 테이블 샘플 데이터 삽입(PL/SQL)
BEGIN
   FOR I IN 1..1500 LOOP
      INSERT INTO BOARD 
      VALUES( SEQ_BOARD_NO.NEXTVAL,
              SEQ_BOARD_NO.CURRVAL || '번째 게시글',
              SEQ_BOARD_NO.CURRVAL || '번째 게시글 내용 입니다.',
              DEFAULT, DEFAULT, DEFAULT, DEFAULT, 4, 
              CEIL(DBMS_RANDOM.VALUE(0,4))
      );
   END LOOP;
END;

COMMIT;

SELECT * FROM "MEMBER"
WHERE MEMBER_NO =4;

SELECT * FROM "BOARD_TYPE";

SELECT COUNT(*) FROM "BOARD";

-- BOARD_CODE가 1(공지사항)인 게시글을 최신순으로 조회
SELECT * FROM "BOARD"
WHERE BOARD_CODE = 1
AND BOARD_DEL_FL = 'N'
ORDER BY BOARD_NO DESC;

SELECT * FROM "BOARD"
ORDER BY BOARD_NO;



----------------------------------------------------------------------------------------

-- COMMENT 테이블 샘플 데이터 삽입(PL/SQL)
BEGIN
   FOR I IN 1..1500 LOOP
	   INSERT INTO "COMMENT" 
		VALUES(SEQ_COMMENT_NO.NEXTVAL, 
				SEQ_COMMENT_NO.CURRVAL || '번째 댓글',
				DEFAULT, DEFAULT,
				 CEIL(DBMS_RANDOM.VALUE(9,1500)),
				 4, NULL);
   END LOOP;
END;





COMMIT;

SELECT * FROM "COMMENT";



-- 게시글 샘플 이미지
INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/',
		'20230508115013_00001.jpg', 'cat1.jpg', 0, 1507);
	
INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/',
		'20230508115013_00002.jpg', 'cat2.jpg', 0, 1504);
	
INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/',
		'20230508115013_00003.jpg', 'cat3.jpg', 0, 1495);
	
INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/',
		'20230508115013_00004.jpg', 'cat4.jpg', 0, 1493);
	
INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/',
		'20230508115013_00005.jpg', 'cat5.jpg', 0, 1491);

COMMIT;

SELECT BOARD_NO FROM "BOARD"
WHERE BOARD_CODE = 1
ORDER BY 1 DESC;


-- 특정 게시판의 삭제되지 않은 게시글 수 조회
SELECT COUNT(*) 
FROM "BOARD"
WHERE BOARD_DEL_FL = 'N'
AND BOARD_CODE = 1;

-- 특정 게시판의 목록 조회
-- 1. 최신 순서
-- 2. 1page (1~10행) 조회
-- 3. 삭제된 글은 제외

-- 마이바티스 O
--> SqlSessionTemplate 실행구문 / 
------> RowBounds 객체 이용 ex) 20행 만큼 건너뛴 후 다음 10개의 행 조회
SELECT BOARD_NO, BOARD_TITLE, MEMBER_NICKNAME,
	TO_CHAR(B_CREATE_DATE,'YYYY-MM-DD') B_CREATE_DATE,
	READ_COUNT
FROM "BOARD" 
JOIN "MEMBER" USING(MEMBER_NO)
WHERE BOARD_DEL_FL = 'N'
AND BOARD_CODE = 4
ORDER BY BOARD_NO DESC ;

-- 마이바티스 X
-- 1행 ~ 10행 조회
-- ROWNUM은 WHERE절에 사용될 때 1행이 조건에 포함되어야 한다!!!
SELECT * FROM (
	SELECT ROWNUM NUM, A.* FROM (
		SELECT BOARD_NO, BOARD_TITLE, MEMBER_NICKNAME,
			TO_CHAR(B_CREATE_DATE,'YYYY-MM-DD') B_CREATE_DATE,
			READ_COUNT
		FROM "BOARD" 
		JOIN "MEMBER" USING(MEMBER_NO)
		WHERE BOARD_DEL_FL = 'N'
		AND BOARD_CODE = 4
		ORDER BY BOARD_NO DESC
		) A
	)
WHERE NUM BETWEEN 21 AND 30;


SELECT BOARD_NO, BOARD_TITLE, MEMBER_NICKNAME, READ_COUNT, 
	CASE  
		WHEN SYSDATE - B_CREATE_DATE < 1/24/60 
		THEN FLOOR( (SYSDATE - B_CREATE_DATE) * 24 * 60 * 60 ) || '초 전'
		WHEN SYSDATE - B_CREATE_DATE < 1/24 
		THEN FLOOR( (SYSDATE - B_CREATE_DATE) * 24 * 60) || '분 전'
		WHEN SYSDATE - B_CREATE_DATE < 1 // 1일
		THEN FLOOR( (SYSDATE - B_CREATE_DATE) * 24) || '시간 전'
		ELSE TO_CHAR(B_CREATE_DATE, 'YYYY-MM-DD')
	END CREATE_DATE,
	(SELECT COUNT(*) FROM "COMMENT" C
	 WHERE C.BOARD_NO = B.BOARD_NO) COMMENT_COUNT,
	(SELECT COUNT(*) FROM BOARD_LIKE L
	 WHERE L.BOARD_NO = B.BOARD_NO) LIKE_COUNT,
	(SELECT IMG_PATH || IMG_RENAME FROM BOARD_IMG I
	WHERE I.BOARD_NO = B.BOARD_NO
	AND IMG_ORDER = 0) THUMBNAIL
FROM "BOARD" B
JOIN "MEMBER" USING(MEMBER_NO)
WHERE BOARD_DEL_FL = 'N'
AND BOARD_CODE = 4
ORDER BY BOARD_NO DESC;














































