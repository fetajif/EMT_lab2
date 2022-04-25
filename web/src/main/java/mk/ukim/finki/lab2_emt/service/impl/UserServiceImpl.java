//package mk.ukim.finki.lab2_emt.service.impl;
//
//import mk.ukim.finki.lab2_emt.model.User;
//import mk.ukim.finki.lab2_emt.repository.UserRepository;
//import mk.ukim.finki.lab2_emt.service.UserService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return userRepository.findByUsername(s).orElseThrow(()->new UsernameNotFoundException(s));
//    }
//
//    @Override
//    public User login(String username, String password) throws Exception {
//        if(username==null || username.isEmpty() || password==null || password.isEmpty()){
//            throw new Exception("LOGIN ERROR");
//        }
//
//        Optional<User> user = this.userRepository.findByUsernameAndPassword(username, password);
//
//        List<User> users = this.userRepository.findAll();
//
//        return user;
//    }
//
//
//    @Override
//    public User register(String username, String password, String repeatPassword, String name, String surname, Role userRole) {
//        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
//            throw new InvalidUsernameOrPasswordException();
//        if (!password.equals(repeatPassword))
//            throw new PasswordsDoNotMatchException();
//        if(this.userRepository.findByUsername(username).isPresent())
//            throw new UsernameAlreadyExistsException(username);
//        User user = new User(username,passwordEncoder.encode(password),name,surname,userRole);
//        return userRepository.save(user);
//    }
//
//    @Override
//    public Optional<User> delete(String username) {
//        User user = this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
//        this.userRepository.delete(user);
//        return Optional.of(user);
//    }
//
//    @Override
//    public Optional<User> findByUsername(String username) {
//        return this.userRepository.findByUsername(username);
//    }
//}
//
