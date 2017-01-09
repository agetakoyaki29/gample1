package com.github.agetakoyaki29.gs

import javafx.event.Event
import javafx.event.EventHandler
import javafx.geometry.Point2D
import javafx.scene.input.MouseEvent
import com.github.agetakoyaki29.scala.geometry.dim2.Dim2


object PKG {
  implicit def f2eh[T <: Event](f: T => Unit) = new EventHandler[T] {
    def handle(event: T) = f(event)
  }

  implicit def pt2ToDim2(pt2: Point2D) = Dim2(pt2.getX, pt2.getY)
  implicit def meToDim2(pt2: MouseEvent) = Dim2(pt2.getX, pt2.getY)

  implicit def dim2ToPt2(dim2: Dim2) = new Point2D(dim2.x, dim2.y)
}
