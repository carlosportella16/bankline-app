package com.dio.bankline.ui.statement

import androidx.lifecycle.ViewModel
import com.dio.bankline.data.BanklineRepository

class BankStatmentViewModel : ViewModel() {

    fun findBankStatement(accountHolderId: Int) =
        BanklineRepository.findBankStatment(accountHolderId)
}