INSERT INTO user (id, name, password, username, email, role_type, gender, address_id)
SELECT 1, 'Admin', 'admin123', 'admin', 'admin@mailinator.com', 1, 2, NULL
    WHERE NOT EXISTS (
  SELECT 1 FROM user WHERE username = 'admin'
);
