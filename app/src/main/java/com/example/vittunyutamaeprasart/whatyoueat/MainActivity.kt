package com.example.vittunyutamaeprasart.whatyoueat

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.CheckBox
import com.example.vittunyutamaeprasart.whatyoueat.models.Dish
import com.example.vittunyutamaeprasart.whatyoueat.models.DishRepositoryMock
import com.example.vittunyutamaeprasart.whatyoueat.models.StoreRepositoryMock
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    lateinit var steakCB : CheckBox
    lateinit var noodleCB : CheckBox
    lateinit var cookByOrderCB : CheckBox
    lateinit var othersCB : CheckBox
    private lateinit var categoryCBList: ArrayList<CheckBox>

    lateinit var porkCB : CheckBox
    lateinit var chickenCB : CheckBox
    lateinit var beefCB : CheckBox
    lateinit var seaFoodCB : CheckBox
    lateinit var noMeatCB : CheckBox
    private lateinit var meatCBList: ArrayList<CheckBox>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)

        steakCB = findViewById(R.id.steakCB)
        noodleCB = findViewById(R.id.noodleCB)
        cookByOrderCB = findViewById(R.id.cookByOrderCB)
        othersCB = findViewById(R.id.othersCB)

        categoryCBList = arrayListOf(steakCB,noodleCB,cookByOrderCB,othersCB)

        porkCB = findViewById(R.id.porkCB)
        chickenCB = findViewById(R.id.chickenCB)
        beefCB = findViewById(R.id.beefCB)
        seaFoodCB = findViewById(R.id.seaFoodCB)
        noMeatCB = findViewById(R.id.noMeatCB)

        meatCBList = arrayListOf(porkCB,chickenCB,beefCB,seaFoodCB,noMeatCB)

        setDafaultCheckBok(true,categoryCBList)
        setDafaultCheckBok(true,meatCBList)

        DishRepositoryMock.instance.setAllDishes(parseJsonToList())
    }

    fun goToRandomPage(view: View){
        DishRepositoryMock.instance.updateSelectedList(createSelectedList(categoryCBList),createSelectedList(meatCBList))
        StoreRepositoryMock.instance.setPrice(startMoneyEditText.text.toString().toDouble(), endMoneyEditText.text.toString().toDouble())
        var intent = Intent(this, RandomActivity::class.java)
        startActivity(intent)
    }

    private fun createSelectedList(cblist: ArrayList<CheckBox>) : ArrayList<String>{
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

    private fun setDafaultCheckBok(boolean: Boolean, cblist: ArrayList<CheckBox>){
        for(cb in cblist){
            cb.setChecked(true)
        }
    }

    private fun parseJsonToList() : ArrayList<Dish>{
        var list : ArrayList<Dish> = ArrayList()
        val context: Context = this
        val dishJson = JSONArray(readFile())
        for (i in 0..dishJson!!.length() - 1) {
            val name = dishJson.getJSONObject(i).getString("name")
            val category = dishJson.getJSONObject(i).getString("category")
            val meat = dishJson.getJSONObject(i).getString("meat")
            val photoname = dishJson.getJSONObject(i).getString("photoname")
            val photoid = context.resources.getIdentifier(photoname,"drawable",context.packageName)
            list.add(Dish(name,category,meat,photoid))
        }
//        println(list)
        return list
    }

    private fun readFile() : String {
        val inputStream: InputStream = assets.open("dishes.json")
        val inputStreamReader = InputStreamReader(inputStream)
        val sb = StringBuilder()
        var line: String?
        val br = BufferedReader(inputStreamReader)
        line = br.readLine()
        while (line != null) {
            sb.append(line)
            line = br.readLine()
        }
        br.close()
        return sb.toString()
    }
}
