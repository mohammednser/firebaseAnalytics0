package com.example.myappfirebaseanalytics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        analytics = Firebase.analytics

        button1.setOnClickListener {
            selectContentEvent("Image1", "ImageView", "image")
        }
        button2.setOnClickListener {
            trackScreenEvent()
        }

    }
        fun selectContentEvent(id: String, name: String, contentType: String) {
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT) {
                param(FirebaseAnalytics.Param.ITEM_ID, id);
                param(FirebaseAnalytics.Param.ITEM_NAME, name);
                param(FirebaseAnalytics.Param.CONTENT_TYPE, contentType);
            }
        }
        fun trackScreenEvent(){
            analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
                param(FirebaseAnalytics.Param.SCREEN_NAME, "Main");
                param(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity");

            }
    }
}