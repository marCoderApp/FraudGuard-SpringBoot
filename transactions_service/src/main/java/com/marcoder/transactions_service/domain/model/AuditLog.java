package com.marcoder.transactions_service.domain.model;


import com.marcoder.transactions_service.domain.enums.AuditAction;
import com.marcoder.transactions_service.domain.enums.EntityType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID auditLog_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "entity_type", nullable = false, updatable = false)
    private EntityType entityType;

    @Column(name = "entity_id", nullable = false, updatable = false)
    private UUID entityId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private AuditAction auditAction;

    @Column(columnDefinition = "TEXT", updatable = false)
    private String payload;

    @Column(name = "previous_hash", updatable = false)
    private String previousHash;            // null en el primer registro

    @Column(name = "current_hash", nullable = false, updatable = false)
    private String currentHash;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;
}
