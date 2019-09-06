package com.zeus.cursoholamundo

/*class Sicansios{
    var color: String = ""

    constructor(color: String){
        this.color = color
    }
}*/

/*class Sicansios2(color: String){
    var color: String
    init {
        this.color = color
    }

    lateinit var altura: String
    val otro : String = ""
    var mas : String? = null
    constructor(color: String, altura: String): this(color){
        this.altura = String
    }
}*/

/** open se usa para hacer esta clase heredable **/
open class Sicansios(var color: String, val altura: String = "10"){

    fun ahhh(): String{
        return "AAAHHH!!!"
    }
    fun a2() = "AAAAH!!!"

    val a3 = { "AAAHH!!" }

    val a4: (String, Int) -> String = { s, i ->
        "AAAHH!"
    }

    fun start( onClic: (nombre: String,edad: Int)-> Boolean, onAcept: ()->Unit){
    }
}