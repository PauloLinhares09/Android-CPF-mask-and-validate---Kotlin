package br.com.paulolinhares.cpfmaskandvalidate_kotlin.util

import android.util.Log
import android.widget.Toast

/**
 * Created by paulolinhares on 20/10/17.
 */
class CPFUtil{

    companion object {
        fun validateCpf(cpf: String): Boolean {


            val cpfClean = cpf.replace(".", "").replace("-", "")

            //## check if size is eleven
            if (cpfClean.length != 11)
                return false

            //## check if is number
            try {
               val number  = cpfClean.toLong()
            }catch (e : Exception){
                return false
            }

            //continue
            val cpfArray = IntArray(11)
            var dv1 = 0
            var dv2 = 0

            var i : Int = 0
            while (i < 11){
                cpfArray[i] = cpfClean.substring(i, i+1).toInt()
                i++
            }

            i = 0;
            while (i < 9){
                dv1 += cpfArray[i] * (i+1)
                i++
            }
            dv1 = dv1 % 11
            cpfArray[9] = dv1

            i = 0
            while (i < 10){
                dv2 += cpfArray[i] * i
                i++
            }
            dv2 = dv2 % 11
            cpfArray[10] = dv2

            if (dv1 > 9)
                cpfArray[9] = 0
            if (dv2 > 9)
                cpfArray[10] = 0

            if (cpfClean.substring(9, 10).toInt() != cpfArray[9] || cpfClean.substring(10, 11).toInt() != cpfArray[10])
                return false


            return true
        }
    }


}