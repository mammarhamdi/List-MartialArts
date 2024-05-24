package com.ammartech.submissionaplikasiandroidpemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMartial: RecyclerView
    private val list = ArrayList<Martial>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMartial = findViewById(R.id.rv_martial)
        rvMartial.setHasFixedSize(true)

        list.addAll(getListMartial())
        showRecyclerList()
    }

    private fun getListMartial(): ArrayList<Martial> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listMartial = ArrayList<Martial>()
        for (i in dataName.indices) {
            val martial = Martial(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listMartial.add(martial)
        }
        return listMartial
    }

    private fun showSelectedMartial(hero: Martial) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }

    private fun showRecyclerList() {
        rvMartial.layoutManager = LinearLayoutManager(this)
        val listMartialAdapter = ListMartialAdapter(list)
        rvMartial.adapter = listMartialAdapter

        listMartialAdapter.setOnItemClickCallback(object : ListMartialAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Martial) {
                showSelectedMartial(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvMartial.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvMartial.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
