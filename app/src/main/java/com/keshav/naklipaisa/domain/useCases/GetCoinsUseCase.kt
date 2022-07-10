package com.keshav.naklipaisa.domain.useCases

import com.keshav.naklipaisa.common.Resource
import com.keshav.naklipaisa.data.remote.dto.toCoin
import com.keshav.naklipaisa.domain.model.Coin
import com.keshav.naklipaisa.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins()
            emit(Resource.Success<List<Coin>>(coins.map { it.toCoin() }))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Unexpected Error Occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error<List<Coin>>(
                    e.localizedMessage ?: "Couldn't reach server. Check Internet connection"
                )
            )
        }
    }
}