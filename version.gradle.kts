val stableVersion = "1.20.0-SNAP"
val alphaVersion = "1.20.0-alpha-SNAPSHOT"

allprojects {
  if (findProperty("otel.stable") != "true") {
    version = alphaVersion
  } else {
    version = stableVersion
  }
}
