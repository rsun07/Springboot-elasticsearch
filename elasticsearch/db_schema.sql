CREATE TABLE `blog` (
  `author` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` text(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`title`),
  KEY `index_author_name` (`author`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
