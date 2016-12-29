package com.github.agetakoyaki29.gs.shape

import javafx.scene.canvas.GraphicsContext

import com.github.agetakoyaki29.gs.PKG._
import com.github.agetakoyaki29.scalafx.scene.canvas.XXX.GraphicsContextExtension

import com.github.agetakoyaki29.geometry.dim2.line.Line
import javafx.scene.paint.Color
import com.github.agetakoyaki29.geometry.dim2.Point


class Sen(val line: Line) extends Shape {
  
  def getPts = Set(line.sp, line.ep)
  
  def stroke(gc: GraphicsContext) = {
    val prev = gc.getStroke
    
    gc.setStroke(Color.GRAY)
    val nwed = line.dir*40
    val newl = Line((line.sp-nwed).asInstanceOf[Point], nwed*2)
    gc.strokeLine2(newl.sp, newl.ep)
    
    gc.setStroke(prev)
    gc.strokeLine2(line.sp, line.ep)
  }
  
  def fill(gc: GraphicsContext) = {}
  
  override def equals(op: Any): Boolean = op match {
    case op: Line => line sameWithDelta op
    case _ => false
  }
  
}