DROP TABLE if exists TBL_HOUSE;
DROP TABLE if exists TBL_COMPACT;
DROP TABLE if exists TBL_ROOM;
DROP TABLE if exists TBL_ADDR;
DROP TABLE if exists TBL_GOODS;
DROP TABLE if exists TBL_ROOM_GOODS;
DROP TABLE if exists TBL_HOUSE_GOODS;
DROP TABLE if exists TBL_USER;
DROP TABLE if exists TBL_RENT;
DROP TABLE if exists TBL_ROLE;
DROP TABLE if exists TBL_USER_ROLE_XREF;
DROP TABLE if exists TBL_ACCESS;
DROP TABLE if exists TBL_ROLE_ACCESS_XREF;
DROP TABLE if exists TBL_HOUSE_MAINTENANCE;
DROP TABLE if exists TBL_RENT_INFO;

create table TBL_ACCESS
(
  ACCESS_ID        bigint       not null
    primary key,
  ACCESS_NAME      varchar(255) null,
  ACCESS_URL       varchar(255) null,
  PARENT_ACCESS_ID bigint       null,
  CREATE_DATETIME  datetime     null,
  MODIFY_DATETIME  datetime     null,
  VERSION          int(3)       null
)
  engine = InnoDB
  charset = utf8;

create table TBL_ADDR
(
  AREA_ID         bigint       not null
    primary key,
  AREA_NAME       varchar(255) null,
  AREA_TYPE       varchar(2)   null,
  PARENT_ID       bigint       null,
  VERSION         int(3)       null,
  CREATE_DATETIME datetime     null,
  MODIFY_DATETIME datetime     null
)
  engine = InnoDB
  charset = utf8;

create table TBL_COMPACT
(
  COMPACT_ID          bigint         not null
    primary key,
  COMPACT_NAME        varchar(255)   null,
  COMPACT_START_DATE  date           null,
  COMPACT_END_DATE    date           null,
  LANDLORD_ID         bigint         null,
  TENANT_ID           bigint         null,
  HOUSE_ID            bigint         null,
  ROOM_ID             bigint         null,
  RENT_PRICE          decimal(10, 2) null
  comment '租金',
  DEPOSIT_PRICE       decimal(10, 2) null
  comment '押金',
  COMPACT_IMAGE       varchar(255)   null,
  COMPACT_DESCRIPTION varchar(255)   null,
  VERSION             int(3)         null,
  CREATE_DATETIME     datetime       null,
  MODIFY_DATETIME     datetime       null
)
  engine = InnoDB
  charset = utf8;

create table TBL_GOODS
(
  GOODS_ID          bigint         not null
    primary key,
  GOODS_NAME        varchar(255)   null,
  GOODS_PRICE       decimal(10, 2) null,
  GOODS_STATUS      varchar(255)   null,
  VERSION           int(3)         null,
  CREATE_DATETIME   datetime       null,
  MODIFY_DATETIME   datetime       null,
  ROOM_ID           bigint         null,
  GOODS_BELONG_TYPE varchar(50)    not null,
  GOODS_COUNT       int            not null,
  HOUSE_ID          bigint         null
)
  engine = InnoDB
  charset = utf8;

create table TBL_HOUSE
(
  HOUSE_ID          bigint       not null
    primary key,
  VILLAGE_NAME      varchar(50)  not null
  comment '房屋的简短的标识',
  HOUSE_ADDRESS     varchar(255) not null,
  HOUSE_NUMBER      varchar(50)  not null,
  AREA_ID           bigint       null,
  OWNER_ID          bigint       null,
  HOUSE_DESCRIPTION varchar(255) null,
  VERSION           int(3)       null,
  CREATE_DATETIME   datetime     null,
  MODIFY_DATETIME   datetime     null
)
  engine = InnoDB
  charset = utf8;

create table TBL_MAINTENANCE
(
  ID           bigint         not null
    primary key,
  HOUSE_ID     bigint(11)     null,
  ROOM_ID      bigint(11)     null,
  PAY_DATETIME datetime       null,
  PAY_PRICE    decimal(10, 2) null
)
  engine = InnoDB
  charset = utf8;

create table TBL_RENT
(
  RENT_ID          bigint      not null
    primary key,
  COMPACT_ID       bigint      null,
  HOUSE_ID         bigint      null,
  ROOM_ID          bigint      null,
  VERSION          int(3)      null,
  CREATE_DATETIME  datetime    null,
  MODIFY_DATETIME  datetime    null,
  RENT_USER_ID     bigint      null,
  RENT_CYCLE       varchar(50) null,
  RENT_REMIND_DATE date        null
)
  engine = InnoDB
  charset = utf8;

create table TBL_RENT_INFO
(
  ID           bigint         not null
    primary key,
  HOUSE_ID     bigint         null,
  ROOM_ID      bigint         null,
  PAY_PRICE    decimal(10, 2) null,
  PAY_DATE     datetime       null,
  RENT_USER_ID bigint         null
)
  engine = InnoDB
  charset = utf8;

create table TBL_ROLE
(
  ROLE_ID         bigint       not null
    primary key,
  ROLE_NAME       varchar(255) null,
  VERSION         int(3)       null,
  CREATE_DATETIME datetime     null,
  MODIFY_DATETIME datetime     null
)
  engine = InnoDB
  charset = utf8;

create table TBL_ROLE_ACCESS_XREF
(
  ROLE_ID   bigint null,
  ACCESS_ID bigint null
)
  engine = InnoDB
  charset = utf8;

create table TBL_ROOM
(
  ROOM_ID          bigint         not null
    primary key,
  ROOM_PRICE       decimal(10, 2) null,
  HOUSE_ID         bigint         null,
  ROOM_NAME        varchar(255)   null,
  ROOM_DESCRIPTION varchar(255)   null,
  VERSION          int(3)         null,
  CREATE_DATETIME  datetime       null,
  MODIFY_DATETIME  datetime       null
)
  engine = InnoDB
  charset = utf8;

create table TBL_USER
(
  USER_ID         bigint auto_increment
    primary key,
  USER_NAME       varchar(255) null,
  PASS_WORD       varchar(255) null,
  ID_CARD         varchar(18)  null,
  ID_CARD_IMAGE   varchar(255) null,
  PHONE_NUMBER    varchar(20)  null,
  IM_PHONE_NUMBER varchar(20)  null,
  VERSION         int(3)       null,
  CREATE_DATETIME datetime     null,
  MODIFY_DATETIME datetime     null,
  user_age        int          null,
  USER_SEX        varchar(50)  null,
  ROLE_ID         bigint       null
)
  engine = InnoDB
  charset = utf8;

