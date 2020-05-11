package com.tzt.studykt


/**
 * Description:
 *
 * @author tangzhentao
 * @since 2020/4/24
 */

fun main() {
    val student = Student(23, "女")
    val student1 = Student("实时",23, "女")

    println(student1.name)

    student.show()

    chu3(listOf(21, 40, 11, 33, 78)).map {
        println(it)
    }
}

fun maxLength(fruits: List<String> ,block: (fruit: String) -> Int): String {
    if (fruits.isEmpty()) return ""
    var result = ""
    for (fruit in fruits) {
        if (block(fruit) > block(result)) {
            result = fruit
        }
    }

    return result
}

fun String.campliEnd(): String {
    if (this.isEmpty()) return ""
    val charArrayList = this.toCharArray()
    charArrayList[length - 1] = charArrayList[length - 1].toUpperCase()
    return String(charArrayList)
}

fun chu3(list: List<Int>) : List<Int> {
    return list.filter {
        it % 3 == 0
    }
}

class Student(var name: String, var age: Int, var sex: String) {

    constructor(name: String = "汤振涛") : this(name, age = 26, sex = "男" )

    constructor(age: Int = 26, sex: String = "男") : this(name = "汤振涛", age = age, sex = sex)

    fun show() {
        println("name=$name \nage=$age \nsex=$sex")
    }
}