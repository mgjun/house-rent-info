insert into TBL_USER (USER_ID,USER_NAME,PASS_WORD,ID_CARD,ID_CARD_IMAGE,PHONE_NUMBER,IM_PHONE_NUMBER,
                      VERSION,CREATE_DATETIME,MODIFY_DATETIME)
    VALUES (1,'DEMO','123456','51302319909092212','url/to/image/card','13568902057','13568902057', 1,current_timestamp,current_timestamp);



insert into TBL_ROLE (ROLE_ID, ROLE_NAME, VERSION, CREATE_DATETIME, MODIFY_DATETIME)
    VALUES (1,'admin',1,current_timestamp ,current_timestamp),
           (2,'user',1,current_timestamp ,current_timestamp );


insert into TBL_ACCESS(ACCESS_ID,ACCESS_NAME,ACCESS_URL,PARENT_ACCESS_ID)
  values (1,'admin','/admin',0),
         (2,'user','/user',0);


INSERT into TBL_ROLE_ACCESS_XREF(ACCESS_ID,ROLE_ID)
values (1,1),
(2,1),
(1,2),
(2,2)

