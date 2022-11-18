package FTN.isa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import FTN.isa.model.RegisteredUser;

public interface IRegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {

	
}
