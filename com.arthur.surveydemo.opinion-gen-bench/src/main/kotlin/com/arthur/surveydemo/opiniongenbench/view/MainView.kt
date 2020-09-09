package com.arthur.surveydemo.opiniongenbench.view

import com.arthur.surveydemo.opiniongenbench.Styles
import com.arthur.surveydemo.opiniongenbench.service.PostingOpinionsService
import javafx.geometry.Pos
import tornadofx.*

class MainView : View("Opinion postings generator") {
    val inputRepositoryURL = javafx.beans.property.SimpleStringProperty("http://localhost/api/surveydemo")
    val inputNbOpinions = javafx.beans.property.SimpleIntegerProperty(-1)
    val inputDuration = javafx.beans.property.SimpleIntegerProperty(30)
    val inputAgeMin = javafx.beans.property.SimpleIntegerProperty(25)
    val inputAgeMax = javafx.beans.property.SimpleIntegerProperty(55)

    override val root = vbox {
        label(title) {
            addClass(Styles.heading)
        }
        form {
            fieldset ("Repository"){
                field("URL") {
                    textfield(inputRepositoryURL)
                }
            }
            fieldset ("Parameters"){
                field("Nb postings") {
                    textfield(inputNbOpinions)
                }
                field("Duration (in sec.)") {
                    textfield(inputDuration)
                }
                field("Age min.") {
                    textfield(inputAgeMin)
                }
                field("Age max.") {
                    textfield(inputAgeMax)
                }
            }
        }
        hbox {
            alignment = Pos.CENTER
            button("Generate postings") {
                action {
                    runAsync {
                        PostingOpinionsService.repositoryUrl = inputRepositoryURL.value
                        PostingOpinionsService.doPostOpinions(
                            inputNbOpinions.value,
                            inputDuration.value,
                            inputAgeMin.value,
                            inputAgeMax.value)
                    } /*ui { () -> {}
                    //this.isDisabled = false
                }*/
                }
            }
        }

    }
}
