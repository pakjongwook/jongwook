SELECT * FROM "MEMBER" ;

SELECT *
FROM "BOARD"
WHERE COUNTRY_NO = 1;

SELECT * FROM BOARD 
WHERE BOARD_NO =170;

SELECT * FROM TAG ;

INSERT INTO BOARD 
VALUES (SEQ_BOARD_NO.NEXTVAL, '아아아','박종욱',DEFAULT,DEFAULT,DEFAULT,DEFAULT,11,1,2,NULL,NULL);

ROLLBACK;

 SELECT * FROM BOARD_TYPE
 WHERE BOARD_CODE = 2
 ORDER BY BOARD_CODE ;
 

SELECT * FROM BOARD
ORDER BY board_no DESC;


-- 게시글 수정 자유/질문
UPDATE "BOARD" SET
BOARD_TITLE = '잘가라',
BOARD_TEXT  = '진짜 간다',
TAG_NO = '2',
UPDATE_DATE = SYSDATE 
WHERE BOARD_CODE = 2
AND BOARD_NO = 186;

COMMIT;

SELECT * FROM BOARD b ;
-- 게시글 수정 자유/질문
UPDATE "BOARD" SET
BOARD_TITLE = '마오쩌둥',
BOARD_TEXT  = '공산주의만세',
TAG_NO = '3',
UPDATE_DATE = SYSDATE 
WHERE BOARD_CODE = 1
AND COUNTRY_NO = 1
AND BOARD_NO = 184;

COMMIT;

-- 자유/질문 게시판 
SELECT * 
FROM BOARD_TYPE 
WHERE BOARD_CODE= 2
OR  BOARD_CODE =3
OR BOARD_CODE =1;



SELECT * FROM BOARD_TYPE
WHERE BOARD_CODE =1
or BOARD_CODE =2
ORDER BY BOARD_CODE ASC;

SELECT * FROM COUNTRY c ;

SELECT * FROM COUNTRY 
WHERE COUNTRY_NO = 1
OR  COUNTRY_NO = 2 
OR  COUNTRY_NO = 3
OR COUNTRY_NO = 4
OR COUNTRY_NO = 5
ORDER BY COUNTRY_NO ASC ;


SELECT * FROM TAG  
WHERE TAG_NO  = 1
OR  TAG_NO = 2 
OR  TAG_NO = 3
OR TAG_NO = 4
ORDER BY TAG_NO ASC ;


SELECT BOARD_CODE, BOARD_NAME, "TYPE" FROM (
	SELECT BOARD_TYPE.* , '1' "TYPE" FROM BOARD_TYPE 
	WHERE BOARD_CODE NOT IN (1,4)
	UNION 
	SELECT COUNTRY.*, '2' "TYPE" FROM COUNTRY 
	WHERE COUNTRY_NO != 0
)
ORDER BY "TYPE", BOARD_CODE;

COMMIT;

SELECT * FROM TAG 
WHERE TAG_NO IN (1,2,3,4);

SELECT * FROM BOARD ;	

UPDATE "BOARD" SET BOARD_TEXT = '<p>asd</p>' WHERE BOARD_NO = 284;
COMMIT;


SELECT * FROM "BOARD";

SELECT * FROM "MEMBER"
WHERE MEMBER_EMAIL LIKE '%sangzoon0102%';


SELECT *
FROM(
    SELECT B.BOARD_THUMBNAIL, B.BOARD_NO, B.BOARD_TITLE, B.BOARD_CODE, COUNTRY_NO, READ_COUNT,(
            SELECT COUNT(*)
FROM CONTENT_LIKE CL
WHERE CL.BOARD_NO = B.BOARD_NO
        ) AS LIKE_COUNT
FROM BOARD B
ORDER BY
        LIKE_COUNT DESC
)
WHERE ROWNUM <= 5 
AND BOARD_CODE !=2
AND BOARD_THUMBNAIL IS NOT NULL;


SELECT * FROM BOARD_IMG ;

DELETE FROM BOARD_IMG
WHERE BOARD_NO = 366;


COMMIT;

SELECT * FROM BOARD_IMG ORDER BY 1 DESC ;


SELECT
BOARD_NO,BOARD_TITLE,BOARD_TEXT ,READ_COUNT,BOARD_CODE,TAG_CONTENT, MEMBER_ROLE, 
MEMBER_NICKNAME,MEMBER_NO ,PROFILE_IMG,
TO_CHAR(CREATE_DATE,'YYYY"년"
MM"월" DD"일" HH24:MI:SS') CREATE_DATE,
TO_CHAR(UPDATE_DATE,'YYYY"년"
MM"월" DD"일" HH24:MI:SS') UPDATE_DATE,
(SELECT COUNT(*) FROM
"CONTENT_LIKE" L
WHERE L.BOARD_NO = B.BOARD_NO) LIKE_COUNT
FROM "BOARD"
B
JOIN "MEMBER" USING(MEMBER_NO)
LEFT JOIN "TAG" USING (TAG_NO)
WHERE BOARD_DELETE='N'
AND
BOARD_CODE=2
AND BOARD_NO=41;

SELECT IMG_PATH
FROM "BOARD_IMG";

SELECT PROFILE_IMG
FROM "MEMBER"
WHERE PROFILE_IMG IS NOT NULL;
