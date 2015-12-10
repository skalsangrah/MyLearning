package learn.xml;

public class HadoopConfigBean
{
	private String hdfsuri;
	private String hdfspath;

	public String getHdfsuri()
	{
		return hdfsuri;
	}

	public void setHdfsuri(String hdfsuri)
	{
		this.hdfsuri = hdfsuri;
	}

	public String getHdfspath()
	{
		return hdfspath;
	}

	public void setHdfspath(String hdfspath)
	{
		this.hdfspath = hdfspath;
	}

	@Override
	public String toString()
	{
		return "BeanData [ " + "hdfsuri=" + hdfsuri + "hdfspath=" + hdfspath
				+ "]";
	}
}
