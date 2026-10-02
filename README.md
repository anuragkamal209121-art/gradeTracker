# Grade Tracker

A Java-based console application for managing student grades.

## Features

- Add Student
- View Student
- Calculate Result
- View All Students
- Average Score
- Highest Score
- Lowest Score
- Update Student Marks
- Delete Student
- Search Student
- Sort Students by Percentage
## Subjects

The project manages marks for five subjects:

- Java
- DBMS
- DSA
- Operating System
- Computer Networks

Each subject is evaluated out of 100 marks.

## Grade System

| Percentage | Grade |
|---|---|
| 90 - 100 | A+ |
| 80 - 89 | A |
| 70 - 79 | B |
| 60 - 69 | C |
| 50 - 59 | D |
| Below 50 | F |

## Technologies Used

- Java
- ArrayList
- Scanner
- File Handling
- Object-Oriented Programming
- Bubble Sort

## Data Storage

Student data is stored in:

`students.txt`

The application automatically loads previously saved student data when it starts.

## Validation

The application checks:

- Student ID must be positive.
- Duplicate Student IDs are not allowed.
- Student name cannot be empty.
- Marks must be between 0 and 100.
- Invalid menu input is handled.

## Future Improvements

- Add MySQL database
- Add GUI
- Add login system
- Add more subjects
- Export results to CSV/PDF
- Add student ranking
- Improve search functionality

## Author

**Anurag Kamal**

BTech CSE Student