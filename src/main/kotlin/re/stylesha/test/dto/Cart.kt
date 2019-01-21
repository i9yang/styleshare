package re.stylesha.test.dto

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "CART")
data class Cart(
        @Id
        @GeneratedValue
        var cartId: Int?,
        var goodId: Int,
        var optionId: Int
)