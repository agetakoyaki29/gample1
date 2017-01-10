package com.github.agetakoyaki29.gs

import javafx.fxml.FXML
import javafx.scene.layout.BorderPane
import javafx.event.ActionEvent
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
import com.github.agetakoyaki29.scala.geometry.dim2.point.Point
import com.github.agetakoyaki29.scala.geometry.dim2.point.line.Line
import com.github.agetakoyaki29.scala.geometry.dim2.point.circle.Circle
import com.github.agetakoyaki29.gs.shape.Sen
import com.github.agetakoyaki29.gs.shape.En
import javafx.collections.SetChangeListener
import com.github.agetakoyaki29.gs.shape.Shape
import com.github.agetakoyaki29.gs.shape.Ten


class DrawSlideController extends BorderPane with SlideController with RootedController {

  val pool = new ShapePool

  val canvas = new GlassedCanvas

  // ----

	// add change listener to draw
	pool.shapes.addListener(new SetChangeListener[Shape] {
	  def onChanged(change: SetChangeListener.Change[_ <: Shape]) = if(change.wasAdded) {
      val shape = change.getElementAdded
      shape.stroke(canvas.coldGC)
	  }
	})

	// add change listener to draw
	pool.points.addListener(new SetChangeListener[Point] {
	  def onChanged(change: SetChangeListener.Change[_ <: Point]) = if(change.wasAdded) {
      val ten = new Ten(change.getElementAdded)
//      ten.stroke(canvas.coldGC)
      ten.fill(canvas.coldGC)
	  }
	})

  // ---- evt ----

  onDrawLine(null)

  @FXML def onDrawLine(evt: ActionEvent) = {
  	var sp: Point = null
  	canvas.setOnMouseClicked((evt: MouseEvent) => {
  	  if(sp == null) sp = Point(evt)
  	  else {
  	    val ep = Point(evt)
  	    if(!(sp same ep)) {
    	    pool.add(new Sen(Line(sp, ep)))
    	    sp = null
  	    }
  	  }
  	})
  }

  @FXML def onDrawCircle(evt: ActionEvent) = {
  	var sp: Point = null
  	canvas.setOnMouseClicked((evt: MouseEvent) => {
  	  if(sp == null) sp = Point(evt)
  	  else {
  	    val ep = Point(evt)
  	    if(!(sp same ep)) {
    	    pool.add(new En(Circle(sp, ep)))
    	    sp = null
  	    }
  	  }
  	})
  }

  // ----

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
