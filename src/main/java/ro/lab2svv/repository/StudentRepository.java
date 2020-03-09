package ro.lab2svv.repository;


import ro.lab2svv.domain.Student;
import ro.lab2svv.validation.Validator;

public class StudentRepository extends AbstractCRUDRepository<String, Student> {
    public StudentRepository(Validator<Student> validator) {
        super(validator);
    }
}

