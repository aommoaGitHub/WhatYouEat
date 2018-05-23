package com.example.vittunyutamaeprasart.whatyoueat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ArrayAdapter
import com.example.vittunyutamaeprasart.whatyoueat.models.Store
import com.example.vittunyutamaeprasart.whatyoueat.models.StoreRepositoryMock
import com.example.vittunyutamaeprasart.whatyoueat.presenter.StorePresenter
import com.example.vittunyutamaeprasart.whatyoueat.presenter.StoreView
import kotlinx.android.synthetic.main.activity_store.*
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class StoreActivity : AppCompatActivity() , StoreView {

    var adapter: ArrayAdapter<Store>? = null


    lateinit var presenter : StorePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        StoreRepositoryMock.instance.setAllStores(parseJsonToList())

        presenter = StorePresenter(this)
        presenter.start()
    }

    override fun setStoresList(stores: ArrayList<Store>) {
        adapter = ArrayAdapter<Store>(this, android.R.layout.simple_list_item_1, stores)
        stores_listview.adapter = adapter
    }

    private fun parseJsonToList() : ArrayList<Store>{
        var list : ArrayList<Store> = ArrayList()
        val storeJson = JSONArray(readFile())
        for (i in 0..storeJson!!.length() - 1) {
            val name = storeJson.getJSONObject(i).getString("name")
            val type = storeJson.getJSONObject(i).getString("type")
            val address = storeJson.getJSONObject(i).getString("address")
            val review = storeJson.getJSONObject(i).getString("review")
            val periodPrice = storeJson.getJSONObject(i).getDouble("periodprice")
            val menuNameJson = storeJson.getJSONObject(i).getJSONArray("menunamelist")
            var menuNameList: ArrayList<String> = ArrayList()
            for (i in 0..menuNameJson!!.length() - 1){
                val menuname = menuNameJson.getJSONObject(i).getString("name")
                menuNameList.add(menuname)
            }
            list.add(Store(name,type,address,review,periodPrice,menuNameList))
        }
//        println(list)
        return list
    }

    private fun readFile() : String {
        val inputStream: InputStream = assets.open("stores.json")
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
