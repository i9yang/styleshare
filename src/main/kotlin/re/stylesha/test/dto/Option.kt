package re.stylesha.test.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "OPTION")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Option (
    @Id
    @JsonProperty("id")
    var id: Int,
    @JsonProperty("color")
    var color: String,
    @JsonProperty("size")
    var size: String,
    @JsonProperty("stock")
    var stock: Int
) {
    var goodId : Int = 0
}
