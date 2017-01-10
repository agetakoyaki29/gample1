package com.github.agetakoyaki29.gs

import scala.collection.JavaConversions._

import javafx.collections.ObservableList
import javafx.collections.FXCollections
import com.github.agetakoyaki29.gs.shape.Shape
import com.github.agetakoyaki29.scala.geometry.dim2.point.Point
import javafx.collections.SetChangeListener
import com.github.agetakoyaki29.gs.shape.Sen
import com.github.agetakoyaki29.gs.shape.En


class ShapePool {
  val shapes = FXCollections.observableSet[Shape]()
  val points = FXCollections.observableSet[Point]()

  def add(shape: Shape) = {
    shapes.add(shape)
  }

	shapes.addListener(new SetChangeListener[Shape] {
	  def onChanged(change: SetChangeListener.Change[_ <: Shape]) = if(change.wasAdded) {
      val shape = change.getElementAdded
      points.addAll(shape.getPts)

      shape match {
        case sen: Sen => shapes.foreach(_ match {
          case op: Sen => points.addAll(sen.line intersect op.line)
          case op: En => points.addAll(sen.line intersect op.circle)
        })
        case en: En => shapes.foreach(_ match {
          case op: Sen => points.addAll(en.circle intersect op.line)
          case op: En => points.addAll(en.circle intersect op.circle)
        })
      }
	  }
	})
}
