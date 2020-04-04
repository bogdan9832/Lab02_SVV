package ro.lab2svv;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ro.lab2svv.domain.Student;
import ro.lab2svv.domain.Tema;
import ro.lab2svv.validation.StudentValidator;
import ro.lab2svv.validation.TemaValidator;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAddStudentMethod(){
        ro.lab2svv.repository.StudentRepository repo = new ro.lab2svv.repository.StudentRepository(new StudentValidator());
        repo.save(new Student("1","Nume",932));
        assertNotNull(repo.findOne("1"));


    }
    @Test
    public void test2AddStudentMethod(){
        ro.lab2svv.repository.StudentRepository repo = new ro.lab2svv.repository.StudentRepository(new StudentValidator());
        assertTrue(repo.save(new Student("1", "Nume", 932)) != null);
        assertTrue(repo.save(new Student("1", "Nume", 932)) == null);
    }



    @Test
    public void shouldBeOnlyOneFalse(){
        ro.lab2svv.repository.StudentRepository repo = new ro.lab2svv.repository.StudentRepository(new StudentValidator());
        assertTrue(repo.save(new Student("1", "Nume", 932)) != null);
        assertTrue(repo.save(new Student("1", "Nume", 932)) == null);
    }
    @Test
    public void shouldBeOnlyOneTrue(){
        ro.lab2svv.repository.StudentRepository repo = new ro.lab2svv.repository.StudentRepository(new StudentValidator());
        assertTrue(repo.save(new Student("1", "Nume", 932)) != null);
        assertTrue(repo.save(new Student("2", "Nume", 932)) != null);
    }
    @Test
    public void shouldHaveIdTrue(){
        ro.lab2svv.repository.StudentRepository repo = new ro.lab2svv.repository.StudentRepository(new StudentValidator());
        assertTrue(repo.save(new Student("1", "Nume", 932)) != null);

    }
    @Test
    public void shouldHaveIdFalse(){
        ro.lab2svv.repository.StudentRepository repo = new ro.lab2svv.repository.StudentRepository(new StudentValidator());
        assertTrue(repo.save(new Student(null, "Nume", 932)) == null);
    }
    @Test
    public void shouldHaveNameTrue(){
        ro.lab2svv.repository.StudentRepository repo = new ro.lab2svv.repository.StudentRepository(new StudentValidator());
        assertTrue(repo.save(new Student("1", "Name", 932)) != null);
    }
    @Test
    public void shouldHaveNameFalse(){
        ro.lab2svv.repository.StudentRepository repo = new ro.lab2svv.repository.StudentRepository(new StudentValidator());
        assertTrue(repo.save(new Student("1", null, 932)) == null);
    }
    @Test
    public void shouldHaveGroupTrue(){
        ro.lab2svv.repository.StudentRepository repo = new ro.lab2svv.repository.StudentRepository(new StudentValidator());
        assertTrue(repo.save(new Student("1", "Name", 932)) != null);

    }
    @Test
    public void shouldHaveGroupFalse(){
        ro.lab2svv.repository.StudentRepository repo = new ro.lab2svv.repository.StudentRepository(new StudentValidator());
        assertTrue(repo.save(new Student("1", "Name", -1)) == null);
    }


    @Test
    public void testAddAssignmentMethod(){
        ro.lab2svv.repository.TemaRepository repo = new ro.lab2svv.repository.TemaRepository(new TemaValidator());
        repo.save(new Tema("1","Description", 6, 2));
        assertNotNull(repo.findOne("1"));
    }

    @Test
    public void test2AddAssignmentMethod(){
        ro.lab2svv.repository.TemaRepository repo = new ro.lab2svv.repository.TemaRepository(new TemaValidator());
        try {
            repo.save(new Tema("1", "Description", 6, 2));
            repo.save(new Tema("1", "Description", 6, 2));
            assertTrue(false);
        }catch (Exception e){
            assertTrue(true);
        }
    }
}
