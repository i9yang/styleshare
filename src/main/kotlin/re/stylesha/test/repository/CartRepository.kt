package re.stylesha.test.repository

import org.springframework.data.repository.CrudRepository
import re.stylesha.test.dto.Cart

interface CartRepository : CrudRepository<Cart, Int>

