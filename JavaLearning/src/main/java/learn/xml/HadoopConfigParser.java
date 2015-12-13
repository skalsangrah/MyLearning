package learn.xml;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

public class HadoopConfigParser
{
	static public HadoopConfigBean parse(String xmlConfigFile)
	{
		HadoopConfigBean data = new HadoopConfigBean();

		try
		{
			XMLConfiguration config = new XMLConfiguration(xmlConfigFile);

			data.setHdfsUri(config.getString("hdfsuri"));
			data.setHdfsPath(config.getString("hdfspath"));
			data.setHdfsUser(config.getString("hdfsuser"));
			data.setLocalPath(config.getString("localpath"));
			data.setDataConfigPropertyFile(config.getString("dataproperty"));

		} catch (ConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
