package com.example.elmismoen26


import android.app.Activity
import android.content.Intent
import android.graphics.*
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap

private lateinit var img:ImageView;
private lateinit var boton:Button;
private lateinit var boton2:Button;
private lateinit var boton3:Button;
private lateinit var rojo:Button;
private lateinit var azul:Button;
private lateinit var verde:Button;
private lateinit var brillo50:Button;
private lateinit var brillo150:Button;
private lateinit var gris:Button;
private lateinit var bitmap: Bitmap;
private lateinit var bitmap2: Bitmap;
private lateinit var brillo:SeekBar;
private lateinit var contraste:SeekBar;
class MainActivity : AppCompatActivity() {
    private val SELECT_ACTIVITY = 50

    private var imageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img = findViewById(R.id.image)
        boton = findViewById(R.id.button)
        boton2 = findViewById(R.id.button2)
        boton3 = findViewById(R.id.button3)
        rojo=findViewById(R.id.rojo)
        azul=findViewById(R.id.azul)
        verde=findViewById(R.id.verde)
        gris=findViewById(R.id.gris)
        brillo=findViewById(R.id.seekBarBrightness)
        contraste=findViewById(R.id.seekBarContrast)


            brillo.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    val brightness = progress.toFloat() - 200
                    val contrast = contraste.progress.toFloat() / 10F
                    img.setImageBitmap(
                        setBrightnessContrast(brightness, contrast,img.drawable.toBitmap(700, 700, null))
                    )
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                }
            })
            contraste.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    val brightness = brillo.progress.toFloat() - 200
                    val contrast = progress.toFloat() / 10F
                    img.setImageBitmap(
                        setBrightnessContrast(brightness, contrast,img.drawable.toBitmap(700
                            , 700, null))
                    )
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                }
            })



        img.setOnClickListener {
            ImageController.selectPhotoFromGallery(this, SELECT_ACTIVITY)

        }
        boton.setOnClickListener {
            //bitmap=
            imageUri?.let {
                ImageController.saveImage(
                        this, 1,
                        it
                )

            }
        }
        boton2.setOnClickListener {
            bitmap = BitmapFactory.decodeFile(ImageController.getImageUri(this, 1).path)
            img.setImageBitmap(bitmap)
        }
        boton3.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.invertFilter(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
        }
        rojo.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.rojos(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
        }
        azul.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.azules(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
        }
        verde.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.verdes(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
        }
        gris.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.grises(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when {
            requestCode == SELECT_ACTIVITY && resultCode == Activity.RESULT_OK -> {
                imageUri = data!!.data
                img.setImageURI(imageUri)
            }
        }
    }

    fun setBrightnessContrast(
        brightness:Float = 0.0F,
        contrast:Float = 1.0F,bitmap: Bitmap
    ):Bitmap?{

        val paint = Paint()

        // brightness -200..200, 0 is default
        // contrast 0..2, 1 is default
        // you may tweak the range
        val matrix = ColorMatrix(
            floatArrayOf(
                contrast, 0f, 0f, 0f, brightness,
                0f, contrast, 0f, 0f, brightness,
                0f, 0f, contrast, 0f, brightness,
                0f, 0f, 0f, 1f, 0f
            )
        )

        val filter = ColorMatrixColorFilter(matrix)
        paint.colorFilter = filter

        Canvas(bitmap).drawBitmap(this,0f,0f,paint)
        return bitmap
    }

}
