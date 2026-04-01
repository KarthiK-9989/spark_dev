import sys
from awsglue.transforms import *
from awsglue.utils import getResolvedOptions
from pyspark.context import SparkContext
from awsglue.context import GlueContext
from awsglue.job import Job

## @params: [JOB_NAME]
args = getResolvedOptions(sys.argv, ['JOB_NAME'])

sc = SparkContext()
glueContext = GlueContext(sc)
spark = glueContext.spark_session
job = Job(glueContext)
job.init(args['JOB_NAME'], args)

dynamic_frame=glueContext.create_dynamic_frame.from_catalog(
    database="april1db",
    table_name="eduapril1bucket_dev_east_001"
)

df=dynamic_frame.toDF()

df.write.format("csv").option("header",True).option("path","s3://april1bucket-dev-east-001/april2").save()

job.commit()