package learn.main;

import learn.xml.HadoopConfigBean;
import learn.xml.HadoopConfigParser;

public class Main
{
	public static void main(String[] args)
	{
		HadoopConfigBean hdConfig = HadoopConfigParser.parse("D://MyLearning//JavaLearning//config//HadoopProperties.xml");

		new Driver(hdConfig).driveWithTestData();
		// new Driver(hdConfig).drive("HadoopProperties.xml");
	}
}
