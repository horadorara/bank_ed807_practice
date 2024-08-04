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
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Реквизиты клиента, по которому предоставляется информация об атрибутах участия в системе БЭСП
 * 
 * <p>Java class for RTGSCustomerInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RTGSCustomerInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Name" type="{urn:cbr-ru:ed:leaftypes:v2.0}Max160TextType"/&gt;
 *         &lt;element name="AdditionalConditions" type="{urn:cbr-ru:ed:v2.0}AdditionalConditions" minOccurs="0"/&gt;
 *         &lt;element name="PURBICInfo" type="{urn:cbr-ru:ed:v2.0}BICInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ListAcc" type="{urn:cbr-ru:ed:v2.0}ListAcc" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ListAccBrf" type="{urn:cbr-ru:ed:v2.0}ListAccBrf" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="PayeeInfo" type="{urn:cbr-ru:ed:v2.0}PayeeInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="OURBIC" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}BICRUIDType" /&gt;
 *       &lt;attribute name="OCBIC" type="{urn:cbr-ru:ed:leaftypes:v2.0}BICRUIDType" /&gt;
 *       &lt;attribute name="BIC" type="{urn:cbr-ru:ed:leaftypes:v2.0}BICRUIDType" /&gt;
 *       &lt;attribute name="UIS" type="{urn:cbr-ru:ed:leaftypes:v2.0}EDDrawerIDType" /&gt;
 *       &lt;attribute name="ParentBIC" type="{urn:cbr-ru:ed:leaftypes:v2.0}BICRUIDType" /&gt;
 *       &lt;attribute name="MemberType" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}OneDigitCodeType" /&gt;
 *       &lt;attribute name="RegistrationMode" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}OneDigitCodeType" /&gt;
 *       &lt;attribute name="RegistrationDate" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}DateType" /&gt;
 *       &lt;attribute name="ExceptionDate" type="{urn:cbr-ru:ed:leaftypes:v2.0}DateType" /&gt;
 *       &lt;attribute name="StoppageMode" type="{urn:cbr-ru:ed:leaftypes:v2.0}OneDigitCodeType" /&gt;
 *       &lt;attribute name="StoppageDate" type="{urn:cbr-ru:ed:leaftypes:v2.0}DateType" /&gt;
 *       &lt;attribute name="StoppageEndDate" type="{urn:cbr-ru:ed:leaftypes:v2.0}DateType" /&gt;
 *       &lt;attribute name="StoppageReason" type="{urn:cbr-ru:ed:leaftypes:v2.0}TwoDigitCodeType" /&gt;
 *       &lt;attribute name="ReasonAddText" type="{urn:cbr-ru:ed:leaftypes:v2.0}Max300TextType" /&gt;
 *       &lt;attribute name="ExecPayeePayts" type="{urn:cbr-ru:ed:leaftypes:v2.0}OneDigitCodeType" /&gt;
 *       &lt;attribute name="DispatchPayeePayts" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}OneDigitCodeType" /&gt;
 *       &lt;attribute name="ForeignPaytsSystemMode" type="{urn:cbr-ru:ed:leaftypes:v2.0}OneDigitCodeType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTGSCustomerInfo", propOrder = {
    "name",
    "additionalConditions",
    "purbicInfos",
    "listAccs",
    "listAccBrves",
    "payeeInfos"
})
public class RTGSCustomerInfo
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "AdditionalConditions")
    protected AdditionalConditions additionalConditions;
    @XmlElement(name = "PURBICInfo")
    protected List<BICInfo> purbicInfos;
    @XmlElement(name = "ListAcc")
    protected List<ListAcc> listAccs;
    @XmlElement(name = "ListAccBrf")
    protected List<ListAccBrf> listAccBrves;
    @XmlElement(name = "PayeeInfo")
    protected List<PayeeInfo> payeeInfos;
    @XmlAttribute(name = "OURBIC", required = true)
    protected String ourbic;
    @XmlAttribute(name = "OCBIC")
    protected String ocbic;
    @XmlAttribute(name = "BIC")
    protected String bic;
    @XmlAttribute(name = "UIS")
    protected String uis;
    @XmlAttribute(name = "ParentBIC")
    protected String parentBIC;
    @XmlAttribute(name = "MemberType", required = true)
    protected String memberType;
    @XmlAttribute(name = "RegistrationMode", required = true)
    protected String registrationMode;
    @XmlAttribute(name = "RegistrationDate", required = true)
    protected XMLGregorianCalendar registrationDate;
    @XmlAttribute(name = "ExceptionDate")
    protected XMLGregorianCalendar exceptionDate;
    @XmlAttribute(name = "StoppageMode")
    protected String stoppageMode;
    @XmlAttribute(name = "StoppageDate")
    protected XMLGregorianCalendar stoppageDate;
    @XmlAttribute(name = "StoppageEndDate")
    protected XMLGregorianCalendar stoppageEndDate;
    @XmlAttribute(name = "StoppageReason")
    protected String stoppageReason;
    @XmlAttribute(name = "ReasonAddText")
    protected String reasonAddText;
    @XmlAttribute(name = "ExecPayeePayts")
    protected String execPayeePayts;
    @XmlAttribute(name = "DispatchPayeePayts", required = true)
    protected String dispatchPayeePayts;
    @XmlAttribute(name = "ForeignPaytsSystemMode")
    protected String foreignPaytsSystemMode;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the additionalConditions property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalConditions }
     *     
     */
    public AdditionalConditions getAdditionalConditions() {
        return additionalConditions;
    }

    /**
     * Sets the value of the additionalConditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalConditions }
     *     
     */
    public void setAdditionalConditions(AdditionalConditions value) {
        this.additionalConditions = value;
    }

    /**
     * Gets the value of the purbicInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the purbicInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPURBICInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BICInfo }
     * 
     * 
     */
    public List<BICInfo> getPURBICInfos() {
        if (purbicInfos == null) {
            purbicInfos = new ArrayList<BICInfo>();
        }
        return this.purbicInfos;
    }

    /**
     * Gets the value of the listAccs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the listAccs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListAccs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListAcc }
     * 
     * 
     */
    public List<ListAcc> getListAccs() {
        if (listAccs == null) {
            listAccs = new ArrayList<ListAcc>();
        }
        return this.listAccs;
    }

    /**
     * Gets the value of the listAccBrves property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the listAccBrves property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListAccBrves().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListAccBrf }
     * 
     * 
     */
    public List<ListAccBrf> getListAccBrves() {
        if (listAccBrves == null) {
            listAccBrves = new ArrayList<ListAccBrf>();
        }
        return this.listAccBrves;
    }

    /**
     * Gets the value of the payeeInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the payeeInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPayeeInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PayeeInfo }
     * 
     * 
     */
    public List<PayeeInfo> getPayeeInfos() {
        if (payeeInfos == null) {
            payeeInfos = new ArrayList<PayeeInfo>();
        }
        return this.payeeInfos;
    }

    /**
     * Gets the value of the ourbic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOURBIC() {
        return ourbic;
    }

    /**
     * Sets the value of the ourbic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOURBIC(String value) {
        this.ourbic = value;
    }

    /**
     * Gets the value of the ocbic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOCBIC() {
        return ocbic;
    }

    /**
     * Sets the value of the ocbic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOCBIC(String value) {
        this.ocbic = value;
    }

    /**
     * Gets the value of the bic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBIC() {
        return bic;
    }

    /**
     * Sets the value of the bic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBIC(String value) {
        this.bic = value;
    }

    /**
     * Gets the value of the uis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUIS() {
        return uis;
    }

    /**
     * Sets the value of the uis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUIS(String value) {
        this.uis = value;
    }

    /**
     * Gets the value of the parentBIC property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentBIC() {
        return parentBIC;
    }

    /**
     * Sets the value of the parentBIC property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentBIC(String value) {
        this.parentBIC = value;
    }

    /**
     * Gets the value of the memberType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemberType() {
        return memberType;
    }

    /**
     * Sets the value of the memberType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemberType(String value) {
        this.memberType = value;
    }

    /**
     * Gets the value of the registrationMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationMode() {
        return registrationMode;
    }

    /**
     * Sets the value of the registrationMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationMode(String value) {
        this.registrationMode = value;
    }

    /**
     * Gets the value of the registrationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets the value of the registrationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRegistrationDate(XMLGregorianCalendar value) {
        this.registrationDate = value;
    }

    /**
     * Gets the value of the exceptionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExceptionDate() {
        return exceptionDate;
    }

    /**
     * Sets the value of the exceptionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExceptionDate(XMLGregorianCalendar value) {
        this.exceptionDate = value;
    }

    /**
     * Gets the value of the stoppageMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStoppageMode() {
        return stoppageMode;
    }

    /**
     * Sets the value of the stoppageMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStoppageMode(String value) {
        this.stoppageMode = value;
    }

    /**
     * Gets the value of the stoppageDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStoppageDate() {
        return stoppageDate;
    }

    /**
     * Sets the value of the stoppageDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStoppageDate(XMLGregorianCalendar value) {
        this.stoppageDate = value;
    }

    /**
     * Gets the value of the stoppageEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStoppageEndDate() {
        return stoppageEndDate;
    }

    /**
     * Sets the value of the stoppageEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStoppageEndDate(XMLGregorianCalendar value) {
        this.stoppageEndDate = value;
    }

    /**
     * Gets the value of the stoppageReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStoppageReason() {
        return stoppageReason;
    }

    /**
     * Sets the value of the stoppageReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStoppageReason(String value) {
        this.stoppageReason = value;
    }

    /**
     * Gets the value of the reasonAddText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonAddText() {
        return reasonAddText;
    }

    /**
     * Sets the value of the reasonAddText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonAddText(String value) {
        this.reasonAddText = value;
    }

    /**
     * Gets the value of the execPayeePayts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecPayeePayts() {
        return execPayeePayts;
    }

    /**
     * Sets the value of the execPayeePayts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecPayeePayts(String value) {
        this.execPayeePayts = value;
    }

    /**
     * Gets the value of the dispatchPayeePayts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispatchPayeePayts() {
        return dispatchPayeePayts;
    }

    /**
     * Sets the value of the dispatchPayeePayts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispatchPayeePayts(String value) {
        this.dispatchPayeePayts = value;
    }

    /**
     * Gets the value of the foreignPaytsSystemMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForeignPaytsSystemMode() {
        return foreignPaytsSystemMode;
    }

    /**
     * Sets the value of the foreignPaytsSystemMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForeignPaytsSystemMode(String value) {
        this.foreignPaytsSystemMode = value;
    }

}
