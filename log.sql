/* �������ݿ� */ 
create database db_log4j;

/* �л����ݿ� */
use  db_log4j;

/* ��־��Ϣ�� */
create table tb_log(
    logId int not null auto_increment comment '��ˮ��' ,
    createDate varchar(45) default null comment '��־����ʱ��' ,
    thread varchar(45) default null comment '��ǰ�߳�',
    level varchar(45) default null comment '��ǰ��־����' ,
    class varchar(45) default null comment '������־����',
    message varchar(245) default null comment '��־������Ϣ',
    primary key(logId)
);