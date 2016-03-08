package bookstore.config.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import bookstore.config.main.RootConfig;
import bookstore.config.web.SecurityConfig;
import bookstore.config.web.WebConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
      return new Class[] { RootConfig.class };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
      return new Class[] { WebConfig.class };
  }

  @Override
  protected String[] getServletMappings() {
      return new String[] { "/" };
  }

}