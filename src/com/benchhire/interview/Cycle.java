package com.benchhire.interview;
import java.util.Date;

public class Cycle {

  private int id;
  private String frame,handlebar,seating,wheels,chainAssemble;
  
  private  float price;
  private Date pricingDate;

public Cycle() {
	super();
}

public Cycle(String frame, String handlebar, String seating, String wheels, String chainAssemble, float price,
		Date pricingDate) {
	super();
	this.frame = frame;
	this.handlebar = handlebar;
	this.seating = seating;
	this.wheels = wheels;
	this.chainAssemble = chainAssemble;
	this.price = price;
	this.pricingDate = pricingDate;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFrame() {
	return frame;
}

public void setFrame(String frame) {
	this.frame = frame;
}

public String getHandlebar() {
	return handlebar;
}

public void setHandlebar(String handlebar) {
	this.handlebar = handlebar;
}

public String getSeating() {
	return seating;
}

public void setSeating(String seating) {
	this.seating = seating;
}

public String getWheels() {
	return wheels;
}

public void setWheels(String wheels) {
	this.wheels = wheels;
}

public String getChainAssemble() {
	return chainAssemble;
}

public void setChainAssemble(String chainAssemble) {
	this.chainAssemble = chainAssemble;
}

public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}

public Date getPricingDate() {
	return pricingDate;
}

public void setPricingDate(Date pricingDate) {
	this.pricingDate = pricingDate;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((chainAssemble == null) ? 0 : chainAssemble.hashCode());
	result = prime * result + ((frame == null) ? 0 : frame.hashCode());
	result = prime * result + ((handlebar == null) ? 0 : handlebar.hashCode());
	result = prime * result + Float.floatToIntBits(price);
	result = prime * result + ((pricingDate == null) ? 0 : pricingDate.hashCode());
	result = prime * result + ((seating == null) ? 0 : seating.hashCode());
	result = prime * result + ((wheels == null) ? 0 : wheels.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cycle other = (Cycle) obj;
	if (chainAssemble == null) {
		if (other.chainAssemble != null)
			return false;
	} else if (!chainAssemble.equals(other.chainAssemble))
		return false;
	if (frame == null) {
		if (other.frame != null)
			return false;
	} else if (!frame.equals(other.frame))
		return false;
	if (handlebar == null) {
		if (other.handlebar != null)
			return false;
	} else if (!handlebar.equals(other.handlebar))
		return false;
	if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
		return false;
	if (pricingDate == null) {
		if (other.pricingDate != null)
			return false;
	} else if (!pricingDate.equals(other.pricingDate))
		return false;
	if (seating == null) {
		if (other.seating != null)
			return false;
	} else if (!seating.equals(other.seating))
		return false;
	if (wheels == null) {
		if (other.wheels != null)
			return false;
	} else if (!wheels.equals(other.wheels))
		return false;
	return true;
}

@Override
public String toString() {
	return "id=" + id + ", frame=" + frame + ", handlebar=" + handlebar + ", seating=" + seating + ", wheels="
			+ wheels + ", chainAssemble=" + chainAssemble + ", price=" + price + ", pricingDate=" + pricingDate + "\n";
}

}