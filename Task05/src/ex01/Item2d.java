package ex01;

import java.io.Serializable;

/**
 *The Item2d class represents a data item containing a random number and the quantity of hexadecimal 
 * and octal digits that this number has.
 */
public class Item2d implements Serializable {

    private double randomNumber;
    private int hex;
    private int octal;

    /**
     * Constructs a new Item2d object with the specified parameters.
     * @param randomNumber The random number to be stored in the object.
     * @param hex The quantity of hexadecimal digits that the number has.
     * @param octal The quantity of octal digits that the number has.
     */
    public Item2d(double randomNumber, int hex, int octal) {
        this.randomNumber = randomNumber;
        this.hex = hex;
        this.octal = octal;
    }

    public Item2d() {}

    /**
     * Returns the random number stored in the object.
     * @return the random number stored in the object.
     */
    public double getRandomNumber() {
        return randomNumber;
    }

    /**
     * Sets the random number to be stored in the object.
     * @param randomNumber The random number to be stored in the object.
     */
    public void setRandomNumber(double randomNumber) {
        this.randomNumber = randomNumber;
    }

    /**
     * Returns the quantity of hexadecimal digits that the number has.
     * @return the quantity of hexadecimal digits that the number has.
     */
    public int getHex() {
        return hex;
    }

    /**
     * Sets the quantity of hexadecimal digits that the number has.
     * @param hex The quantity of hexadecimal digits that the number has.
     */
    public void setHex(int hex) {
        this.hex = hex;
    }

    /**
     * Returns the quantity of octal digits that the number has.
     * @return the quantity of octal digits that the number has.
     */
    public int getOctal() {
        return octal;
    }
    
    /**
     * Sets the quantity of octal digits that the number has.
     * @param octal The quantity of octal digits that the number has.
     */
    public void setOctal(int octal) {
        this.octal = octal;
    }

    /**
     * Automatically generated method.
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item2d other = (Item2d) obj;
        if (Double.doubleToLongBits(this.randomNumber) != Double.doubleToLongBits(other.randomNumber)) {
            return false;
        }
        if (this.hex != other.hex) {
            return false;
        }
        return this.octal == other.octal;
    }
    
     /**
     * Automatically generated method.
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.randomNumber) ^ (Double.doubleToLongBits(this.randomNumber) >>> 32));
        hash = 17 * hash + this.hex;
        hash = 17 * hash + this.octal;
        return hash;
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Random number: " + randomNumber + 
               "\nQuantity of hexadecimal digits: " + hex +
               "\nQuantity of octal digits: " + octal;
    }
}
