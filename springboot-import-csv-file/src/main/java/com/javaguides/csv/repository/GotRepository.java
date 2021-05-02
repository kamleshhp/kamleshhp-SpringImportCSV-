package com.javaguides.csv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaguides.csv.entities.GOTENITY;




@Repository

public interface GotRepository extends JpaRepository<GOTENITY,String> {
	
	@Query(value="select region,location from got",nativeQuery = true)
	List<Object []> getDetails();
	
	
	@Query(value="select b from GOTENITY b where b.battle_number=:n")
	public List<GOTENITY> getBattleByNumber(@Param("n") long battle_number);
	
	
	
	
	
}
