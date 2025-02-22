//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.07.02 at 05:36:11 PM SAMT 
//


package ru.cbr.ed.v2;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * BIC of Authorized sender Or List of BICs of Banks using Authorized sender to communicate with NPS.
 * 
 * <p>Java class for UFCFInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UFCFInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="UFBIC" type="{urn:cbr-ru:ed:leaftypes:v2.0}BICRUIDType"/&gt;
 *         &lt;element name="CFBICList" type="{urn:cbr-ru:ed:v2.0}CFBICList"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UFCFInfo", propOrder = {
    "cfbicList",
    "ufbic"
})
public class UFCFInfo
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "CFBICList")
    protected CFBICList cfbicList;
    @XmlElement(name = "UFBIC")
    protected String ufbic;

    /**
     * Gets the value of the cfbicList property.
     * 
     * @return
     *     possible object is
     *     {@link CFBICList }
     *     
     */
    public CFBICList getCFBICList() {
        return cfbicList;
    }

    /**
     * Sets the value of the cfbicList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CFBICList }
     *     
     */
    public void setCFBICList(CFBICList value) {
        this.cfbicList = value;
    }

    /**
     * Gets the value of the ufbic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUFBIC() {
        return ufbic;
    }

    /**
     * Sets the value of the ufbic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUFBIC(String value) {
        this.ufbic = value;
    }

}
