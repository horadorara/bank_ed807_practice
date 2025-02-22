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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Базовый комплексный тип для всех электронных платежных сообщений. Содержит реквизиты, общие для всех типов ЭПС.
 * 
 * <p>Java class for EPDComplete complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EPDComplete"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:cbr-ru:ed:v2.0}ED"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SettleNotEarlier" type="{urn:cbr-ru:ed:v2.0}SettleNotEarlier" minOccurs="0"/&gt;
 *         &lt;element name="SettleNotLater" type="{urn:cbr-ru:ed:v2.0}SettleNotLater" minOccurs="0"/&gt;
 *         &lt;element name="AccDoc" type="{urn:cbr-ru:ed:v2.0}AccDocRefID"/&gt;
 *         &lt;element name="Payer" type="{urn:cbr-ru:ed:v2.0}PayerRU"/&gt;
 *         &lt;element name="Payee" type="{urn:cbr-ru:ed:v2.0}PayeeRU"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="EDReceiver" type="{urn:cbr-ru:ed:leaftypes:v2.0}EDDrawerIDType" /&gt;
 *       &lt;attribute name="PaytKind" type="{urn:cbr-ru:ed:leaftypes:v2.0}OneDigitCodeType" /&gt;
 *       &lt;attribute name="Sum" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}KopeckAmountType" /&gt;
 *       &lt;attribute name="PaymentPrecedence" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}TwoDigitCodeType" /&gt;
 *       &lt;attribute name="ReqSettlementDate" type="{urn:cbr-ru:ed:leaftypes:v2.0}DateType" /&gt;
 *       &lt;attribute name="CodePurpose" type="{urn:cbr-ru:ed:leaftypes:v2.0}Max35TextType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EPDComplete", propOrder = {
    "settleNotEarlier",
    "settleNotLater",
    "accDoc",
    "payer",
    "payee"
})
public class EPDComplete
    extends ED
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "SettleNotEarlier")
    protected SettleNotEarlier settleNotEarlier;
    @XmlElement(name = "SettleNotLater")
    protected SettleNotLater settleNotLater;
    @XmlElement(name = "AccDoc", required = true)
    protected AccDocRefID accDoc;
    @XmlElement(name = "Payer", required = true)
    protected PayerRU payer;
    @XmlElement(name = "Payee", required = true)
    protected PayeeRU payee;
    @XmlAttribute(name = "EDReceiver")
    protected String edReceiver;
    @XmlAttribute(name = "PaytKind")
    protected String paytKind;
    @XmlAttribute(name = "Sum", required = true)
    protected BigInteger sum;
    @XmlAttribute(name = "PaymentPrecedence", required = true)
    protected String paymentPrecedence;
    @XmlAttribute(name = "ReqSettlementDate")
    protected XMLGregorianCalendar reqSettlementDate;
    @XmlAttribute(name = "CodePurpose")
    protected String codePurpose;

    /**
     * Gets the value of the settleNotEarlier property.
     * 
     * @return
     *     possible object is
     *     {@link SettleNotEarlier }
     *     
     */
    public SettleNotEarlier getSettleNotEarlier() {
        return settleNotEarlier;
    }

    /**
     * Sets the value of the settleNotEarlier property.
     * 
     * @param value
     *     allowed object is
     *     {@link SettleNotEarlier }
     *     
     */
    public void setSettleNotEarlier(SettleNotEarlier value) {
        this.settleNotEarlier = value;
    }

    /**
     * Gets the value of the settleNotLater property.
     * 
     * @return
     *     possible object is
     *     {@link SettleNotLater }
     *     
     */
    public SettleNotLater getSettleNotLater() {
        return settleNotLater;
    }

    /**
     * Sets the value of the settleNotLater property.
     * 
     * @param value
     *     allowed object is
     *     {@link SettleNotLater }
     *     
     */
    public void setSettleNotLater(SettleNotLater value) {
        this.settleNotLater = value;
    }

    /**
     * Gets the value of the accDoc property.
     * 
     * @return
     *     possible object is
     *     {@link AccDocRefID }
     *     
     */
    public AccDocRefID getAccDoc() {
        return accDoc;
    }

    /**
     * Sets the value of the accDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccDocRefID }
     *     
     */
    public void setAccDoc(AccDocRefID value) {
        this.accDoc = value;
    }

    /**
     * Gets the value of the payer property.
     * 
     * @return
     *     possible object is
     *     {@link PayerRU }
     *     
     */
    public PayerRU getPayer() {
        return payer;
    }

    /**
     * Sets the value of the payer property.
     * 
     * @param value
     *     allowed object is
     *     {@link PayerRU }
     *     
     */
    public void setPayer(PayerRU value) {
        this.payer = value;
    }

    /**
     * Gets the value of the payee property.
     * 
     * @return
     *     possible object is
     *     {@link PayeeRU }
     *     
     */
    public PayeeRU getPayee() {
        return payee;
    }

    /**
     * Sets the value of the payee property.
     * 
     * @param value
     *     allowed object is
     *     {@link PayeeRU }
     *     
     */
    public void setPayee(PayeeRU value) {
        this.payee = value;
    }

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

    /**
     * Gets the value of the paytKind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaytKind() {
        return paytKind;
    }

    /**
     * Sets the value of the paytKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaytKind(String value) {
        this.paytKind = value;
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
     * Gets the value of the paymentPrecedence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentPrecedence() {
        return paymentPrecedence;
    }

    /**
     * Sets the value of the paymentPrecedence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentPrecedence(String value) {
        this.paymentPrecedence = value;
    }

    /**
     * Gets the value of the reqSettlementDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReqSettlementDate() {
        return reqSettlementDate;
    }

    /**
     * Sets the value of the reqSettlementDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReqSettlementDate(XMLGregorianCalendar value) {
        this.reqSettlementDate = value;
    }

    /**
     * Gets the value of the codePurpose property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodePurpose() {
        return codePurpose;
    }

    /**
     * Sets the value of the codePurpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodePurpose(String value) {
        this.codePurpose = value;
    }

}
