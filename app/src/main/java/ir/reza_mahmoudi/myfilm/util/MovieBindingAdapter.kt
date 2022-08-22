package ir.reza_mahmoudi.myfilm.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

class MovieBindingAdapter {
    companion object {
        @BindingAdapter("loadImage")
        @JvmStatic
        fun loadImage(imageView: ImageView, imageUrl: String) {
            val progressDrawable = getProgressDrawable(imageView.context)
            imageView.loadImage(imageUrl, progressDrawable)
        }
        @BindingAdapter("setDoubleToTextView")
        @JvmStatic
        fun setDoubleToTextView(textView: TextView, text: Double) {
            textView.text = text.toString()
        }
    }
}