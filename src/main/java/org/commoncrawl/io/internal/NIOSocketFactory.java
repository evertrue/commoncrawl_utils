/**
 * Copyright 2008 - CommonCrawl Foundation
 * 
 * CommonCrawl licenses this file to you under the Apache License, 
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.commoncrawl.io.internal;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;

/**
 * NIOSocketFactory - factory object used to construct NIOSocket objects from URL objects 
 * 
 * @author rana
 *
 */
public class NIOSocketFactory {

	static public NIOClientSocket createClientSocket(URL forURL, InetSocketAddress localBindAddress,
			NIOClientSocketListener socketListener) throws IOException {
		return createClientSocket(forURL.getProtocol(), localBindAddress, socketListener);
	}

	static public NIOClientSocket createClientSocket(String protocol, InetSocketAddress localBindAddress,
			NIOClientSocketListener socketListener) throws IOException {

		if (protocol.equalsIgnoreCase("http")) {
			return new NIOClientTCPSocket(localBindAddress, socketListener);
		}
		throw new IOException("Unsupported Protocol Type:" + protocol);
	}

}
