DROP TABLE IF EXISTS discount_slab;

CREATE TABLE discount_slab (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  customer_type ENUM('Regular','Premium') NOT NULL,
  start_range DECIMAL NOT NULL,
  end_range DECIMAL,
  discount DECIMAL
);

INSERT INTO discount_slab (customer_type,start_range, end_range,discount) VALUES
    ('Regular',0, 5000,0),
    ('Regular',5000,10000,10),
    ('Regular',10000,null,20);

INSERT INTO discount_slab (customer_type,start_range, end_range,discount) VALUES
    ('Premium',0, 4000,10),
    ('Premium',4000,8000,15),
    ('Premium',8000,12000,20),
    ('Premium',12000,null,30);