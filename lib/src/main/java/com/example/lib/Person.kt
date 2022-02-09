package com.example.lib
fun main(){
    val p = Person()
    p.weight = 65f
    p.height = 1.7f
    print("Your BMI is ${p.getBmi()}")
}
class Person {
    var weight:Float = 0f
    var height:Float = 0f

    fun getBmi():Float{
        val bmi = weight/(height*height)
        return bmi
    }

}