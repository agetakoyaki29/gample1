package com.github.agetakoyaki29.gs.shape

import com.github.agetakoyaki29.scala.geometry.dim2.point.Figure
import com.github.agetakoyaki29.scala.geometry.dim2.point.line.Line
import javafx.scene.canvas.GraphicsContext
import com.github.agetakoyaki29.scala.geometry.dim2.point.Point
import javafx.scene.paint.Paint


abstract class Shape {
  def getPts: Set[Point]

  def stroke(gc: GraphicsContext): Unit
  def stroke(gc: GraphicsContext, paint: Paint): Unit = {
    gc.setStroke(paint)
    stroke(gc)
  }

  def fill(gc: GraphicsContext): Unit
  def fill(gc: GraphicsContext, paint: Paint): Unit = {
    gc.setStroke(paint)
    fill(gc)
  }
}
