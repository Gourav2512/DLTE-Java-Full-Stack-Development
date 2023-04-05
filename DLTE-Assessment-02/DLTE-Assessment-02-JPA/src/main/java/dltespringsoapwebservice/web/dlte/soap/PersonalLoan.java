//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.04 at 10:48:16 PM IST 
//


package dltespringsoapwebservice.web.dlte.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PersonalLoan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonalLoan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="loanRequestNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="requestedAmount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cibil" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="aadhaar" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="pan" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="profession" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="incomePerAnnum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="statusOfApproval" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateOfTheRequest" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonalLoan", propOrder = {
    "loanRequestNumber",
    "requestedAmount",
    "cibil",
    "aadhaar",
    "pan",
    "profession",
    "incomePerAnnum",
    "statusOfApproval",
    "dateOfTheRequest"
})
public class PersonalLoan {

    protected int loanRequestNumber;
    protected int requestedAmount;
    protected int cibil;
    protected long aadhaar;
    @XmlElement(required = true)
    protected String pan;
    @XmlElement(required = true)
    protected String profession;
    protected int incomePerAnnum;
    @XmlElement(required = true)
    protected String statusOfApproval;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfTheRequest;

    /**
     * Gets the value of the loanRequestNumber property.
     * 
     */
    public int getLoanRequestNumber() {
        return loanRequestNumber;
    }

    /**
     * Sets the value of the loanRequestNumber property.
     * 
     */
    public void setLoanRequestNumber(int value) {
        this.loanRequestNumber = value;
    }

    /**
     * Gets the value of the requestedAmount property.
     * 
     */
    public int getRequestedAmount() {
        return requestedAmount;
    }

    /**
     * Sets the value of the requestedAmount property.
     * 
     */
    public void setRequestedAmount(int value) {
        this.requestedAmount = value;
    }

    /**
     * Gets the value of the cibil property.
     * 
     */
    public int getCibil() {
        return cibil;
    }

    /**
     * Sets the value of the cibil property.
     * 
     */
    public void setCibil(int value) {
        this.cibil = value;
    }

    /**
     * Gets the value of the aadhaar property.
     * 
     */
    public long getAadhaar() {
        return aadhaar;
    }

    /**
     * Sets the value of the aadhaar property.
     * 
     */
    public void setAadhaar(long value) {
        this.aadhaar = value;
    }

    /**
     * Gets the value of the pan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPan() {
        return pan;
    }

    /**
     * Sets the value of the pan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPan(String value) {
        this.pan = value;
    }

    /**
     * Gets the value of the profession property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfession() {
        return profession;
    }

    /**
     * Sets the value of the profession property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfession(String value) {
        this.profession = value;
    }

    /**
     * Gets the value of the incomePerAnnum property.
     * 
     */
    public int getIncomePerAnnum() {
        return incomePerAnnum;
    }

    /**
     * Sets the value of the incomePerAnnum property.
     * 
     */
    public void setIncomePerAnnum(int value) {
        this.incomePerAnnum = value;
    }

    /**
     * Gets the value of the statusOfApproval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusOfApproval() {
        return statusOfApproval;
    }

    /**
     * Sets the value of the statusOfApproval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusOfApproval(String value) {
        this.statusOfApproval = value;
    }

    /**
     * Gets the value of the dateOfTheRequest property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfTheRequest() {
        return dateOfTheRequest;
    }

    /**
     * Sets the value of the dateOfTheRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfTheRequest(XMLGregorianCalendar value) {
        this.dateOfTheRequest = value;
    }

}
