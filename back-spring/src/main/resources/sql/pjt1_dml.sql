USE PJT1DB;

show tables;

DESC board;
DESC hotplace;
DESC city;
DESC comment;
DESC course;
DESC faq;
DESC festival;
DESC files;
DESC follow;
DESC likes;
DESC member;
DESC post;
DESC qna;

INSERT INTO MEMBERS (mem_id, mem_email, mem_password, mem_phone, mem_grant, mem_del_check )
VALUES ("ebbunnim2", "ebbunnim@yagoo.co.kr2", "password2","010-4053-244522",1,false);
SELECT * FROM MEMBERS;

INSERT INTO BOARD (board_name) VALUES ('테스트용 첫 게시판');
SELECT * FROM BOARD;

INSERT INTO POST (board_no,mem_no,post_title,post_content,post_start_day,post_end_day ) 
VALUES (1, 1, "post-title","post_content","2015-01-02","2015-12-9");

select * from post;
INSERT INTO COMMENT (board_no, post_no, mem_no, cmt_title)
VALUES (1, 1, 1, "comment");
SELECT * FROM COMMENT;

select * from FAQ;


INSERT INTO faq (faq_category, faq_title, faq_content, faq_answer) VALUES 
('General', 'Save or share Video' ,'How to Share videos and channels',
'Share videos 
 1. Start watching a video on youtube.com. 
 2. Under the video, click Share . 
 3. A panel will appear, presenting different sharing options:
    Message on YouTube: Select the YouTube friend(s) you’d like to send the video to.
    A private conversation is created where the recipient(s) can view and discuss the video.
    Click Messages on the top right of the page to find the private chat.
    You can watch the shared videos and chat at the same time. '
);
INSERT INTO faq (faq_category, faq_title, faq_content, faq_answer) VALUES 
('General', 'Create & grow your channel' ,'Upload videos longer than 15 minutes',
"Increase your video length limit
By default, you can upload videos that are up to 15 minutes long. Verified accounts can upload videos longer than 15 minutes.

To verify your Google Account:

On a computer, go to https://www.youtube.com/verify.
Follow the steps to verify your Google Account. You can choose to get a verification code through a text message on a mobile device or an automated voice call.
Make sure you're using an up-to-date version of your browser to upload files greater than 20GB."
);

insert into FAQ (faq_category, faq_title, faq_content, faq_answer) 
values ("JUST TEST","제목","내용","답변");


INSERT INTO CITYLAYERTOP(clt_name, clt_address,clt_img, clt_content, clt_type, clt_del_check)
VALUES("대도시","서울","이미지소스","내용", 1,false);
SELECT * FROM CITYLAYERTOP;

INSERT INTO CITYLAYERMID (clt_no, clm_name, clm_address, clm_content, clm_type, clm_del_check)
VALUES(1,"서울","성북구","내용", 1,false);
SELECT * FROM CITYLAYERMID;

INSERT INTO CITYLAYERBOTTOM (clm_no, clb_name, clb_address, clb_img, clb_content, clb_del_check)
VALUES(1,"압구정","경리단길","이미지소스","내용", false);
SELECT * FROM CITYLAYERBOTTOM;