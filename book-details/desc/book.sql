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

Date: 2019-10-09 01:05:42
*/


-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS "public"."book";
CREATE TABLE "public"."book" (
"id" int4 NOT NULL,
"name" varchar(255) COLLATE "default",
"page_count" int4,
"author_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO "public"."book" VALUES ('1', 'b1', '199', '1');
INSERT INTO "public"."book" VALUES ('2', 'b2', '123', '2');
INSERT INTO "public"."book" VALUES ('3', 'b3', '242', '1');
INSERT INTO "public"."book" VALUES ('4', 'b4', '512', '1');
INSERT INTO "public"."book" VALUES ('5', 'b5', '752', '3');
INSERT INTO "public"."book" VALUES ('6', 'b6', '142', '3');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table book
-- ----------------------------
ALTER TABLE "public"."book" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "public"."book"
-- ----------------------------
ALTER TABLE "public"."book" ADD FOREIGN KEY ("author_id") REFERENCES "public"."author" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
