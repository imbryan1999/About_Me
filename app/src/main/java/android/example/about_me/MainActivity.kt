package android.example.about_me

import android.content.Context
import android.example.about_me.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

//        binding view
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneButton.setOnClickListener { addNickName(it) }
    }

    private fun addNickName(view: View) {
        binding.apply {
            nicknameText.text = binding.nicknameEditText.text
            invalidateAll() // it will invalid and refreshing data
            nicknameEditText.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // for hide keyboard
        val keyBo = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyBo.hideSoftInputFromWindow(view.windowToken, 0)
    }
}