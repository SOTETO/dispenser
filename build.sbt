name := """dispenser"""
organization := "net.soteto"

version := Option(System.getProperty("version")).getOrElse("0.4.15")
//version := "0.2.3"

lazy val root = (project in file(".")).enablePlugins(PlayScala).enablePlugins(SbtWeb)

scalaVersion := "2.12.6"

//resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
//resolvers += "Sonatype OSS Staging" at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
resolvers += "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases/"
resolvers += Resolver.jcenterRepo

libraryDependencies += guice
libraryDependencies += ehcache
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "org.vivaconagua" %% "play2-oauth-client" % "0.4.3"
//libraryDependencies += "commons-codec" % "commons-codec" % "1.10"
libraryDependencies ++= Seq(
// "org.reactivemongo" %% "play2-reactivemongo" % "0.16.0", 
 "org.reactivemongo" %% "play2-reactivemongo" % "0.12.6-play26",
	//"com.github.tototoshi" %% "play-scalate" % "0.3.0",
  "org.scalatra.scalate" %% "scalate-core" % "1.8.0",
  "org.scala-lang" % "scala-compiler" % scalaVersion.value
//  "com.typesafe.play" % "play-ehcache" % "2.10.4",
//  "org.ehcache" % "jcache" % "1.0.1" 
)

unmanagedResourceDirectories in Compile += baseDirectory.value / "app" / "views"
unmanagedResourceDirectories in Compile += baseDirectory.value / "public"
//conflictManager := ConflictManager.strict

includeFilter in (Assets, LessKeys.less) := "*.less"
excludeFilter in (Assets, LessKeys.less) := "_*.less"

//Docker
maintainer in Docker := "Johann Sell"
dockerExposedPorts := Seq(9000, 9443)
//dockerRepository := Some("soteto")
dockerUsername := Some("soteto")
dockerUpdateLatest := true
routesGenerator := InjectedRoutesGenerator
packageName in Docker := packageName.value
version in Docker := version.value

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
