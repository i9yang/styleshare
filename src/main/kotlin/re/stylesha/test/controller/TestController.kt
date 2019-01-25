package re.stylesha.test.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Transactional
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import re.stylesha.test.dto.Cart
import re.stylesha.test.repository.Repository

@Controller
class TestController {

    @Autowired
    lateinit var repository : Repository


    @GetMapping("/")
    fun index(modelMap : ModelMap) : String {
        modelMap["goodList"] = repository.selectGoodList()
        return "index"
    }

    @ResponseBody
    @Transactional
    @GetMapping("/insertCart", produces = ["plain/text; charset=utf8"])
    fun insertCart(cart : Cart, modelMap : ModelMap) : ResponseEntity<String>{
        var option = repository.selectOption(cart)

        return if(option.stock > 1) {
            cart.stock = -1
            repository.mergeCart(cart)
            ResponseEntity("SUCCESS", HttpStatus.OK)
        } else {
            ResponseEntity("상품 수량이 부족합니다.", HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    @GetMapping("/cart")
    fun cart(modelMap : ModelMap) : String {
        modelMap["cartList"] = repository.selectCartList()
        modelMap["cartPrice"] = repository.selectCartPrice()
        return "cart"
    }

    @ResponseBody
    @Transactional
    @GetMapping("/updateStock", produces = ["plain/text; charset=utf8"])
    fun updateCart(cart : Cart, modelMap : ModelMap) : ResponseEntity<String>{
        var option = repository.selectOptionStock(cart)
        var c = Cart()
        c.optionId = option.id
        c.goodId = option.goodId
        c.stock = cart.previousStock - cart.stock

        if(option.stock + c.stock < 0 || cart.stock < 0) {
            return ResponseEntity("0보다 작은 값은 설정 불가능합니다.", HttpStatus.INTERNAL_SERVER_ERROR)
        } else if(cart.stock == 0) {
            repository.deleteCart(cart)
        } else {
            repository.updateCart(cart)
        }


        repository.updateOption(c)
        return ResponseEntity("SUCCESS", HttpStatus.OK)
    }
}