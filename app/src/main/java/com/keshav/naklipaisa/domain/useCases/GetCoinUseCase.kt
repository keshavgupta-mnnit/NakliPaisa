package com.keshav.naklipaisa.domain.useCases

import com.keshav.naklipaisa.common.Resource
import com.keshav.naklipaisa.data.remote.dto.toCoinDetail
import com.keshav.naklipaisa.domain.model.CoinDetail
import com.keshav.naklipaisa.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId)
            emit(Resource.Success<CoinDetail>(coin.toCoinDetail()))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Unexpected Error Occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error<CoinDetail>(
                    e.localizedMessage ?: "Couldn't reach server. Check Internet connection"
                )
            )
        }
    }
}