/*
 Navicat Premium Data Transfer

 Source Server         : database
 Source Server Type    : MySQL
 Source Server Version : 100312
 Source Host           : localhost:3306
 Source Schema         : appointment

 Target Server Type    : MySQL
 Target Server Version : 100312
 File Encoding         : 65001

 Date: 07/06/2020 15:23:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appointment_list
-- ----------------------------
DROP TABLE IF EXISTS `appointment_list`;
CREATE TABLE `appointment_list`  (
  `id` int(11) NOT NULL COMMENT '一个轮次',
  `max` int(255) NOT NULL COMMENT '口罩总数量',
  `limit` int(255) NOT NULL COMMENT '个人最大预约数量',
  `startTime` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '开始时间',
  `endTime` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '结束时间',
  `status` int(1) NOT NULL COMMENT '1是开放0是结束',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for draw_list
-- ----------------------------
DROP TABLE IF EXISTS `draw_list`;
CREATE TABLE `draw_list`  (
  `id` int(11) NOT NULL,
  `waiting_id` int(11) NOT NULL COMMENT '中签的id',
  `appointment_id` int(11) NOT NULL COMMENT '预约轮次id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `waiting_id`(`waiting_id`) USING BTREE,
  INDEX `appointment_id`(`appointment_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for place
-- ----------------------------
DROP TABLE IF EXISTS `place`;
CREATE TABLE `place`  (
  `id` int(11) NOT NULL,
  `place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`, `place`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for waiting_list
-- ----------------------------
DROP TABLE IF EXISTS `waiting_list`;
CREATE TABLE `waiting_list`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `id_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号码',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `appointment_id` int(11) NOT NULL COMMENT '预约轮次id',
  `appoint_num` int(11) NOT NULL COMMENT '预约数量',
  `place_id` int(11) NOT NULL COMMENT '取货地点',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `appointment_id`(`appointment_id`) USING BTREE,
  INDEX `place_id`(`place_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
