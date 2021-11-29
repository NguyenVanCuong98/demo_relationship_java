package com.test.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "card")
@Getter
@Setter
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Integer id;
    private Integer money;
    private String title;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "card")
    @JsonIgnore
    private Customer customer;
    public void setCustomer(Customer customer) {
        this.customer = customer;
        if (customer != null) {
            customer.setCard(this);
        }
    }



}
