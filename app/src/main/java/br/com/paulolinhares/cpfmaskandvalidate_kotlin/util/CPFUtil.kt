package br.com.paulolinhares.cpfmaskandvalidate_kotlin.util

import android.util.Log
import android.widget.Toast

/**
 * Created by paulolinhares on 20/10/17.
 */
class CPFUtil{

    companion object {
        fun validateCpf(cpf: String): Boolean {

            val regex : Regex = Regex("([\\.])([\\,])")
            val cpfClean = cpf.replaceFirst(regex, "")
            Log.i("TAG", "cpf: " + cpfClean)


            return false
        }
    }


}