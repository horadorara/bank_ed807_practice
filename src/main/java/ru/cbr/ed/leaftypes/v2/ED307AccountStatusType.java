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
 * <p>Java class for ED307AccountStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="ED307AccountStatusType"&gt;
 *   &lt;restriction base="{urn:cbr-ru:ed:basetypes:v2.0}IdentifierTextCategory"&gt;
 *     &lt;enumeration value="ACAC"/&gt;
 *     &lt;enumeration value="ACWD"/&gt;
 *     &lt;enumeration value="ACDL"/&gt;
 *     &lt;enumeration value="ACDE"/&gt;
 *     &lt;enumeration value="ACSE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ED307AccountStatusType", namespace = "urn:cbr-ru:ed:leaftypes:v2.0")
@XmlEnum
public enum ED307AccountStatusType {

    ACAC,
    ACWD,
    ACDL,
    ACDE,
    ACSE;

    public String value() {
        return name();
    }

    public static ED307AccountStatusType fromValue(String v) {
        return valueOf(v);
    }

}
