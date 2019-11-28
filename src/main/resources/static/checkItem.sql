-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.56-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 coaching.checkitemdetail 结构
DROP TABLE IF EXISTS `checkitemdetail`;
CREATE TABLE IF NOT EXISTS `checkitemdetail` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `material_in_id` int(5) DEFAULT NULL COMMENT '入仓Id',
  `check_result` int(5) DEFAULT NULL COMMENT '检测结果',
  `appearance` int(5) DEFAULT NULL COMMENT '外观',
  `smell` int(5) DEFAULT NULL COMMENT '气味',
  `color_and_lustre` int(5) DEFAULT NULL COMMENT '色泽',
  `PH_value` int(5) DEFAULT NULL COMMENT 'PH值',
  `PH_reference_min` int(5) DEFAULT NULL COMMENT 'PH最小参考值',
  `PH_reference_max` int(5) DEFAULT NULL COMMENT 'PH最大参考值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
