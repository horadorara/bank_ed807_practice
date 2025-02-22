//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.07.02 at 05:36:11 PM SAMT 
//


package ru.cbr.ed.v2;

import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Список предоставленных бесплатных услуг по видам
 * 
 * <p>Java class for FreeServicesCodeList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FreeServicesCodeList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="ServicesCode" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}OneDigitCodeType" /&gt;
 *       &lt;attribute name="ReceiverSWIFTBIC" type="{urn:cbr-ru:ed:leaftypes:v2.0}UICIDType" /&gt;
 *       &lt;attribute name="ServicesDate" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}DateType" /&gt;
 *       &lt;attribute name="ServicesQuantity" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}Max9QuantityType" /&gt;
 *       &lt;attribute name="ServicesRate" type="{urn:cbr-ru:ed:leaftypes:v2.0}NotNegativeKopeckAmountType" /&gt;
 *       &lt;attribute name="ARMNo" type="{urn:cbr-ru:ed:leaftypes:v2.0}TwoDigitIdentifierType" /&gt;
 *       &lt;attribute name="UIS" type="{urn:cbr-ru:ed:leaftypes:v2.0}EDDrawerIDType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FreeServicesCodeList")
public class FreeServicesCodeList
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlAttribute(name = "ServicesCode", required = true)
    protected String servicesCode;
    @XmlAttribute(name = "ReceiverSWIFTBIC")
    protected String receiverSWIFTBIC;
    @XmlAttribute(name = "ServicesDate", required = true)
    protected XMLGregorianCalendar servicesDate;
    @XmlAttribute(name = "ServicesQuantity", required = true)
    protected BigInteger servicesQuantity;
    @XmlAttribute(name = "ServicesRate")
    protected BigInteger servicesRate;
    @XmlAttribute(name = "ARMNo")
    protected String armNo;
    @XmlAttribute(name = "UIS")
    protected String uis;

    /**
     * Gets the value of the servicesCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServicesCode() {
        return servicesCode;
    }

    /**
     * Sets the value of the servicesCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServicesCode(String value) {
        this.servicesCode = value;
    }

    /**
     * Gets the value of the receiverSWIFTBIC property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiverSWIFTBIC() {
        return receiverSWIFTBIC;
    }

    /**
     * Sets the value of the receiverSWIFTBIC property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiverSWIFTBIC(String value) {
        this.receiverSWIFTBIC = value;
    }

    /**
     * Gets the value of the servicesDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getServicesDate() {
        return servicesDate;
    }

    /**
     * Sets the value of the servicesDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setServicesDate(XMLGregorianCalendar value) {
        this.servicesDate = value;
    }

    /**
     * Gets the value of the servicesQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getServicesQuantity() {
        return servicesQuantity;
    }

    /**
     * Sets the value of the servicesQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setServicesQuantity(BigInteger value) {
        this.servicesQuantity = value;
    }

    /**
     * Gets the value of the servicesRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getServicesRate() {
        return servicesRate;
    }

    /**
     * Sets the value of the servicesRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setServicesRate(BigInteger value) {
        this.servicesRate = value;
    }

    /**
     * Gets the value of the armNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getARMNo() {
        return armNo;
    }

    /**
     * Sets the value of the armNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setARMNo(String value) {
        this.armNo = value;
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

}
