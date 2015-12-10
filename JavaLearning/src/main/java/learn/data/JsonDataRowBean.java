package learn.data;

public class JsonDataRowBean
{
	String clientLocation;
	String websiteSource;
	String requestTime;
	String sessionId;
	String event;
	String userId;
	String action;
	String clientIp;
	String os;
	String url;

	public String getClientLocation()
	{
		return clientLocation;
	}

	public void setClientLocation(String clientLocation)
	{
		this.clientLocation = clientLocation;
	}

	public String getRequestTime()
	{
		return requestTime;
	}

	public void setRequestTime(String requestTime)
	{
		this.requestTime = requestTime;
	}

	public String getSessionId()
	{
		return sessionId;
	}

	public void setSessionId(String sessionId)
	{
		this.sessionId = sessionId;
	}

	public String getEvent()
	{
		return event;
	}

	public void setEvent(String event)
	{
		this.event = event;
	}

	public String getWebsiteSource()
	{
		return websiteSource;
	}

	public void setWebsiteSource(String websiteSource)
	{
		this.websiteSource = websiteSource;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	public String getClientIp()
	{
		return clientIp;
	}

	public void setOs(String os)
	{
		this.os = os;
	}

	public String getOs()
	{
		return os;
	}

	public void setClientIp(String clientIp)
	{
		this.clientIp = clientIp;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
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