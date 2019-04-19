package com.test.dto

import javax.persistence.*

@Entity
class Region {
        @Id
        var id : String = ""

        var regionNm : String  = ""

        @OneToMany(cascade = [CascadeType.ALL])
        @JoinColumn(name = "program", referencedColumnName = "id")
        var programs: List<Program> = listOf()

        override fun toString(): String {
                return "Region(id='$id', regionNm='$regionNm', programs=$programs)"
        }
}