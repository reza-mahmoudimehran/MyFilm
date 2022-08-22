package ir.reza_mahmoudi.myfilm.util

import android.content.Context
import android.util.Log
import android.widget.Toast
import ir.reza_mahmoudi.myfilm.BuildConfig


fun showLog(tag: String, msg: String){
    if(BuildConfig.DEBUG){
        Log.e(tag,msg)
    }
}
