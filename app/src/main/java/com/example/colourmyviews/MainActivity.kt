package com.example.colourmyviews

import android.graphics.Color
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.View
import com.example.colourmyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var root = binding.root
        setContentView(root)
        checkMyListeners()
    }

    private fun checkMyListeners(){

        binding.apply {

            var boxesList = listOf<View>(textBoxOne,textBoxTwo,textBoxThree, textBoxFour, textBoxFive)

            var colourViewsList = listOf<View>(textBoxOne,textBoxTwo,textBoxThree,
                textBoxFour, textBoxFive, layout, btnRed, btnGreen, btnBlue)

            for(item in colourViewsList){
                item.setOnClickListener{ colouring(it, boxesList)}
            }
        }

    }

    private fun colouring (chosenBox: View, elementsOnScreen: List<View>){
        binding.apply {
            when (chosenBox) {

                textBoxOne -> chosenBox.setBackgroundColor(Color.RED)

                textBoxTwo -> chosenBox.setBackgroundColor(Color.BLUE)

                textBoxThree -> chosenBox.setBackgroundColor(Color.GREEN)

                textBoxFour -> chosenBox.setBackgroundColor(Color.YELLOW)

                textBoxFive -> chosenBox.setBackgroundColor(Color.MAGENTA)

                btnRed -> {

                    for(element in elementsOnScreen){
                        element.setBackgroundColor(getColor(R.color.my_red))
                    }
                }

                btnGreen -> {

                    for(element in elementsOnScreen){
                        element.setBackgroundColor(getColor(R.color.my_green))
                    }
                }

                btnBlue -> {

                    for(element in elementsOnScreen){
                        element.setBackgroundColor(getColor(R.color.my_blue))
                    }
                }

                else -> chosenBox.setBackgroundColor(Color.LTGRAY)

            }
        }

    }
}