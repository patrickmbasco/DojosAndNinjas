package com.pbasco.DojoNinja.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pbasco.DojoNinja.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

}