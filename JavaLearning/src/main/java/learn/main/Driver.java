package learn.main;

import java.io.IOException;
import java.net.URISyntaxException;

import learn.data.JsonDataGenerator;
import learn.hdfs.HdfsWriter;
import learn.xml.DataConfigBean;
import learn.xml.DataConfigParser;
import learn.xml.HadoopConfigBean;
import learn.xml.HadoopConfigParser;

public class Driver
{
	/**
	 * @param args
	 * @return
	 */
	public String genData(DataConfigBean properties)
	{

		JsonDataGenerator dataGenerator = new JsonDataGenerator();
		String outFilename = dataGenerator.generate(properties);
		System.out.println("Generated json data into file: " + outFilename);
		return outFilename;

	}

	public void hdfsWrite(HadoopConfigBean hdProp, String fName)
	{
		System.out.println("Attempting to write to HDFS: " + fName);

		HdfsWriter hdfsW = new HdfsWriter();
		hdfsW.setHdfsPath(hdProp.getHdfspath());
		hdfsW.setHdfsUri(hdProp.getHdfsuri());
		hdfsW.setLocalFileToWrite(fName);

		try
		{
			hdfsW.write();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Write to HDFS done: " + fName);
	}

	public void drive(String fName)
	{
		HadoopConfigParser hdParser = new HadoopConfigParser();
		HadoopConfigBean hdProp = hdParser.parse("HadoopProperties.xml");
		hdfsWrite(hdProp, fName);
	}

	public void driveWithTestData()
	{
		System.out.println("Attempting to generate test data");

		DataConfigParser dataConfigParser = new DataConfigParser();
		DataConfigBean properties = dataConfigParser
				.parse("DataProperties.xml");
		String fName = genData(properties);
		System.out.println("Attempting to generate test data.. Done");

		drive(fName);
	}
}
