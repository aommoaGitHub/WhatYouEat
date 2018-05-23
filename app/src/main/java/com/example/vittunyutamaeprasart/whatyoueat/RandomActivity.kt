package com.example.vittunyutamaeprasart.whatyoueat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.example.vittunyutamaeprasart.whatyoueat.models.DishRepositoryMock
import com.example.vittunyutamaeprasart.whatyoueat.presenter.DishPresenter
import com.example.vittunyutamaeprasart.whatyoueat.presenter.DishView

class RandomActivity : AppCompatActivity(), DishView {

    lateinit var presenter : DishPresenter
    lateinit var repository: DishRepositoryMock

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        repository = DishRepositoryMock()
        presenter = DishPresenter(this,repository)
        presenter.start()

        updateChoices()
    }

    fun goToStorePage(view: View){
        val intent = Intent(this, StoreActivity::class.java)
        startActivity(intent)
    }

    fun randomAgainButton(view: View){
        updateChoices()
    }

    override fun updateChoices() {
        println("4 choices: "+presenter.randomDishes())
    }
}
