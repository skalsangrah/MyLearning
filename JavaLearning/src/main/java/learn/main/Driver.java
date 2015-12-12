package learn.main;

import java.io.IOException;
import java.net.URISyntaxException;

import learn.data.JsonDataGenerator;
import learn.hdfs.HdfsReader;
import learn.hdfs.HdfsWriter;
import learn.xml.DataConfigBean;
import learn.xml.DataConfigParser;
import learn.xml.HadoopConfigBean;

public class Driver
{
	HadoopConfigBean hadoopProperties;

	Driver(HadoopConfigBean hadoopProperties)
	{
		this.hadoopProperties = hadoopProperties;
	}

	public HadoopConfigBean getHadoopProperties()
	{
		return hadoopProperties;
	}

	public void setHadoopProperties(HadoopConfigBean hadoopProperties)
	{
		this.hadoopProperties = hadoopProperties;
	}

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

	public void hdfsWrite(String fName)
	{
		System.out.println("Attempting to write to HDFS: " + fName);

		HdfsWriter hdfsW = new HdfsWriter();
		hdfsW.setHdfsPath(hadoopProperties.getHdfspath());
		hdfsW.setHdfsUri(hadoopProperties.getHdfsuri());
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

	public void hdfsRead(String fName)
	{
		System.out.println("Attempting to read from HDFS: " + fName);

		HdfsReader hdfsR = new HdfsReader();
		hdfsR.setHdfsPath(hadoopProperties.getHdfspath());
		hdfsR.setHdfsUri(hadoopProperties.getHdfsuri());
		hdfsR.setHdfsFileToRead(fName);
		String fNewName = null;
		try
		{
			fNewName = hdfsR.read();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Read from HDFS done: " + fNewName);
	}

	public void drive(String fName)
	{
		hdfsWrite(fName);
		hdfsRead(fName);
	}

	public void driveWithTestData()
	{
		System.out.println("Attempting to generate test data");

		DataConfigBean properties = DataConfigParser
				.parse("DataProperties.xml");
		String fName = genData(properties);
		System.out.println("Attempting to generate test data.. Done");

		drive(fName);
	}
}
