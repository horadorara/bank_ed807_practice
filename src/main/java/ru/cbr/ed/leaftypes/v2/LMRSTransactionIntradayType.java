//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.07.02 at 05:36:11 PM SAMT 
//


package ru.cbr.ed.leaftypes.v2;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LMRSTransactionIntradayType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="LMRSTransactionIntradayType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="EDTR"/&gt;
 *     &lt;enumeration value="IDTR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "LMRSTransactionIntradayType", namespace = "urn:cbr-ru:ed:leaftypes:v2.0")
@XmlEnum
public enum LMRSTransactionIntradayType {

    EDTR,
    IDTR;

    public String value() {
        return name();
    }

    public static LMRSTransactionIntradayType fromValue(String v) {
        return valueOf(v);
    }

}
