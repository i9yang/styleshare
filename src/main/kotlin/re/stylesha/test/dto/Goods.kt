package re.stylesha.test.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class Goods(
    @JsonProperty("goods")
    var goods : List<Good>
)