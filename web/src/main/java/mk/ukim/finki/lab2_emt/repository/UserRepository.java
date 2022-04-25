//package mk.ukim.finki.lab2_emt.repository;
//
//import mk.ukim.finki.lab2_emt.model.Role;
//import mk.ukim.finki.lab2_emt.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, String> {
//
//    Optional<User> findByUsernameAndPassword(String username, String password);
//
//    Optional<User> findByUsername(String username);
//
//    Optional<User> findByRole(Role role);
//
//}
