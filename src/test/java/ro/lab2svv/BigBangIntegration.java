package ro.lab2svv;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import ro.lab2svv.domain.Student;
import ro.lab2svv.domain.Tema;
import ro.lab2svv.domain.Nota;
import ro.lab2svv.domain.Pair;
import ro.lab2svv.validation.StudentValidator;
import ro.lab2svv.validation.TemaValidator;
import ro.lab2svv.validation.NotaValidator;


/**
 * Unit test for simple App.
 */
public class BigBangIntegration
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void addStudent(){
        ro.lab2svv.repository.StudentRepository repo = new ro.lab2svv.repository.StudentRepository(new StudentValidator());
        repo.save(new Student("1","Nume",932));
        assertNotNull(repo.findOne("1"));
    }
    @Test
    public void addAssignment(){
        ro.lab2svv.repository.TemaRepository repo = new ro.lab2svv.repository.TemaRepository(new TemaValidator());

        assertTrue(repo.save(new Tema("1", "Description", 6, 2)) != null);
        assertTrue(repo.save(new Tema("1", "Description", 6, 2)) == null);
    }
    @Test
    public void addGrade(){
        ro.lab2svv.repository.NotaRepository repo = new ro.lab2svv.repository.NotaRepository(new NotaValidator());
        assertTrue(repo.save(new Nota(new Pair<String, String>("1","1"), 10, 5, "")) != null);
        assertTrue(repo.save(new Nota(new Pair<String, String>("1","1"), 10, 5, "")) == null);

    }
    @Test
    public void integrateAll(){
        ro.lab2svv.repository.StudentRepository studentRepo = new ro.lab2svv.repository.StudentRepository(new StudentValidator());
        ro.lab2svv.repository.TemaRepository temaRepo = new ro.lab2svv.repository.TemaRepository(new TemaValidator());
        ro.lab2svv.repository.NotaRepository notaRepo = new ro.lab2svv.repository.NotaRepository(new NotaValidator());

        studentRepo.save(new Student("1","Nume",932));
        assertNotNull(studentRepo.findOne("1"));
        assertTrue(temaRepo.save(new Tema("1", "Description", 6, 2)) != null);
        assertTrue(temaRepo.save(new Tema("1", "Description", 6, 2)) == null);
        assertTrue(notaRepo.save(new Nota(new Pair<String, String>("1","1"), 10, 5, "")) != null);
        assertTrue(notaRepo.save(new Nota(new Pair<String, String>("1","1"), 10, 5, "")) == null);

    }



}
