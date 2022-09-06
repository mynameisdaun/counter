create table counter_v2
(
    id int auto_increment primary key comment '일련번호',
    created datetime not null default current_timestamp comment '일시',
    professor varchar(100) not null comment '교수님'
);
