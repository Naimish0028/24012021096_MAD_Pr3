package com.example.a24012021096_mad_pr3
import com.example.a24012021096_mad_pr3.ui.login.LoginActivity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        impliciteintent()
        explciteintent()
    }

    fun impliciteintent() {

        findViewById<Button>(R.id.btn_browse).setOnClickListener {

            var url = findViewById<EditText>(R.id.editTextText)
                .text.toString().trim()

            if (url.isEmpty()) {
                Toast.makeText(this, "Enter URL", Toast.LENGTH_SHORT).show()
            } else {

                if (!url.startsWith("http://") &&
                    !url.startsWith("https://")) {
                    url = "https://$url"
                }

                openIntent(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
            }
        }


        findViewById<Button>(R.id.btn_call).setOnClickListener {

            val number = findViewById<EditText>(R.id.editTextPhone)
                .text.toString()

            openIntent(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number")))
        }

        findViewById<Button>(R.id.btn_calllog).setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW)
                .setType(CallLog.Calls.CONTENT_TYPE)

            openIntent(intent)
        }

        findViewById<Button>(R.id.btn_gallery).setOnClickListener{
            Intent(Intent.ACTION_VIEW).setType("image/*").also{
                startActivity(it)
            }              }

        findViewById<Button>(R.id.btn_camera).setOnClickListener {

            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            openIntent(intent)
        }

        findViewById<Button>(R.id.btn_alarm).setOnClickListener {

            val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS)

            openIntent(intent)
        }
    }

    private fun openIntent(intent: Intent) {
        try {
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(
                this,
                "Cannot open application: ${e.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun explciteintent() {
        findViewById<Button>(R.id.btn_login).setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}