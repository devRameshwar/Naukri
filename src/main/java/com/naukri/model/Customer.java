package com.naukri.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name = "customer")

public class Customer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String customer_id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String type;
}
