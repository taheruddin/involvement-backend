INSERT INTO  sector (id, title, parent_id) VALUES (1, 'ROOT', null);
INSERT INTO  sector (id, title, parent_id) VALUES (2, 'Manufacturing', 1);
INSERT INTO  sector (id, title, parent_id) VALUES (3, 'Other', 1);
INSERT INTO  sector (id, title, parent_id) VALUES (4, 'Service', 1);
-- Manufacturing 2
INSERT INTO  sector (id, title, parent_id) VALUES (5, 'Construction materials', 2);
INSERT INTO  sector (id, title, parent_id) VALUES (6, 'Electronics and Optics', 2);
INSERT INTO  sector (id, title, parent_id) VALUES (7, 'Food and Beverage', 2);
INSERT INTO  sector (id, title, parent_id) VALUES (8, 'Furniture', 2);
INSERT INTO  sector (id, title, parent_id) VALUES (9, 'Machinery', 2);
INSERT INTO  sector (id, title, parent_id) VALUES (10, 'Metalworking', 2);
INSERT INTO  sector (id, title, parent_id) VALUES (11, 'Plastic and Rubber', 2);
INSERT INTO  sector (id, title, parent_id) VALUES (12, 'Printing', 2);
INSERT INTO  sector (id, title, parent_id) VALUES (13, 'Textile and Clothing', 2);
INSERT INTO  sector (id, title, parent_id) VALUES (14, 'Wood', 2);
-- Food and Beverage 7
INSERT INTO  sector (id, title, parent_id) VALUES (15, 'Bakery & confectionery products', 7);
INSERT INTO  sector (id, title, parent_id) VALUES (16, 'Beverages', 7);
INSERT INTO  sector (id, title, parent_id) VALUES (17, 'Fish & fish products', 7);
INSERT INTO  sector (id, title, parent_id) VALUES (18, 'Meat & meat products', 7);
INSERT INTO  sector (id, title, parent_id) VALUES (19, 'Milk & dairy products', 7);
INSERT INTO  sector (id, title, parent_id) VALUES (20, 'Other', 7);
INSERT INTO  sector (id, title, parent_id) VALUES (21, 'Sweets & snack food', 7);
-- Furniture 8
INSERT INTO  sector (id, title, parent_id) VALUES (22, 'Bathroom/sauna', 8);
INSERT INTO  sector (id, title, parent_id) VALUES (23, 'Bedroom', 8);
INSERT INTO  sector (id, title, parent_id) VALUES (24, 'Children’s room', 8);
INSERT INTO  sector (id, title, parent_id) VALUES (25, 'Kitchen', 8);
INSERT INTO  sector (id, title, parent_id) VALUES (26, 'Living room', 8);
INSERT INTO  sector (id, title, parent_id) VALUES (27, 'Office', 8);
INSERT INTO  sector (id, title, parent_id) VALUES (28, 'Other (Furniture)', 8);
INSERT INTO  sector (id, title, parent_id) VALUES (29, 'Outdoor', 8);
INSERT INTO  sector (id, title, parent_id) VALUES (30, 'Project furniture', 8);
-- Machinery 9
INSERT INTO  sector (id, title, parent_id) VALUES (31, 'Machinery components', 9);
INSERT INTO  sector (id, title, parent_id) VALUES (32, 'Machinery equipment/tools', 9);
INSERT INTO  sector (id, title, parent_id) VALUES (33, 'Manufacture of machinery', 9);
INSERT INTO  sector (id, title, parent_id) VALUES (34, 'Maritime', 9);
INSERT INTO  sector (id, title, parent_id) VALUES (35, 'Metal structures', 9);
INSERT INTO  sector (id, title, parent_id) VALUES (36, 'Other', 9);
INSERT INTO  sector (id, title, parent_id) VALUES (37, 'Repair and maintenance service', 9);
--      Maritime 34
INSERT INTO  sector (id, title, parent_id) VALUES (38, 'Aluminium and steel workboats', 34);
INSERT INTO  sector (id, title, parent_id) VALUES (39, 'Boat/Yacht building', 34);
INSERT INTO  sector (id, title, parent_id) VALUES (40, 'Ship repair and conversion', 34);
-- Metalworking 10
INSERT INTO  sector (id, title, parent_id) VALUES (41, 'Construction of metal structures', 10);
INSERT INTO  sector (id, title, parent_id) VALUES (42, 'Houses and buildings', 10);
INSERT INTO  sector (id, title, parent_id) VALUES (43, 'Metal products', 10);
INSERT INTO  sector (id, title, parent_id) VALUES (44, 'Metal works', 10);
--      Metal works 44
INSERT INTO  sector (id, title, parent_id) VALUES (45, 'CNC-machining', 44);
INSERT INTO  sector (id, title, parent_id) VALUES (46, 'Forgings, Fasteners', 44);
INSERT INTO  sector (id, title, parent_id) VALUES (47, 'Gas, Plasma, Laser cutting', 44);
INSERT INTO  sector (id, title, parent_id) VALUES (48, 'MIG, TIG, Aluminum welding', 44);
-- Plastic and Rubber 11
INSERT INTO  sector (id, title, parent_id) VALUES (49, 'Packaging', 11);
INSERT INTO  sector (id, title, parent_id) VALUES (50, 'Plastic goods', 11);
INSERT INTO  sector (id, title, parent_id) VALUES (51, 'Plastic processing technology', 11);
INSERT INTO  sector (id, title, parent_id) VALUES (52, 'Plastic profiles', 11);
--      Plastic processing technology 51
INSERT INTO  sector (id, title, parent_id) VALUES (53, 'Blowing', 51);
INSERT INTO  sector (id, title, parent_id) VALUES (54, 'Moulding', 51);
INSERT INTO  sector (id, title, parent_id) VALUES (55, 'Plastics welding and processing', 51);
-- Printing 12
INSERT INTO  sector (id, title, parent_id) VALUES (56, 'Advertising', 12);
INSERT INTO  sector (id, title, parent_id) VALUES (57, 'Book/Periodicals printing', 12);
INSERT INTO  sector (id, title, parent_id) VALUES (58, 'Labelling and packaging printing', 12);
-- Textile and Clothing 13
INSERT INTO  sector (id, title, parent_id) VALUES (59, 'Clothing', 13);
INSERT INTO  sector (id, title, parent_id) VALUES (60, 'Textile', 13);
-- Wood 14
INSERT INTO  sector (id, title, parent_id) VALUES (61, 'Other (Wood)', 14);
INSERT INTO  sector (id, title, parent_id) VALUES (62, 'Wooden building materials', 14);
INSERT INTO  sector (id, title, parent_id) VALUES (63, 'Wooden houses', 14);
-- Other 3
INSERT INTO  sector (id, title, parent_id) VALUES (64, 'Creative industries', 3);
INSERT INTO  sector (id, title, parent_id) VALUES (65, 'Energy technology', 3);
INSERT INTO  sector (id, title, parent_id) VALUES (66, 'Environment', 3);
-- Service 4
INSERT INTO  sector (id, title, parent_id) VALUES (67, 'Business services', 4);
INSERT INTO  sector (id, title, parent_id) VALUES (68, 'Engineering', 4);
INSERT INTO  sector (id, title, parent_id) VALUES (69, 'Information Technology and Telecommunications', 4);
INSERT INTO  sector (id, title, parent_id) VALUES (70, 'Tourism', 4);
INSERT INTO  sector (id, title, parent_id) VALUES (71, 'Translation services', 4);
INSERT INTO  sector (id, title, parent_id) VALUES (72, 'Transport and Logistics', 4);
--      Information Technology and Telecommunications 69
INSERT INTO  sector (id, title, parent_id) VALUES (73, 'Data processing, Web portals, E-marketing', 69);
INSERT INTO  sector (id, title, parent_id) VALUES (74, 'Programming, Consultancy', 69);
INSERT INTO  sector (id, title, parent_id) VALUES (75, 'Software, Hardware', 69);
INSERT INTO  sector (id, title, parent_id) VALUES (76, 'Telecommunications', 69);
--      Transport and Logistics 72
INSERT INTO  sector (id, title, parent_id) VALUES (77, 'Air', 72);
INSERT INTO  sector (id, title, parent_id) VALUES (78, 'Rail', 72);
INSERT INTO  sector (id, title, parent_id) VALUES (79, 'Road', 72);
INSERT INTO  sector (id, title, parent_id) VALUES (80, 'Water', 72);
--