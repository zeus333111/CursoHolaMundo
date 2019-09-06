package com.zeus.cursoholamundo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zeus.cursoholamundo.Entities.Credential
import com.zeus.cursoholamundo.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val client by lazy { RetrofitClient.createClient() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sicansios3 = Sicansios("verde")
        tv_hola.text = sicansios3.alturaPies()

        sicansios3.start({n,i -> true}){

        }

        /*btn_aceptar.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {

            }
        }*/
        btn_aceptar.setOnClickListener {
            val credential = Credential(
                et_number.text.toString().toInt(),
                et_code.text.toString()
            )
            //Toast.makeText(this, "asodfnnskdjfn", Toast.LENGTH_LONG).show()
            CoroutineScope(Dispatchers.IO).launch {
                var sum = 5 + 5
                launch(Dispatchers.Main) { tv_hola.text = "Resultado: $sum" }
                delay(5000)
                sum += 5
                launch(Dispatchers.Main) { tv_hola.text = "Resultado: $sum" }
                val result = async(Dispatchers.Default) {return@async 10+10 }.await()

                val resultLogin = client.login(credential).await()
                launch(Dispatchers.Main) {
                    if (resultLogin.isSuccessful){
                        val msn = resultLogin.body()!!.msn
                        tv_hola.text = msn
                    } else {
                        tv_hola.text = "Error en la peticion"
                    }
                }
            }
        }


        for ( i in 0..10){

        }
        for(i in 0 until 10){

        }
        for (i in 0..10 step 2){}

        val lista = listOf("uno","dos")

        for (i in lista){

        }

        lista.forEach {

        }


        val opcion = 5
        when(opcion){
            5 -> print(opcion)
            2 -> {
                print(opcion)
                print(opcion+1)
            }
            else -> {}
        }

        when{
            opcion == 1 ->{}
            lista.size > 5 ->{}
            opcion in 0..10 -> {}
            else -> {}
        }
    }

    /*fun btnClic(view: View){
        Toast.makeText(this, "asodfnnskdjfn", Toast.LENGTH_LONG).show()
    }*/

    override fun onPause() {
        super.onPause()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }

    fun Sicansios.alturaPies(): String{
        return "${this.altura.toDouble() * 3.28} Pies"
    }
}
