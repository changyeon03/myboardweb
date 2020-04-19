create table tbl_reply(
    rno int not null auto_increment,
    bno int not null,
    content text not null,
    writer varchar(30) not null,
    regDate timestamp not null default now(),
    primary key(rno),
    foreign key(bno) references tbl_board(bno) ON DELETE CASCADE
);