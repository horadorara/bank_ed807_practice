//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.07.02 at 05:36:11 PM SAMT 
//


package ru.cbr.ed.v2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Participant's Private Profile.
 * 
 * <p>Java class for ParticipantProfileType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParticipantProfileType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ParticipantProfileInfo" type="{urn:cbr-ru:ed:v2.0}ParticipantProfileInfoType"/&gt;
 *         &lt;element name="AccountsInfo" type="{urn:cbr-ru:ed:v2.0}AccountsInfoType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParticipantProfileType", propOrder = {
    "participantProfileInfo",
    "accountsInfos"
})
public class ParticipantProfileType
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "ParticipantProfileInfo", required = true)
    protected ParticipantProfileInfoType participantProfileInfo;
    @XmlElement(name = "AccountsInfo")
    protected List<AccountsInfoType> accountsInfos;

    /**
     * Gets the value of the participantProfileInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ParticipantProfileInfoType }
     *     
     */
    public ParticipantProfileInfoType getParticipantProfileInfo() {
        return participantProfileInfo;
    }

    /**
     * Sets the value of the participantProfileInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParticipantProfileInfoType }
     *     
     */
    public void setParticipantProfileInfo(ParticipantProfileInfoType value) {
        this.participantProfileInfo = value;
    }

    /**
     * Gets the value of the accountsInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the accountsInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountsInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountsInfoType }
     * 
     * 
     */
    public List<AccountsInfoType> getAccountsInfos() {
        if (accountsInfos == null) {
            accountsInfos = new ArrayList<AccountsInfoType>();
        }
        return this.accountsInfos;
    }

}
