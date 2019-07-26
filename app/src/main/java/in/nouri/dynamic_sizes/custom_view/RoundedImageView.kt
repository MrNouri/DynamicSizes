package `in`.nouri.dynamic_sizes.custom_view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class RoundedImageView : AppCompatImageView {

    private var borderWidth = 4
    private var viewWidth: Int = 0
    private var viewHeight: Int = 0
    private var image: Bitmap? = null
    private var paint: Paint? = null
    private var paintBorder: Paint? = null
    private var shader: BitmapShader? = null

    constructor(context: Context) : super(context) {
        setup()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setup()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        setup()
    }

    private fun setup() {
        paint = Paint()
        paint!!.isAntiAlias = true

        paintBorder = Paint()
        setBorderColor(Color.WHITE)
        paintBorder!!.isAntiAlias = true
        this.setLayerType(LAYER_TYPE_SOFTWARE, paintBorder)

        paintBorder!!.setShadowLayer(4.0f, 0.0f, 2.0f, Color.WHITE)
    }

    fun setBorderWidth(borderWidth: Int) {
        this.borderWidth = borderWidth
        this.invalidate()
    }

    fun setBorderColor(borderColor: Int) {
        if (paintBorder != null)
            paintBorder!!.color = borderColor

        this.invalidate()
    }

    private fun loadBitmap() {
        val bitmapDrawable = this.drawable as BitmapDrawable

        if (bitmapDrawable != null)
            image = bitmapDrawable.bitmap
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        loadBitmap()

        if (image != null) {
            shader = BitmapShader(
                Bitmap.createScaledBitmap(image!!, width, height, false),
                Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP
            )
            paint!!.setShader(shader)
            val circleCenter = viewWidth / 2
            canvas.drawCircle(
                (circleCenter + borderWidth).toFloat(),
                (circleCenter + borderWidth).toFloat(),
                circleCenter + borderWidth - 4.0f,
                paintBorder
            )
            canvas.drawCircle(
                (circleCenter + borderWidth).toFloat(),
                (circleCenter + borderWidth).toFloat(), circleCenter - 4.0f, paint
            )
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = measureWidth(widthMeasureSpec)
        val height = measureHeight(heightMeasureSpec, widthMeasureSpec)

        viewWidth = width - borderWidth * 2
        viewHeight = height - borderWidth * 2

        setMeasuredDimension(width, height)
    }

    private fun measureWidth(measureSpec: Int): Int {
        var result = 0
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize
        } else {
            // Measure the text
            result = viewWidth
        }

        return result
    }

    private fun measureHeight(measureSpecHeight: Int, measureSpecWidth: Int): Int {
        var result = 0
        val specMode = MeasureSpec.getMode(measureSpecHeight)
        val specSize = MeasureSpec.getSize(measureSpecHeight)

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize
        } else {
            result = viewHeight
        }

        return result + 2
    }
}