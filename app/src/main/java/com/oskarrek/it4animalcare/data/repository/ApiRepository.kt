package com.oskarrek.it4animalcare.data.repository


import android.os.Build
import androidx.annotation.RequiresApi
import com.oskarrek.it4animalcare.data.model.AdvertisementModel
import com.oskarrek.it4animalcare.data.model.AnimalModel
import com.oskarrek.it4animalcare.data.model.DeadlineModel
import com.oskarrek.it4animalcare.data.model.UserModel
import com.oskarrek.it4animalcare.data.model.request.LoginRequest
import com.oskarrek.it4animalcare.data.model.request.RegisterRequest
import com.oskarrek.it4animalcare.data.model.response.ApiResult
import com.oskarrek.it4animalcare.data.source.remote.RetrofitClientGenerator
import com.oskarrek.it4animalcare.data.source.remote.api.AdvertisementsApi
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

@RequiresApi(Build.VERSION_CODES.N)
object ApiRepository {

    private val advertisementsApi = RetrofitClientGenerator.createClient(AdvertisementsApi::class.java)

    fun getAdvertisements() : Single<List<AdvertisementModel>> {
       return advertisementsApi
           .getAdvertisements()
           .subscribeOn(Schedulers.single())
           .map {response -> response.advertisements}
           .observeOn(AndroidSchedulers.mainThread())
    }

    fun getAdvertisementDeadlines(id : Int) : Single<List<DeadlineModel>> {
        return advertisementsApi
            .getAdvertisementDeadlines(id)
            .subscribeOn(Schedulers.single())
            .map {response -> response.deadlines}
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getAdvertisementAnimals(id : Int) : Single<List<AnimalModel>> {
        return advertisementsApi
            .getAdvertisementAnimals(id)
            .subscribeOn(Schedulers.single())
            .map {response -> response.animals}
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun registerUser(registerRequest : RegisterRequest) : Single<Response<ApiResult>> {
        return advertisementsApi
            .registerUser(registerRequest)
            .subscribeOn(Schedulers.single())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun loginUser(loginRequest : LoginRequest)  : Single<UserModel?> {
        return advertisementsApi
            .loginUser(loginRequest)
            .subscribeOn(Schedulers.single())
            .map {it.body()?.get(0)}
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun logoutUser(login : String) : Single<ApiResult> {
        return  advertisementsApi
            .logoutUser(login)
            .subscribeOn(Schedulers.single())
            .observeOn(AndroidSchedulers.mainThread())
    }

}