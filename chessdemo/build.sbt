name := """chessdemo"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)

libraryDependencies ++= Seq(
  "org.kurento" % "kurento-client" % "5.0.3"
)

libraryDependencies += "org.kurento" % "kurento-utils-js" % "5.0.3"
