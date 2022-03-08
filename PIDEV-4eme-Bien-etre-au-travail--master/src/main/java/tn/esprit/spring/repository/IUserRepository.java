package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entity.User;

import java.util.Optional;

public interface IUserRepository extends CrudRepository<User, Long> {

    public User findUserByUserName(String userName);
    Optional<User> findByUserName(String username);
    public User findUserByName(String name);
    public User findUserByEmail(String email);
    public boolean existsByEmail(String email);
    Boolean existsByNid(String nid);
    Boolean existsByUserName(String username);
    @Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
    public User findByVerificationCode(String code);



}
