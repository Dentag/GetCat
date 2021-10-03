package com.dentag.getcat.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dentag.getcat.databinding.ActivityMainBinding
import com.dentag.getcat.ui.cat.CatFullFragment
import com.dentag.getcat.ui.catlist.CatListFragment

class MainActivity : AppCompatActivity(), Router {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(binding.mainFragmentContainer.id, CatListFragment())
            .commitNow()
    }

    override fun goToCat(url: String, view: View) {
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .addSharedElement(view, "full_image")
            .replace(binding.mainFragmentContainer.id, CatFullFragment.getInstance(url))
            .addToBackStack(null)
            .commit()
    }
}
