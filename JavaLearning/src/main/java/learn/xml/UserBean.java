package learn.xml;

import java.util.List;

public class UserBean
{
	private String userId;
	List<String> ipAddresses;

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public List<String> getIpAddresses()
	{
		return ipAddresses;
	}

	public void setIpAddresses(List<String> ipAddresses)
	{
		this.ipAddresses = ipAddresses;
	}

	@Override
	public String toString()
	{
		return "UserBean [" + "\nuserId=" + userId + ", ipAddresses="
				+ ipAddresses + "]";
	}
}
