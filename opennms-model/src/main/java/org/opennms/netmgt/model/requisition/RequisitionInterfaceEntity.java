/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2009-2014 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2014 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.01.29 at 01:15:48 PM EST 
//


package org.opennms.netmgt.model.requisition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.opennms.core.utils.InetAddressUtils;
import org.opennms.netmgt.model.PrimaryType;


@Entity
@Table(name = "requisition_node_interfaces")
public class RequisitionInterfaceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @SequenceGenerator(name="requisitionInterfaceSequence", sequenceName="requisitioninterfacenxtid")
    @GeneratedValue(generator="requisitionInterfaceSequence")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "ipInterface")
    protected List<RequisitionMonitoredServiceEntity> monitoredServices = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "requisition_node_interface_categories",
            joinColumns=@JoinColumn(name = "interface_id", referencedColumnName = "id")
    )
    @Column(name="name")
    protected Set<String> categories = new HashSet<>();

    @Column(name="description")
    protected String description;

    @Column(name="ipaddress", nullable=false)
    protected String ipAddress;

    @Column(name="managed")
    protected boolean managed = true;

    // TODO MVR this looks weird and is different than in OnmsIpInterface, why does it not work automatically?!
    @Embedded
    @AttributeOverride(name="m_collType", column=@Column(name="issnmpprimary"))
    protected PrimaryType snmpPrimary = PrimaryType.NOT_ELIGIBLE;

    @Column(name="status")
    protected int status = 1;

    @ManyToOne(optional = false)
    @JoinColumn(name="node_id")
    private RequisitionNodeEntity node;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public List<RequisitionMonitoredServiceEntity> getMonitoredServices() {
        return monitoredServices;
    }

    public void setMonitoredServices(List<RequisitionMonitoredServiceEntity> services) {
        Objects.requireNonNull(services);
        monitoredServices = services;
    }

    public RequisitionMonitoredServiceEntity getMonitoredService(String service) {
        for (RequisitionMonitoredServiceEntity svc : monitoredServices) {
            if (svc.getServiceName().equals(service)) {
                return svc;
            }
        }
        return null;
    }

    public void removeMonitoredService(RequisitionMonitoredServiceEntity service) {
        if (monitoredServices.remove(service)) {
            service.setIpInterface(null); // remove parent relationship
        }
    }

    public void removeMonitoredService(String service) {
        removeMonitoredService(getMonitoredService(service));
    }

    public void addMonitoredService(RequisitionMonitoredServiceEntity service) {
        Objects.requireNonNull(service);
        if (!monitoredServices.contains(service)) {
            service.setIpInterface(this);
            monitoredServices.add(service);
        }
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }

    public void removeCategory(String category) {
        categories.remove(category);
    }

    public void setIpAddress(String value) {
        try {
            ipAddress = InetAddressUtils.toIpAddrString(InetAddressUtils.getInetAddress(value));
        } catch (Throwable e) {
            throw new IllegalArgumentException("Invalid IP address specified", e);
        }
    }

    public boolean isManaged() {
        return managed;
    }

    public void setManaged(boolean value) {
        managed = value;
    }

    public PrimaryType getSnmpPrimary() {
        return snmpPrimary;
    }

    public void setSnmpPrimary(final PrimaryType value) {
        snmpPrimary = value;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int value) {
        status = value;
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    public RequisitionNodeEntity getNode() {
        return node;
    }

    public void setNode(RequisitionNodeEntity node) {
        this.node = node;
    }

    @Override
    public int hashCode() {
        if (getId() != null) {
            return getId().hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof RequisitionInterfaceEntity)) return false;
        if (getId() != null) {
            final RequisitionInterfaceEntity other = (RequisitionInterfaceEntity) obj;
            return getId().equals(other.getId());
        }
        return super.equals(obj);
    }
}
