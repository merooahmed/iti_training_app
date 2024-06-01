package com.ya.iticourse.ui.second

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle

import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ya.iticourse.ui.ThirdActivity
import com.ya.iticourse.ui.CustomerAdapter
import com.ya.iticourse.ui.MyCustomClickListener
import com.ya.iticourse.R
import com.ya.iticourse.databinding.ActivitySecondBinding
import com.ya.iticourse.core.model.Post
import com.ya.iticourse.core.data_source.remote.ApiInterface


class SecondActivity :AppCompatActivity() , MyCustomClickListener {
    lateinit var binding: ActivitySecondBinding
    lateinit var postAdapter: CustomerAdapter
    lateinit var sharedPref: SharedPreferences
    lateinit  var retrofit : ApiInterface
    lateinit var recyclerview:RecyclerView
    lateinit var viewModel:SecondViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

viewModel=SecondViewModel()

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = SecondViewModel()
        sharedPref = applicationContext.getSharedPreferences("UserPref", MODE_PRIVATE)





        val pref = applicationContext.getSharedPreferences("MySharedPreference",Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("USERNAME","Yara")
        editor.putBoolean("login",false)
        editor.putInt("password",1)
        editor.commit()
        val username = pref.getString("USERNAME"," ")





        viewModel.secondData.observe(this){
            recyclerview= findViewById(R.id.recyclerView)
            recyclerview.setHasFixedSize(true)
            recyclerview.layoutManager = LinearLayoutManager(this@SecondActivity)

            postAdapter = CustomerAdapter(it.body()?: listOf(), this@SecondActivity)
            recyclerview.layoutManager = LinearLayoutManager(this@SecondActivity)
            binding.recyclerView.adapter = postAdapter
        }

        binding.postsbutton.setOnClickListener() {
            viewModel.startSecond(binding.userIdEt.text.toString().toInt())

        }




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_second_activity,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        println(item.itemId)
        return when(item.itemId){
            R.id.logout ->{
                val sharedPref = applicationContext.getSharedPreferences("UserPref", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.remove("USERNAME")
                editor.remove("PASSWORD")
                editor.putBoolean("IS_LOGIN",false)
                editor.commit()
               startActivity(Intent(this, SecondActivity::class.java))
                finish()
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onItemClick(post: Post, position: Int) {

        val intent = Intent(this@SecondActivity , ThirdActivity::class.java )
        intent.putExtra("postId", post.id)
        startActivity(intent)

    }

    }
