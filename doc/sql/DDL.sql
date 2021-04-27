/*
 Navicat Premium Data Transfer

 Source Server         : BD_Mysql
 Source Server Type    : MySQL
 Source Server Version : 50622
 Source Host           : 106.12.208.53:3306
 Source Schema         : webuy_brms

 Target Server Type    : MySQL
 Target Server Version : 50622
 File Encoding         : 65001

 Date: 27/04/2021 23:20:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for brms_model
-- ----------------------------
DROP TABLE IF EXISTS `brms_model`;
CREATE TABLE `brms_model`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id自增1',
  `model_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '模型key',
  `model_desc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '模型描述',
  `is_delete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_model_key`(`model_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '模型表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for brms_model_attr
-- ----------------------------
DROP TABLE IF EXISTS `brms_model_attr`;
CREATE TABLE `brms_model_attr`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id自增1',
  `model_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '模型key',
  `attr_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性名称',
  `attr_desc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '属性描述',
  `attr_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性类型(STRING,NUMBER,BOOLEAN,DATE,COLLECTION)',
  `attr_model_key_ref` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '属性模型(适用于OBJECT类型属性)',
  `attr_value_source` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性值来源(INPUT,DICT,ADDRESS)',
  `is_delete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_model_key_attr_name`(`model_key`, `attr_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '模型属性表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for brms_rule
-- ----------------------------
DROP TABLE IF EXISTS `brms_rule`;
CREATE TABLE `brms_rule`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id自增1',
  `rule_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规则key',
  `rule_desc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '规则描述',
  `rule_set_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规则集key(package)',
  `rule_enter_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'SELECT' COMMENT '规则录入方式(CODING:编码式录入; SELECT:选择式录入 )',
  `rule_condition_text` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '规则condition代码(CODING方式)',
  `rule_action_text` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '规则action代码(CODING方式)',
  `rule_import_text` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '规则import内容代码(CODING方式)',
  `activation_group` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'activation-group',
  `agenda_group` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'agenda-group',
  `no_loop` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'no-loop(false 或 true)',
  `date_effective` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'date-effective(格式yyyy-MM-DD HH:mm:ss)',
  `date_expires` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'date-expires(格式yyyy-MM-DD HH:mm:ss)',
  `salience` int(10) UNSIGNED NULL DEFAULT NULL COMMENT 'salience(优先级,值越大优先级越高)',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_rule_key`(`rule_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '规则表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for brms_rule_action
-- ----------------------------
DROP TABLE IF EXISTS `brms_rule_action`;
CREATE TABLE `brms_rule_action`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id自增1',
  `rule_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规则key',
  `attr_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性名称',
  `action_value` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '动作值',
  `action_value_type` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '动作值类型(INPUT:直接输入型; CALCULATE:计算型)',
  `value_calculate_formula` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '动作值计算公式(CALCULATE 类型下有效)',
  `calculate_scale` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '计算保留位数',
  `calculate_rounding_mode` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '计算取整方式',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_rule_key`(`rule_key`(20)) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '规则动作表(RHS)' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for brms_rule_condition
-- ----------------------------
DROP TABLE IF EXISTS `brms_rule_condition`;
CREATE TABLE `brms_rule_condition`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id自增1',
  `rule_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规则key',
  `attr_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性名称',
  `condition_operator` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '条件符',
  `condition_value` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '条件值',
  `logical_operator` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '逻辑运算符(与下一个条件的逻辑运算符;取值: &&,|| )',
  `condition_order` int(11) NOT NULL DEFAULT 0 COMMENT '排序(多个条件通过order排序,值越小越靠前,并通过 logical_operator 字段进行连接)',
  `is_delete` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_rule_key`(`rule_key`(20)) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '规则条件表(LHS)' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for brms_rule_hit_log
-- ----------------------------
DROP TABLE IF EXISTS `brms_rule_hit_log`;
CREATE TABLE `brms_rule_hit_log`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id自增1',
  `request_no` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '流水号',
  `rule_set_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规则集key(package)',
  `agenda_group` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '议程组',
  `rule_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规则key',
  `input_model` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '输入模型(Json)',
  `output_model` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '输出模型(Json)',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_request_no`(`request_no`(13)) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 208 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '规则命中日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for brms_rule_set
-- ----------------------------
DROP TABLE IF EXISTS `brms_rule_set`;
CREATE TABLE `brms_rule_set`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id自增1',
  `rule_set_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规则集key(package)',
  `rule_set_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '规则集名称',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_namespace_rule_set_key`(`rule_set_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '规则集表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for brms_rule_set_model
-- ----------------------------
DROP TABLE IF EXISTS `brms_rule_set_model`;
CREATE TABLE `brms_rule_set_model`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id自增1',
  `model_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '模型key',
  `rule_set_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规则集key(package)',
  `model_type` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '模型类型(INPUT:输入; OUTPUT:输出)',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '规则模型关联表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
