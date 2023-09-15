package com.dicoding.projectappnusantara

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvNusantara: RecyclerView
    private val list = ArrayList<Nusantara>()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvNusantara.layoutManager = LinearLayoutManager(this)
            }

            R.id.action_grid -> {
                rvNusantara.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.action_about -> {
                val aboutIntent = Intent(this, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNusantara = findViewById(R.id.rv_nusantara)
        rvNusantara.setHasFixedSize(true)
        list.addAll(getListNusantara())
        showRecyclerList()
    }

    private fun getListNusantara(): ArrayList<Nusantara> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listNusantara = ArrayList<Nusantara>()
        for (i in dataName.indices) {
            val nusantara =
                Nusantara(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listNusantara.add(nusantara)
        }
        dataPhoto.recycle()
        return listNusantara
    }

    private fun showRecyclerList() {
        rvNusantara.layoutManager = LinearLayoutManager(this)
        val listNusantaraAdapter = ListNusantaraAdapter(list)
        rvNusantara.adapter = listNusantaraAdapter

        listNusantaraAdapter.setOnItemClickCallback(object :
            ListNusantaraAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Nusantara) {
                showSelectedNusantara(data)
            }
        })
    }

    private fun showSelectedNusantara(nusantara: Nusantara) {
        val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)
        detailIntent.putExtra("NUSANTARA_NAME", nusantara.name)
        detailIntent.putExtra("NUSANTARA_DESCRIPTION", nusantara.description)
        detailIntent.putExtra("NUSANTARA_PHOTO", nusantara.photo)
        startActivity(detailIntent)
    }

}

