package com.killjoy.killjoyadventures.repository;

import com.killjoy.killjoyadventures.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepo extends JpaRepository<Activity, String> {
}
