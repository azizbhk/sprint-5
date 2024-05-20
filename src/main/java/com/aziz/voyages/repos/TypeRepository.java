package com.aziz.voyages.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aziz.voyages.entities.Type;
public interface TypeRepository extends JpaRepository<Type, Long>
{
}