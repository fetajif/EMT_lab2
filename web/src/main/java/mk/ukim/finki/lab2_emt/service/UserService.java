//package mk.ukim.finki.lab2_emt.service;
//
//
//import mk.ukim.finki.lab2_emt.model.Role;
//import mk.ukim.finki.lab2_emt.model.User;
//
//public interface UserService extends UserDetailsService{
//
//    User login(String username, String password);
//    User register(String username, String password, String repeatPassword, String name, String surname, Role role);
//
//    @Override
//    default UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return null;
//    }
//}
