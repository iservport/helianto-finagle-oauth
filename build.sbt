import _root_.sbt.Artifact
import _root_.sbt.Keys._
import _root_.sbt.ModuleID
import _root_.sbt.ScalaVersion
import _root_.sbt.dsl._
//import com.typesafe.sbt.packager.archetypes.JavaServerAppPackaging

name := "helianto-finagle-oauth"

organization := "org.helianto"

version := "1.0"
crossPaths := false

scalaVersion := "2.11.7"

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  println(artifact.name + "-" + module.revision + "." + artifact.extension)
  artifact.name + "-" + module.revision + "." + artifact.extension
}
//
//packageBin in Compile := file(s"${name.value}.jar")

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.0.4",
  "org.helianto" % "helianto-core"      % "0.6.0-SNAPSHOT" changing(),
  "com.github.finagle" %% "finagle-oauth2" % "0.1.6",
  "com.typesafe.akka" %% "akka-kernel" % "2.4.1",
  "com.typesafe.akka" %% "akka-actor" % "2.4.1",
  "com.typesafe.akka" %% "akka-slf4j" % "2.4.1",
  "com.typesafe.akka" %% "akka-testkit" % "2.4.1",
  "com.typesafe.akka" %% "akka-http-experimental" % "2.0.1",
  "com.typesafe" % "config" % "1.3.0",
  "io.circe" %% "circe-generic" % "0.3.0"
)

//enablePlugins(JavaServerAppPackaging)

//mainClass in Compile := Some("org.helianto.mailer.Bootstrap")

resolvers ++= Seq(
  "Typesafe Releases"   at "https://repo.typesafe.com/typesafe/releases/",
  "Spring Releases"     at "http://maven.springframework.org/release",
  "Helianto Releases"   at "http://s3-sa-east-1.amazonaws.com/maven.helianto.org/release",
  "Helianto Snapshots"  at "http://s3-sa-east-1.amazonaws.com/maven.helianto.org/snapshot",
  "Iservport Releases"  at "http://s3-sa-east-1.amazonaws.com/maven.iservport.com/release",
  "Iservport Snapshots" at "http://s3-sa-east-1.amazonaws.com/maven.iservport.com/snapshot",
  "Artima Releases"     at "http://repo.artima.com/releases"
)