package com.alpengotter.dental_service_bank.domain.repository;

import com.alpengotter.dental_service_bank.domain.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("select u from UserEntity u where u.email = lower(:email)")
    Optional<UserEntity> findByEmailIgnoreCase(String email);
    Optional<UserEntity> findByEmailContainingIgnoreCaseAndIsActiveIsTrue(String email);
    @Query(value = "select u from UserEntity u where u.isActive = true order by u.lastName asc",
    countQuery = "select count(u) from UserEntity u where u.isActive = true")
    Page<UserEntity> findAllAndIsActiveIsTrue(Pageable pageRequest);

    List<UserEntity> findByIsActiveIsTrue();

    List<UserEntity> findAllByIdInAndIsActiveIsTrue(List<Integer> ids);
    @Query(value = "select u from UserEntity u "
        + "where (lower(u.firstName) like lower(concat('%', :firstName, '%')) or lower(u.lastName) like lower(concat('%', :lastName, '%'))) "
        + "and u.isActive = true")
    List<UserEntity> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseAndIsActiveIsTrue(String firstName, String lastName);
    Optional<UserEntity> findByIdAndIsActiveIsTrue(Integer id);
    @Modifying
    @Query("update UserEntity u set u.diamonds = ?1 where u.id in ?2")
    void updateDiamondsForIds(Integer currency, List<Integer> userIds);
    @Modifying
    @Query("update UserEntity u set u.lemons = ?1 where u.id in ?2")
    void updateLemonsForIds(Integer currency, List<Integer> userIds);
    @Modifying
    @Query("update UserEntity u set u.isActive = ?1 where u.id in ?2")
    void updateIsActiveForIds(boolean isActive, List<Integer> userIds);
    @Query("select COUNT(u) from UserEntity u where u.isActive = true ")
    Integer countAllActiveUsers();
    @Query("select SUM (u.diamonds) from UserEntity u where u.isActive = true ")
    Integer countAllDiamonds();
    @Query("select SUM (u.lemons) from UserEntity u where u.isActive = true ")
    Integer countAllLemons();
    @Query("select distinct u.jobTitle from UserEntity u "
        + "where u.jobTitle is not null "
        + "and trim(u.jobTitle) <> '' ")
    Set<String> getUniqueJobTitles();
}
