package tdd.movies.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tdd.movies.domain.Movie;
import tdd.movies.domain.MovieRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaMovieRepository implements MovieRepository {

    private EntityManager entityManager;

    @Autowired
    public JpaMovieRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Movie> loadAll() {
        return entityManager.createQuery("from Movie").getResultList();
    }

    @Override
    public void save(Movie movie) {
        entityManager.persist(movie);
    }

}
