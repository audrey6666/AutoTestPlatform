SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for EnvInfo
-- ----------------------------
DROP TABLE IF EXISTS `EnvInfo`;
CREATE TABLE `EnvInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `env_name` varchar(40) COLLATE utf8_bin NOT NULL,
  `base_url` varchar(80) COLLATE utf8_bin NOT NULL,
  `simple_desc` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ModuleInfo
-- ----------------------------
DROP TABLE IF EXISTS `ModuleInfo`;
CREATE TABLE `ModuleInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `module_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `test_user` varchar(50) COLLATE utf8_bin NOT NULL,
  `simple_desc` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `other_desc` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `belong_project_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `ModuleInfo_belong_project_id_7a17e510_fk_ProjectInfo_id` (`belong_project_id`) USING BTREE,
  CONSTRAINT `ModuleInfo_belong_project_id_7a17e510_fk_ProjectInfo_id` FOREIGN KEY (`belong_project_id`) REFERENCES `ProjectInfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ProjectInfo
-- ----------------------------
DROP TABLE IF EXISTS `ProjectInfo`;
CREATE TABLE `ProjectInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `project_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `responsible_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `test_user` varchar(100) COLLATE utf8_bin NOT NULL,
  `dev_user` varchar(100) COLLATE utf8_bin NOT NULL,
  `publish_app` varchar(60) COLLATE utf8_bin NOT NULL,
  `simple_desc` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `other_desc` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for TestCaseInfo
-- ----------------------------
DROP TABLE IF EXISTS `TestCaseInfo`;
CREATE TABLE `TestCaseInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `type` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `belong_project` varchar(50) COLLATE utf8_bin NOT NULL,
  `include` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `author` varchar(20) COLLATE utf8_bin NOT NULL,
  `request` longtext COLLATE utf8_bin NOT NULL,
  `belong_module_id` int(11) NOT NULL,
  `interface_url` longtext COLLATE utf8_bin,
  `level` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `TestCaseInfo_belong_module_id_040b8702_fk_ModuleInfo_id` (`belong_module_id`) USING BTREE,
  CONSTRAINT `TestCaseInfo_belong_module_id_040b8702_fk_ModuleInfo_id` FOREIGN KEY (`belong_module_id`) REFERENCES `ModuleInfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=296 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for TestReports
-- ----------------------------
DROP TABLE IF EXISTS `TestReports`;
CREATE TABLE `TestReports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `report_name` varchar(40) COLLATE utf8_bin NOT NULL,
  `status` tinyint(1) NOT NULL,
  `reports` longtext COLLATE utf8_bin NOT NULL,
  `start_at` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `testsRun` int(11) NOT NULL,
  `successes` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for TestSuite
-- ----------------------------
DROP TABLE IF EXISTS `TestSuite`;
CREATE TABLE `TestSuite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `suite_name` varchar(100) COLLATE utf8_bin NOT NULL,
  `include` longtext COLLATE utf8_bin NOT NULL,
  `belong_project_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `TestSuite_belong_project_id_76d73d7f_fk_ProjectInfo_id` (`belong_project_id`) USING BTREE,
  CONSTRAINT `TestSuite_belong_project_id_76d73d7f_fk_ProjectInfo_id` FOREIGN KEY (`belong_project_id`) REFERENCES `ProjectInfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for UserInfo
-- ----------------------------
DROP TABLE IF EXISTS `UserInfo`;
CREATE TABLE `UserInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `username` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `email` varchar(254) COLLATE utf8_bin NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for usertype
-- ----------------------------
DROP TABLE IF EXISTS `usertype`;
CREATE TABLE `usertype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `type_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `type_desc` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for WebHookInfo
-- ----------------------------
DROP TABLE IF EXISTS `WebHookInfo`;
CREATE TABLE `WebHookInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `webhook_name` varchar(100) COLLATE utf8_bin NOT NULL,
  `job_name` varchar(100) COLLATE utf8_bin NOT NULL,
  `token` varchar(100) COLLATE utf8_bin NOT NULL,
  `belong_project_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `WebHookInfo_belong_project_id_f9280392_fk_ProjectInfo_id` (`belong_project_id`),
  CONSTRAINT `WebHookInfo_belong_project_id_f9280392_fk_ProjectInfo_id` FOREIGN KEY (`belong_project_id`) REFERENCES `ProjectInfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
