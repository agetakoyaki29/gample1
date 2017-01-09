
lazy val root = (project in file("."))
  .settings(fxmlSettings: _*)
  .settings(
    organization := "com.github.agetakoyaki29",
    name := "gample1",
    version := "1.0",
    scalaVersion := "2.11.8",

    libraryDependencies += scalactic,
    libraryDependencies += scalatest,

    logBuffered in Test := false
  )
  .dependsOn(scalafx)
  .dependsOn(slidefx1)
  .dependsOn(geo3)

// ---- settings ----
lazy val fxmlSettings = Seq(
    unmanagedJars in Compile += {
        val ps = new sys.SystemProperties
        val jh = ps("java.home")
        Attributed.blank(file(jh) / "lib/ext/jfxrt.jar")
    }
)

// ---- lib ----
lazy val scalactic = "org.scalactic" %% "scalactic" % "2.2.5"
lazy val scalatest = "org.scalatest" %% "scalatest" % "2.2.5" % "test"

lazy val scalafx = RootProject(uri("git://github.com/agetakoyaki29/scalafx"))
lazy val slidefx1 = RootProject(uri("git://github.com/agetakoyaki29/slidefx1"))
lazy val geo3 = RootProject(file("../geo3"))
