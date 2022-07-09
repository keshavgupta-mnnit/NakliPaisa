package com.keshav.naklipaisa.domain.repository

import com.keshav.naklipaisa.data.remote.dto.CoinDetailDto
import com.keshav.naklipaisa.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}