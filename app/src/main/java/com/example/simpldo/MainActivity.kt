package com.example.simpldo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.simpldo.databinding.ActivityMainBinding
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private val mainPrefInstance: SharedPreferences by lazy {
        this.getSharedPreferences(
            "Storage",
            Context.MODE_PRIVATE
        )
    }
    private val sharedViewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController

        sharedViewModel.todo.value!!.addAll(getStoreData())
    }

    override fun onDestroy() {
        setStoreData()
        super.onDestroy()
    }

    private fun setStoreData() {
        mainPrefInstance.edit().apply { putString("json", Gson().toJson(sharedViewModel.todo.value!!.toTypedArray())) }.apply()
    }

    private fun getStoreData(): List<ListItem> {
        return Gson().fromJson(mainPrefInstance.getString("json", ""), Array<ListItem>::class.java)?.asList() ?: listOf()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}