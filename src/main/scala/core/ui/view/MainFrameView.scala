package core.ui.view

import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.{Button, ToggleButton}
import scalafx.scene.layout._
import scalafx.scene.text.Text

/**
  * MainFeameのview
  *
  * @see scalafx official http://www.scalafx.org/docs/home/
  * @see scalafx8.0 apidoc http://www.scalafx.org/api/8.0/index.html
  * @see scalafx ensenmble https://github.com/scalafx/scalafx-ensemble
  * @see javafx ensemble http://download.oracle.com/otndocs/products/javafx/2/samples/Ensemble/index.html#SAMPLES/Layout
  * Created by bububu10 on 2016/05/22.
  */
class MainFrameView extends PrimaryStage {

  def createStage(): Unit = {
    title.value = "Gyges"
    width = 600
    height = 450
    resizable = false
    scene = new Scene {
      content = new BorderPane {
        padding = Insets(25)
        prefWidth = 600
        prefHeight = 450
        left = new VBox {
          prefWidth = 150
          prefHeight = 430
          children = new ToggleButton {
            prefWidth = 130
            prefHeight = 10
            text = "test111"
          }
        }
        bottom = new HBox {
          prefWidth = 150
          prefHeight = 20
          children = new Button {
            prefWidth = 10
            prefHeight = 10
            text = "U"
          }
        }
        right = new FlowPane {
          prefWidth = 450
          prefHeight = 450
          children = (1 to 50).map(e => {
            new Text {
              style = "-fx-background-color: mistyrose"
              text = s"test${e}"
            }
          }
          )
        }
      }
    }
  }


}
