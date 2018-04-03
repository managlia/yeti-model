package com.yeti.model.action;

import java.io.Serializable;
import javax.persistence.*;

import com.yeti.model.general.Carrier;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@Table(name="placed_order")
@NamedQuery(name="PlacedOrder.findAll", query="SELECT a FROM PlacedOrder a")
public class PlacedOrder extends Action implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_bill_date")
	private Date billDate;

	@Column(name="order_carrier_tracking_number")
	private String carrierTrackingNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_create_date")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_delivery_date")
	private Date deliveryDate;

	@Column(name="order_external_id")
	private String externalId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_last_retrieved_date")
	private Date lastRetrievedDate;

	@Lob
	@Column(name="order_last_retrieved_value")
	private String lastRetrievedValue;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_pay_date")
	private Date payDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_ship_date")
	private Date shipDate;

	@Column(name="order_valuation")
	private BigDecimal valuation;

	@Column(name="order_valuation_currency")
	private String valuationCurrency;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "order_product", 
      joinColumns = @JoinColumn(name = "product_external_id", referencedColumnName = "action_id"), 
      inverseJoinColumns = @JoinColumn(name = "action_id", referencedColumnName = "product_external_id"))
	private Set<Product> products;

	//bi-directional many-to-one association to Carrier
	@ManyToOne
	@JoinColumn(name="carrier_id")
	private Carrier carrier;

	//bi-directional many-to-one association to OrderStateType
	@ManyToOne
	@JoinColumn(name="order_state_type_id")
	private OrderStateType stateType;

	public PlacedOrder() {
	}

	public Date getBillDate() {
		return this.billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getCarrierTrackingNumber() {
		return this.carrierTrackingNumber;
	}

	public void setCarrierTrackingNumber(String carrierTrackingNumber) {
		this.carrierTrackingNumber = carrierTrackingNumber;
	}

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getExternalId() {
		return this.externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public Date getLastRetrievedDate() {
		return this.lastRetrievedDate;
	}

	public void setLastRetrievedDate(Date lastRetrievedDate) {
		this.lastRetrievedDate = lastRetrievedDate;
	}

	public String getLastRetrievedValue() {
		return this.lastRetrievedValue;
	}

	public void setLastRetrievedValue(String lastRetrievedValue) {
		this.lastRetrievedValue = lastRetrievedValue;
	}

	public Date getPayDate() {
		return this.payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Date getShipDate() {
		return this.shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public BigDecimal getValuation() {
		return this.valuation;
	}

	public void setValuation(BigDecimal valuation) {
		this.valuation = valuation;
	}

	public String getValuationCurrency() {
		return this.valuationCurrency;
	}

	public void setValuationCurrency(String valuationCurrency) {
		this.valuationCurrency = valuationCurrency;
	}
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Carrier getCarrier() {
		return this.carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public OrderStateType getStateType() {
		return this.stateType;
	}

	public void setStateType(OrderStateType stateType) {
		this.stateType = stateType;
	}

}