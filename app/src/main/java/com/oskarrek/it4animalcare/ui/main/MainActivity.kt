package com.oskarrek.it4animalcare.ui.main

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.ui.advertisement.add_edit_advertisement.AddAdvertisementActivity
import com.oskarrek.it4animalcare.ui.advertisement.users_advertisements.UserAdvertisementsActivity
import com.oskarrek.it4animalcare.ui.animal.AnimalsActivity
import com.oskarrek.it4animalcare.ui.animal.animals_list.AnimalsFragment
import com.oskarrek.it4animalcare.ui.main.notice_board.NoticeBoardFragment
import com.oskarrek.it4animalcare.ui.offer.OffersActivity
import com.oskarrek.it4animalcare.ui.user.UserActivity
import com.oskarrek.it4animalcare.util.ViewModelUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    lateinit var viewModel : MainViewModel
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, NoticeBoardFragment.newInstance())
                .commitNow()
        }

        setupFab()
        setupNavigationDrawer(toolbar)
        setupViewModel()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_user, menu)
        return true
    }

  /*  override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }*/
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {

      drawer_layout.closeDrawer(GravityCompat.START)

      val intent : Intent

      when(p0.itemId) {
          R.id.nav_my_account -> {
              intent = Intent(this, UserActivity::class.java)
          }
          R.id.nav_add_advertisement -> {
              intent = Intent(this, AddAdvertisementActivity::class.java)
          }
          R.id.nav_my_advertisements -> {
              intent = Intent(this, UserAdvertisementsActivity::class.java)
          }
          R.id.nav_my_animals -> {
              intent = Intent(this, AnimalsActivity::class.java)
          }
          R.id.nav_my_offers -> {
              intent = Intent(this, OffersActivity::class.java)
          }
          else -> return super.onOptionsItemSelected(p0)
      }

      startActivity(intent)
      return true

  }

    /** Utils methods. */
    private fun setupFab() {
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    //TODO: refactor to use data binding library.
    private fun setupNavigationDrawer(toolbar : Toolbar) {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }


    private fun setupViewModel()  {
        viewModel = ViewModelUtils.createViewModel(this)
        viewModel.loggedUser.observe(this, Observer { user ->
            run {
                if (user == null) {
                    navView.menu.setGroupVisible(R.id.menu_group_signed_in, false)
                    navView.menu.setGroupVisible(R.id.menu_group_signed_out, true)
                } else {
                    navView.menu.setGroupVisible(R.id.menu_group_signed_in, true)
                    navView.menu.setGroupVisible(R.id.menu_group_signed_out, false)
                }
            }
        })
    }

}
