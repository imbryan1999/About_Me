package android.example.about_me

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickName(it) // here 'it' is a reference in the context of view
        }
      }

    private fun addNickName(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit_text)
        val nickNameText = findViewById<TextView>(R.id.nickname_text)

        nickNameText.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nickNameText.visibility = View.VISIBLE

        // for hide keyboard
        val keyBo = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyBo.hideSoftInputFromWindow(view.windowToken, 0)
    }
}