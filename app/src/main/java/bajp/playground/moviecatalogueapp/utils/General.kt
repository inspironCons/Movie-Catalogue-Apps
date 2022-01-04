package bajp.playground.moviecatalogueapp.utils

import android.annotation.SuppressLint
import android.view.View
import android.widget.ProgressBar
import java.text.SimpleDateFormat
import java.util.*

object General {
    @SuppressLint("SimpleDateFormat")
    fun String.toGetYear():String{
        val date = SimpleDateFormat("MM/dd/yyyy", Locale("IND","ID")).parse(this)
        return SimpleDateFormat("yyyy").format(date as Date)
    }

    @SuppressLint("SimpleDateFormat")
    fun String.toDateFormatRelease():String{
        val date = SimpleDateFormat("MM/dd/yyyy", Locale("IND","ID")).parse(this)
        return SimpleDateFormat("dd MMM  yyyy").format(date as Date)
    }

    fun isShowComponentProgress(view:ProgressBar?,show:Boolean){
        if(show){
            view?.visibility = View.VISIBLE
        }else{
            view?.visibility = View.GONE
        }
    }
}