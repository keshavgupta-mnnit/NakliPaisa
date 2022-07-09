package com.keshav.naklipaisa.presentation.coin_detail

import com.keshav.naklipaisa.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coins: CoinDetail? = null,
    val error: String = ""
)