package com.example.elmismoen26

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Color.*
import android.graphics.Color.BLUE
import android.graphics.PixelFormat
import android.net.Uri
import androidx.core.graphics.get
import androidx.core.graphics.red
import androidx.core.graphics.toColor
import java.io.File

object ImageController {
    fun selectPhotoFromGallery(activity: Activity, code: Int) {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        activity.startActivityForResult(intent, code)
    }

    fun saveImage(context: Context, id: Long, uri: Uri) {
        val file = File(context.filesDir, id.toString())
        val bytes = context.contentResolver.openInputStream(uri)?.readBytes()!!
        file.writeBytes(bytes)
    }

    fun getImageUri(context: Context, id: Long): Uri {
        val file = File(context.filesDir, id.toString())
        return if (file.exists()) Uri.fromFile(file)
        else Uri.parse(
            "android.resource://" +
                    "com.example.editorimagenes/drawable/placeholder"
        )
    }

    fun invertFilter(bitmap: Bitmap): Bitmap {
        var ancho=bitmap.width;
        var alto=bitmap.height;
        var R=0
        var G=0
        var B=0
        var A=0
var RN=0
        for(i in 0 until ancho){
            for(j in 0 until alto){
               var pixel=bitmap.getPixel(i,j)
                 R=255-Color.red(pixel)
                 G=255-Color.green(pixel)
                 B=255-Color.blue(pixel)
                bitmap.setPixel(i,j, argb(255,R,G,B))
            }
        }
        return bitmap
    }
    fun rojos(bitmap: Bitmap): Bitmap {
        var ancho=bitmap.width;
        var alto=bitmap.height;
        var R=0
        for(i in 0 until ancho){
            for(j in 0 until alto){
                var pixel=bitmap.getPixel(i,j)
                R=Color.red(pixel)
                bitmap.setPixel(i,j, argb(255,R,0,0))
            }
        }
        return bitmap
    }
    fun azules(bitmap: Bitmap): Bitmap {
        var ancho=bitmap.width;
        var alto=bitmap.height;
        var B=0
        for(i in 0 until ancho){
            for(j in 0 until alto){
                var pixel=bitmap.getPixel(i,j)
                B=Color.blue(pixel)
                bitmap.setPixel(i,j, argb(255,0,0,B))
            }
        }
        return bitmap
    }
    fun verdes(bitmap: Bitmap): Bitmap {
        var ancho=bitmap.width;
        var alto=bitmap.height;
        var G=0
        for(i in 0 until ancho){
            for(j in 0 until alto){
                var pixel=bitmap.getPixel(i,j)
                G=Color.green(pixel)
                bitmap.setPixel(i,j, argb(255,0,G,0))
            }
        }
        return bitmap
    }
    fun grises(bitmap: Bitmap): Bitmap {
        var ancho=bitmap.width;
        var alto=bitmap.height;
        var Gris=0

        for(i in 0 until ancho){
            for(j in 0 until alto){
                var pixel=bitmap.getPixel(i,j)
                Gris=(Color.red(pixel)*0.299+
                 Color.green(pixel)*0.587+
                Color.blue(pixel)*0.114).toInt()
                bitmap.setPixel(i,j, argb(255,Gris,Gris,Gris))
            }
        }
        return bitmap
    }
    fun gamma(bitmap: Bitmap,gamma:Int): Bitmap {
        var ancho=bitmap.width;
        var alto=bitmap.height;
        var R=0
        var G=0
        var B=0
        var redGamma=IntArray(256)
        var greenGamma=IntArray(256)
        var blueGamma=IntArray(256)
        for(i in 0 until 256){
           redGamma[i]= Math.min(255,((255.0*Math.pow(i/255.0,1.0/gamma))+0.5).toInt())
            greenGamma[i]=Math.min(255,((255.0*Math.pow(i/255.0,1.0/gamma))+0.5).toInt())
            blueGamma[i]=Math.min(255,((255.0*Math.pow(i/255.0,1.0/gamma))+0.5).toInt())
        }
        for(i in 0 until ancho){
            for(j in 0 until alto){
                var pixel=bitmap.getPixel(i,j)
                R=Color.red(pixel)
                G=Color.green(pixel)
                B=Color.blue(pixel)
                bitmap.setPixel(i,j, argb(255,redGamma[R],greenGamma[G],
                    blueGamma[B]))

            }}
        return bitmap
    }
}