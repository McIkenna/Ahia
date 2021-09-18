package com.shopping.ahia.repository;

import com.shopping.ahia.models.productContent.ProductLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLogRepository extends MongoRepository<ProductLog, Long> {
ProductLog findByCategoryIdentifier(String categoryIdentifier);
}
