package re.stylesha.test.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Transactional
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import re.stylesha.test.dto.Cart
import re.stylesha.test.dto.Good
import re.stylesha.test.repository.CartRepository
import re.stylesha.test.repository.GoodRepository

@Controller
class TestController {

    @Autowired
    lateinit var goodRepository : GoodRepository

    @Autowired
    lateinit var cartRepository : CartRepository

    @GetMapping("/")
    fun index(modelMap : ModelMap) : String {
        modelMap["goods"] = goodRepository.findAll()
        return "index"
    }

    @ResponseBody
    @Transactional
    @GetMapping("/insertCart")
    fun insertCart(cart : Cart, modelMap : ModelMap) : ResponseEntity<String>{
        cartRepository.save(cart)
        goodRepository.setStock(cart.goodId,  cart.optionId, -1)
        return ResponseEntity("SUCCESS", HttpStatus.OK)
    }

    @GetMapping("/cart")
    fun cart(modelMap : ModelMap) : String {
        modelMap["goods"] = goodRepository.findAll()
        return "cart"
    }
}