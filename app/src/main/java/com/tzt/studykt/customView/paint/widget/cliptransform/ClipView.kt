package com.tzt.studykt.customView.paint.widget.cliptransform

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tzt.studykt.R
import kotlin.math.min


/**
 * Description: 范围裁剪
 *
 * @author tangzhentao
 * @since 2020/5/6
 */
class ClipView: View{
    companion object {
        const val CLIP_RECT = 1
        const val CLIP_PATH = 2
    }

    private var type = CLIP_RECT

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.LEFT
        textSize = 36f
        style = Paint.Style.FILL
        color = Color.BLACK
    }

    constructor(context: Context, type: Int = CLIP_RECT): this(context, null) {
        this.type = type
    }

    constructor(context: Context): this(context, null)

    constructor(context: Context, attributeSet: AttributeSet?): this(context, attributeSet, 0)

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int): super(context, attributeSet, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val size = min(width / 2f, height * 1f) / 4 * 3
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.maps)
        val srcRectf = RectF(width / 4f - size / 2, height / 2f - size / 2f, width / 4f +  size / 2, height / 2f + size / 2f)
        val dstRectf = RectF(width / 4f * 3 - size / 2, height / 2f - size / 2f, width / 4f * 3 +  size / 2, height / 2f + size / 2f)
        when(type) {
            CLIP_RECT -> {
                // 矩形裁剪
                canvas?.drawBitmap(bitmap, null, srcRectf, null)

                canvas?.drawBitmap(bitmap, null, dstRectf, null)
            }
            CLIP_PATH -> {
                // 路径裁剪
            }
        }
    }
}