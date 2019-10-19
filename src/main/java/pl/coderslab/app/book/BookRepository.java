package pl.coderslab.app.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long>, BookCustomRepository {

    Set<Book> findByTitle(String title);

    Set<Book> findByCategoryName(String categoryName);

    Set<Book> findByCategoryId(Long id);

    Set<Book> findByAuthorsId(Long authorId);

    Set<Book> findByPublisherId(Long publisherId);

    Set<Book> findByRating(BigDecimal rating);

    Optional<Book> findFirstByCategoryIdOrderByTitle(Long categoryId);

    @Query("SELECT b from Book b where b.title = ?1")
    Set<Book> findByTitleQuery(String title);

    @Query("SELECT b from Book b where b.title = :title")
    Set<Book> findByTitleQueryParam(@Param("title") String title);

    @Query("SELECT b from Book b where b.category.name = ?1")
    Set<Book> findByCategoryNameQuery(String name);

    @Query("SELECT b from Book b where b.rating >= :minRating and b.rating <= :maxRating")
    Set<Book> findByRatingFromMinToMax(@Param("minRating") BigDecimal minRating, @Param("maxRating") BigDecimal maxRating);

    @Query("SELECT b from Book b where b.publisher.id = ?1")
    Set<Book> findByPublisherIdQuery(Long publisherId);

    @Query(value = "SELECT * FROM bookStore.books AS b join bookStore.categories c on b.category_id = c.id WHERE b.category_id = ?1 ORDER BY b.title ASC LIMIT 1", nativeQuery = true)
    Optional<Book> findFirstByCategoryIdOrderByTitleQuery(Long categoryId);
}
