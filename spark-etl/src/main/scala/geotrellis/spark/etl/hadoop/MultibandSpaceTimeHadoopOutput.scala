package geotrellis.spark.etl.hadoop

import geotrellis.raster._
import geotrellis.spark._
import geotrellis.spark.etl.EtlJob
import geotrellis.spark.etl.config.Backend
import geotrellis.spark.io._
import geotrellis.spark.io.hadoop._
import geotrellis.spark.io.index.KeyIndexMethod
import org.apache.hadoop.fs.Path
import org.apache.spark.SparkContext

class MultibandSpaceTimeHadoopOutput extends HadoopOutput[SpaceTimeKey, MultibandTile, TileLayerMetadata[SpaceTimeKey]] {
  def writer(job: EtlJob)(implicit sc: SparkContext) =
    HadoopLayerWriter(job.outputProps("path")).writer[SpaceTimeKey, MultibandTile, TileLayerMetadata[SpaceTimeKey]](job.input.ingestOptions.getKeyIndexMethod[SpaceTimeKey])
}
