package FTN.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import FTN.isa.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}

