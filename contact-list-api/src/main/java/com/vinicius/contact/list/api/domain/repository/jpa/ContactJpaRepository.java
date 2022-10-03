package com.vinicius.contact.list.api.domain.repository.jpa;

import com.vinicius.contact.list.api.domain.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface ContactJpaRepository extends JpaRepository<Contact, Long> {

    @Query(value = "SELECT c.*, pc.person_fk " +
            "FROM tb_contact c " +
            "LEFT JOIN person_contact pc ON c.id = pc.contact_fk " +
            "LEFT JOIN tb_person p on pc.person_fk = p.id " +
            "WHERE p.uuid = :personUuid ORDER BY created_at DESC", nativeQuery = true)
    Set<Contact> findAllByPersonUuid(String personUuid);

    @Query("SELECT c " +
            "FROM Contact c " +
            "WHERE c.uuid = ?1")
    Optional<Contact> findByUuid(String personUuid);
}
