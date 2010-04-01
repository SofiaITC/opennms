package org.opennms.features.poller.remote.gwt.client;

import java.io.Serializable;

public class GWTMonitoredService implements Serializable {
	private static final long serialVersionUID = 1L;

	private int m_id;
	private int m_ifIndex;
	private int m_ipInterfaceId;
	private String m_ipAddress;
	private String m_hostname;
	private int m_nodeId;
	private String m_serviceName;

	public void setId(final int id) {
		m_id = id;
	}
	public int getId() {
		return m_id;
	}
	public void setIfIndex(final Integer ifIndex) {
		m_ifIndex = ifIndex;
	}
	public Integer getIfIndex() {
		return m_ifIndex;
	}
	public void setIpInterfaceId(final Integer id) {
		m_ipInterfaceId = id;
	}
	public Integer getIpInterfaceId() {
		return m_ipInterfaceId;
	}
	public void setIpAddress(final String ipAddress) {
		m_ipAddress = ipAddress;
	}
	public String getIpAddress() {
		return m_ipAddress;
	}
	public void setHostname(final String hostname) {
		m_hostname = hostname;
	}
	public String getHostname() {
		return m_hostname;
	}
	public void setNodeId(final Integer nodeId) {
		m_nodeId = nodeId;
	}
	public Integer getNodeId() {
		return m_nodeId;
	}
	public void setServiceName(final String serviceName) {
		m_serviceName = serviceName;
	}
	public String getServiceName() {
		return m_serviceName;
	}

}
