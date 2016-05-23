lazy val root = (project in file(".")).
  settings(
    name := "gyges",
    organization := "jp.co.mistnet",
    version := "0.1",
    scalaVersion := "2.11.8",
    autoScalaLibrary := false,
    javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
    crossPaths := false,
    // 利用したいライブラリがある場合は maven repository(http://mvnrepository.com/)などから探して、以下に追加する
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-compiler" % scalaVersion.value,
      "org.scala-lang" % "scala-library" % scalaVersion.value,
      "com.typesafe" % "config" % "1.3.0",
      "org.scalafx" %% "scalafx" % "8.0.92-R10",
      "org.scalatest" % "scalatest_2.11" % "3.0.0-RC1" % "test",
      "junit" % "junit" % "4.11" % "test",
      "com.novocode" % "junit-interface" % "0.11-RC1" % "test"
    ),
    // resolverの設定が必要な場合は以下にも追加する
    resolvers ++= Seq(
      "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
    )
  )
