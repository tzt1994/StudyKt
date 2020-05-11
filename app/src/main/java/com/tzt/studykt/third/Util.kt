package com.tzt.studykt.third


/**
 * Description:
 *
 * @author tangzhentao
 * @since 2020/4/9
 */
class Util {
    fun doAction() {
        println("do action")
    }

    companion object {
        @JvmStatic
        fun doAction2() {
            println("do action 2 static")
        }
    }
}