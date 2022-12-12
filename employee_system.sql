/*
SQLyog Enterprise v12.14 (64 bit)
MySQL - 5.7.33-log : Database - employee_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`employee_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `employee_system`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='管理员';

/*Data for the table `admin` */

insert  into `admin`(`id`,`username`,`password`) values 
(1,'admin','admin'),
(2,'root','root');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `did` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `dlocation` varchar(50) DEFAULT NULL COMMENT '部门位置',
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COMMENT='部门表';

/*Data for the table `department` */

insert  into `department`(`did`,`dname`,`dlocation`) values 
(1,'研发部','北京'),
(2,'市场部','北京'),
(3,'行政部','北京'),
(4,'财务部','北京'),
(5,'法务部','北京'),
(6,'总裁办公室','北京');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `eid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `eno` char(5) NOT NULL COMMENT '工号',
  `ename` varchar(20) NOT NULL COMMENT '姓名',
  `eage` int(11) DEFAULT NULL COMMENT '年龄',
  `egender` char(1) DEFAULT NULL COMMENT '性别',
  `ejob` varchar(10) DEFAULT NULL COMMENT '工种',
  `eentrydate` date DEFAULT NULL COMMENT '入职时间',
  `esalary` decimal(8,2) DEFAULT NULL COMMENT '基本薪资',
  `estate` tinyint(1) DEFAULT NULL COMMENT '在职状态(1.在职 2.离职)',
  `did` int(11) DEFAULT NULL COMMENT '部门编号',
  PRIMARY KEY (`eid`),
  UNIQUE KEY `empno` (`eno`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COMMENT='员工表';

/*Data for the table `employee` */

insert  into `employee`(`eid`,`eno`,`ename`,`eage`,`egender`,`ejob`,`eentrydate`,`esalary`,`estate`,`did`) values 
(1,'10001','华强',40,'男','董事长','2019-02-14','10000.00',1,6),
(2,'10100','张三',30,'男','助理','2019-02-15','5000.00',1,6),
(3,'10002','李四',30,'男','助理','2019-03-01','6000.00',1,6),
(4,'10003','王五',20,'男','软件开发工程师','2019-03-04','30000.00',1,1),
(5,'10004','Tom',22,'男','软件开发工程师','2019-05-12','42000.00',1,1),
(6,'10005','大海',25,'男','软件开发工程师','2019-05-19','40000.00',1,1),
(7,'10006','Smith',30,'男','软件开发工程师','2019-06-12','50000.00',1,1),
(8,'10007','Rose',31,'女','软件开发工程师','2019-06-18','40000.00',1,1),
(9,'10008','Peter',26,'男','硬件开发工程师','2019-06-18','30000.00',1,1),
(11,'10009','John',30,'男','销售主管','2019-06-20','24000.00',1,2),
(12,'10010','华强1',32,'男','销售','2019-08-20','6000.00',1,2),
(13,'10011','华强2',29,'男','销售','2019-08-21','6000.00',1,2),
(14,'10012','华强3',28,'男','销售','2019-09-22','6000.00',1,2),
(15,'10013','华强4',29,'男','行政','2019-09-22','5000.00',1,3),
(16,'10014','华强5',30,'男','行政','2019-09-22','5000.00',1,3),
(17,'10015','华强6',32,'男','行政','2019-09-22','5000.00',1,3),
(18,'10016','华强7',33,'女','会计','2019-09-22','6000.00',1,4),
(20,'10017','华强8',33,'女','会计','2019-09-22','6000.00',1,4),
(21,'10018','华强9',33,'女','出纳','2019-09-22','6000.00',1,4),
(22,'10019','华强10',33,'女','法务','2019-09-22','6000.00',1,5),
(23,'10020','华强20',34,'女','法务','2019-09-22','7000.00',1,5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
