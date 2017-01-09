package com.github.agetakoyaki29.gs.shape

import com.github.agetakoyaki29.gs.PKG._
import com.github.agetakoyaki29.scalafx.scene.canvas.XXX.GraphicsContextExtension

import com.github.agetakoyaki29.scala.geometry.dim2.point.Point
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color


case class Ten(val pt: Point) {
  val delta = Point(2, 2)

  def stroke(gc: GraphicsContext) = {
    gc.strokeCircle2(pt-delta, delta*2)
  }

  def fill(gc: GraphicsContext) = {
//    gc.setFill(Color.WHITE)
    gc.fillCircle2(pt-delta, delta*2)
  }

}
