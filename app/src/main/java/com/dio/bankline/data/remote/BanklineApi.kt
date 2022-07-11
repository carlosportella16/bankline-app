package com.dio.bankline.data.remote

import com.dio.bankline.domain.Movimentacao
import retrofit2.http.GET
import retrofit2.http.Path

interface BanklineApi {

    @GET("movimentacoes/{id}")
    suspend fun findBankStatement(@Path("id") accountHolderId: Int): List<Movimentacao>
}