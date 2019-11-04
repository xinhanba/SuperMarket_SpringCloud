/*
Navicat MySQL Data Transfer

Source Server         : SuperMarket
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : user

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-11-04 16:42:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for f_consumer_user
-- ----------------------------
DROP TABLE IF EXISTS `f_consumer_user`;
CREATE TABLE `f_consumer_user` (
  `f_user_id` varchar(32) NOT NULL COMMENT '主键',
  `f_user_email` varchar(255) NOT NULL COMMENT '用户邮箱',
  `f_user_pwd` varchar(255) NOT NULL COMMENT '用户密码',
  `f_user_tel` varchar(255) DEFAULT NULL COMMENT '用户手机号',
  `f_user_credits` int(11) DEFAULT '0' COMMENT '积分(活跃度)',
  `f_user_level_id` bigint(20) DEFAULT '0' COMMENT '用户VIP级别',
  `f_user_state` char(255) DEFAULT NULL COMMENT '用户状态（0:无效,1:有效,-1:冻结）',
  `f_user_salt` varchar(6) NOT NULL COMMENT '密码随机码6位salt',
  `f_user_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `f_user_email_status` int(11) DEFAULT '0' COMMENT '邮箱认证(1:已认证 0:未认证)',
  PRIMARY KEY (`f_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_consumer_user
-- ----------------------------
INSERT INTO `f_consumer_user` VALUES ('623cd1d83498423897f83556a0159934', '517491659@qq.com', '5afbbff0bea00ec81dca60137be220e9', '17711111111', '0', '0', null, 'kyx456', '2019-11-04 15:21:52', '0');
