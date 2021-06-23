package de.telekom.sea3.webserver.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import de.telekom.sea3.webserver.model.EmailPerson;
import de.telekom.sea3.webserver.model.MiniPerson;
import de.telekom.sea3.webserver.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	@Query("SELECT firstname, lastname, salutation FROM persons WHERE salutation = 1")
	public Iterable<MiniPerson> selectMiniPerson1(); // vgl. Iterator

	@Query("SELECT firstname, nachname, Anrede FROM Persons WHERE Anrede = ?1") // Flexible Query mit einem Parameter
	public Iterable<MiniPerson> selectMiniPersonByAnrede(int salutation);

	@Query("SELECT firstname, nachname, Anrede FROM Persons WHERE Anrede = ?1 AND Version < ?2") // Flexible Query mit
																								// zwei Parametern
	public Iterable<MiniPerson> selectMiniPersonByAnredeAndVersion(int salutation, int maxVersion);

//	@Query("SELECT adresse, email FROM Persons") // Flexible Query mit zwei Parametern
//	public Iterable<EmailPerson> selectEmail();

	@Query("SELECT * FROM Persons WHERE vorname like ?1 OR nachname like ?1") // Flexible Query mit zwei Parametern
	public Iterable<Person> searchByName(String searchExpr);

	@Query("UPDATE Persons SET Anrede = 1 WHERE Anrede > 2")
	public Iterable<MiniPerson> selectMiniPerson(); // vgl. Iterator

}
