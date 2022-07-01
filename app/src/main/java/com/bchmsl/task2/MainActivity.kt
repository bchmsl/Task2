package com.bchmsl.task2

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import com.bchmsl.task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val array = mutableListOf<String>()
    private val anagrams = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        listeners()
    }

    private fun listeners() {
        binding.btnSave.setOnClickListener {
            saveAnagram()
            binding.etInput.setText("")
        }
        binding.btnOutput.setOnClickListener {
            getAnagram()
            binding.tvOutput.text = anagrams.toString()
        }
    }

    private fun saveAnagram() {
        val value = binding.etInput.text.toString()
        array.add(value)
    }

    private fun getAnagram() {
        array.forEach { first ->
            array.forEach { second ->
                if (first.toSortedSet() == second.toSortedSet() && first !in anagrams) {
                    if (!(first === second)) {
                        anagrams.add(first)
                        d("TAG - ADDED", first)
                    }
                }
            }
        }

        d("TAG - Full", array.toString())
        d("TAG - Anagrams", anagrams.toString())
    }

}