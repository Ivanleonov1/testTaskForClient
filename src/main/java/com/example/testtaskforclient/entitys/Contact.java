package com.example.testtaskforclient.entitys;

import com.example.testtaskforclient.entitys.enumirated.ContactType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String value;

    @Enumerated(EnumType.STRING)
    private ContactType type;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
