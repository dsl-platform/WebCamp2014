name := "WebCamp 2014 - Scala"

scalaVersion := "2.11.2"

unmanagedSourceDirectories in Compile := Seq(
  (scalaSource in Compile).value
, sourceDirectory.value / "generated" / "scala"
)

unmanagedResourceDirectories in Compile ++= Seq(
  sourceDirectory.value / "generated" / "resources"
)

libraryDependencies ++= Seq(
  "com.dslplatform" %% "dsl-client-scala" % "0.9.0",
  "ch.qos.logback" % "logback-classic" % "1.1.2"
)

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource 

unmanagedSourceDirectories in Test := Nil

unmanagedResourceDirectories in Test := Nil
