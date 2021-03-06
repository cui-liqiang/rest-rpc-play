enablePlugins(HaxeJavaPlugin)

disablePlugins(HaxeCSharpPlugin)

organization := "com.thoughtworks"

name := "microbuilder-play"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/releases"

libraryDependencies += "org.specs2" %% "specs2-core" % "3.6.4" % Test

libraryDependencies += "com.typesafe.play" %% "play-ws" % "2.4.2"

libraryDependencies += "com.thoughtworks.microbuilder" %% "json-stream" % "2.0.0"% HaxeJava classifier "haxe-java"

libraryDependencies += "com.thoughtworks.microbuilder" %% "json-stream" % "2.0.0"% Provided

libraryDependencies += "com.qifun" %% "haxe-scala-stm" % "0.1.4" % HaxeJava classifier "haxe-java"

libraryDependencies += "org.scala-stm" %% "scala-stm" % "0.7" % Test

libraryDependencies += "org.specs2" %% "specs2-mock" % "3.6.4" % Test

libraryDependencies += "org.mockito" % "mockito-all" % "1.10.19" % Test

libraryDependencies += "com.github.dreamhead" % "moco-core" % "0.10.1"  % Test

libraryDependencies += "de.leanovate.play-mockws" %% "play-mockws" % "2.4.0" % Test

libraryDependencies += "com.typesafe.play" %% "play-specs2" % "2.4.2" % Test

for (c <- Seq(Compile, Test)) yield {
  haxeOptions in c ++= Seq("-lib", "continuation")
}

for (c <- Seq(Compile, Test)) yield {
  haxeOptions in c ++= Seq("-D", "scala")
}

for (c <- Seq(Compile, Test)) yield {
  haxeOptions in c ++= Seq("-dce", "no")
}

scalacOptions in Test += "-Yrangepos"

compileOrder := CompileOrder.JavaThenScala
