package com.moha123live.gtk_api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Where(clause = "is_deleted = false")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cusId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 100)
    private String tamilName;

    @Column(length = 255)
    private String address;

    @Column(length = 100)
    private String city;

    @Column(length = 10)
    private String phone;

    @Column(precision = 10, scale = 2)
    private BigDecimal oldBalance = BigDecimal.ZERO;

    @Column(precision = 10, scale = 2)
    private BigDecimal currBalance = BigDecimal.ZERO;

    @Column(precision = 10, scale = 2)
    private BigDecimal comm1 = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;
    
    private Boolean isDeleted = false;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updateAt;

    public enum Status {
        ACTIVE, INACTIVE
    };

}
