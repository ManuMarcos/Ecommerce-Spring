package com.arg.ecommerce.dao;

import com.arg.ecommerce.domain.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeDao extends JpaRepository<Size, Long> {

    Size findSizeByValue(String value);

}
