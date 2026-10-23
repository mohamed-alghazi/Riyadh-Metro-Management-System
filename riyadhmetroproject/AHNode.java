/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package riyadhmetroproject;

/**
 *
 * @author amany
 */
public class AHNode <Key , E> {
	private Key key;
	private E value;

	public AHNode(Key key , E value) {
		this.key=key;
		this.value=value;
	}

	public void setKey(Key k) {
		key = k;
	}

	public void setValue(E v) {
		value = v;
	}

	public Key getKey() {
		return key;
	}

	public E getValue() {
		return value;
	}
}

