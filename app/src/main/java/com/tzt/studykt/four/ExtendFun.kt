package com.tzt.studykt.four


/**
 * Description: 扩展函数
 *
 * @author tangzhentao
 * @since 2020/4/9
 */

fun String.lettersCount() : Int {
    var count = 0
    for (char in this) {
        count ++
    }

    return count
}