
/**
 * Build script for $name$
 */
name := "$name$"
organization := "$organisation$",

version := "1.0-SNAPSHOT"

licenses +=("MIT", url("http://opensource.org/licenses/MIT"))

pomExtra := (
  <url></url>
  <scm>
    <url>$git_url$</url>
    <connection>scm:git:$git_url$.git</connection>
  </scm>
  <developers>
    <developer>
      <id>$git_user$</id>
      <name>$full_name$</name>
    </developer>
  </developers>
)

scalaVersion := "$scala_version$"

scalacOptions ++= Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-Xfatal-warnings", // Fail the compilation if there are any warnings.
  "-Xlint", // Enable recommended additional warnings.
  "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver.
  "-Ywarn-dead-code", // Warn when dead code is identified.
  "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures.
  "-Ywarn-nullary-override", // Warn when non-nullary overrides nullary, e.g. def foo() over def foo.
  "-Ywarn-numeric-widen", // Warn when numerics are widened.
  // For advanced language features
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  "-language:postfixOps",
  "-target:jvm-1.8",
  "-encoding", "UTF-8"
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)

// Disable scaladoc
publishArtifact in (Compile, packageDoc) := false
publishArtifact in packageDoc := false
sources in (Compile,doc) := Seq.empty

// Print log statements in tests as they happen instead of doing it out of band.
logBuffered in Test := false

coverageExcludedPackages := "<empty>;controllers.javascript;views.*;router;no.uio.musit.test"
coverageExcludedFiles := ""
coverageMinimum := 80
coverageFailOnMinimum := true

scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(FormatXml, false)
  .setPreference(DoubleIndentClassDeclaration, false)
  .setPreference(SpacesAroundMultiImports, false)

resolvers ++= Seq(
  Resolver.typesafeRepo("releases"),
  Resolver.sonatypeRepo("releases"),
  Resolver.jcenterRepo
)

val jodaTimeVersion = "2.9.4"
val jodaConvertVersion = "1.8.1"
val scalaGuiceVersion = "4.1.0"
val iheartFicusVersion = "1.2.3"
val stestVersion = "3.0.0"
val stestPlusVersion = "1.5.1"

libraryDependencies ++= Seq(
  ws,
  cache,
  "com.iheart" %% "ficus" % iheartFicusVersion,
  "net.codingwell" %% "scala-guice" % scalaGuiceVersion,
  "joda-time" % "joda-time" % jodaTimeVersion,
  "org.joda" % "joda-convert" % jodaConvertVersion,
  "org.scalatestplus.play" %% "scalatestplus-play" % stestPlusVersion % Test
)
