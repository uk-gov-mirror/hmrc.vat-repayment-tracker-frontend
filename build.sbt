import uk.gov.hmrc.DefaultBuildSettings.{defaultSettings, integrationTestSettings, scalaSettings}
import uk.gov.hmrc.SbtArtifactory
import uk.gov.hmrc.sbtdistributables.SbtDistributablesPlugin.publishingSettings

val scalaV = "2.12.12"
scalaVersion := scalaV

lazy val microservice = Project(appName, file("."))
  .enablePlugins(play.sbt.PlayScala, SbtAutoBuildPlugin, SbtGitVersioning, SbtDistributablesPlugin, SbtArtifactory)
  .disablePlugins(JUnitXmlReportPlugin)
  .settings(
    resolvers ++= Seq(Resolver.bintrayRepo("hmrc", "releases"), Resolver.jcenterRepo),
    libraryDependencies ++= AppDependencies.compile ++ AppDependencies.test,
    retrieveManaged := false,
    routesGenerator := InjectedRoutesGenerator,
    evictionWarningOptions in update := EvictionWarningOptions.default.withWarnScalaVersionEviction(false)
  )
  .settings(majorVersion := 1)
  .settings(ScalariformSettings())
  .settings(ScoverageSettings())
  .settings(WartRemoverSettings.wartRemoverError)
  .settings(WartRemoverSettings.wartRemoverWarning)
  .settings(wartremoverErrors in(Test, compile) --= Seq(Wart.Any, Wart.Equals, Wart.Null, Wart.NonUnitStatements, Wart.PublicInference))
  .settings(wartremoverExcluded ++=
    routes.in(Compile).value ++
      (baseDirectory.value / "it").get ++
      (baseDirectory.value / "test").get ++
      Seq(sourceManaged.value / "main" / "sbt-buildinfo" / "BuildInfo.scala"))
  .settings(publishingSettings: _*)
  .settings(PlayKeys.playDefaultPort := 9863)
  .settings(scalaSettings: _*)
  .settings(defaultSettings(): _*)
  .settings(integrationTestSettings())
  .configs(IntegrationTest)
  .settings(
    routesImport ++= Seq(
      "model._",
      "model.des._",
      "langswitch.Language"
    ))
  .settings(
    scalacOptions ++= Seq(
      "-Xfatal-warnings",
      "-Xlint:-missing-interpolator,_",
      "-Yno-adapted-args",
      "-Ywarn-value-discard",
      "-Ywarn-dead-code",
      "-deprecation",
      "-feature",
      "-unchecked",
      "-language:implicitConversions",
      "-language:reflectiveCalls",
      "-Ypartial-unification", //required by cats
      "-Ywarn-unused:-imports,-patvars,-privates,-locals,-explicits,-implicits,_"
    )
  )
val appName = "vat-repayment-tracker-frontend"
