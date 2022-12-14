package com.vinicius.contact.list.api.domain.repository.jpa;

import com.vinicius.contact.list.api.domain.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface ContactListJpaRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT id, uuid, name, last_name, created_at, modified_at " +
            "FROM tb_person " +
            "ORDER BY created_at DESC ", nativeQuery = true)
    Set<Person> listAllPersons();

    @Query(value = "SELECT id, uuid, name, last_name, created_at, modified_at " +
            "FROM tb_person " +
            "WHERE uuid = ?1", nativeQuery = true)
    Optional<Person> findByUuid(String personUuid);
}
