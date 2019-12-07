DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `member_seq` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(250) NOT NULL,
  `address_seq` bigint(11)  DEFAULT NULL,
  `profile_seq` bigint(11)  DEFAULT NULL,
  `created_at` datetime DEFAULT NOW(),
  `updated_at` datetime DEFAULT NOW(),
  `deleted` tinyint NOT NULL DEFAULT 0,
  PRIMARY KEY (`member_seq`),
  KEY `member_index_01` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `profile`;
CREATE TABLE `profile` (
   `profile_seq` bigint(11) NOT NULL AUTO_INCREMENT,
   `title` varchar(300) NOT NULL,
   `description` varchar(300),
   `created_at` datetime DEFAULT NOW(),
   `updated_at` datetime DEFAULT NOW(),
   PRIMARY KEY (`profile_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
   `address_seq` bigint(11) NOT NULL AUTO_INCREMENT,
   `country_code` varchar(3) NOT NULL,
   `city` varchar(200) NOT NULL,
   `street` varchar(300) NOT NULL,
   `post_number` varchar(10) NOT NULL,
   `created_at` datetime DEFAULT NOW(),
   `updated_at` datetime DEFAULT NOW(),
   PRIMARY KEY (`address_seq`),
   KEY `address_index_01` (`country_code`),
   KEY `address_index_02` (`city`),
   KEY `address_index_03` (`post_number`),
   KEY `address_index_04` (`country_code`,`city`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
 `topic_seq` bigint(11) NOT NULL AUTO_INCREMENT,
 `title` varchar(200) NOT NULL,
 `description` tinytext,
 `member_seq` bigint(11)  NOT NULL,
 `deleted` tinyint NOT NULL DEFAULT 0,
 `created_at` datetime DEFAULT NOW(),
 `updated_at` datetime DEFAULT NOW(),
 PRIMARY KEY (`topic_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
   `comment_seq` bigint(11) NOT NULL AUTO_INCREMENT,
   `title` varchar(200) NOT NULL,
   `description` varchar(500),
   `member_seq` bigint(11) NOT NULL,
   `topic_seq` bigint(11)  NOT NULL,
   `deleted` tinyint NOT NULL DEFAULT 0,
   `created_at` datetime DEFAULT NOW(),
   `updated_at` datetime DEFAULT NOW(),
   PRIMARY KEY (`comment_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- insert sample data
INSERT INTO `address` (country_code, city, street, post_number, created_at, updated_at) VALUES ('KOR', 'seoul', 'gangam', '1896', now(),now());
INSERT INTO `address` (country_code, city, street, post_number, created_at, updated_at) VALUES ('KOR', 'busan', 'mukk', '4533',  now(),now());

INSERT INTO `profile` (title, description, created_at, updated_at) VALUES ('Developer', 'developer...', now(),now());
INSERT INTO `profile` (title, description, created_at, updated_at) VALUES ('Designer', 'designer', now(),now());

INSERT INTO `topic` (title, description, member_seq, deleted, created_at, updated_at) VALUES ('test', 'test', 1, 0, now(),now());
INSERT INTO `topic` (title, description, member_seq, deleted, created_at, updated_at) VALUES ('test', 'test', 2, 0, now(),now());

INSERT INTO `member` (name, email, password, address_seq, profile_seq, created_at, updated_at, deleted) VALUES ('gavin', 'gavin@test.com', 'password', 1, 1, now(),now(), 0);
INSERT INTO `member` (name, email, password, address_seq, profile_seq, created_at, updated_at, deleted) VALUES ('james', 'james@test.com', 'password', 2, 2, now(),now(), 0);

INSERT INTO `comment` (title, description, member_seq, topic_seq, deleted, created_at, updated_at) VALUES ('Java', 'java is...', 1, 1, 0, now(), now());
INSERT INTO `comment` (title, description, member_seq, topic_seq, deleted, created_at, updated_at) VALUES ('test', 'test', 2, 2, 0, now(), now());

-- sample join
select
    m.name,p.title '직업',t.title '제목',t.created_at '작성일자',t.topic_seq '번호'
from `member` m
         join `topic` t
              on m.member_seq = t.member_seq
         join `profile` p
              on  p.profile_seq = m.profile_seq
where m.name='gavin';