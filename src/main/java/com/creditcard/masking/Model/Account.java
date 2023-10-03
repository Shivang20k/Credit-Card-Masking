package com.creditcard.masking.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Account")
public class Account {
    @Id
    @Column(name = "accountNumber")
    private String accountNumber;
    @Column(name = "branchCode")
    private String branchCode;
    @Column(name = "cvv")
    private String cvv;
}
