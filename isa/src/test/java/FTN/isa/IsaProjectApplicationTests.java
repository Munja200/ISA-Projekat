package FTN.isa;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;

import FTN.isa.model.Address;
import FTN.isa.model.Appointment;
import FTN.isa.model.Center;
import FTN.isa.model.RegisteredUser;
import FTN.isa.repository.RegisteredUserRepository;
import FTN.isa.service.AppointmentService;


@RunWith(SpringRunner.class)
@SpringBootTest
class IsaProjectApplicationTests {
	    @Autowired
		private AppointmentService productService;

	    @Autowired
		private RegisteredUserRepository userService;


	    @Before
		public void setUp() throws Exception {
	    	productService.save(new Appointment(0, new Date(2023,1,29,11,30), new Date(2023,1,29,11,0), true, "", null,
	    			new Center(0,"Novi Centar", new Address(), "dobar centar", 10,false)));
	    	///Person person = userService.getByUsername("rade@gmail.com");
	    	///person.setEmail("rad@gmail.com");
	    	///person.setPassword("123");
	    	///person.setName("Neko");
	    	///person.setSurname("Niko");
	    	///person.setUsername("rad@gmail.com");
	    	///userService.save(new RegisteredUser(0,false, person));
	    	///Person person1 = new Person();
	    	///person1.setEmail("ivo@gmail.com");
	    	///person1.setPassword("123");
	    	///person1.setName("Ivek");
	    	///person1.setSurname("Ivic");
	    	///person.setUsername("ivo@gmail.com");
	    	///userService.save(new RegisteredUser(0,false, person1));
	    }


		@Test
		public void testOptimisticLocking() throws Throwable {	

			ExecutorService executor = Executors.newFixedThreadPool(2);
			Future<?> future1 = executor.submit(new Runnable() {

				@Override
				public void run() {
			        System.out.println("Startovan Thread 1");
					Appointment productToUpdate = productService.findById(1);
				    System.out.println(productToUpdate.getVersion() + "  Ovo je verzija u tredu");

					RegisteredUser user = userService.getByUsername("rade@gmail.com");

					productToUpdate.setUser(user);
					try { Thread.sleep(3000); } catch (InterruptedException e) {}
					assertThrows(ObjectOptimisticLockingFailureException.class, () -> {
							productService.setAppointmentForUser(productToUpdate, user.getPerson().getUsername());
				        });

				}
			});
			executor.submit(new Runnable() {

				@Override
				public void run() {
			        System.out.println("Startovan Thread 2");
			        Appointment productToUpdate = productService.findById(1);
			        System.out.println(productToUpdate.getVersion() + "  Ovo je verzija u tredu 2");
					RegisteredUser user = userService.getByUsername("ivan@gmail.com");
					productToUpdate.setUser(user);

					productService.setAppointmentForUser(productToUpdate, user.getPerson().getUsername());
					}
			});
			try {
			    future1.get(); 
			} catch (ExecutionException e) {
			    System.out.println("Exception from thread " + e.getCause().getClass()); 
			    throw e.getCause();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			executor.shutdown();

		}
}
