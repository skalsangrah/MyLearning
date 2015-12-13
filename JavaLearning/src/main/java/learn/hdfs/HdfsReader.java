package learn.hdfs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class HdfsReader
{
	private String hdfsFileToRead;
	private String hdfsUri;
	private String hdfsPath;
	private String localPath;

	HdfsReader(String hdfsFileToRead, String hdfsUri, String hdfsPath)
	{
		this.hdfsFileToRead = hdfsFileToRead;
		this.hdfsUri = hdfsUri;
		this.hdfsPath = hdfsPath;
	}

	public HdfsReader()
	{

	}

	public String getHdfsFileToRead()
	{
		return hdfsFileToRead;
	}

	public void setHdfsFileToRead(String hdfsFileToRead)
	{
		this.hdfsFileToRead = hdfsFileToRead;
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

	public String getLocalPath()
	{
		return localPath;
	}

	public void setLocalPath(String localPath)
	{
		this.localPath = localPath;
	}

	public String read() throws IOException, URISyntaxException
	{
		String localFile = hdfsFileToRead + "_2";

		// 1. Get the instance of Configuration
		Configuration configuration = new Configuration();

		// // 2. URI of the file to be read
		// URI uri = new URI(hdfsUri + hdfsPath + hdfsFileToRead);

		// 3. Get the instance of the HDFS
		// FileSystem hdfs = FileSystem.get(uri, configuration);
		FileSystem hdfs = FileSystem.get(new URI(hdfsUri), configuration);

		// 4. A reference to hold the InputStream
		InputStream inputStream = null;

		FileOutputStream fileOuputStream = null;
		try
		{
			// 5. Prepare the Path, i.e similar to File class in Java, Path
			// represents file in HDFS
			// 6. Open a Input Stream to read the data from HDFS
			inputStream = hdfs.open(new Path(hdfsUri + hdfsPath
					+ hdfsFileToRead));

			File outFile = new File(localPath + localFile);
			fileOuputStream = new FileOutputStream(outFile);

			// 7. Use the IOUtils to flush the data from the file to local file
			IOUtils.copyBytes(inputStream, fileOuputStream, 4096, false);

		} finally
		{
			// 8. Close the InputStream once the data is read
			// IOUtils.closeStream(inputStream);
			IOUtils.closeStream(fileOuputStream);
			hdfs.close();
		}
		return localFile;
	}

}
