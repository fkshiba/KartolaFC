package com.example.vntfesh.kartolafc.model.domain

import com.google.gson.annotations.SerializedName

/**
 * Created by vntalqd on 05/07/2017.
 */

class Highlight {

    @SerializedName("Atleta")
    val athlete: Athlete? = null;

    @SerializedName("posicao")
    val position: String? = null;

    @SerializedName("escalacoes")
    val numberOfDraft = 0;

    @SerializedName("clube")
    val team: String? = null;

    @SerializedName("escudo_clube")
    val teamShield: String? = null;

}