SELECT * FROM "MEMBER";


-- 이메일 중복 검사
SELECT COUNT(*)  
FROM "MEMBER"
WHERE MEMBER_EMAIL = 'user01@mail.com';