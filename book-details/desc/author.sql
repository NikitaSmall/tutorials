/*
Navicat PGSQL Data Transfer

Source Server         : local
Source Server Version : 110500
Source Host           : localhost:5432
Source Database       : testdb
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 110500
File Encoding         : 65001

Date: 2019-10-09 01:06:47
*/


-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS "public"."author";
CREATE TABLE "public"."author" (
"id" int4 NOT NULL,
"first_name" varchar(255) COLLATE "default",
"last_name" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO "public"."author" VALUES ('1', 'f1', 'l1');
INSERT INTO "public"."author" VALUES ('2', 'f2', 'l2');
INSERT INTO "public"."author" VALUES ('3', 'f3', 'l3');
INSERT INTO "public"."author" VALUES ('4', 'f4', 'l4');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table author
-- ----------------------------
ALTER TABLE "public"."author" ADD PRIMARY KEY ("id");
