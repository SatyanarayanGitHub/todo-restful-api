INSERT INTO TBL_EMPLOYEES (first_name, last_name, email) VALUES
  ('Lokesh', 'Gupta', 'lokesh@gmail.com'),
  ('Nikhil', 'Patel', 'nikhil@gmail.com'),
  ('Rahul', 'Jain', 'rahul@gmail.com');
  
  INSERT INTO TBL_TODO (user_name, description, target_date, is_done) VALUES
  	('satya','Learn Node JS', now() + interval 4 day, 0),
  	('satya','Explore South India', now() + interval 6 day, 0),
  	('satya','Update Angular 8 knowledge', now(), 0),
  	('satya','Learn Spring Cloud', '2020-01-22 05:30:00', 1),
  	('satya','Learn Spring JPA Data', now() + interval 7 day, 0),
  	('satya','Learn AWS', now() + interval 15 day, 1),
  	('satya','Learn Phyton', '2020-01-20 05:30:00', 0),
  	('satya','Learn Tomcat', now(), 0),
  	('satya','Learn Node JS', now(), 0),
  	('satya','Learn React JS', now(), 0),
  	('satya','Learn Vue JS', now() + interval 5 day, 0),
  	('satya','Learn Maven', now(), 0),
  	('satya','Learn Spring Cloud', now(), 0),
  	('satya','Learn Spring mircoservice', now(), 0),
  	('satya','Learn Docker', now(), 0),
  	('admin','Admin Task-1', now(), 0),
  	('admin','Admin Task-2', now(), 1);