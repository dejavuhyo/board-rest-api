-- PostgreSQL
create table tb_board
(
    id       integer not null
        constraint tb_board_pk
            primary key,
    title    varchar(200),
    contents varchar(4000),
    writer   varchar(50),
    reg_date timestamp default now(),
    view_cnt integer   default 0
);
