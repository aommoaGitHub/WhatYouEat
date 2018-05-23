package com.example.vittunyutamaeprasart.whatyoueat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.example.vittunyutamaeprasart.whatyoueat.models.Dish
import com.example.vittunyutamaeprasart.whatyoueat.models.StoreRepositoryMock
import com.example.vittunyutamaeprasart.whatyoueat.presenter.StorePresenter
import com.example.vittunyutamaeprasart.whatyoueat.presenter.StoreView

class StoreActivity : AppCompatActivity() , StoreView {

    lateinit var presenter : StorePresenter
    lateinit var repository: StoreRepositoryMock

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        repository = StoreRepositoryMock()
        presenter = StorePresenter(Dish("","","",""),this,repository)
        presenter.start()
    }
}
