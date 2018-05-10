package ar.edu.unlp.pasae.pasaepractica.repositories;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unlp.pasae.pasaepractica.entities.User;

@Named
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
