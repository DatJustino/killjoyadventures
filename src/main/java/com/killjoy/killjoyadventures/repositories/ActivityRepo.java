package com.killjoy.killjoyadventures.repositories;

import com.killjoy.killjoyadventures.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepo extends JpaRepository<Activity, String> {
}
