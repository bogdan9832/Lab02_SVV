package ro.lab2svv.validation;

public interface Validator<E> {
    void validate(E entity) throws ValidationException;
}