package datahub.spark.model.dataset;

import org.apache.hadoop.fs.Path;

import com.linkedin.common.FabricType;

import lombok.ToString;

@ToString
public class HdfsPathDataset extends SparkDataset {
  
  public HdfsPathDataset(Path path, String platformInstance, FabricType fabricType) {
    // TODO check static partitions?
    this(String.join("/",
            path.toUri().toString()
            .split("stamp_date=")[0]
            .split("date_ymd=")[0]
            .split("3://")[1]
            .split("/")), platformInstance, fabricType);
  }

  public HdfsPathDataset(String pathUri, String platformInstance, FabricType fabricType) {
    // TODO check static partitions?
    super("s3", platformInstance, pathUri, fabricType);
  }

}
