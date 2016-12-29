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
import javafx.scene.canvas.Canvas
import javafx.stage.Screen


class DrawSlideController extends BorderPane with SlideController with RootedController {
  
  val canvas = new GlassedCanvas
	canvas.hotGC.strokeLine(10, 20, 500, 600)
	canvas.coldGC.strokeCircle(10, 20, 500, 600)
	var sp: Point2D = null
	canvas.setOnMouseClicked((evt: MouseEvent) => {
	  if(sp == null) sp = new Point2D(evt.getX, evt.getY)
	  else {
	    val ep = new Point2D(evt.getX, evt.getY)
	    canvas.coldGC.strokeLine(sp, ep)
	    sp = null
	  }
	})
	
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
