INSERT INTO users (username, password, role) VALUES
                                                 ('admin', '$2a$10$hashedpasswordhere', 'ADMIN'),
                                                 ('operator1', '$2a$10$hashedpasswordhere', 'OPERATOR');

INSERT INTO units (name, type, status, latitude, longitude) VALUES
                                                                ('Tank A', 'Tank', 'ACTIVE', 50.0647, 19.9450),
                                                                ('Transporter B', 'Transporter', 'IN_MOTION', 50.0670, 19.9500);

INSERT INTO missions (name, description, start_date, end_date, status, unit_id) VALUES
    ('Operation Alpha', 'Secure area Alpha', '2025-06-20 08:00:00', '2025-06-20 18:00:00', 'PLANNED', 1);

INSERT INTO location_logs (unit_id, timestamp, latitude, longitude) VALUES
                                                                        (1, '2025-06-19 10:00:00', 50.0647, 19.9450),
                                                                        (1, '2025-06-19 12:00:00', 50.0650, 19.9460),
                                                                        (2, '2025-06-19 10:00:00', 50.0670, 19.9500);
