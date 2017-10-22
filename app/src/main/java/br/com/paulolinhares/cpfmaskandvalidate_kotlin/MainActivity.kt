package br.com.paulolinhares.cpfmaskandvalidate_kotlin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import br.com.paulolinhares.cpfmaskandvalidate_kotlin.util.CPFUtil
import br.com.paulolinhares.cpfmaskandvalidate_kotlin.util.Mask
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        etCpf.addTextChangedListener(Mask.mask("###.###.###-##", etCpf))


        fab.setOnClickListener { view ->
            if (CPFUtil.myValidateCPF(etCpf.text.toString()))
                showSnackFeedback("CPF valid", true, view)
            else
                showSnackFeedback("CPF Invalid", false, view)
        }
    }

    fun showSnackFeedback(message : String, isValid : Boolean, view : View){
        val snackbar : Snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        var v : View = snackbar.view
        if (isValid)
            v.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
        else
            v.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))

        snackbar.show()
    }


}
