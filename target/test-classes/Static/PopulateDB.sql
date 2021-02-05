-- Valores para poblar la Base de datos, en el orden que debe ejecutarse luego de haber creado las tablas y que estén vacías
-- Opportunitty y Contact se crean al convertir un Lead, es recomendable hacerlo al ejecutar el programa para que las FK se coloquen correctamente

-- Primero 4 Sales Representatives
INSERT INTO sales_rep(name) VALUES
("Xabier García de Vicuña"),
("Victor Cardozo"),
("Arnoldo Labarquilla"),
("Dinis Oliveira");
-- Verificar que los IDs sean del 1 al 4 antes de continuar

-- Dos series de 10 Leads
INSERT INTO leadd(name, email, phone_number, company_name, sales_rep_id) VALUES
("Walter Ryan", "walter.ryan@example.com", "(624)-559-3256", "Campbell Co.", 1),
("Harold Hale", "harold.hale@example.com", "(857)-904-8150", "Sandy Lake Rd", 2),
("Claudia Wallace", "claudia.wallace@example.com", "(574)-477-3851", "Campbell Ave", 1),
("Toni Curtis", "toni.curtis@example.com", "(606)-560-4542", "Campbell Co.", 3),
("Ramon Daniels", "ramon.daniels@example.com", "(130)-161-3768", "Gray Ltd", 1),
("Clara Butler", "clara.butler@example.com", "(393)-250-8044", "Green Rd", 2),
("Claire Smith", "claire.smith@example.com", "(293)-871-5306", "Campbell Co.", 4),
("Sonia Torres", "sonia.torres@example.com", "(662)-293-6891", "Stelling", 1),
("Stelling Rd", "jerry.cruz@example.com", "(613)-673-0983", "Ash Campbell", 4),
("Eleanor Bates", "eleanor.bates@example.com", "(795)-841-0657", "Mcgowen Co.", 4);

INSERT INTO leadd(name, email, phone_number, company_name, sales_rep_id) VALUES
("Sherri Alexander", "sherri.alexander@example.com", "(396)-198-9017", "Saddle", 4),
("Louise Griffin", "louise.griffin@example.com", "(022)-051-8291", "Lovers Inn", 1),
("Ivan Mckinney", "ivan.mckinney@example.com", "(345)-787-6654", "Valley View", 2),
("Eileen Porter", "eileen.porter@example.com", "(368)-672-1067", "Mcgowen Co.", 3),
("Samantha Wade", "samantha.wade@example.com", "(281)-911-5608", "Campbell Soups", 1),
("Joann Holland", "joann.holland@example.com", "(977)-403-2576", "Railroad Spa", 1),
("Clinton Hoffman", "clinton.hoffman@example.com", "(120)-588-1401", "Railroad Spa", 1),
("Hunter Hamilton", "hunter.hamilton@example.com", "(987)-033-4227", "Homestead", 3),
("Jerome Payne", "jerome.payne@example.com", "(601)-356-8509", "Lovers Inn", 3),
("Sheila Ruiz", "sheila.ruiz@example.com", "(800)-059-2440", "Campbell Co.", 4);

-- Por último 8 Accounts
-- Industry: (PRODUCE, ECOMMERCE, MANUFACTURING, MEDICAL, OTHER)
INSERT INTO account(city, country, employee_count, industry) VALUES
("San Diego","USA", 160,"ECOMMERCE"),
("Ontario","Canada", 380,"MANUFACTURING"),
("Mexico D.F.","Mexico", 75,"PRODUCE"),
("Lisbon","Portugal", 450,"ECOMMERCE"),
("Oporto","Portugal", 120,"MEDICAL"),
("Bordeaux","France", 230,"MANUFACTURING"),
("Barcelona","Spain", 780,"OTHER"),
("Madrid","Spain", 935,"MEDICAL");
