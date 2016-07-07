package geotrellis.spark.etl.config

case class IngestType(
  format: String,
  input: BackendInputType,
  credentials: Option[String] = None
)
