package com.github.agetakoyaki29.gs.shape

import com.github.agetakoyaki29.geometry.dim2.figure.Figure
import com.github.agetakoyaki29.geometry.dim2.line.Line
import javafx.scene.canvas.GraphicsContext
import com.github.agetakoyaki29.geometry.dim2.Point
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
