package com.github.agetakoyaki29.gs.shape

import com.github.agetakoyaki29.geometry.dim2.figure.Figure
import com.github.agetakoyaki29.geometry.dim2.line.Line
import javafx.scene.canvas.GraphicsContext
import com.github.agetakoyaki29.geometry.dim2.Point


abstract class Shape {
  def getPts: Set[Point]
  
  def stroke(gc: GraphicsContext)
  def fill(gc: GraphicsContext)
}
