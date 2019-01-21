package re.stylesha.test.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Embeddable

@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Shipping (
    @JsonProperty("method")
    var shippinMethod: String,
    @JsonProperty("price")
    var shippingPrice: Int,
    @JsonProperty("canBundle")
    var shippinCanBundle: Boolean
)
