package org.fedelaper.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.fedelaper.spring.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonDAO {

	// Dummy database. Initialize with some dummy values.
	private List<Person> persons;
	{
		persons = new ArrayList<Person>();
		persons.add(new Person(1, "John", "Doe", "djohn@gmail.com", "121-232-3435", "pass1"));
		persons.add(new Person(2, "Russ", "Smith", "sruss@gmail.com", "343-545-2345", "pass2"));
		persons.add(new Person(3, "Kate", "Williams", "kwilliams@gmail.com", "876-237-2987", "pass3"));
		persons.add(new Person(4, "Pablo", "Folgar", "kwilliams@gmail.com", "876-237-2987", "pass3"));
		persons.add(new Person(5, "Federico", "Lapertosa", "kwilliams@gmail.com", "876-237-2987", "pass3"));
		persons.add(new Person(6, "Juan", "Osudar", "kwilliams@gmail.com", "876-237-2987", "pass3"));
		persons.add(new Person(7, "Leandro", "Giordano", "kwilliams@gmail.com", "876-237-2987", "pass3"));
	}

	/**
	 * Returns list of persons from dummy database.
	 * 
	 * @return list of persons
	 */
	public List<Person> list() {
		return persons;
	}

	/**
	 * Return person object for given id from dummy database. If person is
	 * not found for id, returns null.
	 * 
	 * @param id
	 *            person id
	 * @return person object for given id
	 */
	public Person get(Long id) {

		for (Person c : persons) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Create new person in dummy database. Updates the id and insert new
	 * person in list.
	 * 
	 * @param person
	 *            Person object
	 * @return person object with updated id
	 */
	public Person create(Person person) {
		person.setId(System.currentTimeMillis());
		persons.add(person);
		return person;
	}

	/**
	 * Delete the person object from dummy database. If person not found for
	 * given id, returns null.
	 * 
	 * @param id
	 *            the person id
	 * @return id of deleted person object
	 */
	public Long delete(Long id) {

		for (Person c : persons) {
			if (c.getId().equals(id)) {
				persons.remove(c);
				return id;
			}
		}

		return null;
	}

	/**
	 * Update the person object for given id in dummy database. If person
	 * not exists, returns null
	 * 
	 * @param id
	 * @param person
	 * @return person object with id
	 */
	public Person update(Long id, Person person) {

		for (Person c : persons) {
			if (c.getId().equals(id)) {
				person.setId(c.getId());
				persons.remove(c);
				persons.add(person);
				return person;
			}
		}

		return null;
	}

}
