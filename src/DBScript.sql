CREATE TABLE Students (
  student_id INT PRIMARY KEY,
  name VARCHAR(50),
  age INT,
  class_id INT,
  FOREIGN KEY (class_id) REFERENCES Classes(class_id)
);

CREATE TABLE Teachers (
  teacher_id INT PRIMARY KEY,
  name VARCHAR(50),
  age int
);

CREATE TABLE Classes (
  class_id INT PRIMARY KEY,
  name VARCHAR(50),
  teacher_id INT,
  school_id INT,
  FOREIGN KEY (teacher_id) REFERENCES Teachers(teacher_id),
  FOREIGN KEY (school_id) REFERENCES Schools(school_id)
);

CREATE TABLE Schools (
  school_id INT PRIMARY KEY,
  name VARCHAR(50)
);

INSERT INTO Schools (school_id, name) VALUES (1, 'HN');
INSERT INTO Schools (school_id, name) VALUES (2, 'BG');
INSERT INTO Schools (school_id, name) VALUES (3, 'BN');
INSERT INTO Schools (school_id, name) VALUES (4, 'NA');

INSERT INTO Teachers (teacher_id, name, age) VALUES (1, 'a', 10);
INSERT INTO Teachers (teacher_id, name, age) VALUES (2, 'b', 20);
INSERT INTO Teachers (teacher_id, name, age) VALUES (3, 'c', 30);
INSERT INTO Teachers (teacher_id, name, age) VALUES (4, 'd', 40);

INSERT INTO Classes (class_id, name, teacher_id, school_id) VALUES (1, 'Class 1', 1, 1);
INSERT INTO Classes (class_id, name, teacher_id, school_id) VALUES (2, 'Class 2', 2, 2);
INSERT INTO Classes (class_id, name, teacher_id, school_id) VALUES (3, 'Class 3', 2, 3);
INSERT INTO Classes (class_id, name, teacher_id, school_id) VALUES (4, 'Class 4', 2, 4);

INSERT INTO Students (student_id, name, age, class_id) VALUES (1, 'Student 1', 15, 1);
INSERT INTO Students (student_id, name, age, class_id) VALUES (2, 'Student 2', 16, 2);
INSERT INTO Students (student_id, name, age, class_id) VALUES (3, 'Student 3', 17, 3);
INSERT INTO Students (student_id, name, age, class_id) VALUES (4, 'Student 4', 18, 4);

DELETE FROM Students WHERE student_id = 1;
DELETE FROM Teachers WHERE teacher_id = 1;
DELETE FROM Classes WHERE class_id = 1;
DELETE FROM Schools WHERE school_id = 1;

show databases;
show schemas;
select * from students;
select * from teachers;
select * from classes;
select * from schools;

