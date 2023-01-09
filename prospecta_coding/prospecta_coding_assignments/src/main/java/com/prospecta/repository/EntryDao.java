package com.prospecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prospecta.beans.Entry;

@Repository
public interface EntryDao extends JpaRepository<Entry, Integer>{

}
