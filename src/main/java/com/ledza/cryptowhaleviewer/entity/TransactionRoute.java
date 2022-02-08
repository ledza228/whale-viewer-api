package com.ledza.cryptowhaleviewer.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class TransactionRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "from_place")
    private String fromPlace;

    @NonNull
    @Column(name = "to_place")
    private String toPlace;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionRoute that = (TransactionRoute) o;

        if (!fromPlace.equals(that.fromPlace)) return false;
        return toPlace.equals(that.toPlace);
    }

    @Override
    public int hashCode() {
        int result = fromPlace.hashCode();
        result = 31 * result + toPlace.hashCode();
        return result;
    }
}
