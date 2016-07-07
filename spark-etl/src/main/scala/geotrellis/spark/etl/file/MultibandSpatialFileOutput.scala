package geotrellis.spark.etl.file

import geotrellis.raster.MultibandTile
import geotrellis.spark._
import geotrellis.spark.etl.EtlJob
import geotrellis.spark.io._
import geotrellis.spark.io.file._
import org.apache.spark.SparkContext

class MultibandSpatialFileOutput extends FileOutput[SpatialKey, MultibandTile, TileLayerMetadata[SpatialKey]] {
  def writer(job: EtlJob)(implicit sc: SparkContext) =
    FileLayerWriter(job.outputProps("path")).writer[SpatialKey, MultibandTile, TileLayerMetadata[SpatialKey]](job.input.ingestOptions.getKeyIndexMethod[SpatialKey])
}
