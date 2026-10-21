package es.upsa.dasi.videojuegosws.infrastructure.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;

@ApplicationScoped
public class DataSourceProducer {
    @Produces
    @ApplicationScoped
    public DataSource dataSource() {
        String password = System.getenv("DB_PASSWORD");
        if (password == null || password.isBlank()) {
            throw new IllegalStateException("Set DB_PASSWORD before starting the backend");
        }
        PGSimpleDataSource source = new PGSimpleDataSource();
        source.setURL(System.getenv().getOrDefault("DB_URL", "jdbc:postgresql://localhost:55433/retrogames"));
        source.setUser(System.getenv().getOrDefault("DB_USER", "portfolio"));
        source.setPassword(password);
        return source;
    }
}
