//package mk.ukim.finki.lab2_emt.web;
//
//import mk.ukim.finki.lab2_emt.model.User;
//import mk.ukim.finki.lab2_emt.service.UserService;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/")
//public class UserController {
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
////
////    @PostMapping("/register")
////    public ResponseEntity<User> register(@RequestBody User user) {
////        return this.userService.register(user.getUsername(), user.getPassword(), user.getName(), user.getSurname(), user.getRole())
////                .map(tmp -> ResponseEntity.ok().body(tmp))
////                .orElseGet(() -> ResponseEntity.badRequest().build());
////    }
////
////    @PostMapping("/login")
////    public ResponseEntity<User> login(@RequestBody UserDto userDto) throws Exception {
////        return this.userService.login(userDto.getUsername(), userDto.getPassword())
////                .map(x-> ResponseEntity.ok().body(x))
////                .orElseGet(() -> ResponseEntity.badRequest().build());
////    }
//}
