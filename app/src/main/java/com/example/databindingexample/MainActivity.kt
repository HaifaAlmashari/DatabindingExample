package com.example.databindingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databindingexample.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)

        binding.main = viewModel

        // This line I forget to write
        binding.lifecycleOwner = this@MainActivity

        binding.fab.setOnClickListener { view ->

            viewModel.changeName(Random.nextInt(20).toString())

            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction(
                    "Action",
                    null
                ).show()
        }
    }
}