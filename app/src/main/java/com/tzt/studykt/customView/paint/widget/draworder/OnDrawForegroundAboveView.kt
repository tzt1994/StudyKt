package com.tzt.studykt.customView.paint.widget.draworder

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView


/**
 * Description: onDrawForegeound()上面
 * @author tangzhentao
 * @since 2020/5/6
 */
class OnDrawForegroundAboveView: AppCompatImageView {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        style = Paint.Style.FILL
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        textSize = 36f
    }

    constructor(context: Context): this(context, null)

    constructor(context: Context, attributeSet: AttributeSet?): this(context, attributeSet, 0)

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int): super(context, attributeSet, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        val textwith = textPaint.measureText("New")
        val textheight = textPaint.fontMetrics.bottom - textPaint.fontMetrics.top
        canvas?.drawRect(0f, 100f, textwith * 2, textheight + 100f, paint)
        canvas?.drawText("New", 20f, textheight + 100f - textPaint.fontMetrics.bottom, textPaint)
        super.onDraw(canvas)
    }
}