package com.tzt.studykt.four


/**
 * Description:
 *
 * @author tangzhentao
 * @since 2020/4/9
 */
class Money(val value: Int) {

    operator fun plus(money: Money): Money {
        val sum = value + money.value;
        return Money(sum)
    }
}