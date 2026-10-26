package com.marcoder.transactions_service.domain.model;

import com.marcoder.transactions_service.domain.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID transaction_id;

    private String currency;

    private Double amount;

    private String sourceIp;

    private String destinationIp;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Float riskScore;

    @Column(name = "ai_explanation", columnDefinition = "TEXT")
    private String aiExplanation;

    private LocalDateTime createdAt;

}
