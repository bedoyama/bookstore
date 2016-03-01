package bookstore.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@Import(PersistenceJPAConfig.class)
@ComponentScan(basePackages = { "bookstore.dao", "bookstore.model", "bookstore.service", "bookstore.util" })
public class RootConfig {
}
