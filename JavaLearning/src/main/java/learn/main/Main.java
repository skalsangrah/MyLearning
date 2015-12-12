package learn.main;

import learn.xml.HadoopConfigBean;
import learn.xml.HadoopConfigParser;

public class Main
{
	public static void main(String[] args)
	{
		HadoopConfigBean hadoopProperties = HadoopConfigParser
				.parse("HadoopProperties.xml");

		new Driver(hadoopProperties).driveWithTestData();
		new Driver(hadoopProperties).drive("HadoopProperties.xml");
	}
}
