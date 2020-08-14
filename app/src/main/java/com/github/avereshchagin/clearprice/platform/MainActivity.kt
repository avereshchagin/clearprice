package com.github.avereshchagin.clearprice.platform

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import com.github.avereshchagin.clearprice.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        invalidateToolbar(false)

        findNavController(R.id.nav_host_fragment).addOnDestinationChangedListener {
                _: NavController, navDestination: NavDestination, _: Bundle? ->
            invalidateToolbar(navDestination.id != R.id.CartFragment)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            findNavController(R.id.nav_host_fragment).navigateUp()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun invalidateToolbar(shouldDisplayHome: Boolean) {
        supportActionBar?.apply {
            setHomeButtonEnabled(shouldDisplayHome)
            setDisplayShowHomeEnabled(shouldDisplayHome)
            setDisplayHomeAsUpEnabled(shouldDisplayHome)
        }
    }
}
