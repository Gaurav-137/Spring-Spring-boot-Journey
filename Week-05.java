Week-05
---------------------------------------------------------------------------------------------
  1. Spring Security 6: Getting Started
    <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
---------------------------------------------------------------------------------------------
  2. Custom Login Implementation
    @Override
protected void configure(HttpSecurity http) throws Exception {
    http.formLogin()
        .loginPage("/custom-login")
        .permitAll();
}
---------------------------------------------------------------------------------------------
  3. Understanding and Using CSRF Tokens
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
---------------------------------------------------------------------------------------------
  4. Customizing Spring Security Configurations
  @Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/public/**").permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .anyRequest().authenticated();
}
---------------------------------------------------------------------------------------------
  5. Verifying Users from a Database
  @Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), user.getRoles());
    }
}
---------------------------------------------------------------------------------------------
  6. Encoding Passwords with BCrypt
  @Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
# When saving a new user:
user.setPassword(passwordEncoder.encode(plainPassword));
---------------------------------------------------------------------------------------------
  7. What is JWT and Why It’s Needed
---------------------------------------------------------------------------------------------
  8. Generating JWT Tokens in Spring Boot
  String token = Jwts.builder()
        .setSubject(user.getUsername())
        .signWith(SignatureAlgorithm.HS512, "secret_key")
        .compact();
---------------------------------------------------------------------------------------------
  9. Validating JWT Tokens and Using OAuth2
  @Override
protected void configure(HttpSecurity http) throws Exception {
    http.oauth2Login()
        .loginPage("/oauth2/authorization/google");
}
---------------------------------------------------------------------------------------------
