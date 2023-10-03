package com.creditcard.masking.Model;

import com.creditcard.masking.CustomAnnotation.Mask;
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
    @Mask
    @Column(name = "accountNumber")
    private String accountNumber;
    @Mask
    @Column(name = "branchCode")
    private String branchCode;
    @Mask
    @Column(name = "cvv")
    private String cvv;
}
