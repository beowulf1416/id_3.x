/**
 * 
 */
package org.tomale.id.db;

import java.sql.Connection;

/**
 * @author ferd
 *
 */
public interface IConnectionFactory {

	Connection create(final String host, final int port, final String name,
			final String user, final String pw, final String options);
	
}
