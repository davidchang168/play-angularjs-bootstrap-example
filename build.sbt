name := """play-angularjs-bootstrap-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  // WebJars (i.e. client-side) dependencies
  "org.webjars" %% "webjars-play" % "2.4.0-1",
  "org.webjars" % "requirejs" % "2.1.14-1",
  "org.webjars" % "underscorejs" % "1.6.0-3",
  "org.webjars" % "jquery" % "1.11.1",
  "org.webjars" % "bootstrap" % "3.1.1-2" exclude("org.webjars", "jquery"),
  "org.webjars" % "angularjs" % "1.2.18" exclude("org.webjars", "jquery"),
  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
