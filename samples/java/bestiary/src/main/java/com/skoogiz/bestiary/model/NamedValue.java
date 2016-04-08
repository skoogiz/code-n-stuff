/**
 * 
 */
package com.skoogiz.bestiary.model;

import java.io.Serializable;

/**
 * Interface defining an named value.
 * 
 * @author ask
 *
 */
public interface NamedValue<N, V> extends Serializable {

	N getName();

	V getValue();
}
