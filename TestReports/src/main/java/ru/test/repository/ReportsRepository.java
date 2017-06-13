package ru.test.repository;

import com.sun.org.apache.regexp.internal.RE;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.test.model.Report;


import java.util.Date;
import java.util.List;

@Repository
public interface ReportsRepository extends JpaRepository<Report, Integer> {


    List<Report> findAll();

    List<Report> findAllByPerformer(String performer);

    @Modifying
    @Query(value = "SELECT * FROM report WHERE startdate >=:startquery AND enddate <=:endquery", nativeQuery = true)
    @Transactional
    List<Report> findAllByEndDateAndStartDateBetween(@Param("startquery") Date startquery,
                                                     @Param("endquery") Date endquery);


    @Modifying
    @Query(value = "SELECT * FROM report WHERE performer=:performer AND startdate >=:startquery AND enddate <=:endquery", nativeQuery = true)
    @Transactional
    List<Report> findAllByPerformerAndStartdateAndEnddateBetween(@Param("startquery") Date startquery,
                                                                 @Param("endquery") Date endquery,
                                                                 @Param("performer") String performer);

    @Modifying
    @Query(value = "SELECT * FROM report WHERE performer=:performer AND  enddate <=:endquery", nativeQuery = true)
    @Transactional
    List<Report> findAllByPerformerAndEnddate( @Param("endquery") Date endquery,@Param("performer") String performer);

    @Modifying
    @Query(value = "SELECT * FROM report WHERE performer=:performer AND  startdate >=:startquery", nativeQuery = true)
    @Transactional
    List<Report> findAllByPerformerAndStartdate( @Param("startquery") Date startquery,@Param("performer") String performer);

    @Modifying
    @Query(value = "SELECT * FROM report WHERE performer=:performer ", nativeQuery = true)
    @Transactional
    List<Report> findAllByPerformerWhithoutDate(@Param("performer") String performer);

    @Modifying
    @Query(value = "SELECT * FROM report WHERE enddate <=:endquery", nativeQuery = true)
    @Transactional
    List<Report> findAllByEnddate(@Param("endquery") Date endquery);

    @Modifying
    @Query(value = "SELECT * FROM report WHERE startdate >=:startquery", nativeQuery = true)
    @Transactional
    List<Report> findAllByStartDate(@Param("startquery") Date startquery);
}


