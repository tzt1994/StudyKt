package com.tzt.studykt.customView.paint.widget.color

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tzt.studykt.R
import kotlin.math.max

/**
 * Description: PorterDuffXfermode
 *
 *
 * @author tangzhentao
 * @since 2020/5/6
 */
class PorterDuffXfermodeView: View{
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var model =  PorterDuff.Mode.SRC

    constructor(context: Context, porterDuffModel: PorterDuff.Mode): this(context, null) {
        this.model = porterDuffModel
    }

    constructor(context: Context): this(context, null)

    constructor(context: Context, attributeSet: AttributeSet?): this(context, attributeSet, 0)

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int): super(context, attributeSet, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val bitmapDst = BitmapFactory.decodeResource(resources, R.mipmap.batman)
        val bitmapSrc = BitmapFactory.decodeResource(resources, R.mipmap.batman_logo)
        val size = height * 1f
        val saved = canvas?.saveLayer(null, null, Canvas.ALL_SAVE_FLAG)
        canvas?.drawBitmap(bitmapSrc, null, RectF((width - size) / 2f, 0f, (width - size) / 2f + size, size), paint)
        paint.xfermode = PorterDuffXfermode(model)
        canvas?.drawBitmap(bitmapDst, null, RectF((width - size) / 2f, 0f, (width - size) / 2f + size, size), paint)
        paint.xfermode = null
        canvas?.restoreToCount(saved?: 0)
    }
}