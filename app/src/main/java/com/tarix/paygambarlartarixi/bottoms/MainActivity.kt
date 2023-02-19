package com.tarix.paygambarlartarixi.bottoms

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import uz.tarix.paygambarlartarixi.R
import uz.tarix.paygambarlartarixi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //for bottom navigation implement fragments
        loadFragment(HomeFragment())
        bottomNav()
        //for navigationDrawer
        navigatiodrawer()

        //for item clicks in Navigation Drawer
        clicks()

    }

    private fun navigatiodrawer() {

        binding.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        binding.openMenu.setOnClickListener {
            if (binding.drawer.isOpen) {
                binding.menu.animate().alpha(0.0f).duration = 650
                binding.openMenu.animate().rotation(0f).duration = 600
                binding.drawer.closeDrawers()
                binding.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            } else {
                binding.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                binding.menu.alpha = 0.0f
                binding.menu.animate().alpha(1.0f).duration = 650
                binding.drawer.openDrawer(binding.menu)
                binding.openMenu.animate().rotation(180f).duration = 600
            }
        }

        binding.drawer.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {

            }

            override fun onDrawerOpened(drawerView: View) {
                binding.myLogo.alpha = 0.0f
                binding.myLogo.animate().alpha(1.0f).duration = 1250
            }

            override fun onDrawerClosed(drawerView: View) {
                binding.menu.animate().alpha(0.0f).duration = 650
                binding.openMenu.animate().rotation(0f).duration = 600
                binding.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                binding.myLogo.alpha = 0.0f
            }

            override fun onDrawerStateChanged(newState: Int) {

            }

        })

    }

    private fun bottomNav() {
        var one = true
        var two = false
        var three = false
        var four = false
        binding.bnv.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.home -> {
                    if (!one){
                        loadFragment(HomeFragment())
                    }

                    one = true
                    two = false
                    three = false
                    four = false
                }
                R.id.media -> {
                    if (!two){
                        loadFragment(MediaFragment())
                    }
                    one = false
                    two = true
                    three = false
                    four = false
                }
                R.id.save -> {
                    if (!three){
                        loadFragment(SaveFragment())
                    }
                    one = false
                    two = false
                    three = true
                    four = false

                }
                R.id.about -> {
                    if (!four){
                        loadFragment(AboutFragment())
                    }
                    one = false
                    two = false
                    three = false
                    four = true
                }

            }
            true

        }
    }

    private fun loadFragment(fragment: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

    private fun clicks() {

        binding.menu.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.contact -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://t.me/akbarjonps")
                        )
                    )
                }
                R.id.share -> {
                    val shareApp = Intent()
                    shareApp.action = Intent.ACTION_SEND
                    shareApp.type = "text/plain"
                    shareApp.putExtra(
                        Intent.EXTRA_SUBJECT,
                        "https://play.google.com/store/apps/developer?id=Samandar+Sdk"
                    )
                    startActivity(Intent.createChooser(shareApp, "Share App"))
                }
                R.id.otherApps -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/developer?id=creativer")
                        )
                    )
                }
                R.id.rate -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=uz.tarix.paygambarlartarixi")
                        )
                    )
                }
                R.id.dasturchi -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://github.com/AkbarjonCoder")
                        )
                    )
                }

            }
            true
        }

    }
}