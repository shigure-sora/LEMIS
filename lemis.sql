/*
 Future-Tech DMC Data Transfer

 Source Server         : Future-Tech Data Center
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : 
 Source Schema         : lemis

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 03/07/2021 16:42:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for checklist
-- ----------------------------
DROP TABLE IF EXISTS `checklist`;
CREATE TABLE `checklist`  (
  `req_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `equip_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equip_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equip_series` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `req_repair_man` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lab` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`req_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of checklist
-- ----------------------------
INSERT INTO `checklist` VALUES ('121551', '666', '456464', '水道发', '67', 'soar', 'Approve', '阿达');
INSERT INTO `checklist` VALUES ('336878', '离心力演示仪', '41638149852', 'FTC-CF01', '外环脱离', 'kano_dayo', 'Approve', '基础物理实验室1');
INSERT INTO `checklist` VALUES ('49574', '光学透镜', '41638149849', 'FTC-L01', '碎裂', 'kano_dayo', 'Approve', '基础物理实验室1');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
  `equip_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '序列号',
  `equip_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备名',
  `equip_lab` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所在实验室',
  `manufacturing_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产日期',
  `expiring_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保修日期',
  `manufactory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产厂商',
  `equip_series` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态',
  `problem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问题描述',
  `req_repair_man` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修申请人',
  `worker_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修员',
  PRIMARY KEY (`equip_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('41638149849', '光学透镜', '基础物理实验室1', '2019-03-28 17:22:29.000', '2022-03-28 17:22:29.000', 'Future-Tech Corporation', 'FTC-L01', 'Normal', '', '', '');
INSERT INTO `equipment` VALUES ('41638149850', '光学透镜', '基础物理实验室2', '2019-03-29 17:22:28.995', '2022-03-29 17:22:28.995', 'Future-Tech Corporation', 'FTC-L01', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149851', '光学透镜', '基础物理实验室3', '2019-03-30 17:22:28.995', '2022-03-30 17:22:28.995', 'Future-Tech Corporation', 'FTC-L01', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149852', '离心力演示仪', '基础物理实验室1', '2019-03-31 17:22:28.98', '2022-03-31 17:22:28.98', 'Future-Tech Corporation', 'FTC-CF01', 'Normal', '', '', '');
INSERT INTO `equipment` VALUES ('41638149853', '离心力演示仪', '基础物理实验室2', '2019-04-01 17:22:28.975', '2022-04-01 17:22:28.975', 'Future-Tech Corporation', 'FTC-CF01', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149854', '离心力演示仪', '基础物理实验室3', '2019-04-02 17:22:28.97', '2022-04-02 17:22:28.97', 'Future-Tech Corporation', 'FTC-CF01', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149855', 'He-Ne激光发生器', '基础物理实验室1', '2019-04-01 17:22:28.975', '2022-04-01 17:22:28.975', 'Future-Tech Corporation', 'FTC-HN01', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149856', 'He-Ne激光发生器', '基础物理实验室2', '2019-04-02 17:22:28.97', '2022-04-02 17:22:28.97', 'Future-Tech Corporation', 'FTC-HN01', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149857', 'He-Ne激光发生器', '基础物理实验室3', '2019-04-01 17:22:28.975', '2022-04-01 17:22:28.975', 'Future-Tech Corporation', 'FTC-HN01', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149858', 'FTC-I 声光衍射仪', '基础物理实验室1', '2019-04-01 17:22:28.975', '2022-04-01 17:22:28.975', 'Future-Tech Corporation', 'FTC-AO-I', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149859', 'FTC-I 声光衍射仪', '基础物理实验室2', '2019-04-02 17:22:28.97', '2022-04-02 17:22:28.97', 'Future-Tech Corporation', 'FTC-AO-I', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149860', 'FTC-I 声光衍射仪', '基础物理实验室3', '2019-04-01 17:22:28.975', '2022-04-01 17:22:28.975', 'Future-Tech Corporation', 'FTC-AO-I', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149861', '游标卡尺', '基础物理实验室1', '2019-04-01 17:22:28.975', '2022-04-01 17:22:28.975', 'Future-Tech Corporation', 'FTC-VC-1', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149862', '游标卡尺', '基础物理实验室2', '2019-04-02 17:22:28.97', '2022-04-02 17:22:28.97', 'Future-Tech Corporation', 'FTC-VC-1', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149863', '游标卡尺', '基础物理实验室3', '2019-04-01 17:22:28.975', '2022-04-01 17:22:28.975', 'Future-Tech Corporation', 'FTC-VC-1', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149864', '进动仪', '基础物理实验室1', '2019-04-01 17:22:28.975', '2022-04-01 17:22:28.975', 'Future-Tech Corporation', 'FTC-Pre-01', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149865', '进动仪', '基础物理实验室2', '2019-04-02 17:22:28.97', '2022-04-02 17:22:28.97', 'Future-Tech Corporation', 'FTC-Pre-01', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149866', '进动仪', '基础物理实验室3', '2019-04-01 17:22:28.975', '2022-04-01 17:22:28.975', 'Future-Tech Corporation', 'FTC-Pre-01', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149867', '其他', '基础物理实验室1', '2019-04-01 17:22:28.975', '2022-04-01 17:22:28.975', 'Future-Tech Corporation', 'FTC-PHPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149868', '其他', '基础物理实验室2', '2019-04-02 17:22:28.97', '2022-04-02 17:22:28.97', 'Future-Tech Corporation', 'FTC-PHPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149869', '其他', '基础物理实验室3', '2019-04-01 17:22:28.975', '2022-04-01 17:22:28.975', 'Future-Tech Corporation', 'FTC-PHPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149870', '化学器材箱', '化学实验室1', '2019-03-28 17:22:29.000', '2022-03-28 17:22:29.000', 'Future-Tech Corporation', 'FTC-CHPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149871', '化学器材箱', '化学实验室2', '2019-03-29 17:22:28.995', '2022-03-29 17:22:28.995', 'Future-Tech Corporation', 'FTC-CHPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149872', '化学器材箱', '化学实验室3', '2019-03-30 17:22:28.995', '2022-03-30 17:22:28.995', 'Future-Tech Corporation', 'FTC-CHPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149873', '化学器材箱', '化学实验室4', '2019-03-31 17:22:28.98', '2022-03-31 17:22:28.98', 'Future-Tech Corporation', 'FTC-CHPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149874', '生物实验箱', '基础生物实验室1', '2019-03-28 17:22:29.000', '2022-03-28 17:22:29.000', 'Future-Tech Corporation', 'FTC-BIOPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149875', '生物实验箱', '基础生物实验室2', '2019-03-29 17:22:28.995', '2022-03-29 17:22:28.995', 'Future-Tech Corporation', 'FTC-BIOPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149876', '生物实验箱', '基础生物实验室3', '2019-03-30 17:22:28.995', '2022-03-30 17:22:28.995', 'Future-Tech Corporation', 'FTC-BIOPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149877', '生物实验箱', '基础生物实验室4', '2019-03-31 17:22:28.98', '2022-03-31 17:22:28.98', 'Future-Tech Corporation', 'FTC-BIOPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149878', '电子实验箱', '电子实验室1', '2019-03-28 17:22:29.000', '2022-03-28 17:22:29.000', 'Future-Tech Corporation', 'FTC-EPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149879', '电子实验箱', '电子实验室2', '2019-03-29 17:22:28.995', '2022-03-29 17:22:28.995', 'Future-Tech Corporation', 'FTC-EPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149880', '电子实验箱', '电子实验室3', '2019-03-30 17:22:28.995', '2022-03-30 17:22:28.995', 'Future-Tech Corporation', 'FTC-EPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149881', '电子实验箱', '电子实验室4', '2019-03-31 17:22:28.98', '2022-03-31 17:22:28.98', 'Future-Tech Corporation', 'FTC-EPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149882', '机电实验箱', '机电实验室1', '2019-03-28 17:22:29.000', '2022-03-28 17:22:29.000', 'Future-Tech Corporation', 'FTC-MAPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149883', '机电实验箱', '机电实验室2', '2019-03-29 17:22:28.995', '2022-03-29 17:22:28.995', 'Future-Tech Corporation', 'FTC-MAPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149884', '机电实验箱', '机电实验室3', '2019-03-30 17:22:28.995', '2022-03-30 17:22:28.995', 'Future-Tech Corporation', 'FTC-MAPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149885', '机电实验箱', '机电实验室4', '2019-03-31 17:22:28.98', '2022-03-31 17:22:28.98', 'Future-Tech Corporation', 'FTC-MAPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149886', '基础实验室1', '基础实验室1', '2019-03-28 17:22:29.000', '2022-03-28 17:22:29.000', 'Future-Tech Corporation', 'FTC-BPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149887', '基础实验室2', '基础实验室2', '2019-03-29 17:22:28.995', '2022-03-29 17:22:28.995', 'Future-Tech Corporation', 'FTC-BPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149888', '基础实验室3', '基础实验室3', '2019-03-30 17:22:28.995', '2022-03-30 17:22:28.995', 'Future-Tech Corporation', 'FTC-BPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149889', '基础实验室4', '基础实验室4', '2019-03-31 17:22:28.98', '2022-03-31 17:22:28.98', 'Future-Tech Corporation', 'FTC-BPACK', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149890', '投影', '所有实验室', '2019-03-30 17:22:28.995', '2022-03-30 17:22:28.995', 'Future-Tech Corporation', 'FTC-PROJ01', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149891', '投影', '所有实验室', '2019-03-31 17:22:28.98', '2022-03-31 17:22:28.98', 'Future-Tech Corporation', 'FTC-PROJ01', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149892', '投影', '所有实验室', '2019-03-28 17:22:29.000', '2022-03-28 17:22:29.000', 'Future-Tech Corporation', 'FTC-PROJ01', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149893', '投影', '所有实验室', '2019-03-29 17:22:28.995', '2022-03-29 17:22:28.995', 'Future-Tech Corporation', 'FTC-PROJ01', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149894', '投影', '所有实验室', '2019-03-30 17:22:28.995', '2022-03-30 17:22:28.995', 'Future-Tech Corporation', 'FTC-PROJ01', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149895', '投影', '所有实验室', '2019-03-31 17:22:28.98', '2022-03-31 17:22:28.98', 'Future-Tech Corporation', 'FTC-PROJ01', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149896', '空调', '所有实验室', '2019-03-30 17:22:28.995', '2022-03-30 17:22:28.995', 'Future-Tech Corporation', 'FTC-AC-II', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149897', '空调', '所有实验室', '2019-03-31 17:22:28.98', '2022-03-31 17:22:28.98', 'Future-Tech Corporation', 'FTC-AC-II', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149898', '空调', '所有实验室', '2019-03-28 17:22:29.000', '2022-03-28 17:22:29.000', 'Future-Tech Corporation', 'FTC-AC-II', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149899', '空调', '所有实验室', '2019-03-29 17:22:28.995', '2022-03-29 17:22:28.995', 'Future-Tech Corporation', 'FTC-AC-II', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149900', '空调', '所有实验室', '2019-03-30 17:22:28.995', '2022-03-30 17:22:28.995', 'Future-Tech Corporation', 'FTC-AC-II', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149901', '空调', '所有实验室', '2019-03-31 17:22:28.98', '2022-03-31 17:22:28.98', 'Future-Tech Corporation', 'FTC-AC-II', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149902', '电脑', '软件实验室1', '2019-03-30 17:22:28.995', '2022-03-30 17:22:28.995', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149903', '电脑', '软件实验室2', '2019-03-31 17:22:28.98', '2022-03-31 17:22:28.98', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149904', '电脑', '软件实验室3', '2019-03-28 17:22:29.000', '2022-03-28 17:22:29.000', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149905', '电脑', '软件实验室4', '2019-03-29 17:22:28.995', '2022-03-29 17:22:28.995', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149906', '电脑', '软件实验室5', '2019-03-30 17:22:28.995', '2022-03-30 17:22:28.995', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149907', '电脑', '基础物理实验室1', '2019-03-31 17:22:28.98', '2022-03-31 17:22:28.98', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149908', '电脑', '基础物理实验室2', '2019-03-30 17:22:28.995', '2022-03-30 17:22:28.995', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149909', '电脑', '基础物理实验室3', '2019-03-31 17:22:28.98', '2022-03-31 17:22:28.98', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149910', '电脑', '化学实验室1', '2019-03-28 17:22:29.000', '2022-03-28 17:22:29.000', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149911', '电脑', '化学实验室2', '2019-03-29 17:22:28.995', '2022-03-29 17:22:28.995', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149912', '电脑', '化学实验室3', '2019-03-30 17:22:28.995', '2022-03-30 17:22:28.995', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149913', '电脑', '化学实验室4', '2019-03-31 17:22:28.98', '2022-03-31 17:22:28.98', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149914', '电脑', '基础生物实验室1', '2019-03-30 17:22:28.995', '2022-03-30 17:22:28.995', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149915', '电脑', '基础生物实验室2', '2019-03-31 17:22:28.98', '2022-03-31 17:22:28.98', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149916', '电脑', '基础生物实验室3', '2019-03-28 17:22:29.000', '2022-03-28 17:22:29.000', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149917', '电脑', '基础生物实验室4', '2019-03-29 17:22:28.995', '2022-03-29 17:22:28.995', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);
INSERT INTO `equipment` VALUES ('41638149918', '电脑', '基础实验室4', '2019-04-02 17:22:28.945', '2022-04-02 17:22:28.99', 'DELL.Inc', 'PowerEdge T640', 'Normal', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for laboratory
-- ----------------------------
DROP TABLE IF EXISTS `laboratory`;
CREATE TABLE `laboratory`  (
  `lab_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lab_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lab_equip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lab_technician` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lab_dept` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lab_sit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lab_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`lab_id`) USING BTREE,
  INDEX `lab_technician`(`lab_technician`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of laboratory
-- ----------------------------
INSERT INTO `laboratory` VALUES ('10001', '基础物理实验室1', '120', 'kano_dayo', 'Physics', '30', 'Online');
INSERT INTO `laboratory` VALUES ('10002', '基础物理实验室2', '120', 'kano_dayo', 'Physics', '30', 'Online');
INSERT INTO `laboratory` VALUES ('10003', '基础物理实验室3', '120', 'kano_dayo', 'Physics', '30', 'Online');
INSERT INTO `laboratory` VALUES ('10004', '化学实验室1', '60', 'sora', 'Department of Chemistry', '20', 'Online');
INSERT INTO `laboratory` VALUES ('10005', '化学实验室2', '60', 'sora', 'Department of Chemistry', '20', 'Online');
INSERT INTO `laboratory` VALUES ('10006', '化学实验室3', '60', 'sora', 'Department of Chemistry', '20', 'Online');
INSERT INTO `laboratory` VALUES ('10007', '化学实验室4', '60', 'sora', 'Department of Chemistry', '20', 'Online');
INSERT INTO `laboratory` VALUES ('10008', '软件实验室1', '40', '李迪', 'Department of Computer Science', '40', 'Online');
INSERT INTO `laboratory` VALUES ('10009', '软件实验室2', '40', '海山', 'Department of Computer Science', '40', 'Online');
INSERT INTO `laboratory` VALUES ('10010', '软件实验室3', '40', '汉宝', 'Department of Computer Science', '40', 'Online');
INSERT INTO `laboratory` VALUES ('10011', '软件实验室4', '40', '阿韦', 'Department of Computer Science', '40', 'Online');
INSERT INTO `laboratory` VALUES ('10012', '软件实验室5', '40', '狸头人赛高', 'Department of Computer Science', '40', 'Online');
INSERT INTO `laboratory` VALUES ('10013', '机电实验室1', '40', 'Tartaglia', 'Engineering Department', '40', 'Online');
INSERT INTO `laboratory` VALUES ('10014', '机电实验室2', '40', 'Tartaglia', 'Engineering Department', '40', 'Online');
INSERT INTO `laboratory` VALUES ('10015', '机电实验室3', '40', 'Tartaglia', 'Engineering Department', '40', 'Online');
INSERT INTO `laboratory` VALUES ('10016', '机电实验室4', '40', 'Tartaglia', 'Engineering Department', '40', 'Online');
INSERT INTO `laboratory` VALUES ('10017', '基础生物实验室1', '45', 'Hu Tao', 'Medicine', '45', 'Online');
INSERT INTO `laboratory` VALUES ('10018', '基础生物实验室2', '45', 'Hu Tao', 'Medicine', '45', 'Online');
INSERT INTO `laboratory` VALUES ('10019', '基础生物实验室3', '45', 'Hu Tao', 'Medicine', '45', 'Online');
INSERT INTO `laboratory` VALUES ('10020', '基础生物实验室4', '45', 'Hu Tao', 'Medicine', '45', 'Online');
INSERT INTO `laboratory` VALUES ('10021', '电子实验室1', '60', 'Tartaglia', 'Engineering Department', '60', 'Online');
INSERT INTO `laboratory` VALUES ('10022', '电子实验室2', '60', 'Tartaglia', 'Engineering Department', '60', 'Online');
INSERT INTO `laboratory` VALUES ('10023', '电子实验室3', '60', 'Tartaglia', 'Engineering Department', '60', 'Online');
INSERT INTO `laboratory` VALUES ('10024', '电子实验室4', '60', 'Tartaglia', 'Engineering Department', '60', 'Online');
INSERT INTO `laboratory` VALUES ('10025', '基础实验室1', '60', 'Eula', 'Engineering Department', '60', 'Online');
INSERT INTO `laboratory` VALUES ('10026', '基础实验室2', '60', 'Eula', 'Engineering Department', '60', 'Online');
INSERT INTO `laboratory` VALUES ('10027', '基础实验室3', '60', 'Eula', 'Engineering Department', '60', 'Online');
INSERT INTO `laboratory` VALUES ('10028', '基础实验室4', '60', 'Eula', 'Engineering Department', '60', 'Online');
INSERT INTO `laboratory` VALUES ('10029', 'FTC-Lab', '10', 'kano_dayo', 'unknow', '5', 'unknow');

-- ----------------------------
-- Table structure for level
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level`  (
  `level_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`level_id`) USING BTREE,
  INDEX `level`(`level_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of level
-- ----------------------------
INSERT INTO `level` VALUES ('1', 'Administrator');
INSERT INTO `level` VALUES ('3', 'Maintenance Worker');
INSERT INTO `level` VALUES ('5', 'Student');
INSERT INTO `level` VALUES ('4', 'Teacher');
INSERT INTO `level` VALUES ('2', 'Technician');

-- ----------------------------
-- Table structure for maintain
-- ----------------------------
DROP TABLE IF EXISTS `maintain`;
CREATE TABLE `maintain`  (
  `req_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `equip_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equip_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equip_series` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`req_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of maintain
-- ----------------------------
INSERT INTO `maintain` VALUES ('121551', '666', '456464', '水道发', '67', 'Approve');

-- ----------------------------
-- Table structure for request
-- ----------------------------
DROP TABLE IF EXISTS `request`;
CREATE TABLE `request`  (
  `req_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `equip_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `equip_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `req_repair_man` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `equip_series` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `problem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lab` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`req_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of request
-- ----------------------------
INSERT INTO `request` VALUES ('121551', '666', '456464', 'soar', '水道发', '67', '阿达', 'Approve');
INSERT INTO `request` VALUES ('336878', '离心力演示仪', '41638149852', 'kano_dayo', 'FTC-CF01', '外环脱离', '基础物理实验室1', 'Approve');
INSERT INTO `request` VALUES ('49574', '光学透镜', '41638149849', 'kano_dayo', 'FTC-L01', '碎裂', '基础物理实验室1', 'Approve');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户标识',
  `user_tele` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `user_dept` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属二级学院',
  `user_auth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权码',
  `user_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `user_lab` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `user_title`(`user_title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('316381099', 'kano_dayo', '123456', 'Administrator', '17777777777', 'Management level', '122448', 'Online', 'FTC-Lab');
INSERT INTO `user` VALUES ('316381100', 'sora', '123456', 'Technician', '16666666666', 'Department of Chemistry', '140422', 'Online', '化学实验室1-4');
INSERT INTO `user` VALUES ('316381101', 'shigure', '123456', 'Student', '15555555555', 'BigData', '130601', 'Online', '');
INSERT INTO `user` VALUES ('316381102', 'test15', '123456', 'Technician', '13333333333', 'BigData', '110702', 'Online', '软件实验室4');
INSERT INTO `user` VALUES ('316381103', 'QWQ', '123456', 'Student', '12222222222', 'Mathematics', '101816', 'Online', '');
INSERT INTO `user` VALUES ('316381104', 'test6', '123456', 'Maintenance Worker', '11111111111', 'MD', '211135', 'Online', '');
INSERT INTO `user` VALUES ('316381105', 'Tartaglia', '123456', 'Technician', '18888888888', 'Engineering Department', '454278', 'Online', '基础实验室1-2');
INSERT INTO `user` VALUES ('316381106', 'Hu Tao', '123456', 'Technician', '10101010101', 'Medicine', '130611', 'Online', '基础生物实验室1-4');
INSERT INTO `user` VALUES ('316381107', 'Eula', '123456', 'Technician', '12121212121', 'Engineering Department', '151211', 'Online', '基础实验室3-4');
INSERT INTO `user` VALUES ('316381108', 'AIRI', '123456', 'Administrator', '17777777777', 'Management level', '122448', 'Online', 'FTC-Lab');
INSERT INTO `user` VALUES ('316381110', 'test1', '123456', 'Technician', '13131313113', 'BigData', '151588', 'Online', '软件实验室1');
INSERT INTO `user` VALUES ('316381111', 'test2', '123456', 'Technician', '15151515151', 'BigData', '634633', 'Online', '软件实验室2');
INSERT INTO `user` VALUES ('316381112', 'test3', '123456', 'Technician', '16161616161', 'BigData', '456836', 'Online', '软件实验室3');
INSERT INTO `user` VALUES ('316381113', 'test4', '123456', 'Technician', '17171717171', 'BigData', '545151', 'Online', '软件实验室5');
INSERT INTO `user` VALUES ('316381114', 'sana', '123456', 'Teacher', '18181818181', 'BigData', '564465', 'Online', '');
INSERT INTO `user` VALUES ('316381115', 'aqua', '123456', 'Student', '19191919191', 'BigData', '165165', 'Online', '');
INSERT INTO `user` VALUES ('316381116', 'kano', '123456', 'Technician', '19199191921', 'Physics', '140422', 'Online', '基础物理实验室1-4');
INSERT INTO `user` VALUES ('316381117', 'unicorn', '123456', 'Technician', '17777777777', 'Physics', '140422', 'Online', 'FTC-Lab');
INSERT INTO `user` VALUES ('316381199', 'ATRI', '123456', 'Administrator', '17777777777', 'Management level', '122448', 'Online', 'FTC-Lab');

SET FOREIGN_KEY_CHECKS = 1;
