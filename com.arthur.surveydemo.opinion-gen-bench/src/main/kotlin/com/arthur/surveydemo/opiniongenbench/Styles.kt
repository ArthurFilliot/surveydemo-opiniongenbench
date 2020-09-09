package com.arthur.surveydemo.opiniongenbench

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
    }

    init {
        heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }
        /*label {
            minWidth = 100.px;
        }
        field {
            maxWidth = 250.px;
        }*/
    }
}