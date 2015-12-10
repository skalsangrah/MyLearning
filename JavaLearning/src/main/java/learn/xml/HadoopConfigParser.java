package learn.xml;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

public class HadoopConfigParser
{
	public HadoopConfigBean parse(String xmlConfigFile)
	{
		HadoopConfigBean data = new HadoopConfigBean();

		try
		{
			XMLConfiguration config = new XMLConfiguration(xmlConfigFile);

			data.setHdfsuri(config.getString("hdfsuri"));
			data.setHdfspath(config.getString("hdfspath"));
		} catch (ConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
