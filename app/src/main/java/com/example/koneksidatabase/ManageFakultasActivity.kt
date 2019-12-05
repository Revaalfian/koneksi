package com.example.koneksidatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ManageFakultasActivity : AppCompatActivity() {

    lateinit var i: Intent
    lateinit var add:Button
    lateinit var edit:Button
    lateinit var delete:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_fakultas)
        i = intent
        if (i.hasExtra("editmode")) {

            if (i.getStringExtra("editmode").equals("1")) {

                onEditMode()
            }
        }
        add.setOnClickListener {
            create()
        }

        edit.setOnClickListener {
            update()
        }

        delete.setOnClickListener {
            Ondelete()
        }


    }
    private fun onEditMode() {
        txt_idfakultas.setText(i.getStringExtra("txt_idfakultas"))
        txt_kodefakultas.setText(i.getStringExtra("txt_kodefakultas"))
        txt_namafakultas.setText(i.getStringExtra("txt_namafakultas"))
        txt_idfakultas.isEnabled = false



        btnCreate.visibility = View.GONE
        btnUpdate.visibility = View.VISIBLE
        btnDelete.visibility = View.VISIBLE
    }

    private fun create(){

        val loading = ProgressDialog(this)
        loading.setMessage("Menambahkan data...")
        loading.show()

        AndroidNetworking.post(ApiEndPoint.CREATE)
            .addBodyParameter("kodefakultas",txt_kodefakultas.text.toString())
            .addBodyParameter("namafakultas",txt_namafakultas.text.toString())
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {

                override fun onResponse(response: JSONObject?) {

                    loading.dismiss()
                    Toast.makeText(applicationContext,response?.getString("message"),Toast.LENGTH_SHORT).show()

                    if(response?.getString("message")?.contains("successfully")!!){
                        this@ManageFakultasActivity.finish()
                    }

                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()                    }


            })

    }

    private fun update(){

        val loading = ProgressDialog(this)
        loading.setMessage("Mengubah data...")
        loading.show()

        AndroidNetworking.post(ApiEndPoint.UPDATE)
            .addBodyParameter("idfakultas",txt_idfakultas.text.toString())
            .addBodyParameter("kodefakultas",txt_kodefakultas.text.toString())
            .addBodyParameter("namafakultas",txt_namafakultas.text.toString())
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {

                override fun onResponse(response: JSONObject?) {

                    loading.dismiss()
                    Toast.makeText(applicationContext,response?.getString("message"),Toast.LENGTH_SHORT).show()

                    if(response?.getString("message")?.contains("successfully")!!){
                        this@ManageFakultasActivity.finish()
                    }

                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()                    }


            })

    }

    private fun Ondelete(){

        val loading = ProgressDialog(this)
        loading.setMessage("Menghapus data...")
        loading.show()

        AndroidNetworking.post(ApiEndPoint.DELETE)
            .addBodyParameter("kodefakultas",txt_kodefakultas.text.toString())
            .addBodyParameter("namafakultas",txt_namafakultas.text.toString())
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {

                override fun onResponse(response: JSONObject?) {

                    loading.dismiss()
                    Toast.makeText(applicationContext,response?.getString("message"),Toast.LENGTH_SHORT).show()

                    if(response?.getString("message")?.contains("successfully")!!){
                        this@ManageFakultasActivity.finish()
                    }

                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()                    }


            })

    }
