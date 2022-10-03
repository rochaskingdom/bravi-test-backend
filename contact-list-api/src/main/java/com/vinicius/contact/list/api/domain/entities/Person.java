package com.vinicius.contact.list.api.domain.entities;

import com.vinicius.contact.list.api.controller.request.UpdatePersonRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import static java.util.Objects.nonNull;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    @Setter
    private String name;

    @Setter
    private String lastName;

    @CreationTimestamp
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    private OffsetDateTime modifiedAt;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "person_contact",
            joinColumns = {@JoinColumn(name = "person_fk", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "contact_fk", referencedColumnName = "id")}
    )
    private Set<Contact> contacts = new LinkedHashSet<>();

    public static Person toSave(Person person) {
        var personSave = Person.builder()
                .uuid(UUID.randomUUID().toString())
                .name(person.getName())
                .lastName(person.getLastName())
                .contacts(person.getContacts())
                .build();
        person.getContacts().forEach(contact -> contact.setUuid(UUID.randomUUID().toString()));
        return personSave;
    }

    public static Person toUpdate(Person person, UpdatePersonRequest request) {
        if (nonNull(request.getName())) {
            person.setName(request.getName());
        }
        if (nonNull(request.getLastName())) {
            person.setLastName(request.getLastName());
        }
        return person;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("uuid", uuid)
                .append("name", name)
                .append("lastName", lastName)
                .append("createdAt", createdAt)
                .append("modifiedAt", modifiedAt)
                .toString();
    }
}
