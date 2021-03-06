package com.tzt.studykt.customView.paint.widget.color.colorFilter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tzt.studykt.R

/**
 * Description: PorterDuffColorFilterView颜色过滤器
 *
 *
 * @author tangzhentao
 * @since 2020/5/6
 */
class PorterDuffColorFilterView: View{
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var model =  PorterDuff.Mode.SRC

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#333333")
        textSize = 36f
        textAlign = Paint.Align.CENTER
    }

    constructor(context: Context, porterDuffModel: PorterDuff.Mode): this(context, null) {
        this.model = porterDuffModel
    }

    constructor(context: Context): this(context, null)

    constructor(context: Context, attributeSet: AttributeSet?): this(context, attributeSet, 0)

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int): super(context, attributeSet, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.batman)
        val size = width / 3f
        canvas?.drawBitmap(bitmap, null, RectF(50f, 50f, size + 50f, size + 50f), null)
        canvas?.drawText("原图", size / 2 + 50f, size + 150f, textPaint)
        paint.colorFilter = PorterDuffColorFilter(0xff113000.toInt(), model)
        canvas?.drawBitmap(bitmap, null, RectF(size + 150f, 50f, size * 2 + 150f, size + 50f), paint)
        canvas?.drawText("转化后", size / 2 * 3 + 150f, size + 150f, textPaint)
    }
}