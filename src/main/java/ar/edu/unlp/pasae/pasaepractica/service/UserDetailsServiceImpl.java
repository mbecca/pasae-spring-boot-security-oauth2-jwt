package ar.edu.unlp.pasae.pasaepractica.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ar.edu.unlp.pasae.pasaepractica.entities.User;
import ar.edu.unlp.pasae.pasaepractica.repositories.UserRepository;

@Named
public class UserDetailsServiceImpl implements UserDetailsService {

	@Inject
	private UserRepository userRepository;

	private UserRepository getUserRepository() {
		return userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final User user = this.getUserRepository().findByUsername(username);

		if (user == null)
			throw new UsernameNotFoundException(String.format("No user found with username '%s'", username));
		return user;
	}

}
