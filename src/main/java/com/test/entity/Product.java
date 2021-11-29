package com.test.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(columnDefinition = "NVARCHAR(100)", nullable = false)
    private String name;

    @Column
    private Integer price;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_distributor",
    joinColumns = @JoinColumn(name="products_id"),
    inverseJoinColumns = @JoinColumn(name = "distributors_id"))
    @JsonIgnore
    private Collection<Distributor> distributors;
}
