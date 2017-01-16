
drop table if exists sa_user;

/*==============================================================*/
/* Table: sa_user                                     */
/*==============================================================*/
create table sa_user
(
   operid            varchar(30) not null comment '操作员ID',
   opername         varchar(50) comment '操作员名称',
   password         varchar(30) comment '登陆密码',
   email         varchar(30) comment '邮箱',
   phone         varchar(30) comment '电话'
);