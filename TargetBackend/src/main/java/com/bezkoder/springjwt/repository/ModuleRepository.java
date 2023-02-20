package com.bezkoder.springjwt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.bezkoder.springjwt.models.Module;


@Repository 
public interface ModuleRepository extends JpaRepository<Module, Integer>{
  
	 
}
