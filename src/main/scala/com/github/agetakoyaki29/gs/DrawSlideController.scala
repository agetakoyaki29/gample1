package com.github.agetakoyaki29.gs

import javafx.fxml.FXML
import javafx.scene.layout.BorderPane
import javafx.scene.input.MouseEvent
import javafx.geometry.Point2D

import com.github.agetakoyaki29.gs.PKG._
import com.github.agetakoyaki29.scalafx.scene.canvas.XXX.GraphicsContextExtension

import com.github.agetakoyaki29.scalafx.scene.control.GlassedCanvas
import com.github.agetakoyaki29.slidefx.SlideController
import com.github.agetakoyaki29.slidefx.StageContainer
import com.github.agetakoyaki29.slidefx.fxml.controller.RootedController


class DrawSlideController extends BorderPane with SlideController with RootedController {
  
  val canvas = new GlassedCanvas
	canvas.hotGC.strokeLine(10, 20, 300, 400)
	canvas.coldGC.strokeCircle(10, 20, 300, 400)
	
  @FXML var primaryPane: BorderPane = _
	primaryPane.setCenter(canvas)
  
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
