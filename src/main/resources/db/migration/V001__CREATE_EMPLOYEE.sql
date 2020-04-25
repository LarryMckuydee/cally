DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `level` tinyint(4) unsigned DEFAULT 0,
    PRIMARY KEY (`id`),
    UNIQUE KEY `employees_email_unique` (`email`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;