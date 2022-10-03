package com.vinicius.contact.list.api.domain.entities;

import com.vinicius.contact.list.api.controller.request.UpdateContactRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;

import static java.util.Objects.nonNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    private String phone;

    private String email;

    private String whatsapp;

    @CreationTimestamp
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    private OffsetDateTime modifiedAt;

    @ManyToOne
    @JoinTable(name = "person_contact",
            joinColumns = {@JoinColumn(name = "contact_fk", insertable = false,
                    updatable = false, referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "person_fk",
                    updatable = false, referencedColumnName = "id")}
    )
    private Person person;

    public static Contact toSave(Contact contact, Person person) {
        return Contact.builder()
                .uuid(UUID.randomUUID().toString())
                .phone(contact.getPhone())
                .email(contact.getEmail())
                .whatsapp(contact.getWhatsapp())
                .person(person)
                .build();
    }

    public static Contact toUpdate(Contact contact, UpdateContactRequest request) {
        if (nonNull(request.getPhone())) {
            contact.setPhone(request.getPhone());
        }
        if (nonNull(request.getEmail())) {
            contact.setEmail(request.getEmail());
        }
        if (nonNull(request.getWhatsapp())) {
            contact.setWhatsapp(request.getWhatsapp());
        }
        return contact;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("uuid", uuid)
                .append("phone", phone)
                .append("email", email)
                .append("whatsapp", whatsapp)
                .append("createdAt", createdAt)
                .append("modifiedAt", modifiedAt)
                .toString();
    }
}
