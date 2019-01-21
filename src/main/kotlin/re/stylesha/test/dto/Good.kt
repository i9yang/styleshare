package re.stylesha.test.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "GOOD")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Good (
    @Id
    @JsonProperty("id")
    var id: Int,
    @JsonProperty("name")
    var name: String,
    @JsonProperty("provider")
    var provider: String,
    @JsonProperty("price")
    var price: Int,
    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "goodId", referencedColumnName = "id")
    @JsonProperty("options")
    var options: List<Option>,
    @JsonProperty("shipping")
    var shipping: Shipping
)
