package re.stylesha.test.repository

import org.springframework.stereotype.Repository
import re.stylesha.test.dto.Good
import org.apache.ibatis.session.SqlSession
import org.springframework.beans.factory.annotation.Autowired
import re.stylesha.test.dto.Cart
import re.stylesha.test.dto.Option

@Repository
class Repository  {
    @Autowired
    private lateinit var sqlSession: SqlSession

    fun selectGoodList() : List<Good> {
        return sqlSession.selectList<Good>("re.stylesha.test.selectGoodList")
    }

    fun selectCartList() : List<Cart> {
        return sqlSession.selectList<Cart>("re.stylesha.test.selectCartList")
    }

    fun selectOption(cart : Cart): Option {
        return sqlSession.selectOne<Option>("re.stylesha.test.selectOption", cart)
    }

    fun mergeCart(cart: Cart) {
        var cartResult = sqlSession.selectOne<Cart>("re.stylesha.test.selectCart", cart)

        if(cartResult != null) {
            sqlSession.update("re.stylesha.test.updateCartByGoodIdOptionID", cart)
        } else {
            sqlSession.insert("re.stylesha.test.insertCart", cart)
        }

        updateOption(cart)
    }

    fun updateOption(cart: Cart){
        sqlSession.update("re.stylesha.test.updateOption", cart)
    }

    fun insertGood(good : Good) {
        sqlSession.insert("re.stylesha.test.insertGood", good)
        for(option in good.options) {
            this.insertOption(option)
        }
    }

    fun insertOption(option : Option){
        sqlSession.insert("re.stylesha.test.insertOption", option)
    }

    fun selectCartPrice(): Int{
        return sqlSession.selectOne<Int>("re.stylesha.test.selectCartPrice")
    }

    fun deleteCart(cart: Cart) {
        sqlSession.delete("re.stylesha.test.deleteCart", cart)
    }

    fun updateCart(cart: Cart) {
        sqlSession.update("re.stylesha.test.updateCart", cart)
    }

    fun selectOptionStock(cart: Cart): Option {
        return sqlSession.selectOne<Option>("re.stylesha.test.selectOptionStock", cart)
    }
}

