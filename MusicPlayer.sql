/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : MusicPlayer

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 14/12/2023 00:00:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for songList
-- ----------------------------
DROP TABLE IF EXISTS `songList`;
CREATE TABLE `songList` (
  `id` int NOT NULL,
  `songName` varchar(255) DEFAULT NULL,
  `path` varchar(2048) DEFAULT NULL,
  `photo` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of songList
-- ----------------------------
BEGIN;
INSERT INTO `songList` (`id`, `songName`, `path`, `photo`) VALUES (0, '手写的从前', 'http://s5jm2durk.hn-bkt.clouddn.com/1808.%E6%89%8B%E5%86%99%E7%9A%84%E4%BB%8E%E5%89%8D.mp3', '//y.qq.com/music/photo_new/T002R300x300M000001uqejs3d6EID_2.jpg?max_age=2592000');
INSERT INTO `songList` (`id`, `songName`, `path`, `photo`) VALUES (1, 'Lemon', 'http://s5jm2durk.hn-bkt.clouddn.com/%E7%B1%B3%E6%B4%A5%E7%8E%84%E5%B8%AB%20-%20Lemon%20.wav', '//y.qq.com/music/photo_new/T002R300x300M000002OR8wD3Lo3E5_3.jpg?max_age=2592000');
INSERT INTO `songList` (`id`, `songName`, `path`, `photo`) VALUES (2, '小半', 'http://s5jm2durk.hn-bkt.clouddn.com/%E9%99%88%E7%B2%92%20-%20%E5%B0%8F%E5%8D%8A.mp3', '//y.qq.com/music/photo_new/T002R300x300M000004fAhFe0fdHYF_1.jpg?max_age=2592000');
INSERT INTO `songList` (`id`, `songName`, `path`, `photo`) VALUES (3, '成全', 'http://s5jm2durk.hn-bkt.clouddn.com/%E6%88%90%E5%85%A8%EF%BC%88Live%EF%BC%89-%E6%9E%97%E5%AE%A5%E5%98%89.mp3', 'https://i.kfs.io/album/global/36160387,1v1/fit/500x500.jpg');
INSERT INTO `songList` (`id`, `songName`, `path`, `photo`) VALUES (4, '阿拉斯加海湾', 'http://s5jm2durk.hn-bkt.clouddn.com/%E8%93%9D%E5%BF%83%E7%BE%BD%20-%20%E9%98%BF%E6%8B%89%E6%96%AF%E5%8A%A0%E6%B5%B7%E6%B9%BE.mp3', '//y.qq.com/music/photo_new/T002R300x300M000003QU3EZ3Sfm6B_1.jpg?max_age=2592000');
INSERT INTO `songList` (`id`, `songName`, `path`, `photo`) VALUES (5, '追梦赤子心', 'http://s5jm2durk.hn-bkt.clouddn.com/%E8%BF%BD%E6%A2%A6%E8%B5%A4%E5%AD%90%E5%BF%83%20-%20GALA.mp3', '//y.qq.com/music/photo_new/T002R300x300M000003uDUds09qQHp_2.jpg?max_age=2592000');
INSERT INTO `songList` (`id`, `songName`, `path`, `photo`) VALUES (6, '年少有为', 'http://s5jm2durk.hn-bkt.clouddn.com/%E5%B9%B4%E5%B0%91%E6%9C%89%E4%B8%BA%20-%20%E6%9D%8E%E8%8D%A3%E6%B5%A9.mp3', '//y.qq.com/music/photo_new/T002R300x300M000004QnEHc3zjC7J_1.jpg?max_age=2592000');
INSERT INTO `songList` (`id`, `songName`, `path`, `photo`) VALUES (7, '七里香', 'http://s5jm2durk.hn-bkt.clouddn.com/%E5%91%A8%E6%9D%B0%E4%BC%A6%20-%20%E4%B8%83%E9%87%8C%E9%A6%99.mp3', '//y.qq.com/music/photo_new/T002R300x300M000003DFRzD192KKD_1.jpg?max_age=2592000');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `avatar` varchar(2048) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `avatar`, `username`, `password`) VALUES (1, 'https://s3.bmp.ovh/imgs/2023/07/05/2fcd345a8539c0e4.jpg', 'a', '$2a$10$ldC1Wxs0rNVIUiKYzQbDj.QTYDTmWsYI1gDLAKfJs3W8IqZ6v2phm');
INSERT INTO `user` (`id`, `avatar`, `username`, `password`) VALUES (2, 'https://s3.bmp.ovh/imgs/2023/07/05/2fcd345a8539c0e4.jpg', 'b', '$2a$10$dTNnd/AZMWsC7B/RVXda5un8.W4TceUcA7U3JVBwpSMrz1uD0LfG2');
INSERT INTO `user` (`id`, `avatar`, `username`, `password`) VALUES (3, 'https://s3.bmp.ovh/imgs/2023/07/05/2fcd345a8539c0e4.jpg', 'c', '$2a$10$vxZ2URG5TiElKbKRo.NFieSwxQ5EQBKzEHyePzHwc8Nbn36rf8hRq');
INSERT INTO `user` (`id`, `avatar`, `username`, `password`) VALUES (4, 'https://s3.bmp.ovh/imgs/2023/07/05/2fcd345a8539c0e4.jpg', 'd', '$2a$10$wdnZKXs/aZMoBu6mQbWPlOirPTfyBmvPy/HIpXZuYXW4ZiqV32Lh2');
INSERT INTO `user` (`id`, `avatar`, `username`, `password`) VALUES (5, 'https://s3.bmp.ovh/imgs/2023/07/05/2fcd345a8539c0e4.jpg', 'x', '$2a$10$HcVJuc/s/OyORDBZ7uTT6OcfYxKTiSdEkLfReOan/k.Cnz60zgpAu');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
