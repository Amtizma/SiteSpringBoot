package com.site.site.repository;

import com.site.site.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {
    List<Games> findAllOrderByPrice(Double price);

    @Query("SELECT g FROM Games g WHERE g.platform like %:platform%")
    List <Games> findAllByPlatform(String platform);
    @Query("SELECT g FROM Games g WHERE g.genre like %:genre% AND g.platform like %:platform%")
    List <Games> getAllByGenreAndPlatform(String genre, String platform);

    @Query("SELECT g FROM Games g WHERE g.name like %:name%")
    List<Games> findAllByName(String name);
}
