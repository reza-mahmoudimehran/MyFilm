package ir.reza_mahmoudi.myfilm.util

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ir.reza_mahmoudi.myfilm.BuildConfig
import ir.reza_mahmoudi.myfilm.R


fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

fun ImageView.loadImage(url: String?, progressDrawable: CircularProgressDrawable) {
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.drawable.ic_damaged_image)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}

fun showLog(tag: String, msg: String){
    if(BuildConfig.DEBUG){
        Log.e(tag,msg)
    }
}

fun Context.showToast(msg: String){
    Toast.makeText(this,msg, Toast.LENGTH_LONG).show()
}