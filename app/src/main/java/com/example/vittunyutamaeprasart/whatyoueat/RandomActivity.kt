package com.example.vittunyutamaeprasart.whatyoueat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.TextView
import com.example.vittunyutamaeprasart.whatyoueat.models.Dish
import com.example.vittunyutamaeprasart.whatyoueat.models.DishRepositoryMock
import com.example.vittunyutamaeprasart.whatyoueat.models.StoreRepositoryMock
import com.example.vittunyutamaeprasart.whatyoueat.presenter.DishPresenter
import com.example.vittunyutamaeprasart.whatyoueat.presenter.DishView
import kotlinx.android.synthetic.main.activity_random.*

class RandomActivity : AppCompatActivity(), DishView {

    lateinit var presenter : DishPresenter
    lateinit var repository: DishRepositoryMock
    lateinit var choicebtnlist: ArrayList<ImageButton>
    lateinit var choicenamebtnlist: ArrayList<TextView>
    lateinit var disheslist : ArrayList<Dish>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        choicebtnlist = arrayListOf(food1,food2,food3,food4)
        choicenamebtnlist = arrayListOf(food1_text,food2_text,food3_text,food4_text)
        repository = DishRepositoryMock()
        presenter = DishPresenter(this,repository)
        presenter.start()

        updateChoices()
    }

    fun goToStorePage(view: View){
        when (view.id) {
            R.id.food1 -> StoreRepositoryMock.instance.setCurrentDish(disheslist.get(0))
            R.id.food2 -> StoreRepositoryMock.instance.setCurrentDish(disheslist.get(1))
            R.id.food3 -> StoreRepositoryMock.instance.setCurrentDish(disheslist.get(2))
            R.id.food4 -> StoreRepositoryMock.instance.setCurrentDish(disheslist.get(3))
        }
        val intent = Intent(this, StoreActivity::class.java)
        startActivity(intent)
    }

    fun randomAgainButton(view: View){
        updateChoices()
    }

    override fun updateChoices() {
        var i = 0
        disheslist = presenter.randomDishes()
        for(dish in disheslist){
            choicebtnlist.get(i).setImageResource(dish.photoID)
            choicenamebtnlist.get(i++).text = dish.name
        }

        if(disheslist.size < 4){
            while (i<4){
                choicebtnlist.get(i).visibility = View.INVISIBLE
                choicenamebtnlist.get(i++).visibility = View.INVISIBLE
            }
        }

    }
}
