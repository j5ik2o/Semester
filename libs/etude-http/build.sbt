name := "etude-http"

version := "0.0.1"

libraryDependencies ++= Seq(
  "commons-codec" % "commons-codec" % "1.8",
  "org.apache.httpcomponents" % "httpclient" % "4.3.1",
  "org.specs2" %% "specs2" % "2.2.3" % "test",
  "junit" % "junit" % "4.7" % "test"
)
