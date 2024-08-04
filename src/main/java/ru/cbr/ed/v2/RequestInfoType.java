//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.07.02 at 05:36:11 PM SAMT 
//


package ru.cbr.ed.v2;

import java.io.Serializable;
import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import ru.cbr.ed.leaftypes.v2.LiquidityTransKindType;


/**
 * Информация о состоянии ликвидности в СБП.
 * 
 * <p>Java class for RequestInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="BIC" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}BICRUIDType" /&gt;
 *       &lt;attribute name="CorrespAcc" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}AccountNumberRUIDType" /&gt;
 *       &lt;attribute name="Sum" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}NotNegativeKopeckAmountType" /&gt;
 *       &lt;attribute name="LiquidityTransKind" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}LiquidityTransKindType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestInfoType")
public class RequestInfoType
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlAttribute(name = "BIC", required = true)
    protected String bic;
    @XmlAttribute(name = "CorrespAcc", required = true)
    protected String correspAcc;
    @XmlAttribute(name = "Sum", required = true)
    protected BigInteger sum;
    @XmlAttribute(name = "LiquidityTransKind", required = true)
    protected LiquidityTransKindType liquidityTransKind;

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
     * Gets the value of the correspAcc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrespAcc() {
        return correspAcc;
    }

    /**
     * Sets the value of the correspAcc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrespAcc(String value) {
        this.correspAcc = value;
    }

    /**
     * Gets the value of the sum property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSum() {
        return sum;
    }

    /**
     * Sets the value of the sum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSum(BigInteger value) {
        this.sum = value;
    }

    /**
     * Gets the value of the liquidityTransKind property.
     * 
     * @return
     *     possible object is
     *     {@link LiquidityTransKindType }
     *     
     */
    public LiquidityTransKindType getLiquidityTransKind() {
        return liquidityTransKind;
    }

    /**
     * Sets the value of the liquidityTransKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link LiquidityTransKindType }
     *     
     */
    public void setLiquidityTransKind(LiquidityTransKindType value) {
        this.liquidityTransKind = value;
    }

}
