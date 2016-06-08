package br.com.cs.rest.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.cs.rest.RepositoryConfiguration;
import br.com.cs.rest.model.Phone;
import br.com.cs.rest.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class })
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void testSaveProduct() {
		// User
		User user = new User();
		user.setName("Anderson");
		user.setEmail("anderson@teste");

		Phone p1 = new Phone();
		p1.setDdd(21);
		p1.setNumber(987654321);
		
		Phone p2 = new Phone();
		p2.setDdd(11);
		p2.setNumber(999998888);
		
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(p1);
		phones.add(p2);
		
		user.setPhones(phones);
		
		// Salva usuário, verifica o ID após salvar
		assertNull(user.getId()); // null antes de salvar
		userRepository.save(user);
		assertNotNull(user.getId()); // not null depois de salvar

		// buscar no BD
		User fetchedUser = userRepository.findOne(user.getId());

		// não deve ser nulo
		assertNotNull(fetchedUser);

		// deve ser igual
		assertEquals(user.getId(), fetchedUser.getId());
		assertEquals(user.getEmail(), fetchedUser.getEmail());

		// atualiza email e salva
		fetchedUser.setEmail("novoEmail@testes.com");
		userRepository.save(fetchedUser);

		// buscar no BD, deve estar atualizado
		User fetchedUpdatedUser = userRepository.findOne(fetchedUser.getId());
		assertEquals(fetchedUser.getEmail(), fetchedUpdatedUser.getEmail());

		// verifica quantidade de usuários no BD, deve ser 1
		long productCount = userRepository.count();
		assertEquals(productCount, 1);

		// busca todos os usuários, a lista deve ter apenas 1
		Iterable<User> users = userRepository.findAll();

		int count = 0;

		for (User u : users) {
			count++;
		}

		assertEquals(count, 1);
	}
}
