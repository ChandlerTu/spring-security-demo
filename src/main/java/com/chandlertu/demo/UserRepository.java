package com.chandlertu.demo;

import java.util.Optional;

import org.springframework.data.repository.Repository;
import org.springframework.security.access.prepost.PreAuthorize;

public interface UserRepository extends Repository<User, Integer> {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void deleteById(Integer id);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	Iterable<User> findAll();

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	Optional<User> findById(Integer id);

	public User findByUsername(String username);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	<S extends User> S save(S entity);

}
