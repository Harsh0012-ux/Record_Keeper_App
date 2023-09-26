package com.harshsingh.recordkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.harshsingh.recordkeeper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val runningFragment = RunningFragment()
    private val cyclingFragment = CyclingFragment()


    private fun onRunningClicked(): Boolean{
        supportFragmentManager.commit {
            replace(R.id.frame_content, RunningFragment())
        }
        return true

    }

    private fun onCyclingClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, CyclingFragment())
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_cycling -> {
                    switchFragment(cyclingFragment)
                    true
                }
                R.id.nav_running -> {
                    switchFragment(runningFragment)
                    true
                }
                else -> false
            }
        }

        // Set the initial fragment
        switchFragment(runningFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId){
            R.id.reset_running -> {
                Toast.makeText(this, "Clicked the reset Running menu item", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.reset_cycling -> {
                Toast.makeText(this, "Clicked the reset Cycling menu item", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.reset_all -> {
                Toast.makeText(this, "Clicked the reset All menu item", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_content, fragment).commit()
    }

}
