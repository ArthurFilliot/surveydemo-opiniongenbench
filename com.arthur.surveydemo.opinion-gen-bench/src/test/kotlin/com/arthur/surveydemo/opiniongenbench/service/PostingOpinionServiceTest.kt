package com.arthur.surveydemo.opiniongenbench.service

import io.kotlintest.specs.FunSpec

class PostingOpinionServiceTest: FunSpec({
    /*test("check posting two requests") {
        PostingOpinionsService.doPostOpinions(2, ageStart = 25, ageEnd = 35)
    }*/

    test("check posting requests during five seconds") {
        PostingOpinionsService.doPostOpinions(duration=5, ageStart = 25, ageEnd = 35)
    }
})