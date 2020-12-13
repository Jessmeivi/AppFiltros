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
import androidx.core.util.rangeTo
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
    fun sobell(bitmap: Bitmap): Bitmap {
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
        for(i in 1 until ancho-1){
            for(j in 1 until alto-1){
                var pixelTL=bitmap.getPixel(i-1,j-1)
                R2=Color.red(pixelTL)*1
                G2=Color.green(pixelTL)*1
                B2=Color.blue(pixelTL)*1
                var pixelT=bitmap.getPixel(i,j-1)
                R3=Color.red(pixelT)*2
                G3=Color.green(pixelT)*2
                B3=Color.blue(pixelT)*2
                var pixelTR=bitmap.getPixel(i+1,j-1)
                R4=Color.red(pixelTR)*1
                G4=Color.green(pixelTR)*1
                B4=Color.blue(pixelTR)*1
                var pixelBR=bitmap.getPixel(i+1,j+1)
                R6=Color.red(pixelBR)*(-1)
                G6=Color.green(pixelBR)*(-1)
                B6=Color.blue(pixelBR)*(-1)
                var pixelB=bitmap.getPixel(i,j+1)
                R7=Color.red(pixelB)*(-2)
                G7=Color.green(pixelB)*(-2)
                B7=Color.blue(pixelB)*(-2)
                var pixelBL=bitmap.getPixel(i-1,j+1)
                R8=Color.red(pixelBL)*(-1)
                G8=Color.green(pixelBL)*(-1)
                B8=Color.blue(pixelBL)*(-1)
                RP=(R2+R3+R4+R6+R7+R8)+30
                GP=(G2+G3+G4+G6+G7+G8)+30
                BP=(B2+B3+B4+B6+B7+B8)+30
                bitmap2.setPixel(i,j, argb(255,RP,GP,BP))
            }
        }
        return bitmap2
    }
    fun repujado(bitmap: Bitmap): Bitmap {
        var ancho=bitmap.width;
        var alto=bitmap.height;
        var radio=5
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
                var pixelTL=bitmap.getPixel(i-1,j-1)
                R2=Color.red(pixelTL)*-2
                G2=Color.green(pixelTL)*-2
                B2=Color.blue(pixelTL)*-2
                var pixelT=bitmap.getPixel(i,j-1)
                R3=Color.red(pixelT)*-1
                G3=Color.green(pixelT)*-1
                B3=Color.blue(pixelT)*-1
                var pixelR=bitmap.getPixel(i+1,j)
                R5=Color.red(pixelR)
                G5=Color.green(pixelR)
                B5=Color.blue(pixelR)
                var pixelBR=bitmap.getPixel(i+1,j+1)
                R6=Color.red(pixelBR)*2
                G6=Color.green(pixelBR)*2
                B6=Color.blue(pixelBR)*2
                var pixelB=bitmap.getPixel(i,j+1)
                R7=Color.red(pixelB)
                G7=Color.green(pixelB)
                B7=Color.blue(pixelB)
                var pixelL=bitmap.getPixel(i-1,j)
                R9=Color.red(pixelL)*-1
                G9=Color.green(pixelL)*-1
                B9=Color.blue(pixelL)*-1
                RP=(R1+R2+R3+R4+R5+R6+R7+R8+R9)
                GP=(G1+G2+G3+G4+G5+G6+G7+G8+G9)
                BP=(B1+B2+B3+B4+B5+B6+B7+B8+B9)
                bitmap2.setPixel(i,j, argb(255,RP,GP,BP))
            }
        }
        return bitmap2
    }
    fun smoothing(bitmap: Bitmap): Bitmap {
        var ancho=bitmap.width;
        var alto=bitmap.height;
        var radio=5
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
              R1=Color.red(pixel)*4
                G1=Color.green(pixel)*4
                B1=Color.blue(pixel)*4
                var pixelTL=bitmap.getPixel(i-4,j-4)
                R2=Color.red(pixelTL)
                G2=Color.green(pixelTL)
                B2=Color.blue(pixelTL)
                var pixelT=bitmap.getPixel(i,j-4)
                R3=Color.red(pixelT)*2
                G3=Color.green(pixelT)*2
                B3=Color.blue(pixelT)*2
                var pixelTR=bitmap.getPixel(i+4,j-4)
                R4=Color.red(pixelTR)
                G4=Color.green(pixelTR)
                B4=Color.blue(pixelTR)
                var pixelR=bitmap.getPixel(i+4,j)
                R5=Color.red(pixelR)*2
                G5=Color.green(pixelR)*2
                B5=Color.blue(pixelR)*2
                var pixelBR=bitmap.getPixel(i+4,j+4)
                R6=Color.red(pixelBR)
                G6=Color.green(pixelBR)
                B6=Color.blue(pixelBR)
                var pixelB=bitmap.getPixel(i,j+4)
                R7=Color.red(pixelB)*2
                G7=Color.green(pixelB)*2
                B7=Color.blue(pixelB)*2
                var pixelBL=bitmap.getPixel(i-4,j+4)
                R8=Color.red(pixelBL)
                G8=Color.green(pixelBL)
                B8=Color.blue(pixelBL)
                var pixelL=bitmap.getPixel(i-4,j)
                R9=Color.red(pixelL)*2
                G9=Color.green(pixelL)*2
                B9=Color.blue(pixelL)*2
                RP=(R1+R2+R3+R4+R5+R6+R7+R8+R9)/16
                GP=(G1+G2+G3+G4+G5+G6+G7+G8+G9)/16
                BP=(B1+B2+B3+B4+B5+B6+B7+B8+B9)/16
                bitmap2.setPixel(i,j, argb(255,RP,GP,BP))
            }
        }
        return bitmap2
    }
    fun pixel(bitmap: Bitmap): Bitmap {
        var ancho=bitmap.width;
        var alto=bitmap.height;
        var bitmap2:Bitmap= Bitmap.createBitmap(ancho,alto,Bitmap.Config.ARGB_8888)
        var R1=0
        var B1=0
        var G1=0
        var anchopixel=(ancho/25).toInt()
        var altopixel=alto/25
        var Mas=1
        var MAN=1
        var j=0
        var i=0

        while( j<alto){
            while( i< ancho ){
                var pixel=bitmap.getPixel(i,j)
                R1=Color.red(pixel)
                G1=Color.green(pixel)
                B1=Color.blue(pixel)
              for (y in j until altopixel*MAN ) {
                for ( x in i until anchopixel*Mas) {
                   bitmap2.setPixel(x,y, argb(255, R1, G1, B1))
                    }
                }
                i+=anchopixel
              Mas+=1
                if (Mas==26)
                    Mas=25;
            }
            Mas=1
            i=0
            j+=altopixel
            MAN+=1
        }
        return bitmap2
    }
    fun transparencia(bitmap: Bitmap): Bitmap {
        var ancho=bitmap.width;
        var alto=bitmap.height;
        for(i in 4 until ancho-4){
            for(j in 4 until alto-4){
                var pixel=bitmap.getPixel(i,j)
               var R1=Color.red(pixel)
                var G1=Color.green(pixel)
               var  B1=Color.blue(pixel)
               var A1=Color.alpha(pixel)
                bitmap.setPixel(i,j, argb(A1-50,R1,G1,B1))
            }
        }
        return bitmap
    }
    fun edge(bitmap: Bitmap): Bitmap {
        var ancho=bitmap.width;
        var alto=bitmap.height;
        var radio=5
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
        for(i in 2 until ancho-2){
            for(j in 2 until alto-2){

                var pixelTL=bitmap.getPixel(i-1,j-1)
                R2=Color.red(pixelTL)*1
                G2=Color.green(pixelTL)*1
                B2=Color.blue(pixelTL)*1
                var pixelT=bitmap.getPixel(i,j-1)
                R3=Color.red(pixelT)*1
                G3=Color.green(pixelT)*1
                B3=Color.blue(pixelT)*1
                var pixelTR=bitmap.getPixel(i+1,j-1)
                R4=Color.red(pixelTR)*1
                G4=Color.green(pixelTR)*1
                B4=Color.blue(pixelTR)*1
                var pixelBR=bitmap.getPixel(i+1,j+1)
                R6=Color.red(pixelBR)*-1
                G6=Color.green(pixelBR)*-1
                B6=Color.blue(pixelBR)*-1
                var pixelB=bitmap.getPixel(i,j+1)
                R7=Color.red(pixelB)*-1
                G7=Color.green(pixelB)*-1
                B7=Color.blue(pixelB)*-1
                var pixelBL=bitmap.getPixel(i-1,j+1)
                R8=Color.red(pixelBL)*-1
                G8=Color.green(pixelBL)*-1
                B8=Color.blue(pixelBL)*-1
                RP=(R2+R3+R4+R6+R7+R8)+127
                GP=(G2+G3+G4+G6+G7+G8)+127
                BP=(B2+B3+B4+B6+B7+B8)+127
                bitmap2.setPixel(i,j, argb(255,RP,GP,BP))
            }
        }
        return bitmap2
    }

    fun embossing(bitmap: Bitmap): Bitmap {
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
        for(i in 2 until ancho-2){
            for(j in 2 until alto-2){
                var pixel=bitmap.getPixel(i,j)
                R1=Color.red(pixel)*4
                G1=Color.green(pixel)*4
                B1=Color.blue(pixel)*4
                var pixelTL=bitmap.getPixel(i-2,j-2)
                R2=Color.red(pixelTL)*(-1)
                G2=Color.green(pixelTL)*(-1)
                B2=Color.blue(pixelTL)*(-1)
                var pixelTR=bitmap.getPixel(i+2,j-2)
                R4=Color.red(pixelTR)*(-1)
                G4=Color.green(pixelTR)*(-1)
                B4=Color.blue(pixelTR)*(-1)
                var pixelBR=bitmap.getPixel(i+2,j+2)
                R6=Color.red(pixelBR)*(-1)
                G6=Color.green(pixelBR)*(-1)
                B6=Color.blue(pixelBR)*(-1)
                var pixelBL=bitmap.getPixel(i-2,j+2)
                R8=Color.red(pixelBL)*(-1)
                G8=Color.green(pixelBL)*(-1)
                B8=Color.blue(pixelBL)*(-1)
                RP=(R1+R2+R4+R6+R8+R9)/1+127
                GP=(G1+G2+G4+G6+G8+G9)/1+127
                BP=(B1+B2+B4+B6+B8+B9)/1+127
                bitmap2.setPixel(i,j, argb(255,RP,GP,BP))
            }
        }
        return bitmap2
    }
    fun mean(bitmap: Bitmap): Bitmap {
        var ancho=bitmap.width;
        var alto=bitmap.height;
        var radio=5
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
        for(i in 2 until ancho-2){
            for(j in 2 until alto-2){
                var pixel=bitmap.getPixel(i,j)
                R1=Color.red(pixel)*9
                G1=Color.green(pixel)*9
                B1=Color.blue(pixel)*9
                var pixelTL=bitmap.getPixel(i-1,j-1)
                R2=Color.red(pixelTL)*-1
                G2=Color.green(pixelTL)*-1
                B2=Color.blue(pixelTL)*-1
                var pixelT=bitmap.getPixel(i,j-1)
                R3=Color.red(pixelT)*-1
                G3=Color.green(pixelT)*-1
                B3=Color.blue(pixelT)*-1
                var pixelTR=bitmap.getPixel(i+1,j-1)
                R4=Color.red(pixelTR)*-1
                G4=Color.green(pixelTR)*-1
                B4=Color.blue(pixelTR)*-1
                var pixelR=bitmap.getPixel(i+1,j)
                R5=Color.red(pixelR)*-1
                G5=Color.green(pixelR)*-1
                B5=Color.blue(pixelR)*-1
                var pixelBR=bitmap.getPixel(i+1,j+1)
                R6=Color.red(pixelBR)*-1
                G6=Color.green(pixelBR)*-1
                B6=Color.blue(pixelBR)*-1
                var pixelB=bitmap.getPixel(i,j+1)
                R7=Color.red(pixelB)*-1
                G7=Color.green(pixelB)*-1
                B7=Color.blue(pixelB)*-1
                var pixelBL=bitmap.getPixel(i-1,j+1)
                R8=Color.red(pixelBL)*-1
                G8=Color.green(pixelBL)*-1
                B8=Color.blue(pixelBL)*-1
                var pixelL=bitmap.getPixel(i-1,j)
                R9=Color.red(pixelL)*-1
                G9=Color.green(pixelL)*-1
                B9=Color.blue(pixelL)*-1
                RP=(R1+R2+R3+R4+R5+R6+R7+R8+R9)
                GP=(G1+G2+G3+G4+G5+G6+G7+G8+G9)
                BP=(B1+B2+B3+B4+B5+B6+B7+B8+B9)
                bitmap2.setPixel(i,j, argb(255,RP,GP,BP))
            }
        }
        return bitmap2
    }
    fun sharpen(bitmap: Bitmap): Bitmap {
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
                R1=Color.red(pixel)*11
                G1=Color.green(pixel)*11
                B1=Color.blue(pixel)*11

                var pixelT=bitmap.getPixel(i,j-1)
                R3=Color.red(pixelT)*(-2)
                G3=Color.green(pixelT)*(-2)
                B3=Color.blue(pixelT)*(-2)
                var pixelR=bitmap.getPixel(i+1,j)
                R5=Color.red(pixelR)*(-2)
                G5=Color.green(pixelR)*(-2)
                B5=Color.blue(pixelR)*(-2)
                var pixelB=bitmap.getPixel(i,j+1)
                R7=Color.red(pixelB)*(-2)
                G7=Color.green(pixelB)*(-2)
                B7=Color.blue(pixelB)*(-2)

                var pixelL=bitmap.getPixel(i-1,j)
                R9=Color.red(pixelL)*(-2)
                G9=Color.green(pixelL)*(-2)
                B9=Color.blue(pixelL)*(-2)
                RP=(R1+R3+R5+R7+R9)/3
                GP=(G1+G3+G5+G7+G9)/3
                BP=(B1+B3+B5+B7+B9)/3
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