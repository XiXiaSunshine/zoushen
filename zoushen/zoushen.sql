CREATE TABLE `users_info` (
  `id` INT(11) PRIMARY KEY AUTO_INCREMENT,
  `username` VARCHAR(15) UNIQUE NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `email` VARCHAR(32) DEFAULT NULL,
  `sex` INT(1),
  `headImg` VARCHAR(32) DEFAULT 'default_head.png',
  `zsNum` VARCHAR(32) DEFAULT NULL,
  `signature` VARCHAR(50) DEFAULT '他真的从来没来过吗……',
  `birthday` DATE DEFAULT NULL,
  `experience` INT(11) DEFAULT '0',
  `delete` INT(1) DEFAULT '0'
)


CREATE TABLE `grade_rule` (
  `id` INT(11) PRIMARY KEY AUTO_INCREMENT,
  `level` VARCHAR(32) UNIQUE NOT NULL,
  `experience` INT(11) UNIQUE NOT NULL
)

INSERT INTO grade_rule(`level`,`experience`)
VALUES ('0',0),('1',10),('2',100),('3',200),('4',400),('5',800)