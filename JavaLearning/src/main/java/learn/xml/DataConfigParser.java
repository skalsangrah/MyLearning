package learn.xml;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

public class DataConfigParser
{

	@SuppressWarnings("unchecked")
	public static DataConfigBean parse(String xmlConfigFile)
	{
		DataConfigBean data = new DataConfigBean();

		try
		{
			XMLConfiguration config = new XMLConfiguration(xmlConfigFile);

			data.setBaseUrl(config.getString("baseUrl", ""));
			data.setOutputPath(config.getString("output-file-path"));
			data.setTotalRecords(config.getLong("total-records"));

			List<String> productList = config.getList("products.product");
			data.setProductList(productList);

			List<String> locationList = config.getList("locations.location");
			data.setLocationList(locationList);

			List<String> webSourcesList = config
					.getList("website-sources.source");
			data.setWebSourcesList(webSourcesList);
			// HierarchicalConfiguration actions = config
			// .configurationAt("actions");
			// List<String> actionsList = actions.getList("action");

			List<String> actionsList = config.getList("actions.action");
			data.setActionsList(actionsList);

			List<AbstractConfiguration> usersList = config
					.configurationsAt("users.user");

			List<UserBean> userBeanList = new ArrayList<UserBean>();
			for (AbstractConfiguration sub : usersList)
			{
				UserBean userBean = new UserBean();
				userBean.setUserId(sub.getString("userid"));
				userBean.setIpAddresses(sub.getList("ip-address"));
				userBeanList.add(userBean);
			}

			data.setUserBeanList(userBeanList);
			data.setYearStart(config.getLong("year-range.start"));
			data.setYearEnd(config.getLong("year-range.end"));

			List<String> osList = config.getList("operating-systems.os");
			data.setOsList(osList);
		} catch (ConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}
}
