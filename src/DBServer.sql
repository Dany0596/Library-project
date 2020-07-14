-- Books
DROP TABLE IF EXISTS Books CASCADE;
CREATE TABLE Books(
	title VARCHAR(100) NOT NULL,
	authors VARCHAR (100),
	house VARCHAR(30),
	year INTEGER,
	ISBN VARCHAR(13),
	genre VARCHAR(30) ,
	price NUMERIC(4,2),
	copies INTEGER,
	description VARCHAR(3000),
	bookPoint INTEGER,
	insertDate DATE,
	
	PRIMARY KEY(ISBN)
);

-- Users
DROP TABLE IF EXISTS USERS CASCADE;
CREATE TABLE USERS(
	name VARCHAR(30) NOT NULL,
	surname VARCHAR(30) NOT NULL,
	address VARCHAR(60) NOT NULL,
	cap INTEGER,
	city VARCHAR(30) NOT NULL,
	country VARCHAR(30),
	telephone VARCHAR(13) NOT NULL,
	email VARCHAR(40) NOT NULL,
	password VARCHAR(30),
	libroCard INTEGER,
	bookPoints INTEGER,
	releaseDate DATE DEFAULT CURRENT_DATE,
	master BOOLEAN DEFAULT FALSE,
	
	
	PRIMARY KEY(email)
);
-- Orders
DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders(
	code INTEGER UNIQUE NOT NULL,
	order_day DATE DEFAULT CURRENT_DATE, 
	books VARCHAR(30000),
	email VARCHAR(40),
	bill NUMERIC(5,2) NOT NULL,
	payment_metod VARCHAR(30) DEFAULT 'paypal',
	address VARCHAR(100),
	orderState VARCHAR (60) DEFAULT 'Processing',
	points INTEGER,
	
	PRIMARY KEY (code)
);

DROP TABLE IF EXISTS RANK;
CREATE TABLE RANK(
  ISBN VARCHAR(13) NOT NULL UNIQUE,
  position INTEGER NOT NULL,
  positionDate DATE DEFAULT CURRENT_DATE,
  
  FOREIGN KEY (ISBN) REFERENCES BOOKS(ISBN),
  PRIMARY KEY (ISBN)
);
	  
INSERT INTO USERS (name,surname,address,cap,city,country,telephone,email,password,librocard,bookpoints,releaseDate,master)
VALUES('Daniele','Vencato','Via Edmondo de Amicis 43', 36031, 'Dueville','Italia', '3488030623', 'danielevencato96@gmail.com', 'daniele',0,0,'10/10/2019',TRUE),
('Daniele','Vencato','Via Edmondo de Amicis 43', 36031, 'Dueville','Italia', '3488030623', 'danielevencato@gmail.com', 'daniele',1,25,'10/10/2019',FALSE),
('Admin','Admin','Admin' , 0, 'Admin','Admin', 'Admin', 'admin', 'admin',0,0,'20/10/2010',TRUE),
('Fabio','Tarocco','Via XXIV Maggio 59' , 37057, 'San Giovanni Lupatoto','Italia', '3471840371', 'fabio.tarocco.vr@gmail.com', '123456',99999,95,'18/02/2020',FALSE),
('Asdrubale','Sorrentino','Via Vesuvio 15',	80143,'Napoli','Italia','3666666621','asdrubaleUbell@gmail.com','123',123458,51,'01/06/2020',FALSE);


INSERT INTO ORDERS(code,order_day,books,email,bill,payment_metod,address,orderState,points)
VALUES(123435676,'10/05/2020','[Harry Potter and the Goblet of Fire]','fabio.tarocco.vr@gmail.com',18.00,'paypal','Via XXIV Maggio 59, 37057, San Giovanni Lupatoto,Italia','Delivered',30),
	(124526527,'15/03/2019','[The Very Hungry Caterpillar],[Thirteen Reasons Why]','fabio.tarocco.vr@gmail.com',20.50,'paypal','Via XXIV Maggio 59, 37057, San Giovanni Lupatoto,Italia','Delivered',52),
	(1232121567,'01/06/2020','[The Subtle Art of Not Giving a F*ck]','fabio.tarocco.vr@gmail.com',15.99,'paypal','Via XXIV Maggio 59, 37057, San Giovanni Lupatoto,Italia','Processing',13),
	(166635314,'31/05/2020','[American Gods]','asdrubaleUbell@gmail.com',15.00,'paypal','Via Vesuvio 15 80143, Napoli, Italia','Processing',17),
	(166610255,'02/06/2020','[World of Warcraft]','asdrubaleUbell@gmail.com',29.99,'paypal','Via Vesuvio 15 80143, Napoli, Italia','Processing',34),
	(166410284,'02/02/2020','[Girl Who Kicked the Hornets'' Nest,The Millennium Trilogy]','marietto96@gmail.com',8.99,'cachet','Via Verdi 43,36100, Vicenza, Italia','Delivered',13),
	(145132677,'25/04/2020','[The Great Influenza: The Story of the Deadliest Pandemic in History], [The Mamba Mentality: How I Play], [Pandemic 1918: Eyewitness Accounts from the Greatest Medical Holocaust in Modern History]','mariaMeNego@gmail.com',50.97,'Credit Card', 'Via Giuseppe Garibaldi 12, 10122, Torino, Italia', 'In transit',64);

INSERT INTO BOOKS (title,authors,house,year,isbn,genre,price,copies,description,bookpoint,insertdate)
VALUES ('Numeri intelligenti','Nick Polson, James Scott', 'UTET', 2018, '9788851167820','Science',23.00,13,'L’Intelligenza Artificiale non appartiene più a un futuro fantascientifico: è già qui, e sta cambiando il mondo uno smartphone alla volta.',40,'23/08/2018');
INSERT INTO BOOKS (title,authors,house,year,ISBN,genre,price,copies,description,bookPoint,insertDate)
VALUES('Da vinci Code','Brown Dan','Transworld Grp', 2003, '9780552150736', 'Crime, Thriller & Adventure',8.00, 50, 'The book contains several ambigrams created by real-life typographer John Langdon.[1] Besides the "Angels & Demons" and "Illuminati" designs, the title of the book is also presented as an ambigram on the hardcover book jacket',10,'04/03/2020'),
    ('Harry Potter and the Goblet of Fire','Rowling, J. K.','Bloomsbury Grp', 2002, '9780747546245', 'For Kids',18.00, 10, 'The Triwizard Tournament is to be held at Hogwarts. Only wizards who are over seventeen are allowed to enter - but that doesn t stop Harry dreaming that he will win the competition. ',30,'14/10/2019'),
    ('Thirteen Reasons Why','Jay Asher','razor bill', 2007, '9781595141712', 'Storytelling',14.00, 6, 'When high school student Clay Jenkins receives a box in the mail containing thirteen cassette tapes recorded by his classmate Hannah, who committed suicide, he spends a bewildering and heartbreaking night crisscrossing their town, listening to Hannah s voice recounting the events leading up to her death.',35,'24/12/2019'),
    ('Boy in the Striped Pyjamas','Boyne, John','Definitions', 2007, '9780099487821', 'Fiction',7.00, 5, 'Shmuel lives in a strange parallel existence on the other side of the adjoining wire fence, where everyone wears a uniform of striped pyjamas.Despite the wire fence separating them, the two boys become best friends. ',52, '17/01/2020'),
    ('The Very Hungry Caterpillar','Carle, Eric','Puffin Books', 1994, '9780241003008', 'Learning',6.50, 18, 'A big board book edition of Eric Carle s classic, The Very Hungry Caterpillar.',17,'12/01/2020'),
    ('American Gods','Neil Gaiman','Mondadori', 2001, '9788804672371', 'Fantasy',15.00, 5, 'A big board book edition of Eric Carle s classic, The Very Hungry Caterpillar.',17,'12/12/2019'),
	('New Moon','Meyer, Stephenie','ATOM',2007,'9781904233886','Young Adult Fiction',7.99,6,'The new moon is the phase that is invisible to us here on Earth because the moon is between the earth and the sun, and its illuminated side is facing away from us. The new moon marks the beginning of the lunar cycle, the movement of the moon through its different phases.',12,'05/05/2020'),
	('Girl Who Kicked the Hornets'' Nest,The Millennium Trilogy','Larsson, Stieg','Quercus Publishing Plc',2010,'9781849162746','Crime, Thriller & Adventure',8.99,24,'Lisbeth Salander - the heart of Larsson''s two previous novels - lies in critical condition, a bullet wound to her head, in the intensive care unit of a Swedish city hospital. She''s fighting for her life in more ways than one: if and when she recovers, she''ll be taken back to Stockholm to stand trial for three murders.',13,'10/03/2020'),
	('Becoming','Michelle Obama','Crown Publishing Group',2018,'9781524763138','Biography',11.90,14,'Michelle Robinson Obama served as First Lady of the United States from 2009 to 2017. A graduate of Princeton University and Harvard Law School, Mrs. Obama started her career as an attorney at the Chicago law firm Sidley & Austin, where she met her future husband, Barack Obama. She later worked in the Chicago mayor’s office, at the University of Chicago, and at the University of Chicago Medical Center. Mrs. Obama also founded the Chicago chapter of Public Allies, an organization that prepares young people for careers in public service.',20,'25/12/2019'),
	('The Mamba Mentality: How I Play',' Kobe Bryant','MCD',2018,'9780374201234','Biography',18.99,23,'Kobe Bryant (1978-2020) was one of the most accomplished and celebrated athletes of all time. Over the course of his twenty-year career―all played with the Los Angeles Lakers―he won five NBA championships, two Olympic gold medals, eighteen All-Star selections, and four All-Star Game MVP awards, among many other achievements before retiring in 2016.In 2018, Bryant won the Academy Award for Best Animated Short Film as writer of Dear Basketball, which he also narrated. He was the first African American to win the award as well as the first former professional athlete to be nominated and win an Oscar in any category.As a philanthropist, Bryant founded the Kobe & Vanessa Bryant Family Foundation (KVBFF) and the Kobe Bryant China Fund, organizations dedicated to providing resources for educational, social, and sports programs to improve the lives of children and families in need, and encourage cultural exchanges between Chinese and U. S. middle school children. He was also an official ambassador for After-School All-Stars (ASAS), a nonprofit organization that offers after-school programs to low-income children in more than a dozen U. S. cities.',36,'21/12/2019'),
	('World of Warcraft: Chronicle Volume 1','BLIZZARD ENTERTAINMENT','Dark Horse Books',2016,'9781616558451','Fantasy',29.99,14,'A journey through an age of myth and legend, long before the Horde and the Alliance. This definitive tome reveals untold stories about the birth of the cosmos, the rise of ancient empires, and the forces that shaped Azeroth.',34,'01/01/2020'),
	('The Great Influenza: The Story of the Deadliest Pandemic in History','John M. Barry','Penguin Books',2005,'9780143036494','Storytelling',14.99,19,'Barry will teach you almost everything you need to know about one of the deadliest outbreaks in human history',11,'05/03/2020'),
	('Pandemic 1918: Eyewitness Accounts from the Greatest Medical Holocaust in Modern History','Catharine Arnold','St. Martin''s Griffin',2020,'978125078445','Storytelling & Historic',16.99,35,'In January 1918, as World War I raged on, a new and terrifying virus began to spread across the globe. In three successive waves, from 1918 to 1919, influenza killed more than 50 million people. German soldiers termed it Blitzkatarrh, British soldiers referred to it as Flanders Grippe, but world-wide, the pandemic gained the notorious title of “Spanish Flu”. Nowhere on earth escaped: the United States recorded 550,000 deaths (five times its total military fatalities in the war) while European deaths totaled over two million.',15,'15/05/2020'),
	('The Subtle Art of Not Giving a F*ck: A Counterintuitive Approach to Living a Good Life','Mark Manson','Harper',2016,'9780062457714','StoryTelling & learning',15.99,10,'In this generation-defining self-help guide, a superstar blogger cuts through the crap to show us how to stop trying to be "positive" all the time so that we can truly become better, happier people.',13,'30/12/2019');
	
	INSERT INTO RANK (ISBN, position, positionDate)
	VALUES ('978125078445',1,'06/01/2020'),
      ('9780552150736',2,'08/02/2020'),
      ('9781904233886',3,'16/05/2020'),
      ('9781849162746',4,'12/04/2020'),
      ('9780143036494',5,'08/03/2020'),
      ('9788851167820',6,'03/02/2020'),
      ('9780747546245',7,'06/06/2020'),
      ('9781595141712',8,'24/04/2020'),
      ('9780099487821',9,'28/02/2020'),
      ('9780241003008',10,'10/05/2020'),
      ('9788804672371',11,'14/06/2020'),
      ('9781524763138',12,'24/03/2020'),
      ('9780374201234',13,'25/05/2020'),
      ('9781616558451',14,'05/05/2020'),
      ('9780062457714',15,'12/06/2020');