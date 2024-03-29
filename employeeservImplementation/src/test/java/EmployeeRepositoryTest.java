
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.paypal.bfs.test.employeeserv.api.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
 
@RunWith(SpringRunner.class)
@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
@AutoConfigureTestDatabase
//@DataJpaTest
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = EmployeeRepository.class)
public class EmployeeRepositoryTest 
{
    @Autowired
    EmployeeRepository repository;
    

    
    @Test
    public void testRepository() 
    {
        
        Employee emp = new Employee();
    	Address a = new Address();
    	a.setLine1("4338 Meadow mills road);
    	a.setCity("Owings Mills");
    	a.setCountry("USA");
    	a.setState("MD");
    	a.setZipcode("21117");
    	emp.setAddress(a);
    	emp.setId(123l);
    	emp.setFirstName("Ash");
    	emp.setLastName("S");    	 
    	emp.setBirthDate(new Date(1995, 01, 18));
       
         
        repository.save(emp);
         
        Assert.assertNotNull(emp.getId());
    }
}