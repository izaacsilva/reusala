package br.fatec.reusala;

import br.fatec.reusala.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
