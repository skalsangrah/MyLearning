package learn.xml;

public class HadoopConfigBean
{
	private String hdfsUri;
	private String hdfsPath;
	private String hdfsUser;
	private String localPath;
	private String dataConfigPropertyFile;

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

	public String getHdfsUser()
	{
		return hdfsUser;
	}

	public void setHdfsUser(String hdfsUser)
	{
		this.hdfsUser = hdfsUser;
	}

	public String getLocalPath()
	{
		return localPath;
	}

	public void setLocalPath(String localPath)
	{
		this.localPath = localPath;
	}

	public String getDataConfigPropertyFile()
	{
		return dataConfigPropertyFile;
	}

	public void setDataConfigPropertyFile(String dataConfigPropertyFile)
	{
		this.dataConfigPropertyFile = dataConfigPropertyFile;
	}

	@Override
	public String toString()
	{
		return "HadoopConfigBean [hdfsUri=" + hdfsUri + ", hdfsPath="
				+ hdfsPath + ", hdfsUser=" + hdfsUser + ", localPath="
				+ localPath + ", dataConfigPropertyFile="
				+ dataConfigPropertyFile + "]";
	}
}
