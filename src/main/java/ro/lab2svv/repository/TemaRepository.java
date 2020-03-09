package ro.lab2svv.repository;

import ro.lab2svv.domain.Tema;
import ro.lab2svv.validation.*;

public class TemaRepository extends AbstractCRUDRepository<String, Tema> {
    public TemaRepository(Validator<Tema> validator) {
        super(validator);
    }
}

