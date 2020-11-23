package com.example.editorimagenes

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

private lateinit var img:ImageView;
private lateinit var boton:Button;
private lateinit var boton2:Button;
private lateinit var boton3:Button;
private lateinit var bitmap: Bitmap;
class MainActivity : AppCompatActivity() {
    private val SELECT_ACTIVITY=50
private lateinit var bitmap:Bitmap
    private var imageUri: Uri?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img=findViewById(R.id.image)
        boton=findViewById(R.id.button)
        boton2=findViewById(R.id.button2)
        boton3=findViewById(R.id.button3)
        img.setOnClickListener {
          ImageController.selectPhotoFromGallery(this,SELECT_ACTIVITY)
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
            bitmap= BitmapFactory.decodeFile(ImageController.getImageUri(this,1).path)
            img.setImageBitmap(bitmap) }
        boton3.setOnClickListener {
            bitmap= ImageController.invertFilter(bitmap)
            img.setImageBitmap(bitmap) }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when {
            requestCode==SELECT_ACTIVITY && resultCode==Activity.RESULT_OK->
            {
                imageUri=data!!.data
                img.setImageURI(imageUri)
            }
        }
    }
}