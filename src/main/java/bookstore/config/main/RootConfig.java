package bookstore.config.main;

import org.springframework.context.annotation.Import;

import bookstore.config.web.SecurityConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@Import({ PersistenceJPAConfig.class, SecurityConfig.class })
@ComponentScan(basePackages = { "bookstore.dao", "bookstore.model", "bookstore.service", "bookstore.util" })
public class RootConfig {
}
