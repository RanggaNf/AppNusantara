package com.dicoding.projectappnusantara

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val imageProfile = findViewById<ImageView>(R.id.image_profile)
        val textName = findViewById<TextView>(R.id.text_name)
        val textEmail = findViewById<TextView>(R.id.text_email)
        val textSocialMedia = findViewById<TextView>(R.id.text_social_media)
        val btnContact = findViewById<Button>(R.id.btn_contact)


        textName.text = "MOHAMAD RANGGA NUR FAIZIN"
        textEmail.text = "a215bsy2027@bangkit.academy"
        textSocialMedia.text = "Sosial Media: @rangfaziii"


        btnContact.setOnClickListener {
            val phoneNumber = "+6283852347479"
            val intent = Intent(Intent.ACTION_VIEW)
            val url = "https://wa.me/$phoneNumber"
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}
