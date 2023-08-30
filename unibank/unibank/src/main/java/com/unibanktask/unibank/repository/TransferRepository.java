package com.unibanktask.unibank.repository;

import com.unibanktask.unibank.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
