package com.example.vntfesh.kartolafc.model.domain

import com.google.gson.annotations.SerializedName

/**
 * Created by vntalqd on 05/07/2017.
 */

class Athlete {

    @SerializedName("atleta_id")
    val id = 0;

    @SerializedName("foto")
    val photo: String? = null;

    @SerializedName("nome")
    val name: String? = null;

    @SerializedName("apelido")
    val nickname: String? = null;

    @SerializedName("preco_editorial")
    val editorialPrice: Double = 0.0;

}