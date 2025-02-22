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
 * Indirect Participant Info.
 * 
 * <p>Java class for IPInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IPInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="BICList" type="{urn:cbr-ru:ed:v2.0}IPListType"/&gt;
 *           &lt;element name="DirectParticipant" type="{urn:cbr-ru:ed:v2.0}MainPoolParticipant"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="SWBICS" type="{urn:cbr-ru:ed:v2.0}SWBICList" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Accounts" type="{urn:cbr-ru:ed:v2.0}AccountsType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPInfo", propOrder = {
    "directParticipant",
    "bicList",
    "swbics",
    "accounts"
})
public class IPInfo
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "DirectParticipant")
    protected MainPoolParticipant directParticipant;
    @XmlElement(name = "BICList")
    protected IPListType bicList;
    @XmlElement(name = "SWBICS")
    protected List<SWBICList> swbics;
    @XmlElement(name = "Accounts")
    protected List<AccountsType> accounts;

    /**
     * Gets the value of the directParticipant property.
     * 
     * @return
     *     possible object is
     *     {@link MainPoolParticipant }
     *     
     */
    public MainPoolParticipant getDirectParticipant() {
        return directParticipant;
    }

    /**
     * Sets the value of the directParticipant property.
     * 
     * @param value
     *     allowed object is
     *     {@link MainPoolParticipant }
     *     
     */
    public void setDirectParticipant(MainPoolParticipant value) {
        this.directParticipant = value;
    }

    /**
     * Gets the value of the bicList property.
     * 
     * @return
     *     possible object is
     *     {@link IPListType }
     *     
     */
    public IPListType getBICList() {
        return bicList;
    }

    /**
     * Sets the value of the bicList property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPListType }
     *     
     */
    public void setBICList(IPListType value) {
        this.bicList = value;
    }

    /**
     * Gets the value of the swbics property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the swbics property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSWBICS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SWBICList }
     * 
     * 
     */
    public List<SWBICList> getSWBICS() {
        if (swbics == null) {
            swbics = new ArrayList<SWBICList>();
        }
        return this.swbics;
    }

    /**
     * Gets the value of the accounts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the accounts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccounts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountsType }
     * 
     * 
     */
    public List<AccountsType> getAccounts() {
        if (accounts == null) {
            accounts = new ArrayList<AccountsType>();
        }
        return this.accounts;
    }

}
