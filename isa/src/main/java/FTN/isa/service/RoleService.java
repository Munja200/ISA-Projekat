package FTN.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FTN.isa.model.Role;
import FTN.isa.repository.RoleRepository;

@Service
public class RoleService {

  @Autowired
  private RoleRepository roleRepository;

  public Role findById(Long id) {
	Role auth = roleRepository.getOne(id);
    return auth;
  }

  public List<Role> findByName(String name) {
	List<Role> roles = roleRepository.findByName(name);
    return roles;
  }
}