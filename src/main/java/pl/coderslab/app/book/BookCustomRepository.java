package pl.coderslab.app.book;

import java.math.BigDecimal;

public interface BookCustomRepository {
    void resetRating(BigDecimal rating);
}
