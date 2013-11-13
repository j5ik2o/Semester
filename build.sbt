name := "Semester"

version := "0.0.1"

scalaVersion := "2.10.3"

conflictManager := ConflictManager.strict

resolvers ++= Seq(
  "sonatype-public" at "https://oss.sonatype.org/content/groups/public",
  "atlassian-public" at "https://maven.atlassian.com/repository/public",
  "maven-central" at "http://repo1.maven.org/maven2",
  "twitter-repo" at "http://maven.twttr.com",
  Resolver.sonatypeRepo("snapshots")
)

lazy val appsAreca = project.in(file("apps/areca"))
    .dependsOn(libsEtudeMoney)
    .dependsOn(libsEtudeHtml)

lazy val appsStenographer = project.in(file("apps/stenographer"))
    .dependsOn(libsEtudeBootstrap)
    .dependsOn(libsEtudeChatwork)
    .dependsOn(libsEtudeFile)

lazy val libsEtudeAggregation = project.in(file("libs/etude-aggregation"))

lazy val libsEtudeBootstrap = project.in(file("libs/etude-bootstrap"))

lazy val libsEtudeCalendar = project.in(file("libs/etude-calendar"))
    .dependsOn(libsEtudeAggregation)
    .dependsOn(libsEtudeRegion)
    .dependsOn(libsEtudeReligion)
    .dependsOn(libsEtudeHttp)

lazy val libsEtudeChatwork = project.in(file("libs/etude-chatwork"))
    .dependsOn(libsEtudeHttp)
    .dependsOn(libsEtudeQos)

lazy val libsEtudeFile = project.in(file("libs/etude-file"))

lazy val libsEtudeHtml = project.in(file("libs/etude-html"))

lazy val libsEtudeHttp = project.in(file("libs/etude-http"))
    .dependsOn(libsEtudeIo)

lazy val libsEtudeIo = project.in(file("libs/etude-io"))

lazy val libsEtudeMoney = project.in(file("libs/etude-money"))

lazy val libsEtudeQos = project.in(file("libs/etude-qos"))

lazy val libsEtudeRegion = project.in(file("libs/etude-region"))

lazy val libsEtudeReligion = project.in(file("libs/etude-religion"))
