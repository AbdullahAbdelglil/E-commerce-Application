package com.ecommerce.pharmacy.DAO;

import com.ecommerce.pharmacy.Entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;


@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    Page<Review> findReviewByProductId(Long productId , Pageable pageable);
    Review findByUserAndProductId(String user,Long productId);
}
