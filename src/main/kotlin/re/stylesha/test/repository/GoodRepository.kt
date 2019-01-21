package re.stylesha.test.repository

import org.springframework.data.repository.CrudRepository
import re.stylesha.test.dto.Good
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query


interface GoodRepository : CrudRepository<Good, Int> {
    @Modifying
    @Query("update Option o set o.stock = o.stock + ?3 where o.id = ?2 and o.goodId = ?1")
    fun setStock( goodId: Int , optionId: Int, stock: Int)
}

