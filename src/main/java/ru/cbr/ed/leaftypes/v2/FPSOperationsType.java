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
 * <p>Java class for FPSOperationsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="FPSOperationsType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CCPH"/&gt;
 *     &lt;enumeration value="CCRC"/&gt;
 *     &lt;enumeration value="CCRB"/&gt;
 *     &lt;enumeration value="CCPL"/&gt;
 *     &lt;enumeration value="CBPH"/&gt;
 *     &lt;enumeration value="CBPP"/&gt;
 *     &lt;enumeration value="CBRC"/&gt;
 *     &lt;enumeration value="CBRB"/&gt;
 *     &lt;enumeration value="CCRD"/&gt;
 *     &lt;enumeration value="CCRT"/&gt;
 *     &lt;enumeration value="CCRN"/&gt;
 *     &lt;enumeration value="CBRD"/&gt;
 *     &lt;enumeration value="CBRT"/&gt;
 *     &lt;enumeration value="CBRN"/&gt;
 *     &lt;enumeration value="BCPH"/&gt;
 *     &lt;enumeration value="BCRC"/&gt;
 *     &lt;enumeration value="BCRB"/&gt;
 *     &lt;enumeration value="BCRD"/&gt;
 *     &lt;enumeration value="BCRT"/&gt;
 *     &lt;enumeration value="BCRN"/&gt;
 *     &lt;enumeration value="BBPH"/&gt;
 *     &lt;enumeration value="BBRT"/&gt;
 *     &lt;enumeration value="BBRN"/&gt;
 *     &lt;enumeration value="BBRB"/&gt;
 *     &lt;enumeration value="BBRD"/&gt;
 *     &lt;enumeration value="BBRC"/&gt;
 *     &lt;enumeration value="CGPH"/&gt;
 *     &lt;enumeration value="CGRT"/&gt;
 *     &lt;enumeration value="CTPH"/&gt;
 *     &lt;enumeration value="CTRB"/&gt;
 *     &lt;enumeration value="CTRT"/&gt;
 *     &lt;enumeration value="BCCB"/&gt;
 *     &lt;enumeration value="BCRX"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FPSOperationsType", namespace = "urn:cbr-ru:ed:leaftypes:v2.0")
@XmlEnum
public enum FPSOperationsType {

    CCPH,
    CCRC,
    CCRB,
    CCPL,
    CBPH,
    CBPP,
    CBRC,
    CBRB,
    CCRD,
    CCRT,
    CCRN,
    CBRD,
    CBRT,
    CBRN,
    BCPH,
    BCRC,
    BCRB,
    BCRD,
    BCRT,
    BCRN,
    BBPH,
    BBRT,
    BBRN,
    BBRB,
    BBRD,
    BBRC,
    CGPH,
    CGRT,
    CTPH,
    CTRB,
    CTRT,
    BCCB,
    BCRX;

    public String value() {
        return name();
    }

    public static FPSOperationsType fromValue(String v) {
        return valueOf(v);
    }

}
