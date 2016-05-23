package core.ui.controller

import core.ui.view.MainFrameView

import scalafx.application.JFXApp

/**
  *
  * Created by bububu10 on 2016/05/22.
  */
object MainFrameController extends JFXApp {

  stage = new MainFrameView()
  val instance = stage.asInstanceOf[MainFrameView].createStage()


}
