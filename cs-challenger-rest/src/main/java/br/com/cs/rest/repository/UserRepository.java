package br.com.cs.rest.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cs.rest.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
