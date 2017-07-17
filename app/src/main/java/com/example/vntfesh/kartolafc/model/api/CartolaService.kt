package com.example.vntfesh.kartolafc.model.api

import com.example.vntfesh.kartolafc.model.Status
import com.example.vntfesh.kartolafc.model.domain.Athlete
import com.example.vntfesh.kartolafc.model.domain.Highlight
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by vntfesh on 6/29/17.
 */

interface CartolaService {

    @GET("mercado/status")
    fun getStatus(): Observable<Status>

    @GET("/mercado/destaques")
    fun getHighlightList(): Observable<List<Highlight>>

}