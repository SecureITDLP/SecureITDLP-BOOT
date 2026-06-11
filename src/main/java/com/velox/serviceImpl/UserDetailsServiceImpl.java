//package com.velox.serviceImpl;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
// 
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
// 
//    // Hardcoded user — swap this out for DB lookup when you add JPA later.
//    // Password "admin123" pre-encoded. To generate a new hash:
//    // new BCryptPasswordEncoder().encode("yourpassword")
//    private static final String ENCODED_PASSWORD =
//            new BCryptPasswordEncoder().encode("admin123");
// 
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if ("admin".equals(username)) {
//            return User.builder()
//                    .username("admin")
//                    .password(ENCODED_PASSWORD)
//                    .roles("ADMIN")
//                    .build();
//        }
//        throw new UsernameNotFoundException("User not found: " + username);
//    }
//}