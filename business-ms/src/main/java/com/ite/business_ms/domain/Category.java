package com.ite.business_ms.domain;

import com.ite.business_ms.config.jpa.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category extends Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alias;
    private String title;

    @ManyToMany(mappedBy = "categories")
    private List<Business> businesses;

}
