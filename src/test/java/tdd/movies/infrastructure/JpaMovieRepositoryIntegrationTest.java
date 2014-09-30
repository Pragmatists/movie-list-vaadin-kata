package tdd.movies.infrastructure;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tdd.movies.domain.Movie;

@Transactional
@ContextConfiguration(classes = JpaConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaMovieRepositoryIntegrationTest {

    @PersistenceContext
    private EntityManager entityManager;

    private JpaMovieRepository repository;

    @Before
    public void setUp() {
        repository = new JpaMovieRepository(entityManager);
    }

    @Test
    public void saveAndLoadRoundtrip() {
        Movie movie = new Movie("Forrest Gump", "Robert Zemeckis", 1994);
        repository.save(movie);

        List<Movie> all = repository.loadAll();

        Assertions.assertThat(all).containsExactly(movie);
    }

}
