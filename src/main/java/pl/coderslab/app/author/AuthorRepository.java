package pl.coderslab.app.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByEmail(String email);

    Author findByPesel(String pesel);

    List<Author> findByLastName(String lastName);

    @Query("SELECT a from Author a where a.email LIKE ?1%")
    Set<Author> findByEmailStartingWith(String email);

    @Query("SELECT a from Author a where a.pesel LIKE ?1%")
    Set<Author> findByPeselStartingWith(String pesel);
}
