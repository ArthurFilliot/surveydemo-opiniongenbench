package com.arthur.surveydemo.opiniongenbench.service

import com.arthur.surveydemo.opiniongenbench.domain.OpinionModel

interface RestFacade {

    fun postOpinion(opinionModel: OpinionModel) : Unit

    companion object {
        fun postOpinion(url: String): (OpinionModel) -> Unit = { (data) ->
                try {
                    khttp.post(url=url, data=data, timeout = 2000.0)
                }catch(e:java.net.ConnectException){
                    e.printStackTrace();
                }
            }
    }
}