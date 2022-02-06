package com.supasheva.customdrawerevening

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
  lateinit var appBarConfiguration: AppBarConfiguration
  lateinit var navController: NavController
  lateinit var drawerLayout: DrawerLayout
  lateinit var navHostFragment: NavHostFragment
  lateinit var toolbar: Toolbar
  lateinit var navView: NavigationView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    toolbar = findViewById(R.id.toolbar)
    setSupportActionBar(toolbar)

    navHostFragment = supportFragmentManager?.findFragmentById(R.id.nav_host) as NavHostFragment

    navController = navHostFragment.navController
    drawerLayout = findViewById(R.id.drawer_layout)

    navView = findViewById(R.id.nav_view)

     appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

    toolbar.setupWithNavController(navController, appBarConfiguration)
    navView.setupWithNavController(navController)


  }

  override fun onBackPressed() {
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
      drawerLayout.closeDrawer(GravityCompat.START)
    } else {
      super.onBackPressed()
    }
  }

}
