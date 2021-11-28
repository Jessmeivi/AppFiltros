package com.example.elmismoen26


import android.app.Activity
import android.content.Intent
import android.graphics.*
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
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
private lateinit var bitmap3: Bitmap;
private lateinit var bitmap4: Bitmap;
private lateinit var brillo:SeekBar;
private lateinit var contraste:SeekBar;
private lateinit var brillotxt:TextView;
private lateinit var contrastetxt:TextView;
private lateinit var gamma:Button
private lateinit var gammita:SeekBar;
private lateinit var smoothing:Button
private lateinit var gaussian:Button
private lateinit var mean:Button
private lateinit var sharpen:Button
private lateinit var edge:Button
private lateinit var embossing:Button
private lateinit var repujado:Button
private lateinit var sobell:Button
private lateinit var transparencia:Button
private lateinit var pixel:Button
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
        brillotxt=findViewById(R.id.tvBrightness)
        contrastetxt=findViewById(R.id.tvContrast)
        gamma=findViewById(R.id.gamma)
        gammita=findViewById(R.id.seekBar)
        smoothing=findViewById(R.id.smoothing)
        gaussian=findViewById(R.id.gaussian)
        mean=findViewById(R.id.mean)
        sharpen=findViewById(R.id.sharpen)
        edge=findViewById(R.id.edge)
        embossing=findViewById(R.id.embossing)
        repujado=findViewById(R.id.repujado)
        sobell=findViewById(R.id.sobel)
        transparencia=findViewById(R.id.transparencia)
        pixel=findViewById(R.id.pixel)

        img.setOnClickListener {
            ImageController.selectPhotoFromGallery(this, SELECT_ACTIVITY)
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE
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
            brillo.visibility= View.VISIBLE
            contraste.visibility=View.VISIBLE
            brillotxt.visibility= View.VISIBLE
            contrastetxt.visibility=View.VISIBLE
            bitmap3=img.drawable.toBitmap(700, 700, null)
            bitmap3?.apply {
                img.setImageBitmap(this)
                brillo.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(
                        seekBar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean
                    ) {
                        val brightness = progress.toFloat() - 200
                        val contrast = contraste.progress.toFloat() / 10F
                        img.setImageBitmap(
                            setBrightnessContrast(brightness, contrast)
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
                            setBrightnessContrast(brightness, contrast)
                        )
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                })
            }

        }
        boton3.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.invertFilter(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE
        }
        rojo.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.rojos(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE
        }
        azul.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.azules(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE
        }
        verde.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.verdes(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE
        }
        gris.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.grises(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE
        }
        gamma.setOnClickListener {
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE

            bitmap3=img.drawable.toBitmap(700, 700, null)


                gammita.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(
                        seekBar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean
                    ) {
                        var gamma=progress/4
                        img.setImageBitmap(ImageController.gamma(bitmap2,gamma)
                        )
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {


                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?

                    ) {

                    }
                })


        }

        smoothing.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.smoothing(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE
        }
        gaussian.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.gaussian(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE
        }
        mean.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.mean(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE
        }
        sharpen.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.sharpen(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE
        }
        edge.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.edge(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE
        }
        embossing.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.embossing(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE
        }
        transparencia.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.transparencia(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE
        }
        repujado.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.repujado(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE
        }
        sobell.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.sobell(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE
        }
        pixel.setOnClickListener {
            var ancho = img.width;
            var alto = img.height;
            bitmap2 = ImageController.pixel(img.drawable.toBitmap(ancho, alto, null))
            img.setImageBitmap(bitmap2)
            brillo.visibility= View.GONE
            contraste.visibility=View.GONE
            brillotxt.visibility= View.GONE
            contrastetxt.visibility=View.GONE
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

    fun Bitmap.setBrightnessContrast(
        brightness:Float = 0.0F,
        contrast:Float = 1.0F
    ):Bitmap?{
        val bitmap=copy(Bitmap.Config.ARGB_8888,true)
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
