package sg.edu.rp.c346.p13_calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var onlyOnce = ""
    var globalNum = ""
    var total = 0.0
    var change = false
    var op = ""
    var dot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonAC.setOnClickListener {
            onlyOnce = ""
            globalNum = ""
            tvSum.text = ""
            change = false
            dot = false
        }
    }
    fun btnOnClick(view : View){
        val btnSelected = view as Button
        if(change == false) {
            when (btnSelected.id) {
                button00.id -> onlyOnce = onlyOnce + "0"
                button01.id -> onlyOnce = onlyOnce + "1"
                button02.id -> onlyOnce = onlyOnce + "2"
                button03.id -> onlyOnce = onlyOnce + "3"
                button04.id -> onlyOnce = onlyOnce + "4"
                button05.id -> onlyOnce = onlyOnce + "5"
                button06.id -> onlyOnce = onlyOnce + "6"
                button07.id -> onlyOnce = onlyOnce + "7"
                button08.id -> onlyOnce = onlyOnce + "8"
                button09.id -> onlyOnce = onlyOnce + "9"
            }
            tvSum.text = "$onlyOnce"
        }else{
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
        if(op == "+" && globalNum != ""){
            total = onlyOnce.toDouble() + globalNum.toDouble()
            onlyOnce = total.toString()
            globalNum = ""
            total = 0.0
        }else if(op == "-"&& globalNum != "" ){
            total = onlyOnce.toDouble() - globalNum.toDouble()
            onlyOnce = total.toString()
            globalNum = ""
            total = 0.0
        }else if(op == "*"&& globalNum != ""){
            total = onlyOnce.toDouble() * globalNum.toDouble()
            onlyOnce = total.toString()
            globalNum = ""
            total = 0.0
        }else if(op == "/"&& globalNum != ""){
            total = onlyOnce.toDouble() / globalNum.toDouble()
            onlyOnce = total.toString()
            globalNum = ""
            total = 0.0
        }
        change = true
        dot = false
        tvSum.text = ""
        buttonDot.isEnabled = true
    }

    fun btnEqualsClick(view : View){
        if(op == "+"){
            total = onlyOnce.toDouble() + globalNum.toDouble()
        }else if(op == "-"){
            total = onlyOnce.toDouble() - globalNum.toDouble()
        }else if(op == "*"){
            total = onlyOnce.toDouble() * globalNum.toDouble()
        }else if(op == "/"){
            total = onlyOnce.toDouble() / globalNum.toDouble()
        }
        tvSum.text = total.toString()
        onlyOnce = total.toString()
        total = 0.0
        globalNum = ""
        dot = false
        buttonDot.isEnabled = true
    }

    fun btnDotClick(view : View){
        if(change == false){
            onlyOnce = onlyOnce + "."
            tvSum.text = "$onlyOnce"
        }else if(change == true){
            globalNum = globalNum + "."
            tvSum.text = "$globalNum"
        }
        if(dot == false){
            dot = true
            buttonDot.isEnabled = false
        }
    }

}