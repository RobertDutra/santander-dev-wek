package me.dio.santander_dev_wek.repository;

import me.dio.santander_dev_wek.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String accountNumber);
    boolean existsByCardNumber(String cardNumber);
}





