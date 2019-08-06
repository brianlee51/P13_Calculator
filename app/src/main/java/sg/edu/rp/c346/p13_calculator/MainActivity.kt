package sg.edu.rp.c346.p13_calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var globalNum = ""
    var total = 0.0
    var change = false
    var op = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonAC.setOnClickListener {
            globalNum = ""
            tvSum.text = ""
            change = false
        }
    }

    fun btnOnClick(view : View){
        val btnSelected = view as Button
        if(change == false) {
            when (btnSelected.id) {
                button00.id -> globalNum = globalNum + "0"
                button01.id -> globalNum = globalNum + "1"
                button02.id -> globalNum = globalNum + "2"
                button03.id -> globalNum = globalNum + "3"
                button04.id -> globalNum = globalNum + "4"
                button05.id -> globalNum = globalNum + "5"
                button06.id -> globalNum = globalNum + "6"
                button07.id -> globalNum = globalNum + "7"
                button08.id -> globalNum = globalNum + "8"
                button09.id -> globalNum = globalNum + "9"
                buttonDot.id -> globalNum = globalNum + "."
            }
            tvSum.text = "$globalNum"
            total = globalNum.toDouble()
            globalNum = ""
        } else {
            globalNum = ""
            when (btnSelected.id) {
                button00.id -> globalNum = globalNum + "0"
                button01.id -> globalNum = globalNum + "1"
                button02.id -> globalNum = globalNum + "2"
                button03.id -> globalNum = globalNum + "3"
                button04.id -> globalNum = globalNum + "4"
                button05.id -> globalNum = globalNum + "5"
                button06.id -> globalNum = globalNum + "6"
                button07.id -> globalNum = globalNum + "7"
                button08.id -> globalNum = globalNum + "8"
                button09.id -> globalNum = globalNum + "9"
            }
            if(op == "+"){
                total = total.plus(globalNum.toDouble())
            }else if(op == "-"){
                total = total.minus(globalNum.toDouble())
            }else if(op == "*"){
                total = total.times(globalNum.toDouble())
            }else if(op == "/"){
                total = total.div(globalNum.toDouble())
            }
            tvSum.text = "$globalNum"
        }
    }

    fun btnOnOpClick(view : View){
        val btnSelected = view as Button
        when(btnSelected.id){
            buttonDivide.id -> op = "/"
            buttonMinus.id -> op = "-"
            buttonTimes.id -> op = "*"
            buttonPlus.id -> op = "+"
        }
        change = true
        tvSum.text = ""
    }

    fun btnEqualsClick(view : View){
        tvSum.text = total.toString()
        globalNum = total.toString()
        total = 0.0
    }

}
