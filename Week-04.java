Week-04
---------------------------------------------------------------------------------------------
  1. Understanding React Frontend
---------------------------------------------------------------------------------------------
  2. Setting Up a Spring Boot Project with Models
    @Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    // Getters and Setters
}
---------------------------------------------------------------------------------------------
  3. Loading Data into H2 Database
  spring.datasource.url=jdbc:h2:mem:testdb
  spring.h2.console.enabled=true
---------------------------------------------------------------------------------------------
  4. Handling CORS Errors in Spring Boot
  @Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:3000");
    }
}
---------------------------------------------------------------------------------------------
  5. Using ResponseEntity and Fetching Data by ID
  @GetMapping("/{id}")
public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    Optional<Product> product = productRepository.findById(id);
    return product.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
}
---------------------------------------------------------------------------------------------
  6. Adding Products with Images
  @PostMapping("/products")
public Product addProduct(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) {
    // Logic to save product and file
}
---------------------------------------------------------------------------------------------
  7. Fetching Images from the Server
  @GetMapping("/products/{id}/image")
public ResponseEntity<byte[]> getProductImage(@PathVariable Long id) {
    byte[] image = productService.getProductImage(id);
    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
}
---------------------------------------------------------------------------------------------
  8. Updating and Deleting Products@PutMapping("/{id}")
public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
    return productService.updateProduct(id, product);
}

@DeleteMapping("/{id}")
public void deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
}
---------------------------------------------------------------------------------------------
  9. Implementing a Search Feature
  public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String name);
}
---------------------------------------------------------------------------------------------
