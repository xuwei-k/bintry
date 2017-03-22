organization := "me.lessis"

name := "bintry"

version := "0.5.0-SNAPSHOT"

description := "your packages, delivered fresh"

crossScalaVersions := Seq("2.10.4", "2.11.5")

scalaVersion := crossScalaVersions.value.last

scalacOptions in ThisBuild ++= Seq(Opts.compile.deprecation) ++
  Seq("-Ywarn-unused-import", "-Ywarn-unused", "-Xlint", "-feature").filter(
    Function.const(scalaVersion.value.startsWith("2.11")))

libraryDependencies ++= Seq("net.databinder.dispatch" %% "dispatch-json4s-native" % "0.11.2")

initialCommands := "import scala.concurrent.ExecutionContext.Implicits.global;"

licenses := Seq("MIT" ->
                url(s"https://github.com/sbt/${name.value}/blob/${version.value}/LICENSE"))

homepage := Some(url(s"https://github.com/sbt/${name.value}/#readme"))

bintrayPackageLabels := Seq("bintray", "dispatch", "http")

publishArtifact in Test := false

pomExtra := (
  <scm>
    <url>git@github.com:sbt/{name.value}.git</url>
    <connection>scm:git:git@github.com:sbt/{name.value}.git</connection>
  </scm>
  <developers>
    <developer>
      <id>softprops</id>
      <name>Doug Tangren</name>
      <url>https://github.com/softprops</url>
    </developer>
  </developers>)
