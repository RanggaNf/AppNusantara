package com.dicoding.projectappnusantara

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setContentView(R.layout.activity_detail)
        val intent = intent
        if (intent != null) {
            val nusantaraName = intent.getStringExtra("NUSANTARA_NAME")
            val nusantaraDescription = intent.getStringExtra("NUSANTARA_DESCRIPTION")
            val nusantaraPhoto = intent.getIntExtra("NUSANTARA_PHOTO", 0)

            val imageView = findViewById<ImageView>(R.id.nusantara_image)
            val nameTextView = findViewById<TextView>(R.id.nusantara_name)
            val descriptionTextView = findViewById<TextView>(R.id.nusantara_description)

            imageView.setImageResource(nusantaraPhoto)
            nameTextView.text = nusantaraName

            descriptionTextView.text = nusantaraDescription

            val shareButton = findViewById<Button>(R.id.action_share_whatsapp)
            shareButton.setOnClickListener {
                val shareText = "Nama Nusantara: $nusantaraName\nDeskripsi: $nusantaraDescription"

                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(Intent.EXTRA_TEXT, shareText)
                sendIntent.type = "text/plain"
                sendIntent.setPackage("com.whatsapp") // Menargetkan WhatsApp

                try {
                    startActivity(sendIntent)
                } catch (e: Exception) {

                }
            }
        }
    }
}
