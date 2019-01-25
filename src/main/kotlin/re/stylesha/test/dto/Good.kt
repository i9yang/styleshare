package re.stylesha.test.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
class Good {
    @JsonProperty("id")
    var id  = ""

    @JsonProperty("name")
    var name = ""

    @JsonProperty("provider")
    var provider = ""

    @JsonProperty("price")
    var price = 0

    @JsonProperty("options")
    var options = listOf<Option>()

    var shippingMethod = ""

    var shippingPrice = 0

    var shippingCanBundle = ""

    var optionId = ""
    var optionColor = ""
    var optionSize = ""
    var optionStock = 0


    @JsonProperty("shipping")
    private fun unpackNameFromNestedObject(shipping: Map<String, String>) {
        shippingMethod = shipping["method"]!!
        shippingPrice = shipping["price"]!!.toInt()
        shippingCanBundle = shipping["canBundle"]!!
    }
}
