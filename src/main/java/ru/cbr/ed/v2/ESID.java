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
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Базовый комплексный тип для всех электронных служебно-информационных сообщений. Содержит реквизиты, общие для всех типов ЭСИС.
 * 
 * <p>Java class for ESID complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ESID"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:cbr-ru:ed:v2.0}ED"&gt;
 *       &lt;attribute name="EDReceiver" type="{urn:cbr-ru:ed:leaftypes:v2.0}EDDrawerIDType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESID")
@XmlSeeAlso({
    ESIDResponse.class,
    ESIDWithPartInfo.class
})
public class ESID
    extends ED
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlAttribute(name = "EDReceiver")
    protected String edReceiver;

    /**
     * Gets the value of the edReceiver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEDReceiver() {
        return edReceiver;
    }

    /**
     * Sets the value of the edReceiver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEDReceiver(String value) {
        this.edReceiver = value;
    }

}
