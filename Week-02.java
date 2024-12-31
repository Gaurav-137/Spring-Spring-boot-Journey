Week-02
---------------------------------------------------------------------------------------------
#1. Dependency Injection in Spring Boot

@Service
public class UserService {
    private final UserRepository userRepository;

    // Dependency is injected via constructor
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void performAction() {
        userRepository.saveData();
    }
}
-----------------------------------------------------------------------------------------------
#2. Autowiring in Spring Boot

@Component
public class OrderService {
    @Autowired
    private PaymentService paymentService;

    public void processOrder() {
        paymentService.makePayment();
    }
}
-----------------------------------------------------------------------------------------------
#3. Spring Without Boot

@Configuration
public class AppConfig {
    @Bean
    public UserService userService() {
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
-----------------------------------------------------------------------------------------------
#4. Spring XML Configuration

<beans>
    <bean id="userService" class="com.example.UserService">
        <property name="userRepository" ref="userRepository"/>
    </bean>
    <bean id="userRepository" class="com.example.UserRepository"/>
</beans>
-----------------------------------------------------------------------------------------------
#5. Constructor and Setter Injection in Spring Boot


# Constructor Injection->>
@Component
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}

# Setter Injection->>
@Component
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
-----------------------------------------------------------------------------------------------
#6. Advanced Autowiring in Spring Boot

@Component
public class NotificationService {
    private final MessageSender messageSender;

    @Autowired
    public NotificationService(@Qualifier("emailSender") MessageSender messageSender) {
        this.messageSender = messageSender;
    }
}
-----------------------------------------------------------------------------------------------
#7. The Need for Spring Boot MVC

@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/users")
    public List<User> getAllUsers() {
        // Business logic to fetch users
        return new ArrayList<>();
    }
}
-----------------------------------------------------------------------------------------------
