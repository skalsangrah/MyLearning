package learn.hdfs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

public class HdfsWriter
{
	private String localFileToWrite;
	private String localPath;

	private String hdfsUri;
	private String hdfsPath;

	public HdfsWriter()
	{
		// TODO Auto-generated constructor stub
	}

	HdfsWriter(String localFileToWrite, String hdfsUri, String hdfsPath)
	{
		this.localFileToWrite = localFileToWrite;
		this.hdfsUri = hdfsUri;
		this.hdfsPath = hdfsPath;
	}

	public String getLocalFileToWrite()
	{
		return localFileToWrite;
	}

	public void setLocalFileToWrite(String localFileToWrite)
	{
		this.localFileToWrite = localFileToWrite;
	}

	public String getLocalPath()
	{
		return localPath;
	}

	public void setLocalPath(String localPath)
	{
		this.localPath = localPath;
	}

	public String getHdfsUri()
	{
		return hdfsUri;
	}

	public void setHdfsUri(String hdfsUri)
	{
		this.hdfsUri = hdfsUri;
	}

	public String getHdfsPath()
	{
		return hdfsPath;
	}

	public void setHdfsPath(String hdfsPath)
	{
		this.hdfsPath = hdfsPath;
	}

	public void write() throws IOException, URISyntaxException
	{
		// 1. Get the instance of COnfiguration
		Configuration configuration = new Configuration();

		// 2. Create an InputStream to read the data from local file
		InputStream inputStream = new BufferedInputStream(new FileInputStream(localPath
				+ localFileToWrite));

		// 3. Get the HDFS instance
		FileSystem hdfs = FileSystem.get(new URI(hdfsUri), configuration);

		// 4. Open a OutputStream to write the data, this can be obtained from
		// the FileSytem
		OutputStream outputStream = hdfs.create(new Path(hdfsUri + hdfsPath
				+ localFileToWrite), new Progressable()
		{
			@Override
			public void progress()
			{
				System.out.println("....");
			}
		});

		try
		{
			IOUtils.copyBytes(inputStream, outputStream, 4096, false);
		} finally
		{
			IOUtils.closeStream(inputStream);
			IOUtils.closeStream(outputStream);
		}
	}
}
