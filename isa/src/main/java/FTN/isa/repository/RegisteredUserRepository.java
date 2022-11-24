package FTN.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import FTN.isa.model.RegisteredUser;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long>{

}
