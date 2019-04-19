package com.test.dto

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Program {
        @Id
        var id : String = ""

        var programNm : String = ""
}