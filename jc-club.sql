/*
 Navicat Premium Data Transfer

 Source Server         : CentOS 7 mysql8.4.2
 Source Server Type    : MySQL
 Source Server Version : 80402
 Source Host           : 192.168.88.130:3306
 Source Schema         : jc-club

 Target Server Type    : MySQL
 Target Server Version : 80402
 File Encoding         : 65001

 Date: 20/09/2024 20:25:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_permission
-- ----------------------------
DROP TABLE IF EXISTS `auth_permission`;
CREATE TABLE `auth_permission`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `parent_id` bigint NULL DEFAULT NULL COMMENT '父id',
  `type` tinyint NULL DEFAULT NULL COMMENT '权限类型 0菜单 1操作',
  `menu_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '菜单路由',
  `status` tinyint NULL DEFAULT NULL COMMENT '状态 0启用 1禁用',
  `show` tinyint NULL DEFAULT NULL COMMENT '展示状态 0展示 1隐藏',
  `icon` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图标',
  `permission_key` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '权限唯一标识',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of auth_permission
-- ----------------------------
INSERT INTO `auth_permission` VALUES (1, '新增题目', 0, 1, 'ladiwd/www', 0, 0, 'http://1.png', 'subject:add1', 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:20:38', '', '2023-11-12 16:17:12', 0);

-- ----------------------------
-- Table structure for auth_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_key` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色唯一标识',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否被删除 0未删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of auth_role
-- ----------------------------
INSERT INTO `auth_role` VALUES (1, '管理员', 'admin_user', 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:20:44', '', '2023-11-12 16:16:07', 0);
INSERT INTO `auth_role` VALUES (2, '普通用户', 'normal_user', 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:20:44', '', '2023-11-12 16:16:10', 0);

-- ----------------------------
-- Table structure for auth_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_permission`;
CREATE TABLE `auth_role_permission`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` bigint NULL DEFAULT NULL COMMENT '权限id',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of auth_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名称/账号',
  `nick_name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `email` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `password` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` tinyint NULL DEFAULT NULL COMMENT '性别',
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像',
  `status` tinyint NULL DEFAULT NULL COMMENT '状态 0启用 1禁用',
  `introduce` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '个人介绍',
  `ext_json` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '特殊字段',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否被删除 0未删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of auth_user
-- ----------------------------

-- ----------------------------
-- Table structure for auth_user_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `role_id` bigint NULL DEFAULT NULL COMMENT '角色id',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of auth_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for practice_detail
-- ----------------------------
DROP TABLE IF EXISTS `practice_detail`;
CREATE TABLE `practice_detail`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `practice_id` bigint NULL DEFAULT NULL COMMENT '练题id',
  `subject_id` bigint NULL DEFAULT NULL COMMENT '题目id',
  `subject_type` int NULL DEFAULT NULL COMMENT '题目类型',
  `answer_status` int NULL DEFAULT NULL COMMENT '回答状态',
  `answer_content` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '回答内容',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '练习详情表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of practice_detail
-- ----------------------------

-- ----------------------------
-- Table structure for practice_info
-- ----------------------------
DROP TABLE IF EXISTS `practice_info`;
CREATE TABLE `practice_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `set_id` bigint NULL DEFAULT NULL COMMENT '套题id',
  `complete_status` tinyint NULL DEFAULT NULL COMMENT '是否完成 1完成 0未完成',
  `time_use` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用时',
  `submit_time` datetime NULL DEFAULT NULL COMMENT '交卷时间',
  `correct_rate` decimal(10, 2) NULL DEFAULT NULL COMMENT '正确率',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '练习表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of practice_info
-- ----------------------------

-- ----------------------------
-- Table structure for practice_set
-- ----------------------------
DROP TABLE IF EXISTS `practice_set`;
CREATE TABLE `practice_set`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `set_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '套题名称',
  `set_type` int NULL DEFAULT NULL COMMENT '套题类型 1实时生成 2预设套题',
  `set_heat` int NULL DEFAULT NULL COMMENT '热度',
  `set_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '套题描述',
  `primary_category_id` bigint NULL DEFAULT NULL COMMENT '大类id',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '套题信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of practice_set
-- ----------------------------

-- ----------------------------
-- Table structure for practice_set_detail
-- ----------------------------
DROP TABLE IF EXISTS `practice_set_detail`;
CREATE TABLE `practice_set_detail`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `set_id` bigint NOT NULL COMMENT '套题id',
  `subject_id` bigint NULL DEFAULT NULL COMMENT '题目id',
  `subject_type` int NULL DEFAULT NULL COMMENT '题目类型',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '套题内容表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of practice_set_detail
-- ----------------------------

-- ----------------------------
-- Table structure for sensitive_words
-- ----------------------------
DROP TABLE IF EXISTS `sensitive_words`;
CREATE TABLE `sensitive_words`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `words` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '内容',
  `type` int NULL DEFAULT 0 COMMENT '1=黑名单 2=白名单',
  `is_deleted` tinyint(1) NULL DEFAULT NULL COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '敏感词表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sensitive_words
-- ----------------------------

-- ----------------------------
-- Table structure for share_circle
-- ----------------------------
DROP TABLE IF EXISTS `share_circle`;
CREATE TABLE `share_circle`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '圈子ID',
  `parent_id` bigint NOT NULL COMMENT '父级ID,-1为大类',
  `circle_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '圈子名称',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '圈子图片',
  `created_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_parent_id`(`parent_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '圈子信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of share_circle
-- ----------------------------

-- ----------------------------
-- Table structure for share_comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `share_comment_reply`;
CREATE TABLE `share_comment_reply`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `moment_id` bigint NOT NULL COMMENT '原始动态ID',
  `reply_type` tinyint NOT NULL COMMENT '回复类型 1评论 2回复',
  `to_id` bigint NULL DEFAULT NULL COMMENT '评论目标id',
  `to_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论人',
  `to_user_author` tinyint NULL DEFAULT NULL COMMENT '评论人是否作者 1=是 0=否',
  `reply_id` bigint NULL DEFAULT NULL COMMENT '回复目标id',
  `reply_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '回复人',
  `replay_author` tinyint NULL DEFAULT NULL COMMENT '回复人是否作者 1=是 0=否',
  `content` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '内容',
  `pic_urls` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片内容',
  `created_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  `parent_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_moment_id`(`moment_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '评论及回复信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of share_comment_reply
-- ----------------------------

-- ----------------------------
-- Table structure for share_message
-- ----------------------------
DROP TABLE IF EXISTS `share_message`;
CREATE TABLE `share_message`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `from_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '来自人',
  `to_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '送达人',
  `content` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '消息内容',
  `is_read` tinyint NULL DEFAULT 0 COMMENT '是否被阅读 1是 2否',
  `created_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_to_id`(`to_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '消息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of share_message
-- ----------------------------

-- ----------------------------
-- Table structure for share_moment
-- ----------------------------
DROP TABLE IF EXISTS `share_moment`;
CREATE TABLE `share_moment`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '动态ID',
  `circle_id` bigint NOT NULL COMMENT '圈子ID',
  `content` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '动态内容',
  `pic_urls` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '动态图片内容',
  `reply_count` int NOT NULL DEFAULT 0 COMMENT '回复数',
  `created_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_circle_id`(`circle_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '动态信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of share_moment
-- ----------------------------

-- ----------------------------
-- Table structure for subject_brief
-- ----------------------------
DROP TABLE IF EXISTS `subject_brief`;
CREATE TABLE `subject_brief`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` bigint NULL DEFAULT NULL COMMENT '题目id',
  `subject_answer` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '题目答案',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 281 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '简答题' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of subject_brief
-- ----------------------------
INSERT INTO `subject_brief` VALUES (59, 100, '<p><br></p><ol><li>String（字符串）</li><li>List（列表）</li><li>Hash（字典）</li><li>Set（集合）</li><li>Sorted Set（有序集合）</li></ol><p><br></p><p><strong>String</strong></p><p><br></p><p>String是简单的 key-value 键值对，value 不仅可以是 String，也可以是数字。String在redis内部存储默认就是一个字符串，被redisObject所引用，当遇到incr,decr等操作时会转成数值型进行计算，此时redisObject的encoding字段为int。</p><p><br></p><p><strong>List</strong></p><p><br></p><p>Redis列表是简单的字符串列表，可以类比到C++中的std::list，简单的说就是一个链表或者说是一个队列。可以从头部或尾部向Redis列表添加元素。列表的最大长度为2^32 - 1，也即每个列表支持超过40亿个元素。</p><p><br></p><p>Redis list的实现为一个双向链表，即可以支持反向查找和遍历，更方便操作，不过带来了部分额外的内存开销，Redis内部的很多实现，包括发送缓冲队列等也都是用的这个数据结构。</p><p><br></p><p><strong>Hash</strong></p><p><br></p><p>Redis Hash对应Value内部实际就是一个HashMap，实际这里会有2种不同实现，这个Hash的成员比较少时Redis为了节省内存会采用类似一维数组的方式来紧凑存储，而不会采用真正的HashMap结构，对应的value redisObject的encoding为zipmap,当成员数量增大时会自动转成真正的HashMap。</p><p><br></p><p><strong>Set</strong></p><p><br></p><p>set 的内部实现是一个 value永远为null的HashMap，实际就是通过计算hash的方式来快速排重的，这也是set能提供判断一个成员是否在集合内的原因。</p><p><br></p><p><strong>Sorted Set</strong></p><p><br></p><p>Redis有序集合类似Redis集合，不同的是增加了一个功能，即集合是有序的。一个有序集合的每个成员带有分数，用于进行排序。</p><p><br></p><p>Redis有序集合添加、删除和测试的时间复杂度均为O(1)(固定时间，无论里面包含的元素集合的数量)。列表的最大长度为2^32- 1元素(4294967295，超过40亿每个元素的集合)。</p><p><br></p><p>Redis sorted set的内部使用HashMap和跳跃表(SkipList)来保证数据的存储和有序，HashMap里放的是成员到score的映射，而跳跃表里存放的是所有的成员，排序依据是HashMap里存的score,使用跳跃表的结构可以获得比较高的查找效率，并且在实现上比较简单。</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (60, 101, '<p><br></p><p>bitmap：bitmap是一种位数据类型，常常用于统计，大家比较知名的就是布隆过滤器。也可以统计一些大数据量的东西，比如每天有多少优惠券被使用。</p><p><br></p><p>hyperloglog：用于基数统计，基数是数据集去重后元素个数，运用了LogLog的算法。{1,3,5,7,5,7,8} &nbsp; 基数集:{1,3,5,7,8} &nbsp;基数:5</p><p><br></p><p>geo：应用于地理位置计算，主要是经纬度的计算，常见的就是附近的人，可以以当前人的坐标获取周围附近的成员，可以计算经纬度，计算地理位置</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (61, 102, '<p><br></p><p>(1) 速度快，因为数据存在内存中，类似于HashMap，HashMap的优势就是查找和操作的时间复杂度都是O(1)</p><p><br></p><p>(2) 支持丰富数据类型，支持string，list，set，Zset，hash等</p><p><br></p><p>(3) 支持事务，操作都是原子性，所谓的原子性就是对数据的更改要么全部执行，要么全部不执行</p><p><br></p><p>(4) 丰富的特性：可用于缓存，消息，按key设置过期时间，过期后将会自动删除</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (62, 103, '<p><br></p><p>(1) Memcached所有的值均是简单的字符串，redis作为其替代者，支持更为丰富的数据类型</p><p><br></p><p>(2) Redis的速度比Memcached快很多</p><p><br></p><p>(3) Redis可以持久化其数据</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (63, 104, '<p><br></p><p>Redis采用的是单线程模型，因为Redis是一个基于内存的数据库，将所有的数据放入内存，所以使用单线程的操作效率是最高的，多线程会上下文切换消耗大量时间，对于内存系统来说，单线程才能产生更高的效率。但是单线程不意味着整个Redis就一个线程，Redis其他模块还有各自的线程。</p><p><br></p><p>Redis使用I/O threads 指的是网络I/O处理方面使用了多线程，如网络数据的读写和协议解析等，这是因为读写网络的read/write在Redis执行期间占用了大部分CPU时间，如果把这部分模块使用多线程方式实现会对性能带来极大地提升。但是Redis执行命令的核心模块还是单线程的。</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (64, 105, '<p><br></p><p>1、更新数据库，同时更新缓存，适合并发场景不高的场景</p><p><br></p><p>2、先删除缓存，再更新数据，再删除缓存</p><p><br></p><p>3、通过消息来更新缓存。</p><p><br></p><p>4、通过canal等消息同步的方式。</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (65, 106, '<p><br></p><p>noeviction: 当内存不足以容纳新写入数据时，新写入操作会报错。</p><p><br></p><p>allkeys-lru：当内存不足以容纳新写入数据时，在键空间中，移除最近最少使用的 key。</p><p><br></p><p>allkeys-random：当内存不足以容纳新写入数据时，在键空间中，随机移除某个 key，这个一般没人用吧，为啥要随机，肯定是把最近最少使用的 key 给干掉啊。</p><p><br></p><p>volatile-lru：当内存不足以容纳新写入数据时，在设置了过期时间的键空间中，移除最近最少使用的 key。</p><p><br></p><p>volatile-random：当内存不足以容纳新写入数据时，在设置了过期时间的键空间中，随机移除某个 key。</p><p><br></p><p>volatile-ttl：当内存不足以容纳新写入数据时，在设置了过期时间的键空间中，有更早过期时间的 key 优先移除。</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (66, 107, '<p><br></p><p>缓存穿透是指缓存和数据库中都没有的数据，而用户不断发起请求，如发起为id为“-1”的数据或id为特别大不存在的数据。这时的用户很可能是攻击者，攻击会导致数据库压力过大。</p><p><br></p><p>解决方案</p><p><br></p><p>接口层增加校验，如用户鉴权校验，id做基础校验，id&lt;=0的直接拦截；<br>从缓存取不到的数据，在数据库中也没有取到，这时也可以将key-value对写为key-null，缓存有效时间可以设置短点，如30秒（设置太长会导致正常情况也没法使用）。这样可以防止攻击用户反复用同一个id暴力攻击，也可以使用会话重放，防止不断的攻击。</p><p><br></p><h3></h3>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (67, 108, '<p><br></p><p>缓存击穿是指缓存中没有但数据库中有的数据（一般是缓存时间到期），这时由于并发用户特别多，同时读缓存没读到数据，又同时去数据库去取数据，引起数据库压力瞬间增大，造成过大压力</p><p><br></p><p>解决方案：</p><p><br></p><p>设置热点数据永远不过期。<br>加互斥锁</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (68, 109, '<p><br></p><p>缓存雪崩是指缓存中数据大批量到过期时间，而查询数据量巨大，引起数据库压力过大甚至down机。和缓存击穿不同的是，缓存击穿指并发查同一条数据，缓存雪崩是不同数据都过期了，很多数据都查不到从而查数据库。</p><p><br></p><p>解决方案</p><p><br></p><p>缓存数据的过期时间设置随机，防止同一时间大量数据过期现象发生。<br>如果缓存数据库是分布式部署，将热点数据均匀分布在不同的缓存数据库中。也可以是二级缓存，本地和redis共同使用。<br>设置热点数据永远不过期。</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (69, 110, '<p>setex：<br>setex key seconds value：将key值设置为value，并将设置key的生存周期<br>1，属于原子操作，作用和set key value、expire key seconds作用一致。<br>2，如果key值存在，使用setex将覆盖原有值<br>setnx:<br>setnx key value:只有当key不存在的情况下，将key设置为value；若key存在，不做任何操作，结果成功返回1，失败返回0</p>', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_brief` VALUES (280, 330, 'Mysql是个数据库', NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_category
-- ----------------------------
DROP TABLE IF EXISTS `subject_category`;
CREATE TABLE `subject_category`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_name` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `category_type` tinyint NULL DEFAULT NULL COMMENT '分类类型',
  `image_url` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图标连接',
  `parent_id` bigint NULL DEFAULT NULL COMMENT '父级id',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除 0: 未删除 1: 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '题目分类' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of subject_category
-- ----------------------------
INSERT INTO `subject_category` VALUES (1, '后端', 1, 'https://image/category.icon', 0, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:09', NULL, NULL, 0);
INSERT INTO `subject_category` VALUES (2, '缓存', 2, 'https://image/category.icon', 1, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:09', NULL, NULL, 0);
INSERT INTO `subject_category` VALUES (12, 'mybatis', 2, 'https://image/category.icon', 1, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_info
-- ----------------------------
DROP TABLE IF EXISTS `subject_info`;
CREATE TABLE `subject_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '题目名称',
  `subject_difficult` int NULL DEFAULT NULL COMMENT '题目难度',
  `settle_name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '出题人名',
  `subject_type` tinyint NULL DEFAULT NULL COMMENT '题目类型 1单选 2多选 3判断 4简答',
  `subject_score` int NULL DEFAULT NULL COMMENT '题目分数',
  `subject_parse` varchar(512) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '题目解析',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 331 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '题目信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of subject_info
-- ----------------------------
INSERT INTO `subject_info` VALUES (100, 'Redis支持哪几种数据类型？', 1, NULL, 4, 1, '解析什么', 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (101, 'Redis的高级数据类型有什么？', 2, NULL, 4, 1, '解析什么', 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (102, 'Redis的优点有什么？', 1, NULL, 4, 1, '解析什么', 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (103, 'Redis相比Memcached有哪些优势？', 1, NULL, 4, 1, '解析什么', 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (104, 'Redis是单进程单线程的？', 1, NULL, 4, 1, '解析什么', 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (105, '数据库和缓存的数据一致性如何保障，有哪些方案？', 2, NULL, 4, 1, '解析什么', 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (106, 'redis过期策略都有哪些？', 1, NULL, 4, 1, '解析什么', 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (107, '什么是缓存穿透？', 1, NULL, 4, 1, '解析什么', 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (108, '什么是缓存击穿', 1, NULL, 4, 1, '解析什么', 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (109, '什么是缓存雪崩', 1, NULL, 4, 1, '解析什么', 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (110, 'redis的setnx和setex区别', 1, NULL, 4, 1, '解析什么', 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:20:08', NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (327, 'SpringBoot自动装配原理是什么？', 1, NULL, 1, 2, '题目解析', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (328, 'SpringBoot自动装配原理是什么？', 1, NULL, 2, 2, '题目解析', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (329, 'SpringBoot自动装配原理是什么？', 1, NULL, 3, 2, '题目解析', NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_info` VALUES (330, 'Mysql是个什么东西？', 1, NULL, 4, 2, '题目解析2', NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_judge
-- ----------------------------
DROP TABLE IF EXISTS `subject_judge`;
CREATE TABLE `subject_judge`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` bigint NULL DEFAULT NULL COMMENT '题目id',
  `is_correct` tinyint NULL DEFAULT NULL COMMENT '是否正确',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '判断题' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of subject_judge
-- ----------------------------
INSERT INTO `subject_judge` VALUES (1, 329, 1, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_label
-- ----------------------------
DROP TABLE IF EXISTS `subject_label`;
CREATE TABLE `subject_label`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `label_name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标签分类',
  `sort_num` int NULL DEFAULT NULL COMMENT '排序',
  `category_id` bigint NULL DEFAULT NULL,
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '题目标签表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of subject_label
-- ----------------------------
INSERT INTO `subject_label` VALUES (1, 'Redis', 1, 1, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:27', NULL, NULL, 0);
INSERT INTO `subject_label` VALUES (44, '数据一致性', 1, 1, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:27', NULL, NULL, 0);
INSERT INTO `subject_label` VALUES (65, 'spring', 10, 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_label` VALUES (66, 'spring boot', 11, 1, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_liked
-- ----------------------------
DROP TABLE IF EXISTS `subject_liked`;
CREATE TABLE `subject_liked`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` bigint NULL DEFAULT NULL COMMENT '题目id',
  `like_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '点赞人id',
  `status` tinyint NULL DEFAULT NULL COMMENT '点赞状态 1点赞 0不点赞',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uniq_like`(`subject_id` ASC, `like_user_id` ASC) USING BTREE COMMENT '点赞唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '题目点赞表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of subject_liked
-- ----------------------------

-- ----------------------------
-- Table structure for subject_mapping
-- ----------------------------
DROP TABLE IF EXISTS `subject_mapping`;
CREATE TABLE `subject_mapping`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` bigint NULL DEFAULT NULL COMMENT '题目id',
  `category_id` bigint NULL DEFAULT NULL COMMENT '分类id',
  `label_id` bigint NULL DEFAULT NULL COMMENT '标签id',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 549 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '题目分类关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of subject_mapping
-- ----------------------------
INSERT INTO `subject_mapping` VALUES (216, 100, 2, 1, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (217, 101, 2, 1, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (218, 102, 2, 1, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (219, 103, 2, 1, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (220, 104, 2, 1, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (221, 105, 2, 44, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (222, 105, 3, 44, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (223, 106, 2, 1, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (224, 107, 2, 1, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (225, 108, 2, 1, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (226, 109, 2, 1, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (227, 110, 2, 1, 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:35', NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (536, 327, 4, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (537, 327, 4, 3, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (538, 327, 5, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (539, 327, 5, 3, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (540, 328, 4, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (541, 328, 4, 3, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (542, 328, 5, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (543, 328, 5, 3, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (544, 329, 4, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (545, 329, 4, 3, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (546, 329, 5, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (547, 329, 5, 3, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (548, 330, 5, 11, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_multiple
-- ----------------------------
DROP TABLE IF EXISTS `subject_multiple`;
CREATE TABLE `subject_multiple`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` bigint NULL DEFAULT NULL COMMENT '题目id',
  `option_type` int NULL DEFAULT NULL COMMENT '选项类型',
  `option_content` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '选项内容',
  `is_correct` tinyint NULL DEFAULT NULL COMMENT '是否正确',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '多选题信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of subject_multiple
-- ----------------------------
INSERT INTO `subject_multiple` VALUES (1, 328, 1, '自动的', 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_multiple` VALUES (2, 328, 2, '其实是用配置文件', 1, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_radio
-- ----------------------------
DROP TABLE IF EXISTS `subject_radio`;
CREATE TABLE `subject_radio`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` bigint NULL DEFAULT NULL COMMENT '题目id',
  `option_type` int NULL DEFAULT NULL COMMENT 'a,b,c,d',
  `option_content` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '选项内容',
  `is_correct` tinyint NULL DEFAULT NULL COMMENT '是否正确',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '单选题信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of subject_radio
-- ----------------------------
INSERT INTO `subject_radio` VALUES (1, 327, 1, '自动的', 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_radio` VALUES (2, 327, 2, '其实是用配置文件', 0, NULL, NULL, NULL, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
