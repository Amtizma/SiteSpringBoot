package com.site.site.repository;

import com.site.site.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


    @Query("SELECT g FROM Games g WHERE g.name like %:name%")
    Games findGamesByName(String name);

    @Query("SELECT g FROM Games g WHERE g.platform LIKE %:platform% AND g.genre LIKE %:genre% ORDER BY g.price ASC")
    List<Games> findAllByPlatformOrderByPriceAsc(String platform, String genre);
    @Query("SELECT g FROM Games g WHERE g.platform LIKE %:platform% AND g.genre LIKE %:genre% ORDER BY g.price DESC")
    List<Games> findAllByPlatformOrderByPriceDesc(String platform, String genre);

    @Query("SELECT g FROM Games g WHERE g.platform LIKE %:platform% AND g.genre LIKE %:genre% ORDER BY g.name ASC")
    List<Games> findAllByPlatformOrderByNameAsc(String platform, String genre);

    @Query("SELECT g FROM Games g WHERE g.platform LIKE %:platform% AND g.genre LIKE %:genre% ORDER BY g.name DESC")
    List<Games> findAllByPlatformOrderByNameDesc(String platform, String genre);

    @Query("SELECT g FROM Games g WHERE g.platform LIKE %:platform% AND g.genre LIKE %:genre% ORDER BY g.release_Date ASC")
    List<Games> findAllByPlatformOrderByRelease_DateAsc(String platform, String genre);

    @Query("SELECT g FROM Games g WHERE g.platform LIKE %:platform% AND g.genre LIKE %:genre% ORDER BY g.release_Date DESC")
    List<Games> findAllByPlatformOrderByRelease_DateDesc(String platform, String genre);

    @Query("SELECT g FROM Games g WHERE g.platform LIKE %:platform% ORDER BY g.price ASC")
    List<Games> findAllByPlatOrderByPriceAsc(String platform);
    @Query("SELECT g FROM Games g WHERE g.platform LIKE %:platform% ORDER BY g.price DESC")
    List<Games> findAllByPlatOrderByPriceDesc(String platform);

    @Query("SELECT g FROM Games g WHERE g.platform LIKE %:platform% ORDER BY g.name ASC")
    List<Games> findAllByPlatOrderByNameAsc(String platform);

    @Query("SELECT g FROM Games g WHERE g.platform LIKE %:platform% ORDER BY g.name DESC")
    List<Games> findAllByPlatOrderByNameDesc(String platform);

    @Query("SELECT g FROM Games g WHERE g.platform LIKE %:platform% ORDER BY g.release_Date ASC")
    List<Games> findAllByPlatOrderByRelease_DateAsc(String platform);

    @Query("SELECT g FROM Games g WHERE g.platform LIKE %:platform% ORDER BY g.release_Date DESC")
    List<Games> findAllByPlatOrderByRelease_DateDesc(String platform);
}
