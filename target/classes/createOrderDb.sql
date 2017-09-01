DROP SCHEMA IF EXISTS orderinfo;
CREATE SCHEMA `orderinfo` ;
use orderinfo;

GRANT ALL PRIVILEGES ON orderinfo.* TO 'dbuser'@'localhost' IDENTIFIED BY 'pswdOrderDb' WITH GRANT OPTION;

delimiter $$

CREATE TABLE `cusorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNum` varchar(10) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  UNIQUE INDEX `ordernum_UNIQUE` (`ordernum` ASC),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1$$

INSERT INTO `orderinfo`.`cusorder` (`orderNum`, `amount`) VALUES ('XZ5400C', '102.34');