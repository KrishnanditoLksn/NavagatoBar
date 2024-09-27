package app.ditodev.masbro

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ditodev.masbro.databinding.ActivityMenuBinding
import app.ditodev.masbro.fragment.MenuFragment

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding) {
            searchView.setupWithSearchBar(searchBarView)
            searchView.editText
                .setOnEditorActionListener { textView, actionId, event ->
                    searchBarView.setText(searchView.text)
                    searchView.hide()
                    Toast.makeText(this@MenuActivity, searchView.text, Toast.LENGTH_SHORT).show()
                    false
                }
            /*
            BRUH ERROR
             */
//            searchBarView.inflateMenu(R.menu.option_menu)
//            searchBarView.setOnMenuItemClickListener {
//                when (it.itemId) {
//                    R.id.menu1 -> {
//                        supportFragmentManager.beginTransaction()
//                            .replace(R.id.fragment_container, MenuFragment())
//                            .addToBackStack(null)
//                            .commit()
//                    }
//                }
//                true
//            }
        }
    }
}