package com.github.agetakoyaki29.gs

import javafx.fxml.FXML
import javafx.scene.layout.BorderPane

import com.github.agetakoyaki29.slidefx.SlideController
import com.github.agetakoyaki29.slidefx.StageContainer
import com.github.agetakoyaki29.slidefx.controller.RootedController


class DrawSlideController extends BorderPane with SlideController with RootedController {
  
  @FXML var primaryPane: BorderPane = _
		
	primaryPane.setCenter(new GlassedCanvas)
  
	override def staged(container: StageContainer) = {
    val stage = container.stage
		stage.setWidth(800)
		stage.setHeight(600)
		stage.centerOnScreen()
		stage.setMaximized(true)
  }
  
  override def unstaged(container: StageContainer) = {
    val stage = container.stage
		stage.setMaximized(false)
  }
  
}
