LIST_STUDENTS {
    SELECT * FROM student;
}

ADD_STUDENT {
    INSERT INTO student 
    (id, name, cgpa) VALUES(?, ?, ?);
}
