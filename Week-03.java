Week-03
---------------------------------------------------------------------------------------------
  1. Spring Boot Web
    @RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
---------------------------------------------------------------------------------------------
  2. Spring MVC and Layers
  @Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to the Home Page!");
        return "home";
    }
}
---------------------------------------------------------------------------------------------
  3. HTTP Methods: GET and POST in Spring Web
  @RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        // Retrieve and return user by ID
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        // Create and return new user
    }
}
---------------------------------------------------------------------------------------------
  4. HTTP Methods: PUT and DELETE in Spring Web
  @PutMapping("/{id}")
public User updateUser(@PathVariable Long id, @RequestBody User user) {
    // Update user by ID and return updated user
}

@DeleteMapping("/{id}")
public void deleteUser(@PathVariable Long id) {
    // Delete user by ID
}
---------------------------------------------------------------------------------------------
  5. Introduction to Spring Data JPA
  @Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    // Getters and setters
}

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Spring provides basic CRUD operations out of the box
}
---------------------------------------------------------------------------------------------
  6. Setting Up Spring Data JPA with H2 Database
  6.1 Add the H2 dependency to pom.xml:
   <dependency>
     <groupId>com.h2database</groupId>
     <artifactId>h2</artifactId>
     <scope>runtime</scope>
 </dependency>

  6.2 Configure H2 in application.properties:
   spring.datasource.url=jdbc:h2:mem:testdb
 spring.datasource.driver-class-name=org.h2.Driver
 spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

  6.3 Start using your repository interface to interact with the database.
---------------------------------------------------------------------------------------------
  7. Spring Data JPA and JpaRepository
  public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);
}
---------------------------------------------------------------------------------------------
