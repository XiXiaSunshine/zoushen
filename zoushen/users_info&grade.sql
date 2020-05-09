CREATE TABLE users_info(
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
	`username` VARCHAR(15) UNIQUE NOT NULL,  -- 用户名
	`password` VARCHAR(32) NOT NULL,  -- 密码
	`email` VARCHAR(32),  -- 邮箱
	`sex` VARCHAR(1),  -- 性别
	`head_img` VARCHAR(32) DEFAULT 'default_head.png',  -- 头像图片名称
	`zs_num` VARCHAR(32),  -- 走神编码
	`birthday` DATE, -- 出生日期
	`level` VARCHAR(12) DEFAULT '0',  -- 等级
	`experience` INT DEFAULT 0,  -- 已有经验
	`delete` INT(1)  DEFAULT 0  -- 软删除，1删除，0激活状态
);

CREATE TABLE grade(
	id INT PRIMARY KEY AUTO_INCREMENT,
	`designation` VARCHAR(32) UNIQUE NOT NULL,  -- 等级称号
	`achieve` INT UNIQUE NOT NULL  -- 达到等级时需要的经验
);

INSERT INTO grade(designation, achieve) 
VALUES(0', 0),('1', 10),('2', 100),('3', 1000)
