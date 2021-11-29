package com.test.entity;

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
@Table(name = "distributors")
public class Distributor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(columnDefinition = "NVARCHAR(200)", nullable = false)
    private String address;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "distributors")
    @JsonIgnore
    private Collection<Product> products;

}
