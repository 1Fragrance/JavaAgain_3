CREATE TABLE IF NOT EXISTS `payment` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  value INT NOT NULL,
  creditCode VARCHAR(255) NOT NULL,
  createDate DATE NOT NULL
);

-- test data
 insert into payment(value, creditCode, createDate)
 values
 (111, "creditCode_1", now()),
 (222, "creditCode_2", now()),
 (333, "creditCode_3", now()),
 (444, "creditCode_4", now())
