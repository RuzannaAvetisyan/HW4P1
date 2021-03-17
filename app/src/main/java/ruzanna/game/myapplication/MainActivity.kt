package ruzanna.game.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val add = findViewById<Button>(R.id.add)
        val pass = findViewById<Button>(R.id.pass)
        val number = findViewById<TextView>(R.id.number)
        val extras = intent.extras
        if(extras != null){
            number.text = extras.get("num") as String
        }
        add.setOnClickListener{
            number.text = (number.text.toString().toInt() + 1).toString()
        }
        pass.setOnClickListener{
            val intent = Intent(this, NextActivity::class.java)
            intent.putExtra("num", number.text)
            startActivityForResult(intent, 1000)

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val extras = data?.extras
        val number = findViewById<TextView>(R.id.number)
        if(extras != null){
            number.text = extras.get("num") as String
        }
    }
}

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.next)
        val minus = findViewById<Button>(R.id.min)
        val back = findViewById<Button>(R.id.back)
        val number = findViewById<TextView>(R.id.number)
        val extras = intent.extras
        if(extras != null){
            number.text = extras.get("num") as String
        }
        minus.setOnClickListener{
            number.text = (number.text.toString().toInt() - 1).toString()
        }
        back.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("num", number.text)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

}