Overview
=================
A collection of classes from [commoncrawl](https://github.com/commoncrawl/) and [cc-warc-examples](https://github.com/commoncrawl/cc-warc-examples) with old deprecated objects ripped out. 


Motivation
=================

Upon initial investigation of the [commoncrawl](https://github.com/commoncrawl/) project, it is built primarily with ant. Since EverTrue is built around maven for its Java projects, this was cumbersome to intergrate. 

We ran into a lot of version conflicts w/r/t to hadoop libraries it was built against so after some maven wrangling, this library is now compatible with `2.0.0-mr1-cdh4.5.0`.

Additionally, our needs dictated the support for the [WARCFileInputFormat](https://github.com/evertrue/commoncrawl_utils/blob/master/src/main/java/org/commoncrawl/warc/WARCFileInputFormat.java) which was apart of another project. So we've merged that into one project here.

Considerations
=================
Since this project was manually pieced together to be compatible with maven and current versions of CDH, it will naturally fall behind any changes/updates made to their respective original/parent projects.

We've ripped out a bunch of support for `mapred` packages and other concerns around the webserver component. This wasn't required for our primary needs around MapReduce.

Example
=================

```java
protected static class FindEmailMapper extends Mapper<Text, ArchiveReader, NullWritable, NullWritable> {

		@Override
		public void map(Text key, ArchiveReader value, Context context) throws IOException {
			for (ArchiveRecord r : value) {
				byte[] rawData = IOUtils.toByteArray(r, r.available());
				String content = new String(rawData);

				String[] tokens = content.split("\\s+");

				Set<String> uniqueEmails = Sets.newHashSet();
				for (String token : tokens) {
					if (EmailValidator.getInstance().isValid(token)) {
						uniqueEmails.add(token);
					}
				}

				if (!uniqueEmails.isEmpty()) {
					System.out.println(uniqueEmails);
				}

			}
		}
```

You'll want to configure your job to have these parameters:

```java
...

job.getConfiguration().set("fs.s3n.awsAccessKeyId", "ACCESS_KEY");
job.getConfiguration().set("fs.s3n.awsSecretAccessKey", "SECRET_KEY");

job.setInputFormatClass(WARCFileInputFormat.class);

String inputPath = "s3n://aws-publicdatasets/common-crawl/crawl-data/CC-MAIN-2014-23/segments/1406510280868.21/wet/CC-MAIN-20140728011800-00496-ip-10-146-231-18.ec2.internal.warc.wet.gz";
FileInputFormat.addInputPath(job, new Path(inputPath));

...

```
