package telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import telegrambot.model.entity.Card;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    @Query(value = "SELECT c.id, c.name, c.balance, c.is_deleted FROM cards c WHERE c.name = :name", nativeQuery = true)
    Optional<Card> getByName(@Param("name") String name);

    @Override
    @Query(value = "SELECT c.id, c.name, c.balance, c.is_deleted  FROM cards c WHERE c.id = :id", nativeQuery = true)
    Card getById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cards SET is_deleted = true WHERE id = :id", nativeQuery = true)
    void delete(@Param("id") Long id);

}