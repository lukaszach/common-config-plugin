/* build.sbt
 *
 * Copyright (c) 2015 True Connectivity Solutions Ltd.
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

name := "common-config-plugin"

sbtPlugin := true

enablePlugins(SbtPlugin)

ivyLoggingLevel := UpdateLogging.Quiet
scalacOptions in Compile ++= Seq("-feature", "-deprecation")

releaseVersionBump := sbtrelease.Version.Bump.Bugfix

organization := "com.trueconnectivity"

resolvers ++= Seq(
  Resolver.defaultLocal,
  Resolver.mavenLocal,
  Resolver.sonatypeRepo("releases"),
  Resolver.typesafeRepo("releases"),
  Resolver.typesafeRepo("snapshots"),
  Resolver.sonatypeRepo("snapshots"),
  "spray repo" at "http://repo.spray.io",
  "jgit-repo" at "http://download.eclipse.org/jgit/maven"
)

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.10")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.9.0")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.10.0-RC1")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.6.1")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.2.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "1.0.0")

publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := { _ =>
  false
}

addCommandAlias("format", "; scalafmt ; test:scalafmt ; scalafmtSbt")

//Potential other plugins to add : unidoc
