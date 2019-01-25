package re.stylesha.test.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
class Option  {
    @JsonProperty("id")
    var id: String = ""
    @JsonProperty("color")
    var color: String = ""
    @JsonProperty("size")
    var size: String = ""
    @JsonProperty("stock")
    var stock: Int = 0
    var goodId : String = ""
}
