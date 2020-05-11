package com.tzt.studykt.four


/**
 * Description:
 *
 * @author tangzhentao
 * @since 2020/4/9
 */
class Msg(val content: String, val type: Int) {
    companion object{
        const val TYPE_RECEIVED = 0
        const val TYPE_SEND = 1
    }
}