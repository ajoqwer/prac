# prac
무한코멘트 구현
  DDL   (MariaDB)  
-- mariadb.board definition

CREATE TABLE `board` (
  `idx` int(11) NOT NULL AUTO_INCREMENT COMMENT 'index',
  `Title` varchar(100) NOT NULL,
  `content` varchar(100) NOT NULL,
  `writerId` varchar(100) NOT NULL,
  `regDate` date NOT NULL,
  PRIMARY KEY (`idx`),
  KEY `board_index_IDX` (`idx`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `user` (
  `idx` int(11) NOT NULL AUTO_INCREMENT COMMENT 'index',
  `id` varchar(20) NOT NULL COMMENT '아이디',
  `pw` varchar(100) NOT NULL COMMENT '비밀번호',
  `nickname` varchar(20) NOT NULL COMMENT '별명',
  PRIMARY KEY (`id`),
  KEY `user_index_IDX` (`idx`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;


CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `boardId` int(11) NOT NULL,
  `userId` varchar(100) NOT NULL,
  `commentContent` varchar(100) NOT NULL,
  `replyId` int(11) DEFAULT 0,
  `replyLevel` int(11) DEFAULT 0,
  PRIMARY KEY (`commentId`),
  KEY `reply_index_IDX` (`commentId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;
