package com.example.game

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.game.R
//import androidx.databinding.DataBindingUtil
//import com.example.tictactoe.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import java.util.*
import android.widget.Button as Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
        findViewById<Button>(R.id.reset_button).setOnClickListener { clearBoard() }
        findViewById<Button>(R.id.new_game).setOnClickListener {
            clearBoard()
            player_1_count = 0
            player_2_count = 0
            score_1(player_1_count)
            score_2(player_2_count)
        }

    }

    private fun setListeners() {
        val button1 = findViewById<Button>(R.id.button_1)
        val button2 = findViewById<Button>(R.id.button_2)
        val button3 = findViewById<Button>(R.id.button_3)
        val button4 = findViewById<Button>(R.id.button_4)
        val button5 = findViewById<Button>(R.id.button_5)
        val button6 = findViewById<Button>(R.id.button_6)
        val button7 = findViewById<Button>(R.id.button_7)
        val button8 = findViewById<Button>(R.id.button_8)
        val button9 = findViewById<Button>(R.id.button_9)

        val clickableviews =
            listOf(button1, button2, button3, button4, button5, button6, button7, button8, button9)
        for (view in clickableviews) {
            view.setOnClickListener {
                buttonClicked(it as Button)
            }
        }
    }

    fun buttonClicked(view: Button) {
        var cell_id = 0
        val buttonselected = view as Button


        when (view.id) {
            R.id.button_1 -> cell_id = 1
            R.id.button_2 -> cell_id = 2
            R.id.button_3 -> cell_id = 3
            R.id.button_4 -> cell_id = 4
            R.id.button_5 -> cell_id = 5
            R.id.button_6 -> cell_id = 6
            R.id.button_7 -> cell_id = 7
            R.id.button_8 -> cell_id = 8
            R.id.button_9 -> cell_id = 9
        }
        playgame(cell_id, buttonselected)
    }


    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var active_player = 1
    var player_1_count: Int = 0
    var player_2_count: Int = 0

    fun playgame(cell_id: Int, buttonselected: Button) {

        if (active_player == 1) {
            buttonselected.setTextColor(Color.RED)
            buttonselected.text = "X"
            player1.add(cell_id)
            active_player = 2
            //auto()
        } else {
            buttonselected.setTextColor(Color.GREEN)
            buttonselected.text = "O"
            player2.add(cell_id)
            active_player = 1

        }
        //buttonselected.isEnabled = false
        winner()

    }

    fun winner() {
        var win = -1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
            win = 1
        if (player2.contains(1) && player2.contains(2) && player2.contains(3))
            win = 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6))
            win = 1
        if (player2.contains(4) && player2.contains(5) && player2.contains(6))
            win = 2
        if (player1.contains(7) && player1.contains(8) && player1.contains(9))
            win = 1
        if (player2.contains(7) && player2.contains(8) && player2.contains(9))
            win = 2
        if (player1.contains(1) && player1.contains(5) && player1.contains(9))
            win = 1
        if (player2.contains(1) && player2.contains(5) && player2.contains(9))
            win = 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7))
            win = 1
        if (player2.contains(3) && player2.contains(5) && player2.contains(7))
            win = 2
        if (player1.contains(1) && player1.contains(4) && player1.contains(7))
            win = 1
        if (player2.contains(1) && player2.contains(4) && player2.contains(7))
            win = 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8))
            win = 1
        if (player2.contains(2) && player2.contains(5) && player2.contains(8))
            win = 2
        if (player1.contains(3) && player1.contains(6) && player1.contains(9))
            win = 1
        if (player2.contains(3) && player2.contains(6) && player2.contains(9))
            win = 2
        if (win != -1) {

            if (win == 1) {
                Toast.makeText(this, "Player 1 wins", Toast.LENGTH_LONG).show()
                player_1_count += 1;
                score_1(player_1_count)
            } else {
                Toast.makeText(this, "Player 2 wins", Toast.LENGTH_LONG).show()
                player_2_count += 1;
                score_2(player_2_count)
            }
        }
    }

    fun score_1(p1: Int = player_1_count) {
        val play1 = findViewById<TextView>(R.id.player_1)
        play1.text = "Player 1 : $p1"
    }

    fun score_2(p2: Int = player_2_count) {
        val play2 = findViewById<TextView>(R.id.player_2)
        play2.text = "Player 2 : $p2"
    }

    fun clearBoard() {
        val button1 = findViewById<Button>(R.id.button_1)
        val button2 = findViewById<Button>(R.id.button_2)
        val button3 = findViewById<Button>(R.id.button_3)
        val button4 = findViewById<Button>(R.id.button_4)
        val button5 = findViewById<Button>(R.id.button_5)
        val button6 = findViewById<Button>(R.id.button_6)
        val button7 = findViewById<Button>(R.id.button_7)
        val button8 = findViewById<Button>(R.id.button_8)
        val button9 = findViewById<Button>(R.id.button_9)
        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""
        active_player = 1
        player1.clear()
        player2.clear()
        //empty_cells.clear()

    }
    /*var empty_cells = ArrayList<Int>()

    fun auto() {
        for (c in 1..9) {
            if (!(player1.contains(c) || (player2.contains(c)) )){
                empty_cells.add(c)
            }
        }
        val r = Random()
        val rIndex: Int = r.nextInt(empty_cells.size - 0)+0
        val x = empty_cells[rIndex]
        lateinit var buttonselected : Button
        when(x){
            1 -> buttonselected = findViewById(R.id.button_1)
            2 -> buttonselected = findViewById(R.id.button_2)
            3 -> buttonselected = findViewById(R.id.button_3)
            4 -> buttonselected = findViewById(R.id.button_4)
            5 -> buttonselected = findViewById(R.id.button_5)
            6 -> buttonselected = findViewById(R.id.button_6)
            7 -> buttonselected = findViewById(R.id.button_7)
            8 -> buttonselected = findViewById(R.id.button_8)
            9 -> buttonselected = findViewById(R.id.button_9)
        }
        playgame(x, buttonselected = buttonselected)
    }*/
}
