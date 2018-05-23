package com.example.vittunyutamaeprasart.whatyoueat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.CheckBox
import com.example.vittunyutamaeprasart.whatyoueat.models.DishRepositoryMock


class MainActivity : AppCompatActivity() {

    lateinit var steakCB : CheckBox
    lateinit var noodleCB : CheckBox
    lateinit var cookByOrderCB : CheckBox
    lateinit var othersCB : CheckBox
    lateinit var categoryCBList: ArrayList<CheckBox>

    lateinit var porkCB : CheckBox
    lateinit var chickenCB : CheckBox
    lateinit var beefCB : CheckBox
    lateinit var seaFoodCB : CheckBox
    lateinit var noMeatCB : CheckBox
    lateinit var meatCBList: ArrayList<CheckBox>

    lateinit var repository: DishRepositoryMock

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        steakCB = findViewById(R.id.steakCB) as CheckBox
        noodleCB = findViewById(R.id.noodleCB) as CheckBox
        cookByOrderCB = findViewById(R.id.cookByOrderCB) as CheckBox
        othersCB = findViewById(R.id.othersCB) as CheckBox

        categoryCBList = arrayListOf(steakCB,noodleCB,cookByOrderCB,othersCB)

        porkCB = findViewById(R.id.porkCB) as CheckBox
        chickenCB = findViewById(R.id.chickenCB) as CheckBox
        beefCB = findViewById(R.id.beefCB) as CheckBox
        seaFoodCB = findViewById(R.id.seaFoodCB) as CheckBox
        noMeatCB = findViewById(R.id.noMeatCB) as CheckBox

        meatCBList = arrayListOf(porkCB,chickenCB,beefCB,seaFoodCB,noMeatCB)

//        steakCB.setOnCheckedChangeListener { view, isChecked ->
//            Toast.makeText(this, isChecked.toString(), LENGTH_LONG).show()
//        }

        setDafaultCheckBok(true,categoryCBList)
        setDafaultCheckBok(true,meatCBList)

        repository = DishRepositoryMock()

    }

    fun goToRandomPage(view: View){
//        repository.updateSelectedList(createSelectedList(categoryCBList),createSelectedList(meatCBList))
        DishRepositoryMock.instance.updateSelectedList(createSelectedList(categoryCBList),createSelectedList(meatCBList))
        var intent = Intent(this, RandomActivity::class.java)
        startActivity(intent)
    }

    fun createSelectedList(cblist: ArrayList<CheckBox>) : ArrayList<String>{
        val list = ArrayList<String>()
        for(cb in cblist){
            if(cb.isChecked) list.add(cb.text.toString().toLowerCase())
        }
        return list
    }

    fun goToStorePage(view: View){
        val intent = Intent(this, StoreActivity::class.java)
        startActivity(intent)
    }

    fun setDafaultCheckBok(boolean: Boolean, cblist: ArrayList<CheckBox>){
        for(cb in cblist){
            cb.setChecked(true)
        }
    }

}
