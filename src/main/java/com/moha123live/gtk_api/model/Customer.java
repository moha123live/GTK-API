package com.moha123live.gtk_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "customers")
@Where(clause = "is_deleted = false")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Builder
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

    @Builder.Default
    @Column(precision = 10, scale = 2)
    private BigDecimal oldBalance = BigDecimal.ZERO;

    @Builder.Default
    @Column(precision = 10, scale = 2)
    private BigDecimal currBalance = BigDecimal.ZERO;

    @Builder.Default
    @Column(precision = 10, scale = 2)
    private BigDecimal comm1 = BigDecimal.ZERO;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Status status = Status.ACTIVE;

    @Builder.Default
    @Column(nullable = false)
    private Boolean isDeleted = false;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public enum Status { ACTIVE, INACTIVE };
}
