package com.keshav.naklipaisa.data.repository

import com.keshav.naklipaisa.data.remote.CoinApi
import com.keshav.naklipaisa.data.remote.dto.CoinDetailDto
import com.keshav.naklipaisa.data.remote.dto.CoinDto
import com.keshav.naklipaisa.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinApi: CoinApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return coinApi.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return coinApi.getCoinById(coinId)
    }
}