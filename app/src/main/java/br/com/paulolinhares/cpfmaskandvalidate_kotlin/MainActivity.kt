package br.com.paulolinhares.cpfmaskandvalidate_kotlin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import br.com.paulolinhares.cpfmaskandvalidate_kotlin.util.CPFUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)




        fab.setOnClickListener { view ->
            if (CPFUtil.validateCpf(etCpf.text.toString()))
                Snackbar.make(view, "CPF valid", Snackbar.LENGTH_LONG).setAction("Action", null).show()
            else
                Snackbar.make(view, "CPF invalid", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }
    }


}
