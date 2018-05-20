package com.example.vittunyutamaeprasart.whatyoueat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager

class RandomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    fun goToStorePage(view: View){
        val intent = Intent(this, StoreActivity::class.java)
        startActivity(intent)
    }

    fun randomAgainButton(view: View){

    }
}
