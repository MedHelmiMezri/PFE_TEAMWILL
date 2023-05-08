package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Stats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepository extends JpaRepository<Stats, Integer> {

}
