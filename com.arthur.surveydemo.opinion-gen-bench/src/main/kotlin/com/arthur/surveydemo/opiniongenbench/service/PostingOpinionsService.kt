package com.arthur.surveydemo.opiniongenbench.service

import com.arthur.surveydemo.opiniongenbench.domain.OpinionModel
import com.arthur.surveydemo.opiniongenbench.domain.Score
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

object PostingOpinionsService  {

    var repositoryUrl = "http://localhost";
    var postOpinion:(OpinionModel) -> Unit = RestFacade.postOpinion(repositoryUrl)
        private set

    fun doPostOpinions(nbOpinions: Int=-1, duration: Int = 30, ageStart:Int, ageEnd:Int) {
        postOpinion = RestFacade.postOpinion(repositoryUrl)
        if (duration<0) {
            doPost( nbOpinions, 30, ageStart, ageEnd);
        }else{
            doPost( nbOpinions, duration, ageStart, ageEnd);
        }
        Thread.sleep(2000);
        println("sent")
    }

    private fun doPostRec(nbOpinions: Int, duration: Int = 30, ageStart:Int, ageEnd:Int) {

    }

    private fun doPost(nbOpinions: Int, duration: Int = 30, ageStart:Int, ageEnd:Int) {
        val start = Date().time
        var cnt = 0;
        do {
            GlobalScope.launch {
                val score = Score.getByValue((0..3).random())
                val age = (ageStart..ageEnd).random()
                println(" score " + score + " - age " + age)
                postOpinion(OpinionModel(score!!, age))
            }
            val now = Date().time
            cnt++;
        }while(now<start+(duration*1000) && (nbOpinions<=0 || cnt<nbOpinions))
    }

}