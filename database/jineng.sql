/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : jineng

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 14/10/2026 20:37:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for canting
-- ----------------------------
DROP TABLE IF EXISTS `canting`;
CREATE TABLE `canting`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '来源地',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of canting
-- ----------------------------
INSERT INTO `canting` VALUES (1, '张三1', '男12', '郑州12', '13515362899', '1234123123123');
INSERT INTO `canting` VALUES (3, '王五', '男', '洛阳', '18436921244', NULL);
INSERT INTO `canting` VALUES (4, '麻子', '女', '许昌', '13523456790', '按照习俗冲冲冲');

-- ----------------------------
-- Table structure for dingdan
-- ----------------------------
DROP TABLE IF EXISTS `dingdan`;
CREATE TABLE `dingdan`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order` char(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `ordername` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `order`(`order`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dingdan
-- ----------------------------
INSERT INTO `dingdan` VALUES (1, '1', '烤鸭拌饭123', '张三', '2026-10-14 16:42:29');
INSERT INTO `dingdan` VALUES (2, '2', '大众套餐', '李四', '2026-10-13 16:52:42');
INSERT INTO `dingdan` VALUES (3, '3', '豆花鱼', '王五', '2026-10-13 16:53:00');
INSERT INTO `dingdan` VALUES (5, '1791886393433128', '胡辣汤', '王二', '2026-10-13 18:13:13');

-- ----------------------------
-- Table structure for fancai
-- ----------------------------
DROP TABLE IF EXISTS `fancai`;
CREATE TABLE `fancai`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `fanname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `cainame` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fancai
-- ----------------------------
INSERT INTO `fancai` VALUES (1, '烤鸭拌饭123231', '竹清苑');
INSERT INTO `fancai` VALUES (2, '自选菜', '竹清苑');
INSERT INTO `fancai` VALUES (3, '豆花鱼', '菊南苑');
INSERT INTO `fancai` VALUES (4, '米村拌饭', '鼎元书院');

-- ----------------------------
-- Table structure for yonghu
-- ----------------------------
DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE `yonghu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yonghu
-- ----------------------------
INSERT INTO `yonghu` VALUES (1, '张某', '13523909982', '8号楼212');
INSERT INTO `yonghu` VALUES (2, '刘某', '13687460985', '8号楼212');
INSERT INTO `yonghu` VALUES (3, '聂某', '18438590653', '8号楼212');
INSERT INTO `yonghu` VALUES (4, '齐某', '13947289523', '8号楼212');
INSERT INTO `yonghu` VALUES (6, '张三', '13598752345', '8号楼213');

SET FOREIGN_KEY_CHECKS = 1;
