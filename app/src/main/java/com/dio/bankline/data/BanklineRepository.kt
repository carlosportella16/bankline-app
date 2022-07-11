package com.dio.bankline.data


import android.util.Log
import androidx.lifecycle.liveData
import com.dio.bankline.data.remote.BanklineApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object BanklineRepository {

    private val TAG = javaClass.simpleName

    private val restApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BanklineApi::class.java)
    }

    fun findBankStatment(accountHolderId: Int) = liveData{
        emit(State.Wait)
        try {
            emit(State.Success(data = restApi.findBankStatement(accountHolderId)))
        } catch (e: Exception) {
            Log.e(TAG, e.message, e)
            emit(State.Error(e.message))
        }
    }
}


