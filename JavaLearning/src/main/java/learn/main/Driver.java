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
	public String genData(DataConfigBean properties, String localPath)
	{
		JsonDataGenerator dataGenerator = new JsonDataGenerator();
		String outFilename = dataGenerator.generate(properties, localPath);
		System.out.println("Generated json data into file: " + outFilename
				+ " @path: " + localPath);
		return outFilename;
	}

	public void hdfsWrite(String fName)
	{
		System.out.println("Attempting to write file: " + fName + " @ path:"
				+ hadoopProperties.getLocalPath() + " to HDFS path: "
				+ hadoopProperties.getHdfsUri()
				+ hadoopProperties.getHdfsPath());

		HdfsWriter hdfsW = new HdfsWriter();
		hdfsW.setHdfsPath(hadoopProperties.getHdfsPath());
		hdfsW.setHdfsUri(hadoopProperties.getHdfsUri());
		hdfsW.setLocalFileToWrite(fName);
		hdfsW.setLocalPath(hadoopProperties.getLocalPath());

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
		System.out.println("Write to HDFS done.");
	}

	public void hdfsRead(String fName)
	{
		System.out.println("Attempting to read HDFS File: " + fName
				+ " from HDFS Path: " + hadoopProperties.getHdfsUri()
				+ hadoopProperties.getHdfsPath() + " Into file" + fName + "_2"
				+ " @path: " + hadoopProperties.getLocalPath());

		HdfsReader hdfsR = new HdfsReader();
		hdfsR.setHdfsPath(hadoopProperties.getHdfsPath());
		hdfsR.setHdfsUri(hadoopProperties.getHdfsUri());
		hdfsR.setHdfsFileToRead(fName);
		hdfsR.setLocalPath(hadoopProperties.getLocalPath());

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

		DataConfigBean properties = DataConfigParser.parse(hadoopProperties.getDataConfigPropertyFile());

		String fName = genData(properties, hadoopProperties.getLocalPath());
		System.out.println("Generating test data done.");

		drive(fName);
	}
}
