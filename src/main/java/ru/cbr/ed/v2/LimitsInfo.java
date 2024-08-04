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
 * Value and Usage of Limits.
 * 
 * <p>Java class for LimitsInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LimitsInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LimitInfo" type="{urn:cbr-ru:ed:v2.0}LimitInfoType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LimitsInfo", propOrder = {
    "limitInfos"
})
public class LimitsInfo
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "LimitInfo", required = true)
    protected List<LimitInfoType> limitInfos;

    /**
     * Gets the value of the limitInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the limitInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLimitInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LimitInfoType }
     * 
     * 
     */
    public List<LimitInfoType> getLimitInfos() {
        if (limitInfos == null) {
            limitInfos = new ArrayList<LimitInfoType>();
        }
        return this.limitInfos;
    }

}
