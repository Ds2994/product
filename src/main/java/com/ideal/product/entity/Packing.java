package com.ideal.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "packing")
@NoArgsConstructor
@AllArgsConstructor
public class Packing implements Serializable {

    @Id
    private long id;

    @Column(name = "packing_size")
    private String packingSize;
}