package com.moha123live.gtk_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "ledgers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Ledger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ledId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private EntityType entityType; // CUSTOMER or SUPPLIER

    @Column(nullable = false)
    private Integer entityId; // FK to Customer.cusId or Supplier.supId

    private Long referenceId; // Nullable → depends on reference type

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private ReferenceType referenceType;

    @Column(nullable = false)
    private LocalDateTime date;

    @Builder.Default
    @Column(precision = 10, scale = 2)
    private BigDecimal debit = BigDecimal.ZERO;

    @Builder.Default
    @Column(precision = 10, scale = 2)
    private BigDecimal credit = BigDecimal.ZERO;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal oldBalance;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal newBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by")
    private User updatedBy;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public enum EntityType {
        CUSTOMER, SUPPLIER
    }

    public enum ReferenceType {
        OPENING_BALANCE,
        SALE,
        CUSTOMER_PAYMENT,
        PURCHASE,
        SUPPLIER_PAYMENT,
        ADJUSTMENT
    }
}
