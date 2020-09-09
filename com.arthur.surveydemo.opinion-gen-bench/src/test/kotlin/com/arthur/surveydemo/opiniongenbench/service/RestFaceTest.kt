package com.arthur.surveydemo.opiniongenbench.service

import com.arthur.surveydemo.opiniongenbench.domain.OpinionModel
import com.arthur.surveydemo.opiniongenbench.domain.Score
import io.kotlintest.specs.FunSpec

class RestFaceTest: FunSpec ({
    test("check post request") {
        RestFacade.postOpinion("http://localhost")(OpinionModel(Score.GREAT,11))
    }
})