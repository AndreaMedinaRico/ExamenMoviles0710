package com.example.kotlin.examenmoviles0710.framework.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlin.examenmoviles0710.R
import com.example.kotlin.examenmoviles0710.data.network.models.Item
import com.example.kotlin.examenmoviles0710.databinding.ActivityMainBinding
import com.example.kotlin.examenmoviles0710.framework.adapters.CharacterAdapter
import com.example.kotlin.examenmoviles0710.framework.viewmodel.CharacterViewModel
import com.example.kotlin.examenmoviles0710.framework.views.fragments.BusquedaFragment
import com.example.kotlin.examenmoviles0710.framework.views.fragments.CharacterFragment
import com.example.kotlin.examenmoviles0710.utils.Constants

class MainActivity(): AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter : CharacterAdapter = CharacterAdapter()
    private lateinit var data:ArrayList<Item>

    private val viewModel: CharacterViewModel by viewModels()
    private lateinit var currentFragment: Fragment
    private var currentMenuOption:String?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeListeners()
        exchangeCurrentFragment(CharacterFragment(), Constants.MENU_CHAR)
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun exchangeCurrentFragment(newFragment: Fragment, newMenuOption:String){
        currentFragment = newFragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main,currentFragment)
            .commit()

        currentMenuOption = newMenuOption
    }

    private fun initializeListeners() {
        binding.appBarMain.llPokedex.setOnClickListener {
            selectMenuOption(Constants.MENU_CHAR)
        }

        binding.appBarMain.llSearch.setOnClickListener {
            selectMenuOption(Constants.MENU_SEARCH)
        }
    }

    private fun selectMenuOption(menuOption:String){
        if(menuOption == currentMenuOption){
            return
        }

        when(menuOption){
            Constants.MENU_CHAR -> exchangeCurrentFragment(CharacterFragment(),Constants.MENU_CHAR)
            Constants.MENU_SEARCH -> exchangeCurrentFragment(BusquedaFragment(),Constants.MENU_SEARCH)
        }
    }


}