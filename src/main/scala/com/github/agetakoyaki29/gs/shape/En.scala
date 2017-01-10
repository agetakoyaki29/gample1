package com.github.agetakoyaki29.gs.shape

import javafx.scene.canvas.GraphicsContext

import com.github.agetakoyaki29.gs.PKG._
import com.github.agetakoyaki29.scalafx.scene.canvas.XXX.GraphicsContextExtension

import com.github.agetakoyaki29.scala.geometry.dim2.point.circle.Circle
import javafx.scene.paint.Color
import com.github.agetakoyaki29.scala.geometry.dim2.point.Point


class En(val circle: Circle) extends Shape {

  def getPts = Set(circle.sp, circle.ep)

  val corner = Point(circle.range.norm, circle.range.norm)
  val leftup = circle.sp - corner
  val rightdown = circle.sp + corner

  def stroke(gc: GraphicsContext) = {
    gc.strokeCircle2(leftup, corner*2)
  }

  def fill(gc: GraphicsContext) = {
    gc.fillCircle2(leftup, corner*2)
  }

  override def equals(op: Any): Boolean = op match {
    case op: Circle => circle same op
    case _ => false
  }

}
