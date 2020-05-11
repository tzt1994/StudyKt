package com.tzt.studykt.six

import java.lang.StringBuilder


/**
 * Description:
 *
 * @author tangzhentao
 * @since 2020/4/9
 */

fun num1AndNum2(num1: Int, num2: Int, operator: (Int, Int) -> Int) : Int {
    return operator(num1, num2)
}

/**
 * inline 内联函数，完全消除lambda表达式所带来的的运行时开销
 * oninline 非内联函数，可以自由的传递给其他任何函数，因为它是一个真实的参数。
 *          内联的函数类型只允许传递给另外一个内联函数。
 *          内联和非内联的最重要区别就是 内联函数所引用lambda表达式中可以使用return进行函数返回
 *          非内涵函数只能进行局部返回
 *
 * crossinline 保证内联函数的lambda表达式一定不会使用return关键字。
 *          但是可以是return@printString进行局部返回
 */
inline fun StringBuilder.build(block: StringBuilder.() -> Unit) : StringBuilder {
    block()
    return this
}

fun printString(str: String, block: (String) -> Unit) {
    println("printString start")
    block(str)
    println("printString end")
}

/**
 * 非内联函数只能局部返回
 * 看到的打印结果如下
 *      printString start
 *      lambda start
 *      printString end
 *
 */
//printString("") { s ->
//    println("lambda start")
//    if (s.isEmpty) return@printString
//    println(s)
//    println("lambda end")
//}

/**
 * 内联函数可以使用return进行函数返回
 * 打印结果：
 *      printString start
 *      lambda start
 */
//printString("") { s ->
//    println("lambda start")
//    if (s.isEmpty) return
//    println(s)
//    println("lambda end")
//}
