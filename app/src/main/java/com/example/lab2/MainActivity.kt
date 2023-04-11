package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var val_A: TextView = findViewById(R.id.val_A) as TextView;
        var val_B: TextView = findViewById(R.id.val_B) as TextView;
        var val_C: TextView = findViewById(R.id.val_C) as TextView;
        var text_urav: TextView = findViewById(R.id.text_urav) as TextView;
        var text_itog: TextView = findViewById(R.id.text_itog) as TextView;
        var btn: Button = findViewById(R.id.btn) as Button;

        fun disc(a: Int, b: Int, c: Int):Int{
            return (b * b) - (4 * a * c)
        }
        fun viewUrav(a: Int, b: Int, c: Int){
            var D:Int = disc(a,b,c);
            var A:String;
            var B:String;
            var C:String;
            if(a<0){
                A = "(${a.toString()})";
            }else{
                A = a.toString();
            }
            if(b<0){
                B = "(${b.toString()})";
            }else{
                B = b.toString();
            }
            if(c<0){
                C = "(${c.toString()})";
            }else{
                C = c.toString();
            }
            text_urav.setText("($B*$B)-(4*$A*$C)=$D")
        }
        fun roundToStr(x:Double):String{
            return String.format("%.2f", x)
        }
        fun exp(a: Int, b: Int, c: Int):Boolean{
            if (a==0 && b!=0){
                var x:Double = -c.toDouble()/b.toDouble();
                text_itog.setText("Линейное\nx = ${roundToStr(x)}")
                return true
            }
            if (a==0 && b==0){
                text_itog.setText("Не является уравнением")
                return true
            }
            return false
        }
        fun main(){
            var a:Int = val_A.text.toString().toInt();
            var b:Int = val_B.text.toString().toInt();
            var c:Int = val_C.text.toString().toInt();
            var D:Int = disc(a,b,c);
            if (D<0 && !exp(a,b,c)){
                viewUrav(a,b,c)
                text_itog.setText("Нет корней")
            }
            if (D==0 && !exp(a,b,c)){
                viewUrav(a,b,c)
                var x:Double= (-b - sqrt(D.toDouble())) / (2 * a);
                text_itog.setText("x1=x2=${roundToStr(x)}")
            }
            if (D>0 && !exp(a,b,c)){
                viewUrav(a,b,c)
                var x1:Double = (-b.toDouble() + sqrt(D.toDouble())) / (2 * a.toDouble());
                var x2:Double = (-b.toDouble() - sqrt(D.toDouble())) / (2 * a.toDouble());
                text_itog.setText("x1 = ${roundToStr(x1)};\nx2 = ${roundToStr(x2)}")
            }
        }
        btn.setOnClickListener{
            text_itog.setText("")
            text_urav.setText("")
            main()
        }

    }
}