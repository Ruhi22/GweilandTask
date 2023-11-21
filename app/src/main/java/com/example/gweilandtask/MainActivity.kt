package com.example.gweilandtask

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.gweilandtask.adapter.CurrencyUpdateListAdapter
import com.example.gweilandtask.fragments.EShopFragment
import com.example.gweilandtask.fragments.ExchangeFragment
import com.example.gweilandtask.fragments.LaunchPadsFragment
import com.example.gweilandtask.fragments.WalletFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import java.security.AccessController.getContext


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var fl_parentContainer: FrameLayout

    lateinit var bnv_bottomNavigation: BottomNavigationView
    //lateinit var rv_currency_update_list: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)

        //window.setStatusBarColor(ContextCompat.getColor(applicationContext,R.color.colorstatusBar))



        fl_parentContainer = findViewById(R.id.fl_parentContainer)
        //rv_currency_update_list = findViewById(R.id.rv_currency_update_list)


        //var arrayList_for_recyclerView = ArrayList<String>{"ETH", "BNB", "ADA", "XRP", "SOL"}





        /*btn_jobProfile = findViewById(R.id.btn_jobProfile)
        btn_jobProfile.setOnClickListener(View.OnClickListener {
            val jobProfile = Intent(this, JobProfileActivity::class.java)
            startActivity(jobProfile)
        })

        btn_jobList = findViewById(R.id.btn_jobList)
        btn_jobList.setOnClickListener(View.OnClickListener {
            val jobList = Intent(this, JobList::class.java)
            startActivity(jobList)
        })*/

        bnv_bottomNavigation = findViewById(R.id.bnv_bottomNavigation)
        bnv_bottomNavigation.selectedItemId = R.id.home

        getExtraLoadFragment()


    }


    private fun getExtraLoadFragment() {
        var fragmentToLoad = intent.getStringExtra("fragmentToLoad")
        var fragmentItemId = 0

        if(fragmentToLoad!=null){
            if(fragmentToLoad.equals("Jobs")){
                loadFragments(ExchangeFragment()) // loading the fragment page correctly here
                bnv_bottomNavigation.selectedItemId = R.id.jobs
                //Toast.makeText(this, "Jobs Fragment To Load", Toast.LENGTH_SHORT).show() // UploadActivity to this
            } else if(fragmentToLoad.equals("Profile")){
                loadFragments(LaunchPadsFragment())
                bnv_bottomNavigation.selectedItemId = R.id.profile
            } /*else if(fragmentToLoad.equals("Responses")){
                loadFragments(ResponsesFragment())
                bnv_bottomNavigation.selectedItemId = R.id.responses
            }*/ else if (fragmentToLoad.equals("Home")){
                loadFragments(EShopFragment())
                bnv_bottomNavigation.selectedItemId = R.id.home
                //Toast.makeText(this, "Home Fragment To Load", Toast.LENGTH_SHORT).show() // UploadActivity to this
            }
            if(fragmentToLoad.equals("Groups")){
                loadFragments(WalletFragment()) // loading the fragment page correctly here
                bnv_bottomNavigation.selectedItemId = R.id.groups
                //Toast.makeText(this, "Jobs Fragment To Load", Toast.LENGTH_SHORT).show() // UploadActivity to this
            } else if (fragmentToLoad.equals("Home")){
                loadFragments(EShopFragment())
                bnv_bottomNavigation.selectedItemId = R.id.home
                //Toast.makeText(this, "Home Fragment To Load", Toast.LENGTH_SHORT).show() // UploadActivity to this
            }
        } else {
            loadFragments(EShopFragment())
            fragmentItemId = R.id.home
            //Toast.makeText(this, "Fragment To Load ##NULL", Toast.LENGTH_SHORT).show()
        }

        bnv_bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    //Toast.makeText(this, "$it.title ItemSelectedListener", Toast.LENGTH_SHORT).show()
                    loadFragments(EShopFragment())
                    true
                }
                R.id.jobs -> {
                    //Toast.makeText(this, "$it.title ItemSelectedListener", Toast.LENGTH_SHORT).show()
                    loadFragments(ExchangeFragment())
                    true
                }
                /*R.id.responses -> {
                    //Toast.makeText(this, "$it.title ItemSelectedListener", Toast.LENGTH_SHORT).show()
                    loadFragments(ResponsesFragment())
                    true
                }*/
                R.id.profile -> {
                    //Toast.makeText(this, "$it.title ItemSelectedListener", Toast.LENGTH_SHORT).show()
                    loadFragments(LaunchPadsFragment())
                    true
                }
                R.id.groups -> {
                    //Toast.makeText(this, "$it.title ItemSelectedListener", Toast.LENGTH_SHORT).show()
                    loadFragments(WalletFragment())
                    true
                }
                else -> {
                    true
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        //Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
        getExtraLoadFragment()

    }

    private fun  loadFragments(fragment: Fragment) {
        if (fragment!=null){
            supportFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.fl_parentContainer, fragment).commit()
        }
    }




    @SuppressLint("RestrictedApi")
    override fun onBackPressed(){
        if(bnv_bottomNavigation.selectedItemId==R.id.home){
            super.onBackPressed()
            finish()
        } else {
            Toast.makeText(this, "Please select bottom navigation", Toast.LENGTH_SHORT).show()
            //super.onBackPressed() // Previous Fragment loads with this but does not have bnv_bottomNavigation reflect that


            //bnv_bottomNavigation.selectedItemId = R.id.home // bottomNavigation backstack be accessed here and be directed from here
            //bnv_bottomNavigation.selectedItemId =


        }

        //val homeItem: MenuItem = bnv_bottomNavigation.getMenu().getItem(0)
        /* if (bnv_bottomNavigation.selectedItemId!=R.id.home) {
             bnv_bottomNavigation.selectedItemId = R.id.home
         } else {
             super.onBackPressed()
             finish()
         }*/
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
        return true
    }


}