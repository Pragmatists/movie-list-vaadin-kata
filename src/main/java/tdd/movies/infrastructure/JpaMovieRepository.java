package tdd.movies.infrastructure;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tdd.movies.domain.Movie;
import tdd.movies.domain.MovieRepository;

@Repository
public class JpaMovieRepository implements MovieRepository {

    private EntityManager entityManager;

    @Autowired
    public JpaMovieRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Movie> loadAll() {
        return entityManager.createQuery("from Movie").getResultList();
    }

    public void save(Movie movie) {
        entityManager.persist(movie);
    }

}
