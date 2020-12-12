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
    fun smoothing(bitmap: Bitmap): Bitmap {
        var ancho=bitmap.width;
        var alto=bitmap.height;
        var bitmap2:Bitmap= Bitmap.createBitmap(ancho,alto,Bitmap.Config.ARGB_8888)
        var R1=0
        var R2=0
        var R3=0
        var R4=0
        var R5=0
        var R6=0
        var R7=0
        var R8=0
        var R9=0
        var B1=0
        var B2=0
        var B3=0
        var B4=0
        var B5=0
        var B6=0
        var B7=0
        var B8=0
        var B9=0
        var G1=0
        var G2=0
        var G3=0
        var G4=0
        var G5=0
        var G6=0
        var G7=0
        var G8=0
        var G9=0
        var RP=0
        var GP=0
        var BP=0
        for(i in 4 until ancho-4){
            for(j in 4 until alto-4){
                var pixel=bitmap.getPixel(i,j)
              R1=Color.red(pixel)
                G1=Color.green(pixel)
                B1=Color.blue(pixel)
                var pixelTL=bitmap.getPixel(i-4,j-4)
                R2=Color.red(pixelTL)
                G2=Color.green(pixelTL)
                B2=Color.blue(pixelTL)
                var pixelT=bitmap.getPixel(i,j-4)
                R3=Color.red(pixelT)
                G3=Color.green(pixelT)
                B3=Color.blue(pixelT)
                var pixelTR=bitmap.getPixel(i+4,j-4)
                R4=Color.red(pixelTR)
                G4=Color.green(pixelTR)
                B4=Color.blue(pixelTR)
                var pixelR=bitmap.getPixel(i+4,j)
                R5=Color.red(pixelR)
                G5=Color.green(pixelR)
                B5=Color.blue(pixelR)
                var pixelBR=bitmap.getPixel(i+4,j+4)
                R6=Color.red(pixelBR)
                G6=Color.green(pixelBR)
                B6=Color.blue(pixelBR)
                var pixelB=bitmap.getPixel(i,j+4)
                R7=Color.red(pixelB)
                G7=Color.green(pixelB)
                B7=Color.blue(pixelB)
                var pixelBL=bitmap.getPixel(i-4,j+4)
                R8=Color.red(pixelBL)
                G8=Color.green(pixelBL)
                B8=Color.blue(pixelBL)
                var pixelL=bitmap.getPixel(i-4,j)
                R9=Color.red(pixelL)
                G9=Color.green(pixelL)
                B9=Color.blue(pixelL)
                RP=(R1+R2+R3+R4+R5+R6+R7+R8+R9)/9
                GP=(G1+G2+G3+G4+G5+G6+G7+G8+G9)/9
                BP=(B1+B2+B3+B4+B5+B6+B7+B8+B9)/9
                bitmap2.setPixel(i,j, argb(255,RP,GP,BP))
            }
        }
        return bitmap2
    }
    fun gaussian(bitmap: Bitmap): Bitmap {
        var ancho=bitmap.width;
        var alto=bitmap.height;
        var bitmap2:Bitmap= Bitmap.createBitmap(ancho,alto,Bitmap.Config.ARGB_8888)
        var R1=0
        var R2=0
        var R3=0
        var R4=0
        var R5=0
        var R6=0
        var R7=0
        var R8=0
        var R9=0
        var B1=0
        var B2=0
        var B3=0
        var B4=0
        var B5=0
        var B6=0
        var B7=0
        var B8=0
        var B9=0
        var G1=0
        var G2=0
        var G3=0
        var G4=0
        var G5=0
        var G6=0
        var G7=0
        var G8=0
        var G9=0
        var RP=0
        var GP=0
        var BP=0
        for(i in 4 until ancho-4){
            for(j in 4 until alto-4){
                var pixel=bitmap.getPixel(i,j)
                R1=Color.red(pixel)
                G1=Color.green(pixel)
                B1=Color.blue(pixel)
                var pixelTL=bitmap.getPixel(i-4,j-4)
                R2=Color.red(pixelTL)
                G2=Color.green(pixelTL)
                B2=Color.blue(pixelTL)
                var pixelT=bitmap.getPixel(i,j-4)
                R3=Color.red(pixelT)
                G3=Color.green(pixelT)
                B3=Color.blue(pixelT)
                var pixelTR=bitmap.getPixel(i+4,j-4)
                R4=Color.red(pixelTR)
                G4=Color.green(pixelTR)
                B4=Color.blue(pixelTR)
                var pixelR=bitmap.getPixel(i+4,j)
                R5=Color.red(pixelR)
                G5=Color.green(pixelR)
                B5=Color.blue(pixelR)
                var pixelBR=bitmap.getPixel(i+4,j+4)
                R6=Color.red(pixelBR)
                G6=Color.green(pixelBR)
                B6=Color.blue(pixelBR)
                var pixelB=bitmap.getPixel(i,j+4)
                R7=Color.red(pixelB)
                G7=Color.green(pixelB)
                B7=Color.blue(pixelB)
                var pixelBL=bitmap.getPixel(i-4,j+4)
                R8=Color.red(pixelBL)
                G8=Color.green(pixelBL)
                B8=Color.blue(pixelBL)
                var pixelL=bitmap.getPixel(i-4,j)
                R9=Color.red(pixelL)
                G9=Color.green(pixelL)
                B9=Color.blue(pixelL)
                RP=(R1+R2+R3+R4+R5+R6+R7+R8+R9)/9
                GP=(G1+G2+G3+G4+G5+G6+G7+G8+G9)/9
                BP=(B1+B2+B3+B4+B5+B6+B7+B8+B9)/9
                bitmap2.setPixel(i,j, argb(255,RP,GP,BP))
            }
        }
        return bitmap2
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