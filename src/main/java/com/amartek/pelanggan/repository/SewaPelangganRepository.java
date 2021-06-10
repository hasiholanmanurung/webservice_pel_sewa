package com.amartek.pelanggan.repository;

import com.amartek.pelanggan.entity.PelangganSewa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  SewaPelangganRepository extends JpaRepository<PelangganSewa, Long> {
    
}
