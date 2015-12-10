package learn.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.google.gson.Gson;

import learn.xml.DataConfigBean;
import learn.xml.UserBean;

public class JsonDataGenerator
{
	/**
	 * @param args
	 */
	public String generate(DataConfigBean properties)
	{
		Gson json = new Gson();
		String jsonFileName = "myJson" + Integer.toString(getMyRandom(10000))
				+ ".txt";
		File writer = new File(jsonFileName);
		FileOutputStream is = null;
		try
		{
			is = new FileOutputStream(writer);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OutputStreamWriter osw = new OutputStreamWriter(is);
		Writer w = new BufferedWriter(osw);

		for (int i = 0; i < properties.getTotalRecords(); i++)
		{
			// System.out.println(json.toJson(geterateData()));
			try
			{
				w.write(json.toJson(geterateData(properties)) + "\n");
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try
		{
			w.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonFileName;
	}

	private int getMyRandom(int seed)
	{
		return ThreadLocalRandom.current().nextInt(seed);
	}

	@SuppressWarnings("deprecation")
	private JsonDataRowBean geterateData(DataConfigBean properties)
	{

		JsonDataRowBean row = new JsonDataRowBean();

		row.setClientLocation(properties.getLocationList().get(
				getMyRandom(properties.getLocationList().size())));

		row.setWebsiteSource(properties.getWebSourcesList().get(
				getMyRandom(properties.getWebSourcesList().size())));

		Calendar c = Calendar.getInstance();
		int startYear = (int) properties.getYearStart();
		int endYear = (int) properties.getYearEnd();
		int rand = ThreadLocalRandom.current().nextInt(endYear - startYear);
		c.set(startYear + rand, ThreadLocalRandom.current().nextInt(12),
				ThreadLocalRandom.current().nextInt(28), ThreadLocalRandom
						.current().nextInt(24), ThreadLocalRandom.current()
						.nextInt(60), ThreadLocalRandom.current().nextInt(60));

		SimpleDateFormat format1 = new SimpleDateFormat(
				"yyyy-MM-dd_hh-mm-ss_zz");
		// System.out.println(format1.format(c.getTime()));
		row.setRequestTime(format1.format(c.getTime()));

		row.setSessionId(UUID.randomUUID().toString());
		row.setEvent("new");

		UserBean uid = properties.getUserBeanList().get(
				getMyRandom(properties.getUserBeanList().size()));
		row.setUserId(uid.getUserId());
		String act = properties.getActionsList().get(
				getMyRandom(properties.getActionsList().size()));

		row.setAction(act);
		row.setClientIp(uid.getIpAddresses().get(
				getMyRandom(uid.getIpAddresses().size())));
		row.setOs(properties.getOsList().get(
				getMyRandom(properties.getOsList().size())));
		row.setUrl(properties.getBaseUrl()
				+ "/"
				+ act
				+ "/"
				+ properties.getProductList().get(
						getMyRandom(properties.getProductList().size())));
		return row;
	}
}

/*
 * 
 * "clientLocation": "indore", "websiteReference": "advertisement",
 * "requestTime": "2015-11-03_19-49-40_IST", "sessionId":
 * "a0d9bec4-acd9-4a45-be23-eb9a90b7cf90", "event": "new", "websiteSource":
 * "desktopwebsite", "userId": "devendragarg2938@gmail.com", "action": "view",
 * "clientIp": "214.223.195.201", "url": "www.devkart.com/view/electronics"
 */