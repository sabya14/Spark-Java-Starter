package data_application;
import org.apache.spark.sql.SparkSession;

public interface SparkTestSession {
    SparkSession spark = SparkSession
            .builder()
            .appName("Test app")
            .master("local[*]")
            .config("spark.sql.shuffle.partitions", 8)
            .config("spark.default.parallelism", 8)
            .getOrCreate();
}
