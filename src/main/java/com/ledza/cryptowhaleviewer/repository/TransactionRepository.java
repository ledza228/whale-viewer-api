package com.ledza.cryptowhaleviewer.repository;

import com.ledza.cryptowhaleviewer.entity.Transaction;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    @EntityGraph(value = "TransactionGraph")
    List<Transaction> findAll();

    List<Transaction> findAllByCoinSym(String sym);

    List<Transaction> findAllByDateAfterAndRouteFromPlaceOrRouteToPlaceAndDateAfter(LocalDateTime dateAgo, String exchange1, String exchange2, LocalDateTime dateAgo2);

    @Query(value = "SELECT * FROM transaction JOIN coin ON (transaction.coin_id = coin.id) JOIN transaction_route ON (transaction_route.id = transaction.route_id) JOIN operation_type ON (operation_type.id = transaction.operation_id) WHERE (transaction.date_time >= ?1) AND (transaction_route.from_place = ?2 OR transaction_route.to_place = ?2) AND coin.sym IN ?3", nativeQuery = true)
    List<Transaction> findAllOnlyStableByDateAndExchange(LocalDateTime dateTime, String exchange, List<String> stableCoins);

    @Query(value = "SELECT * FROM transaction JOIN transaction_route ON (transaction.route_id = transaction_route.id) JOIN coin ON (coin.id = transaction.coin_id) WHERE (from_place = ?2 OR to_place = ?2) AND (date_time >= ?1) AND (coin.sym NOT IN ?3)", nativeQuery = true)
    List<Transaction> findAllOnlyNotStableByDateAndExchange(LocalDateTime dateTime, String exchange, List<String> stableCoins);

    @Query(value = "SELECT * FROM transaction JOIN transaction_route ON (transaction.route_id = transaction_route.id) WHERE (from_place NOT LIKE '2%' OR to_place NOT LIKE '2%') AND date_time >= ?1", nativeQuery = true)
    List<Transaction> findForAllExchanges(LocalDateTime dateTime, String antiExchange);
}
